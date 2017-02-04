
package com.mythfish;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Canvas;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableMap;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;

public class RNWatermarkerModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public RNWatermarkerModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNWatermarker";
  }

  @ReactMethod
  public void text(final String path, final String watermark, final ReadableMap options, final Callback callback) {

    WritableMap response;

    // Get options
    int color = Color.parseColor(options.getString("color"));
    int size = options.getInt("size");
    int x = options.getInt("x");
    int y = options.getInt("y");
    int alpha = options.getInt("alpha");
    boolean underline = options.getBoolean("underline");

    // Decode file to Bitmap
    Options bmOptions = new BitmapFactory.Options();
    Bitmap src = BitmapFactory.decodeFile(path, bmOptions);
    if (src == null) {
      response = Arguments.createMap();
      response.putString("error", "can't find open file");
      callback.invoke(response);
      return;
    }

    // Create new Bitmap and draw Text
    int w = src.getWidth();
    int h = src.getHeight();
    Bitmap dest = Bitmap.createBitmap(w, h, src.getConfig());

    Canvas canvas = new Canvas(dest);
    canvas.drawBitmap(src, 0, 0, null);

    Paint paint = new Paint();
    paint.setColor(color);
    paint.setAlpha(alpha);
    paint.setTextSize(size);
    paint.setAntiAlias(true);
    paint.setUnderlineText(underline);
    canvas.drawText(watermark,  x < 0 ? w + x : x, y < 0 ? h + y : y, paint);

    // Save Bitmap to file
    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
    dest.compress(Bitmap.CompressFormat.JPEG, 100, bytes);

    File f = createNewFile();
    FileOutputStream fo;
    try {
      fo = new FileOutputStream(f);
      try {
        fo.write(bytes.toByteArray());
      } catch (IOException e) {
        e.printStackTrace();
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    // recycle to avoid java.lang.OutOfMemoryError
    if (src != null) {
      src.recycle();
      dest.recycle();
      src = null;
      dest = null;
    }

    response = Arguments.createMap();
    response.putString("path", f.getAbsolutePath());
    callback.invoke(response);
    return;
  }

  /**
   * Create a new file
   *
   * @return an empty file
   */
  private File createNewFile() {
    String filename = "image-" + UUID.randomUUID().toString() + ".jpg";
    File path = reactContext.getExternalCacheDir();

    File f = new File(path, filename);
    try {
      path.mkdirs();
      f.createNewFile();
    } catch (IOException e) {
      e.printStackTrace();
    }

    return f;
  }
}

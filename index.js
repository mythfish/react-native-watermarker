
import { NativeModules } from 'react-native';

const { RNWatermarker } = NativeModules;

const DEFAULT_OPTIONS = {
  color: 'white',
  x: 0,
  y: 0,
  size: 12,
  underline: false,
  alpha: 255
};

export default {
  ...RNWatermarker,
  text: function text(path, watermark, options, callback) {
    if (typeof options === 'function') {
      callback = options;
      options = DEFAULT_OPTIONS;
    } else {
      options = Object.assign({}, DEFAULT_OPTIONS, options)
    }
    return RNWatermarker.text(path, watermark, options, callback)
  }
}

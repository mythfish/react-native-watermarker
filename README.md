
# react-native-watermarker

## Getting started

`$ npm install react-native-watermarker --save`

### Mostly automatic installation

`$ react-native link react-native-watermarker`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-watermarker` and add `RNWatermarker.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNWatermarker.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.mythfish.RNWatermarkerPackage;` to the imports at the top of the file
  - Add `new RNWatermarkerPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-watermarker'
  	project(':react-native-watermarker').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-watermarker/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-watermarker')
  	```

#### Windows
[Read it! :D](https://github.com/ReactWindows/react-native)

1. In Visual Studio add the `RNWatermarker.sln` in `node_modules/react-native-watermarker/windows/RNWatermarker.sln` folder to their solution, reference from their app.
2. Open up your `MainPage.cs` app
  - Add `using Cl.Json.RNWatermarker;` to the usings at the top of the file
  - Add `new RNWatermarkerPackage()` to the `List<IReactPackage>` returned by the `Packages` method


## Usage
```javascript
import RNWatermarker from 'react-native-watermarker';

// TODO: What do with the module?
RNWatermarker;
```
  
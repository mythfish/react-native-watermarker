
import { NativeModules } from 'react-native';

const { RNWatermarker } = NativeModules;

export default RNWatermarker;


// import { NativeModules } from 'react-native';
//
// const DEFAULT_OPTIONS = {
//   color: 'white',
//   x: 0,
//   y: 0,
//   size: 12,
//   underline: false,
//   alpha: 255
// };
//
// const RNWatermarker = Object.assign(
//   NativeModules.RNWatermarker,
//   {
//     text: function text(options, callback) {
//       if (typeof options === 'function') {
//         callback = options;
//         options = {};
//       }
//       return NativeModules.RNWatermarker.text(Object.assign(DEFAULT_OPTIONS, options), callback)
//     }
//   }
// )
//
// module.exports = RNWatermarker

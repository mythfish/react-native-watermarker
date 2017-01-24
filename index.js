
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
  text: function text(options, callback) {
    if (typeof options === 'function') {
      callback = options;
      options = {};
    }
    return RNWatermarker.text({...DEFAULT_OPTIONS, ...options}, callback)
  }
}

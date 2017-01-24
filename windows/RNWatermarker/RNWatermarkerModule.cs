using ReactNative.Bridge;
using System;
using System.Collections.Generic;
using Windows.ApplicationModel.Core;
using Windows.UI.Core;

namespace Com.Mythfish.RNWatermarker
{
    /// <summary>
    /// A module that allows JS to share data.
    /// </summary>
    class RNWatermarkerModule : NativeModuleBase
    {
        /// <summary>
        /// Instantiates the <see cref="RNWatermarkerModule"/>.
        /// </summary>
        internal RNWatermarkerModule()
        {

        }

        /// <summary>
        /// The name of the native module.
        /// </summary>
        public override string Name
        {
            get
            {
                return "RNWatermarker";
            }
        }
    }
}

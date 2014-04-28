/*
 * Copyright (C) 2014 The Mokee Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.mokee.hardware;

import org.mokee.hardware.util.FileUtils;

public class TapToWake {

    private static String CONTROL_PATH1 = "/sys/devices/i2c-3/3-004b/knock_on";
    private static String CONTROL_PATH2 = "/sys/devices/virtual/input/lge_touch/touch_gesture"; // PATH for new touchscreen driver
    private static boolean mEnabled = true;

    public static boolean isSupported() {
        return true;
    }

    public static boolean isEnabled()  {
        return mEnabled;
    }

    public static boolean setEnabled(boolean state)  {
        mEnabled = state;
        return FileUtils.writeLine(CONTROL_PATH1, (state ? "1" : "0")) || FileUtils.writeLine(CONTROL_PATH2, (state ? "1" : "0"));
    }
}

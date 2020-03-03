package org.xms.g.utils;

import java.util.Arrays;

import android.content.Context;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

public class GlobalEnvSetting {

    private static boolean isHms;

    /**
     *  init Xms Adapter
     * @param ctx
     * @param logImpl If you want to print the log to your own log file system, please implement {@link XmsLog.XmsLogInterface}.
     *                If you put Null logImpl, then you will use default Android Logcat to print XmsAdapter's log.
     * @param logLevel {@link XmsLog} LOG_LEVEL_DEBUG = 0; LOG_LEVEL_INFO = 1; LOG_LEVEL_WARN = 2; LOG_LEVEL_ERROR = 3;
     *                               LOG_LEVEL_CLOSE = 4;
     */
    public static void init(Context ctx, XmsLog.XmsLogInterface logImpl, int logLevel) {
        XmsLog.newInstance(logImpl, logLevel);
        boolean gAvailable = !Arrays.asList(ConnectionResult.SERVICE_DISABLED,
                ConnectionResult.SERVICE_MISSING,
                ConnectionResult.SERVICE_INVALID).contains(
                GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(ctx));
        boolean hAvailable = !Arrays.asList(com.huawei.hms.api.ConnectionResult.SERVICE_DISABLED,
                com.huawei.hms.api.ConnectionResult.SERVICE_MISSING,
                com.huawei.hms.api.ConnectionResult.SERVICE_INVALID).contains(
                com.huawei.hms.api.HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(ctx));
        isHms = !gAvailable || hAvailable;
    }

    public static boolean isHms() {
        return isHms;
    }

    /**
     * Before calling this method, please make sure whether Google mobile services are supported in the runtime environment of mobile phone
     */
    public static void useGms() {
        isHms = false;
    }
    
    /**
     * Before calling this method, please make sure whether Huawei mobile services are supported in the runtime environment of mobile phone
     */
    public static void useHms() {
        isHms = true;
    }
}

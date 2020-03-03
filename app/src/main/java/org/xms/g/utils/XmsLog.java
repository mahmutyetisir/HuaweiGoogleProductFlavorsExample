package org.xms.g.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import android.util.Log;

public class XmsLog {
    private static XmsLogInterface logImpl;
    private static final String TAG_XmsLog = XmsLog.class.getSimpleName();
    public static final int LOG_LEVEL_DEBUG = 0;
    public static final int LOG_LEVEL_INFO = 1;
    public static final int LOG_LEVEL_WARN = 2;
    public static final int LOG_LEVEL_ERROR = 3;
    public static final int LOG_LEVEL_CLOSE = 4;
    private static int logLevel = LOG_LEVEL_INFO;

    public static void newInstance(XmsLogInterface inLogImpl, int inLogLevel){
        logImpl = inLogImpl;
        if (inLogLevel > LOG_LEVEL_CLOSE || inLogLevel < LOG_LEVEL_DEBUG) {
            logLevel = LOG_LEVEL_INFO;
        } else {
            logLevel = inLogLevel;
        }
    }

    /**
     * If the user did'nt implements the log interface, use Android default log
     */
    private static XmsLogInterface defaultImpl() {
        return new XmsLogInterface() {
            @Override
            public void d(String TAG, String logStr) {
                Log.d(TAG, logStr);
            }

            @Override
            public void d(String TAG, String logStr, Throwable tr) {
                Log.d(TAG, logStr);
            }

            @Override
            public void i(String TAG, String logStr) {
                Log.i(TAG, logStr);
            }

            @Override
            public void i(String TAG, String logStr, Throwable tr) {
                Log.i(TAG, logStr);
            }

            @Override
            public void w(String TAG, String logStr) {
                Log.w(TAG, logStr);
            }

            @Override
            public void w(String TAG, String logStr, Throwable tr) {
                Log.w(TAG, logStr);
            }

            @Override
            public void e(String TAG, String logStr) {
                Log.e(TAG, logStr);
            }

            @Override
            public void e(String TAG, String logStr, Throwable tr) {
                Log.e(TAG, logStr, tr);
            }
        };
    }

    public static void d(String TAG, String logStr) {
        if (null == logImpl) {
            XmsLog.newInstance(defaultImpl(), logLevel);
        }
        if (logLevel <= LOG_LEVEL_DEBUG) {
            logImpl.d(TAG, constructLogInfo(TAG, logStr));
        }
    }

    public static void d(String TAG, String logStr, Throwable tr) {
        if (null == logImpl) {
            XmsLog.newInstance(defaultImpl(), logLevel);
        }
        if (logLevel <= LOG_LEVEL_DEBUG) {
            logImpl.d(TAG, constructLogInfo(TAG, logStr, tr), tr);
        }
    }

    public static void i(String TAG, String logStr) {
        if (null == logImpl) {
            XmsLog.newInstance(defaultImpl(), logLevel);
        }
        if (logLevel <= LOG_LEVEL_INFO) {
            logImpl.i(TAG, constructLogInfo(TAG, logStr));
        }
    }

    public static void i(String TAG, String logStr, Throwable tr) {
        if (null == logImpl) {
            XmsLog.newInstance(defaultImpl(), logLevel);
        }
        if (logLevel <= LOG_LEVEL_INFO) {
            logImpl.i(TAG, constructLogInfo(TAG, logStr, tr), tr);
        }
    }

    public static void w(String TAG, String logStr) {
        if (null == logImpl) {
            XmsLog.newInstance(defaultImpl(), logLevel);
        }
        if (logLevel <= LOG_LEVEL_WARN) {
            logImpl.w(TAG, constructLogInfo(TAG, logStr));
        }
    }

    public static void w(String TAG, String logStr, Throwable tr) {
        if (null == logImpl) {
            XmsLog.newInstance(defaultImpl(), logLevel);
        }
        if (logLevel <= LOG_LEVEL_WARN) {
            logImpl.w(TAG, constructLogInfo(TAG, logStr, tr), tr);
        }
    }

    public static void e(String TAG, String logStr) {
        if (null == logImpl) {
            XmsLog.newInstance(defaultImpl(), logLevel);
        }
        if (logLevel <= LOG_LEVEL_ERROR) {
            logImpl.e(TAG, constructLogInfo(TAG, logStr));
        }
    }

    public static void e(String TAG, String logStr, Throwable tr) {
        if (null == logImpl) {
            XmsLog.newInstance(defaultImpl(), logLevel);
        }
        if (logLevel <= LOG_LEVEL_ERROR) {
            logImpl.e(TAG, constructLogInfo(TAG, logStr, tr), tr);
        }
    }

    private static String constructLogInfo(String TAG, String logStr) {
        return constructLogInfo(TAG, logStr, null);
    }

    private static String constructLogInfo(String TAG, String logStr, Throwable tr) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("[").append(TAG_XmsLog).append("]").append("[").append(TAG).append("]").append("|");
        if (null != tr) {
            StackTraceElement[] stackElements = tr.getStackTrace();
            buffer.append("[").append(stackElements[0].getClassName()).append(".").append(stackElements[0].getMethodName());
            buffer.append(":").append(stackElements[0].getLineNumber()).append("]");
            buffer.append(" | ");
        }
        buffer.append(logStr).append(" | ");
        buffer.append("[").append(getCurrentTime()).append("]");
        return buffer.toString();
    }

    private static String getCurrentTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        formatter.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        Date currTime = new Date();
        return formatter.format(currTime);
    }

    public interface XmsLogInterface {

        public void d(String TAG, String logStr);

        public void d(String TAG, String logStr, Throwable tr);

        public void i(String TAG, String logStr);

        public void i(String TAG, String logStr, Throwable tr);

        public void w(String TAG, String logStr);

        public void w(String TAG, String logStr, Throwable tr);

        public void e(String TAG, String logStr);

        public void e(String TAG, String logStr, Throwable tr);
    }
}

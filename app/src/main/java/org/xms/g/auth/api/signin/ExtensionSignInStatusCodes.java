package org.xms.g.auth.api.signin;

public final class ExtensionSignInStatusCodes extends org.xms.g.common.api.CommonStatusCodes {
    
    public ExtensionSignInStatusCodes(com.google.android.gms.auth.api.signin.GoogleSignInStatusCodes param0, com.huawei.hms.support.hwid.result.HuaweiIdAuthResultCode param1) {
        super(param0, null);
        this.setHInstance(param1);
    }
    
    public static int getSIGN_IN_CANCELLED() {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.huawei.hms.support.hwid.result.HuaweiIdAuthResultCode.RESULT_CODE_CANCELLED", new Exception());
            return com.huawei.hms.support.hwid.result.HuaweiIdAuthResultCode.RESULT_CODE_CANCELLED;
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.google.android.gms.auth.api.signin.GoogleSignInStatusCodes.SIGN_IN_CANCELLED", new Exception());
            return com.google.android.gms.auth.api.signin.GoogleSignInStatusCodes.SIGN_IN_CANCELLED;
        }
    }
    
    public static int getSIGN_IN_CURRENTLY_IN_PROGRESS() {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.huawei.hms.support.hwid.result.HuaweiIdAuthResultCode.RESULT_CODE_EXECUTING", new Exception());
            return com.huawei.hms.support.hwid.result.HuaweiIdAuthResultCode.RESULT_CODE_EXECUTING;
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.google.android.gms.auth.api.signin.GoogleSignInStatusCodes.SIGN_IN_CURRENTLY_IN_PROGRESS", new Exception());
            return com.google.android.gms.auth.api.signin.GoogleSignInStatusCodes.SIGN_IN_CURRENTLY_IN_PROGRESS;
        }
    }
    
    public static int getSIGN_IN_FAILED() {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.huawei.hms.support.hwid.result.HuaweiIdAuthResultCode.RESULT_CODE_FAILED", new Exception());
            return com.huawei.hms.support.hwid.result.HuaweiIdAuthResultCode.RESULT_CODE_FAILED;
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.google.android.gms.auth.api.signin.GoogleSignInStatusCodes.SIGN_IN_FAILED", new Exception());
            return com.google.android.gms.auth.api.signin.GoogleSignInStatusCodes.SIGN_IN_FAILED;
        }
    }
    
    public static java.lang.String getStatusCodeString(int param0) {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.huawei.hms.support.hwid.result.HuaweiIdAuthResultCode.getResultDescription(param0)", new Exception());
            return com.huawei.hms.support.hwid.result.HuaweiIdAuthResultCode.getResultDescription(param0);
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.google.android.gms.auth.api.signin.GoogleSignInStatusCodes.getStatusCodeString(param0)", new Exception());
            return com.google.android.gms.auth.api.signin.GoogleSignInStatusCodes.getStatusCodeString(param0);
        }
    }
    
    public static org.xms.g.auth.api.signin.ExtensionSignInStatusCodes dynamicCast(java.lang.Object param0) {
        return ((org.xms.g.auth.api.signin.ExtensionSignInStatusCodes) param0);
    }
    
    public static boolean isInstance(java.lang.Object param0) {
        if (!(param0 instanceof org.xms.g.utils.XObject)) {
            return false;
        }
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hms.support.hwid.result.HuaweiIdAuthResultCode;
        } else {
            return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.auth.api.signin.GoogleSignInStatusCodes;
        }
    }
}
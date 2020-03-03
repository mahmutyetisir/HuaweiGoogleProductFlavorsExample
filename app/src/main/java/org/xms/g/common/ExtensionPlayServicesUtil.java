package org.xms.g.common;





public final class ExtensionPlayServicesUtil extends org.xms.g.utils.XObject {
    
    
    
    
    public ExtensionPlayServicesUtil(com.google.android.gms.common.GooglePlayServicesUtil param0, com.huawei.hms.api.HuaweiMobileServicesUtil param1) {
        super(param0, null);
        this.setHInstance(param1);
    }
    
    public static java.lang.String getGMS_ERROR_DIALOG() {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.huawei.hms.api.HuaweiMobileServicesUtil.HMS_ERROR_DIALOG", new Exception());
            return com.huawei.hms.api.HuaweiMobileServicesUtil.HMS_ERROR_DIALOG;
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.google.android.gms.common.GooglePlayServicesUtil.GMS_ERROR_DIALOG", new Exception());
            return com.google.android.gms.common.GooglePlayServicesUtil.GMS_ERROR_DIALOG;
        }
    }
    
    public static java.lang.String getGOOGLE_PLAY_SERVICES_PACKAGE() {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static java.lang.String getGOOGLE_PLAY_STORE_PACKAGE() {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static int getGOOGLE_PLAY_SERVICES_VERSION_CODE() {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            
            return com.huawei.hms.api.HuaweiApiAvailability.SERVICES_VERSION_CODE;
            
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.google.android.gms.common.GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE", new Exception());
            return com.google.android.gms.common.GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE;
        }
    }
    
    public static android.app.Dialog getErrorDialog(int param0, android.app.Activity param1, int param2) {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.huawei.hms.api.HuaweiMobileServicesUtil.getErrorDialog(param0, param1, param2)", new Exception());
            return com.huawei.hms.api.HuaweiMobileServicesUtil.getErrorDialog(param0, param1, param2);
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.google.android.gms.common.GooglePlayServicesUtil.getErrorDialog(param0, param1, param2)", new Exception());
            return com.google.android.gms.common.GooglePlayServicesUtil.getErrorDialog(param0, param1, param2);
        }
    }
    
    public static android.app.Dialog getErrorDialog(int param0, android.app.Activity param1, int param2, android.content.DialogInterface.OnCancelListener param3) {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.huawei.hms.api.HuaweiMobileServicesUtil.getErrorDialog(param0, param1, param2, param3)", new Exception());
            return com.huawei.hms.api.HuaweiMobileServicesUtil.getErrorDialog(param0, param1, param2, param3);
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.google.android.gms.common.GooglePlayServicesUtil.getErrorDialog(param0, param1, param2, param3)", new Exception());
            return com.google.android.gms.common.GooglePlayServicesUtil.getErrorDialog(param0, param1, param2, param3);
        }
    }
    
    public static android.app.PendingIntent getErrorPendingIntent(int param0, android.content.Context param1, int param2) {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            
            return com.huawei.hms.api.HuaweiApiAvailability.getInstance().getErrPendingIntent(param1,param0,param2);
            
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.google.android.gms.common.GooglePlayServicesUtil.getErrorPendingIntent(param0, param1, param2)", new Exception());
            return com.google.android.gms.common.GooglePlayServicesUtil.getErrorPendingIntent(param0, param1, param2);
        }
    }
    
    public static java.lang.String getErrorString(int param0) {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.huawei.hms.api.HuaweiMobileServicesUtil.getErrorString(param0)", new Exception());
            return com.huawei.hms.api.HuaweiMobileServicesUtil.getErrorString(param0);
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.google.android.gms.common.GooglePlayServicesUtil.getErrorString(param0)", new Exception());
            return com.google.android.gms.common.GooglePlayServicesUtil.getErrorString(param0);
        }
    }
    
    public static final android.content.Context getRemoteContext(android.content.Context param0) {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.huawei.hms.api.HuaweiMobileServicesUtil.getRemoteContext(param0)", new Exception());
            return com.huawei.hms.api.HuaweiMobileServicesUtil.getRemoteContext(param0);
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.google.android.gms.common.GooglePlayServicesUtil.getRemoteContext(param0)", new Exception());
            return com.google.android.gms.common.GooglePlayServicesUtil.getRemoteContext(param0);
        }
    }
    
    public static final android.content.res.Resources getRemoteResource(android.content.Context param0) {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.huawei.hms.api.HuaweiMobileServicesUtil.getRemoteResource(param0)", new Exception());
            return com.huawei.hms.api.HuaweiMobileServicesUtil.getRemoteResource(param0);
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.google.android.gms.common.GooglePlayServicesUtil.getRemoteResource(param0)", new Exception());
            return com.google.android.gms.common.GooglePlayServicesUtil.getRemoteResource(param0);
        }
    }
    
    public static int isGooglePlayServicesAvailable(android.content.Context param0) {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.huawei.hms.api.HuaweiMobileServicesUtil.isHuaweiMobileServicesAvailable(param0)", new Exception());
            return com.huawei.hms.api.HuaweiMobileServicesUtil.isHuaweiMobileServicesAvailable(param0);
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.google.android.gms.common.GooglePlayServicesUtil.isGooglePlayServicesAvailable(param0)", new Exception());
            return com.google.android.gms.common.GooglePlayServicesUtil.isGooglePlayServicesAvailable(param0);
        }
    }
    
    public static int isGooglePlayServicesAvailable(android.content.Context param0, int param1) {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.huawei.hms.api.HuaweiMobileServicesUtil.isHuaweiMobileServicesAvailable(param0, param1)", new Exception());
            return com.huawei.hms.api.HuaweiMobileServicesUtil.isHuaweiMobileServicesAvailable(param0, param1);
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.google.android.gms.common.GooglePlayServicesUtil.isGooglePlayServicesAvailable(param0, param1)", new Exception());
            return com.google.android.gms.common.GooglePlayServicesUtil.isGooglePlayServicesAvailable(param0, param1);
        }
    }
    
    public static boolean isUserRecoverableError(int param0) {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.huawei.hms.api.HuaweiMobileServicesUtil.isUserRecoverableError(param0)", new Exception());
            return com.huawei.hms.api.HuaweiMobileServicesUtil.isUserRecoverableError(param0);
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.google.android.gms.common.GooglePlayServicesUtil.isUserRecoverableError(param0)", new Exception());
            return com.google.android.gms.common.GooglePlayServicesUtil.isUserRecoverableError(param0);
        }
    }
    
    public static boolean showErrorDialogFragment(int param0, android.app.Activity param1, int param2, android.content.DialogInterface.OnCancelListener param3) {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.huawei.hms.api.HuaweiMobileServicesUtil.popupErrDlgFragment(param0, param1, param2, param3)", new Exception());
            return com.huawei.hms.api.HuaweiMobileServicesUtil.popupErrDlgFragment(param0, param1, param2, param3);
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.google.android.gms.common.GooglePlayServicesUtil.showErrorDialogFragment(param0, param1, param2, param3)", new Exception());
            return com.google.android.gms.common.GooglePlayServicesUtil.showErrorDialogFragment(param0, param1, param2, param3);
        }
    }
    
    public static boolean showErrorDialogFragment(int param0, android.app.Activity param1, androidx.fragment.app.Fragment param2, int param3, android.content.DialogInterface.OnCancelListener param4) {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            
            return com.huawei.hms.api.HuaweiMobileServicesUtil.popupErrDlgFragment(param0,param1,null,param3,param4);
            
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.google.android.gms.common.GooglePlayServicesUtil.showErrorDialogFragment(param0, param1, param2, param3, param4)", new Exception());
            return com.google.android.gms.common.GooglePlayServicesUtil.showErrorDialogFragment(param0, param1, param2, param3, param4);
        }
    }
    
    public static boolean showErrorDialogFragment(int param0, android.app.Activity param1, int param2) {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.huawei.hms.api.HuaweiMobileServicesUtil.showErrorDialogFragment(param0, param1, param2)", new Exception());
            return com.huawei.hms.api.HuaweiMobileServicesUtil.showErrorDialogFragment(param0, param1, param2);
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.google.android.gms.common.GooglePlayServicesUtil.showErrorDialogFragment(param0, param1, param2)", new Exception());
            return com.google.android.gms.common.GooglePlayServicesUtil.showErrorDialogFragment(param0, param1, param2);
        }
    }
    
    public static final void showErrorNotification(int param0, android.content.Context param1) {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.huawei.hms.api.HuaweiMobileServicesUtil.showErrorNotification(param0, param1)", new Exception());
            com.huawei.hms.api.HuaweiMobileServicesUtil.showErrorNotification(param0, param1);
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.google.android.gms.common.GooglePlayServicesUtil.showErrorNotification(param0, param1)", new Exception());
            com.google.android.gms.common.GooglePlayServicesUtil.showErrorNotification(param0, param1);
        }
    }
    
    public static org.xms.g.common.ExtensionPlayServicesUtil dynamicCast(java.lang.Object param0) {
        return ((org.xms.g.common.ExtensionPlayServicesUtil) param0);
    }
    
    public static boolean isInstance(java.lang.Object param0) {
        if (!(param0 instanceof org.xms.g.utils.XObject)) {
            return false;
        }
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hms.api.HuaweiMobileServicesUtil;
        } else {
            return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.common.GooglePlayServicesUtil;
        }
    }
}
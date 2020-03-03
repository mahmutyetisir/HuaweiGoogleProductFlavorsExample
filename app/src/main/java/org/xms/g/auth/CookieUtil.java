package org.xms.g.auth;

public final class CookieUtil extends org.xms.g.utils.XObject {
    
    public CookieUtil(com.google.android.gms.auth.CookieUtil param0, com.huawei.hms.support.hwid.tools.NetworkTool param1) {
        super(param0, null);
        this.setHInstance(param1);
    }
    
    public static final java.lang.String getCookieUrl(java.lang.String param0, java.lang.Boolean param1) {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.huawei.hms.support.hwid.tools.NetworkTool.buildNetworkUrl(param0, param1)", new Exception());
            return com.huawei.hms.support.hwid.tools.NetworkTool.buildNetworkUrl(param0, param1);
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.google.android.gms.auth.CookieUtil.getCookieUrl(param0, param1)", new Exception());
            return com.google.android.gms.auth.CookieUtil.getCookieUrl(param0, param1);
        }
    }
    
    public static final java.lang.String getCookieValue(java.lang.String param0, java.lang.String param1, java.lang.String param2, java.lang.String param3, java.lang.Boolean param4, java.lang.Boolean param5, java.lang.Long param6) {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.huawei.hms.support.hwid.tools.NetworkTool.buildNetworkCookie(param0, param1, param2, param3, param4, param5, param6)", new Exception());
            return com.huawei.hms.support.hwid.tools.NetworkTool.buildNetworkCookie(param0, param1, param2, param3, param4, param5, param6);
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.google.android.gms.auth.CookieUtil.getCookieValue(param0, param1, param2, param3, param4, param5, param6)", new Exception());
            return com.google.android.gms.auth.CookieUtil.getCookieValue(param0, param1, param2, param3, param4, param5, param6);
        }
    }
    
    public static org.xms.g.auth.CookieUtil dynamicCast(java.lang.Object param0) {
        return ((org.xms.g.auth.CookieUtil) param0);
    }
    
    public static boolean isInstance(java.lang.Object param0) {
        if (!(param0 instanceof org.xms.g.utils.XObject)) {
            return false;
        }
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hms.support.hwid.tools.NetworkTool;
        } else {
            return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.auth.CookieUtil;
        }
    }
}
package org.xms.g.common.api;

public final class UnsupportedApiCallException extends java.lang.UnsupportedOperationException implements org.xms.g.utils.XGettable {
    public com.google.android.gms.common.api.UnsupportedApiCallException gInstance;
    public com.huawei.hms.common.api.UnsupportedApiCallException hInstance;
    
    public UnsupportedApiCallException(com.google.android.gms.common.api.UnsupportedApiCallException param0, com.huawei.hms.common.api.UnsupportedApiCallException param1) {
        gInstance = param0;
        hInstance = param1;
    }
    
    public final java.lang.String getMessage() {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.common.api.UnsupportedApiCallException) this.getHInstance()).getMessage()", new Exception());
            return ((com.huawei.hms.common.api.UnsupportedApiCallException) this.getHInstance()).getMessage();
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.common.api.UnsupportedApiCallException) this.getGInstance()).getMessage()", new Exception());
            return ((com.google.android.gms.common.api.UnsupportedApiCallException) this.getGInstance()).getMessage();
        }
    }
    
    public void setGInstance(com.google.android.gms.common.api.UnsupportedApiCallException param0) {
        this.gInstance = param0;
    }
    
    public void setHInstance(com.huawei.hms.common.api.UnsupportedApiCallException param0) {
        this.hInstance = param0;
    }
    
    public java.lang.Object getGInstance() {
        return this.gInstance;
    }
    
    public java.lang.Object getHInstance() {
        return this.hInstance;
    }
    
    public static org.xms.g.common.api.UnsupportedApiCallException dynamicCast(java.lang.Object param0) {
        return ((org.xms.g.common.api.UnsupportedApiCallException) param0);
    }
    
    public static boolean isInstance(java.lang.Object param0) {
        if (!(param0 instanceof org.xms.g.utils.XObject)) {
            return false;
        }
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hms.common.api.UnsupportedApiCallException;
        } else {
            return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.common.api.UnsupportedApiCallException;
        }
    }
}
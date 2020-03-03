package org.xms.g.common;

public final class ExtensionPlayServicesNotAvailableException extends java.lang.Exception implements org.xms.g.utils.XGettable {
    public com.google.android.gms.common.GooglePlayServicesNotAvailableException gInstance;
    public com.huawei.hms.api.HuaweiServicesNotAvailableException hInstance;
    
    public ExtensionPlayServicesNotAvailableException(com.google.android.gms.common.GooglePlayServicesNotAvailableException param0, com.huawei.hms.api.HuaweiServicesNotAvailableException param1) {
        gInstance = param0;
        hInstance = param1;
    }
    
    public ExtensionPlayServicesNotAvailableException(int param0) {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            this.setHInstance(new com.huawei.hms.api.HuaweiServicesNotAvailableException(param0));
        } else {
            this.setGInstance(new com.google.android.gms.common.GooglePlayServicesNotAvailableException(param0));
        }
    }
    
    public int getErrorCode() {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.api.HuaweiServicesNotAvailableException) this.getHInstance()).errorCode", new Exception());
            return ((com.huawei.hms.api.HuaweiServicesNotAvailableException) this.getHInstance()).errorCode;
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.common.GooglePlayServicesNotAvailableException) this.getGInstance()).errorCode", new Exception());
            return ((com.google.android.gms.common.GooglePlayServicesNotAvailableException) this.getGInstance()).errorCode;
        }
    }
    
    public void setGInstance(com.google.android.gms.common.GooglePlayServicesNotAvailableException param0) {
        this.gInstance = param0;
    }
    
    public void setHInstance(com.huawei.hms.api.HuaweiServicesNotAvailableException param0) {
        this.hInstance = param0;
    }
    
    public java.lang.Object getGInstance() {
        return this.gInstance;
    }
    
    public java.lang.Object getHInstance() {
        return this.hInstance;
    }
    
    public static org.xms.g.common.ExtensionPlayServicesNotAvailableException dynamicCast(java.lang.Object param0) {
        return ((org.xms.g.common.ExtensionPlayServicesNotAvailableException) param0);
    }
    
    public static boolean isInstance(java.lang.Object param0) {
        if (!(param0 instanceof org.xms.g.utils.XObject)) {
            return false;
        }
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hms.api.HuaweiServicesNotAvailableException;
        } else {
            return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.common.GooglePlayServicesNotAvailableException;
        }
    }
}
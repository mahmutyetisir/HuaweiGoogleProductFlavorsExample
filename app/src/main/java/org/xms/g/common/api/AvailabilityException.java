package org.xms.g.common.api;





public class AvailabilityException extends java.lang.Exception implements org.xms.g.utils.XGettable {
    private boolean wrapper = true;
    public com.google.android.gms.common.api.AvailabilityException gInstance;
    public com.huawei.hms.common.api.AvailabilityException hInstance;
    
    
    
    
    public AvailabilityException(com.google.android.gms.common.api.AvailabilityException param0, com.huawei.hms.common.api.AvailabilityException param1) {
        gInstance = param0;
        hInstance = param1;
        wrapper = true;
    }
    
    public org.xms.g.common.ConnectionResult getConnectionResult(org.xms.g.common.api.ExtensionApi<? extends org.xms.g.common.api.Api.ApiOptions> param0) {
        com.google.android.gms.common.ConnectionResult gReturn = null;
        com.huawei.hms.api.ConnectionResult hReturn = null;
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.huawei.hms.common.api.AvailabilityException.getConnectionResult(HuaweiApi)", new Exception());
            
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.common.api.AvailabilityException) this.getGInstance()).getConnectionResult(((com.google.android.gms.common.api.GoogleApi) ((param0) == null ? null : (param0.getGInstance()))))", new Exception());
            gReturn = ((com.google.android.gms.common.api.AvailabilityException) this.getGInstance()).getConnectionResult(((com.google.android.gms.common.api.GoogleApi) ((param0) == null ? null : (param0.getGInstance()))));
        }
        if (gReturn == null && hReturn == null) {
            return null;
        }
        return new org.xms.g.common.ConnectionResult(gReturn, hReturn);
    }
    
    public java.lang.String getMessage() {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.common.api.AvailabilityException) this.getHInstance()).getMessage()", new Exception());
            return ((com.huawei.hms.common.api.AvailabilityException) this.getHInstance()).getMessage();
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.common.api.AvailabilityException) this.getGInstance()).getMessage()", new Exception());
            return ((com.google.android.gms.common.api.AvailabilityException) this.getGInstance()).getMessage();
        }
    }
    
    public void setGInstance(com.google.android.gms.common.api.AvailabilityException param0) {
        this.gInstance = param0;
    }
    
    public void setHInstance(com.huawei.hms.common.api.AvailabilityException param0) {
        this.hInstance = param0;
    }
    
    public java.lang.Object getGInstance() {
        return this.gInstance;
    }
    
    public java.lang.Object getHInstance() {
        return this.hInstance;
    }
    
    public static org.xms.g.common.api.AvailabilityException dynamicCast(java.lang.Object param0) {
        return ((org.xms.g.common.api.AvailabilityException) param0);
    }
    
    public static boolean isInstance(java.lang.Object param0) {
        if (!(param0 instanceof org.xms.g.utils.XObject)) {
            return false;
        }
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hms.common.api.AvailabilityException;
        } else {
            return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.common.api.AvailabilityException;
        }
    }
}
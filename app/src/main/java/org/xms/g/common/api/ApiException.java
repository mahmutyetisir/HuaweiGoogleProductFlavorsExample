package org.xms.g.common.api;

public class ApiException extends java.lang.Exception implements org.xms.g.utils.XGettable {
    private boolean wrapper = true;
    public com.google.android.gms.common.api.ApiException gInstance;
    public com.huawei.hms.common.ApiException hInstance;
    
    public ApiException(com.google.android.gms.common.api.ApiException param0, com.huawei.hms.common.ApiException param1) {
        gInstance = param0;
        hInstance = param1;
        wrapper = true;
    }
    
    public ApiException(org.xms.g.common.api.Status param0) {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            this.setHInstance(new HImpl(((com.huawei.hms.support.api.client.Status) ((param0) == null ? null : (param0.getHInstance())))));
        } else {
            this.setGInstance(new GImpl(((com.google.android.gms.common.api.Status) ((param0) == null ? null : (param0.getGInstance())))));
        }
        wrapper = false;
    }
    
    public int getStatusCode() {
        if (wrapper) {
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.common.ApiException) this.getHInstance()).getStatusCode()", new Exception());
                return ((com.huawei.hms.common.ApiException) this.getHInstance()).getStatusCode();
            } else {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.common.api.ApiException) this.getGInstance()).getStatusCode()", new Exception());
                return ((com.google.android.gms.common.api.ApiException) this.getGInstance()).getStatusCode();
            }
        } else {
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                return ((HImpl) ((com.huawei.hms.common.ApiException) this.getHInstance())).getStatusCodeCallSuper();
            } else {
                return ((GImpl) ((com.google.android.gms.common.api.ApiException) this.getGInstance())).getStatusCodeCallSuper();
            }
        }
    }
    
    public java.lang.String getStatusMessage() {
        if (wrapper) {
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.common.ApiException) this.getHInstance()).getStatusMessage()", new Exception());
                return ((com.huawei.hms.common.ApiException) this.getHInstance()).getStatusMessage();
            } else {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.common.api.ApiException) this.getGInstance()).getStatusMessage()", new Exception());
                return ((com.google.android.gms.common.api.ApiException) this.getGInstance()).getStatusMessage();
            }
        } else {
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                return ((HImpl) ((com.huawei.hms.common.ApiException) this.getHInstance())).getStatusMessageCallSuper();
            } else {
                return ((GImpl) ((com.google.android.gms.common.api.ApiException) this.getGInstance())).getStatusMessageCallSuper();
            }
        }
    }
    
    public void setGInstance(com.google.android.gms.common.api.ApiException param0) {
        this.gInstance = param0;
    }
    
    public void setHInstance(com.huawei.hms.common.ApiException param0) {
        this.hInstance = param0;
    }
    
    public java.lang.Object getGInstance() {
        return this.gInstance;
    }
    
    public java.lang.Object getHInstance() {
        return this.hInstance;
    }
    
    public static org.xms.g.common.api.ApiException dynamicCast(java.lang.Object param0) {
        return ((org.xms.g.common.api.ApiException) param0);
    }
    
    public static boolean isInstance(java.lang.Object param0) {
        if (!(param0 instanceof org.xms.g.utils.XObject)) {
            return false;
        }
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hms.common.ApiException;
        } else {
            return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.common.api.ApiException;
        }
    }
    
    public class GImpl extends com.google.android.gms.common.api.ApiException {
        
        public int getStatusCode() {
            return org.xms.g.common.api.ApiException.this.getStatusCode();
        }
        
        public java.lang.String getStatusMessage() {
            return org.xms.g.common.api.ApiException.this.getStatusMessage();
        }
        
        public int getStatusCodeCallSuper() {
            return super.getStatusCode();
        }
        
        public java.lang.String getStatusMessageCallSuper() {
            return super.getStatusMessage();
        }
        
        public GImpl(com.google.android.gms.common.api.Status param0) {
            super(param0);
        }
    }
    
    public class HImpl extends com.huawei.hms.common.ApiException {
        
        public int getStatusCode() {
            return org.xms.g.common.api.ApiException.this.getStatusCode();
        }
        
        public java.lang.String getStatusMessage() {
            return org.xms.g.common.api.ApiException.this.getStatusMessage();
        }
        
        public int getStatusCodeCallSuper() {
            return super.getStatusCode();
        }
        
        public java.lang.String getStatusMessageCallSuper() {
            return super.getStatusMessage();
        }
        
        public HImpl(com.huawei.hms.support.api.client.Status param0) {
            super(param0);
        }
    }
}
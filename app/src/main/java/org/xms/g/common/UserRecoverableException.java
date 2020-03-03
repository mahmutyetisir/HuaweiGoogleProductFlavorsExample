package org.xms.g.common;

public class UserRecoverableException extends java.lang.Exception implements org.xms.g.utils.XGettable {
    private boolean wrapper = true;
    public com.google.android.gms.common.UserRecoverableException gInstance;
    public com.huawei.hms.api.UserRecoverableException hInstance;
    
    public UserRecoverableException(com.google.android.gms.common.UserRecoverableException param0, com.huawei.hms.api.UserRecoverableException param1) {
        gInstance = param0;
        hInstance = param1;
        wrapper = true;
    }
    
    public UserRecoverableException(java.lang.String param0, android.content.Intent param1) {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            this.setHInstance(new HImpl(param0, param1));
        } else {
            this.setGInstance(new GImpl(param0, param1));
        }
        wrapper = false;
    }
    
    public android.content.Intent getIntent() {
        if (wrapper) {
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.api.UserRecoverableException) this.getHInstance()).getIntent()", new Exception());
                return ((com.huawei.hms.api.UserRecoverableException) this.getHInstance()).getIntent();
            } else {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.common.UserRecoverableException) this.getGInstance()).getIntent()", new Exception());
                return ((com.google.android.gms.common.UserRecoverableException) this.getGInstance()).getIntent();
            }
        } else {
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                return ((HImpl) ((com.huawei.hms.api.UserRecoverableException) this.getHInstance())).getIntentCallSuper();
            } else {
                return ((GImpl) ((com.google.android.gms.common.UserRecoverableException) this.getGInstance())).getIntentCallSuper();
            }
        }
    }
    
    public void setGInstance(com.google.android.gms.common.UserRecoverableException param0) {
        this.gInstance = param0;
    }
    
    public void setHInstance(com.huawei.hms.api.UserRecoverableException param0) {
        this.hInstance = param0;
    }
    
    public java.lang.Object getGInstance() {
        return this.gInstance;
    }
    
    public java.lang.Object getHInstance() {
        return this.hInstance;
    }
    
    public static org.xms.g.common.UserRecoverableException dynamicCast(java.lang.Object param0) {
        return ((org.xms.g.common.UserRecoverableException) param0);
    }
    
    public static boolean isInstance(java.lang.Object param0) {
        if (!(param0 instanceof org.xms.g.utils.XObject)) {
            return false;
        }
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hms.api.UserRecoverableException;
        } else {
            return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.common.UserRecoverableException;
        }
    }
    
    public class GImpl extends com.google.android.gms.common.UserRecoverableException {
        
        public android.content.Intent getIntent() {
            return org.xms.g.common.UserRecoverableException.this.getIntent();
        }
        
        public android.content.Intent getIntentCallSuper() {
            return super.getIntent();
        }
        
        public GImpl(java.lang.String param0, android.content.Intent param1) {
            super(param0, param1);
        }
    }
    
    public class HImpl extends com.huawei.hms.api.UserRecoverableException {
        
        public android.content.Intent getIntent() {
            return org.xms.g.common.UserRecoverableException.this.getIntent();
        }
        
        public android.content.Intent getIntentCallSuper() {
            return super.getIntent();
        }
        
        public HImpl(java.lang.String param0, android.content.Intent param1) {
            super(param0, param1);
        }
    }
}
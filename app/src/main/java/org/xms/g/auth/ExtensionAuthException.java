package org.xms.g.auth;

public class ExtensionAuthException extends java.lang.Exception implements org.xms.g.utils.XGettable {
    private boolean wrapper = true;
    public com.google.android.gms.auth.GoogleAuthException gInstance;
    public com.huawei.hms.support.hwid.common.HuaweiIdAuthException hInstance;
    
    public ExtensionAuthException(com.google.android.gms.auth.GoogleAuthException param0, com.huawei.hms.support.hwid.common.HuaweiIdAuthException param1) {
        gInstance = param0;
        hInstance = param1;
        wrapper = true;
    }
    
    public ExtensionAuthException() {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            this.setHInstance(new HImpl());
        } else {
            this.setGInstance(new GImpl());
        }
        wrapper = false;
    }
    
    public ExtensionAuthException(java.lang.String param0) {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            this.setHInstance(new HImpl(param0));
        } else {
            this.setGInstance(new GImpl(param0));
        }
        wrapper = false;
    }
    
    public ExtensionAuthException(java.lang.String param0, java.lang.Throwable param1) {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            this.setHInstance(new HImpl(param0, param1));
        } else {
            this.setGInstance(new GImpl(param0, param1));
        }
        wrapper = false;
    }
    
    public ExtensionAuthException(java.lang.Throwable param0) {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            this.setHInstance(new HImpl(param0));
        } else {
            this.setGInstance(new GImpl(param0));
        }
        wrapper = false;
    }
    
    public void setGInstance(com.google.android.gms.auth.GoogleAuthException param0) {
        this.gInstance = param0;
    }
    
    public void setHInstance(com.huawei.hms.support.hwid.common.HuaweiIdAuthException param0) {
        this.hInstance = param0;
    }
    
    public java.lang.Object getGInstance() {
        return this.gInstance;
    }
    
    public java.lang.Object getHInstance() {
        return this.hInstance;
    }
    
    public static org.xms.g.auth.ExtensionAuthException dynamicCast(java.lang.Object param0) {
        return ((org.xms.g.auth.ExtensionAuthException) param0);
    }
    
    public static boolean isInstance(java.lang.Object param0) {
        if (!(param0 instanceof org.xms.g.utils.XObject)) {
            return false;
        }
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hms.support.hwid.common.HuaweiIdAuthException;
        } else {
            return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.auth.GoogleAuthException;
        }
    }
    
    public class GImpl extends com.google.android.gms.auth.GoogleAuthException {
        
        public GImpl() {
            super();
        }
        
        public GImpl(java.lang.String param0) {
            super(param0);
        }
        
        public GImpl(java.lang.String param0, java.lang.Throwable param1) {
            super(param0, param1);
        }
        
        public GImpl(java.lang.Throwable param0) {
            super(param0);
        }
    }
    
    public class HImpl extends com.huawei.hms.support.hwid.common.HuaweiIdAuthException {
        
        public HImpl() {
            super();
        }
        
        public HImpl(java.lang.String param0) {
            super(param0);
        }
        
        public HImpl(java.lang.String param0, java.lang.Throwable param1) {
            super(param0, param1);
        }
        
        public HImpl(java.lang.Throwable param0) {
            super(param0);
        }
    }
}
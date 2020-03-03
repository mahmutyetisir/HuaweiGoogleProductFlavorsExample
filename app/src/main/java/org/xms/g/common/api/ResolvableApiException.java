package org.xms.g.common.api;

public class ResolvableApiException extends org.xms.g.common.api.ApiException {
    private boolean wrapper = true;
    
    public ResolvableApiException(com.google.android.gms.common.api.ResolvableApiException param0, com.huawei.hms.common.ResolvableApiException param1) {
        super(param0, null);
        this.setHInstance(param1);
        wrapper = true;
    }
    
    public ResolvableApiException(org.xms.g.common.api.Status param0) {
        super(((com.google.android.gms.common.api.ResolvableApiException) null), null);
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            this.setHInstance(new HImpl(((com.huawei.hms.support.api.client.Status) ((param0) == null ? null : (param0.getHInstance())))));
        } else {
            this.setGInstance(new GImpl(((com.google.android.gms.common.api.Status) ((param0) == null ? null : (param0.getGInstance())))));
        }
        wrapper = false;
    }
    
    public android.app.PendingIntent getResolution() {
        if (wrapper) {
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.common.ResolvableApiException) this.getHInstance()).getResolution()", new Exception());
                return ((com.huawei.hms.common.ResolvableApiException) this.getHInstance()).getResolution();
            } else {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.common.api.ResolvableApiException) this.getGInstance()).getResolution()", new Exception());
                return ((com.google.android.gms.common.api.ResolvableApiException) this.getGInstance()).getResolution();
            }
        } else {
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                return ((HImpl) ((com.huawei.hms.common.ResolvableApiException) this.getHInstance())).getResolutionCallSuper();
            } else {
                return ((GImpl) ((com.google.android.gms.common.api.ResolvableApiException) this.getGInstance())).getResolutionCallSuper();
            }
        }
    }
    
    public void startResolutionForResult(android.app.Activity param0, int param1) throws android.content.IntentSender.SendIntentException {
        if (wrapper) {
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.common.ResolvableApiException) this.getHInstance()).startResolutionForResult(param0, param1)", new Exception());
                ((com.huawei.hms.common.ResolvableApiException) this.getHInstance()).startResolutionForResult(param0, param1);
            } else {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.common.api.ResolvableApiException) this.getGInstance()).startResolutionForResult(param0, param1)", new Exception());
                ((com.google.android.gms.common.api.ResolvableApiException) this.getGInstance()).startResolutionForResult(param0, param1);
            }
        } else {
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                ((HImpl) ((com.huawei.hms.common.ResolvableApiException) this.getHInstance())).startResolutionForResultCallSuper(param0, param1);
            } else {
                ((GImpl) ((com.google.android.gms.common.api.ResolvableApiException) this.getGInstance())).startResolutionForResultCallSuper(param0, param1);
            }
        }
    }
    
    public static org.xms.g.common.api.ResolvableApiException dynamicCast(java.lang.Object param0) {
        return ((org.xms.g.common.api.ResolvableApiException) param0);
    }
    
    public static boolean isInstance(java.lang.Object param0) {
        if (!(param0 instanceof org.xms.g.utils.XObject)) {
            return false;
        }
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hms.common.ResolvableApiException;
        } else {
            return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.common.api.ResolvableApiException;
        }
    }
    
    public class GImpl extends com.google.android.gms.common.api.ResolvableApiException {
        
        public android.app.PendingIntent getResolution() {
            return org.xms.g.common.api.ResolvableApiException.this.getResolution();
        }
        
        public void startResolutionForResult(android.app.Activity param0, int param1) throws android.content.IntentSender.SendIntentException {
            org.xms.g.common.api.ResolvableApiException.this.startResolutionForResult(param0, param1);
        }
        
        public android.app.PendingIntent getResolutionCallSuper() {
            return super.getResolution();
        }
        
        public void startResolutionForResultCallSuper(android.app.Activity param0, int param1) throws android.content.IntentSender.SendIntentException {
            super.startResolutionForResult(param0, param1);
        }
        
        public GImpl(com.google.android.gms.common.api.Status param0) {
            super(param0);
        }
    }
    
    public class HImpl extends com.huawei.hms.common.ResolvableApiException {
        
        public android.app.PendingIntent getResolution() {
            return org.xms.g.common.api.ResolvableApiException.this.getResolution();
        }
        
        public void startResolutionForResult(android.app.Activity param0, int param1) throws android.content.IntentSender.SendIntentException {
            org.xms.g.common.api.ResolvableApiException.this.startResolutionForResult(param0, param1);
        }
        
        public android.app.PendingIntent getResolutionCallSuper() {
            return super.getResolution();
        }
        
        public void startResolutionForResultCallSuper(android.app.Activity param0, int param1) throws android.content.IntentSender.SendIntentException {
            super.startResolutionForResult(param0, param1);
        }
        
        public HImpl(com.huawei.hms.support.api.client.Status param0) {
            super(param0);
        }
    }
}
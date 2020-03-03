package org.xms.g.common.api;

public abstract class ResolvingResultCallbacks<XR extends org.xms.g.common.api.Result> extends org.xms.g.common.api.ResultCallbacks<XR> {
    private boolean wrapper = true;
    
    public ResolvingResultCallbacks(com.google.android.gms.common.api.ResolvingResultCallbacks param0, com.huawei.hms.support.api.client.ResolvingResultCallbacks param1) {
        super(param0, null);
        this.setHInstance(param1);
        wrapper = true;
    }
    
    public ResolvingResultCallbacks(android.app.Activity param0, int param1) {
        super(((com.google.android.gms.common.api.ResolvingResultCallbacks) null), null);
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            this.setHInstance(new HImpl(param0, param1));
        } else {
            this.setGInstance(new GImpl(param0, param1));
        }
        wrapper = false;
    }
    
    public abstract void onSuccess(XR param0);
    
    public abstract void onUnresolvableFailure(org.xms.g.common.api.Status param0);
    
    public static org.xms.g.common.api.ResolvingResultCallbacks dynamicCast(java.lang.Object param0) {
        if (param0 instanceof org.xms.g.common.api.ResolvingResultCallbacks) {
            return ((org.xms.g.common.api.ResolvingResultCallbacks) param0);
        }
        if (param0 instanceof org.xms.g.utils.XGettable) {
            com.google.android.gms.common.api.ResolvingResultCallbacks gReturn = ((com.google.android.gms.common.api.ResolvingResultCallbacks) ((org.xms.g.utils.XGettable) param0).getGInstance());
            com.huawei.hms.support.api.client.ResolvingResultCallbacks hReturn = ((com.huawei.hms.support.api.client.ResolvingResultCallbacks) ((org.xms.g.utils.XGettable) param0).getHInstance());
            return new org.xms.g.common.api.ResolvingResultCallbacks.XImpl(gReturn, hReturn);
        }
        return ((org.xms.g.common.api.ResolvingResultCallbacks) param0);
    }
    
    public static boolean isInstance(java.lang.Object param0) {
        if (!(param0 instanceof org.xms.g.utils.XObject)) {
            return false;
        }
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hms.support.api.client.ResolvingResultCallbacks;
        } else {
            return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.common.api.ResolvingResultCallbacks;
        }
    }
    
    public class GImpl<R extends com.google.android.gms.common.api.Result> extends com.google.android.gms.common.api.ResolvingResultCallbacks<R> {
        
        public void onSuccess(R param0) {
            java.lang.Object[] params = new java.lang.Object[1];
            java.lang.Class[] types = new java.lang.Class[1];
            params[0] = param0;
            types[0] = org.xms.g.common.api.Result.class;
            org.xms.g.utils.Utils.invokeBridgeMethod(org.xms.g.common.api.ResolvingResultCallbacks.this, "onSuccess", params, types, false);
        }
        
        public void onUnresolvableFailure(com.google.android.gms.common.api.Status param0) {
            org.xms.g.common.api.ResolvingResultCallbacks.this.onUnresolvableFailure(new org.xms.g.common.api.Status(param0, null));
        }
        
        public GImpl(android.app.Activity param0, int param1) {
            super(param0, param1);
        }
    }
    
    public class HImpl<R extends com.huawei.hms.support.api.client.Result> extends com.huawei.hms.support.api.client.ResolvingResultCallbacks<R> {
        
        public void onSuccess(R param0) {
            java.lang.Object[] params = new java.lang.Object[1];
            java.lang.Class[] types = new java.lang.Class[1];
            params[0] = param0;
            types[0] = org.xms.g.common.api.Result.class;
            org.xms.g.utils.Utils.invokeBridgeMethod(org.xms.g.common.api.ResolvingResultCallbacks.this, "onSuccess", params, types, true);
        }
        
        public void onUnresolvableFailure(com.huawei.hms.support.api.client.Status param0) {
            org.xms.g.common.api.ResolvingResultCallbacks.this.onUnresolvableFailure(new org.xms.g.common.api.Status(null, param0));
        }
        
        protected HImpl(android.app.Activity param0, int param1) {
            super(param0, param1);
        }
    }
    
    public static class XImpl<XR extends org.xms.g.common.api.Result> extends org.xms.g.common.api.ResolvingResultCallbacks<XR> {
        
        public XImpl(com.google.android.gms.common.api.ResolvingResultCallbacks param0, com.huawei.hms.support.api.client.ResolvingResultCallbacks param1) {
            super(param0, param1);
        }
        
        public static boolean isInstance(java.lang.Object param0) {
            if (!(param0 instanceof org.xms.g.utils.XObject)) {
                return false;
            }
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hms.support.api.client.ResolvingResultCallbacks;
            } else {
                return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.common.api.ResolvingResultCallbacks;
            }
        }
        
        public void onSuccess(XR param0) {
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                java.lang.Object hObj0 = org.xms.g.utils.Utils.getInstanceInInterface(param0, true);
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.support.api.client.ResolvingResultCallbacks) this.getHInstance()).onSuccess(((com.huawei.hms.support.api.client.Result) hObj0))", new Exception());
                ((com.huawei.hms.support.api.client.ResolvingResultCallbacks) this.getHInstance()).onSuccess(((com.huawei.hms.support.api.client.Result) hObj0));
            } else {
                java.lang.Object gObj0 = org.xms.g.utils.Utils.getInstanceInInterface(param0, false);
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.common.api.ResolvingResultCallbacks) this.getGInstance()).onSuccess(((com.google.android.gms.common.api.Result) gObj0))", new Exception());
                ((com.google.android.gms.common.api.ResolvingResultCallbacks) this.getGInstance()).onSuccess(((com.google.android.gms.common.api.Result) gObj0));
            }
        }
        
        public void onUnresolvableFailure(org.xms.g.common.api.Status param0) {
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.support.api.client.ResolvingResultCallbacks) this.getHInstance()).onUnresolvableFailure(((com.huawei.hms.support.api.client.Status) ((param0) == null ? null : (param0.getHInstance()))))", new Exception());
                ((com.huawei.hms.support.api.client.ResolvingResultCallbacks) this.getHInstance()).onUnresolvableFailure(((com.huawei.hms.support.api.client.Status) ((param0) == null ? null : (param0.getHInstance()))));
            } else {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.common.api.ResolvingResultCallbacks) this.getGInstance()).onUnresolvableFailure(((com.google.android.gms.common.api.Status) ((param0) == null ? null : (param0.getGInstance()))))", new Exception());
                ((com.google.android.gms.common.api.ResolvingResultCallbacks) this.getGInstance()).onUnresolvableFailure(((com.google.android.gms.common.api.Status) ((param0) == null ? null : (param0.getGInstance()))));
            }
        }
        
        public void onFailure(org.xms.g.common.api.Status param0) {
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.support.api.client.ResolvingResultCallbacks) this.getHInstance()).onFailure(((com.huawei.hms.support.api.client.Status) ((param0) == null ? null : (param0.getHInstance()))))", new Exception());
                ((com.huawei.hms.support.api.client.ResolvingResultCallbacks) this.getHInstance()).onFailure(((com.huawei.hms.support.api.client.Status) ((param0) == null ? null : (param0.getHInstance()))));
            } else {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.common.api.ResolvingResultCallbacks) this.getGInstance()).onFailure(((com.google.android.gms.common.api.Status) ((param0) == null ? null : (param0.getGInstance()))))", new Exception());
                ((com.google.android.gms.common.api.ResolvingResultCallbacks) this.getGInstance()).onFailure(((com.google.android.gms.common.api.Status) ((param0) == null ? null : (param0.getGInstance()))));
            }
        }
        
        public void onResult(XR param0) {
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                java.lang.Object hObj0 = org.xms.g.utils.Utils.getInstanceInInterface(param0, true);
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.support.api.client.ResolvingResultCallbacks) this.getHInstance()).onResult(((com.huawei.hms.support.api.client.Result) hObj0))", new Exception());
                ((com.huawei.hms.support.api.client.ResolvingResultCallbacks) this.getHInstance()).onResult(((com.huawei.hms.support.api.client.Result) hObj0));
            } else {
                java.lang.Object gObj0 = org.xms.g.utils.Utils.getInstanceInInterface(param0, false);
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.common.api.ResolvingResultCallbacks) this.getGInstance()).onResult(((com.google.android.gms.common.api.Result) gObj0))", new Exception());
                ((com.google.android.gms.common.api.ResolvingResultCallbacks) this.getGInstance()).onResult(((com.google.android.gms.common.api.Result) gObj0));
            }
        }
    }
}
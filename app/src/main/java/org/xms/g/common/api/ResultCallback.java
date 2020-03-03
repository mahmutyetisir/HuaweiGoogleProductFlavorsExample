package org.xms.g.common.api;

public interface ResultCallback<XR extends org.xms.g.common.api.Result> extends org.xms.g.utils.XInterface {
    
    public void onResult(XR param0);
    
    default <R extends com.google.android.gms.common.api.Result> com.google.android.gms.common.api.ResultCallback<R> getGInstanceResultCallback() {
        if (this instanceof org.xms.g.utils.XGettable) {
            return ((com.google.android.gms.common.api.ResultCallback<R>) ((org.xms.g.utils.XGettable) this).getGInstance());
        }
        return new com.google.android.gms.common.api.ResultCallback<R>() {
            
            public void onResult(R param0) {
                java.lang.Object[] params = new java.lang.Object[1];
                java.lang.Class[] types = new java.lang.Class[1];
                params[0] = param0;
                types[0] = org.xms.g.common.api.Result.class;
                org.xms.g.utils.Utils.invokeBridgeMethod(org.xms.g.common.api.ResultCallback.this, "onResult", params, types, false);
            }
        };
    }
    
    default <R> com.huawei.hms.support.api.client.ResultCallback<R> getHInstanceResultCallback() {
        if (this instanceof org.xms.g.utils.XGettable) {
            return ((com.huawei.hms.support.api.client.ResultCallback<R>) ((org.xms.g.utils.XGettable) this).getHInstance());
        }
        return new com.huawei.hms.support.api.client.ResultCallback<R>() {
            
            public void onResult(R param0) {
                java.lang.Object[] params = new java.lang.Object[1];
                java.lang.Class[] types = new java.lang.Class[1];
                params[0] = param0;
                types[0] = org.xms.g.common.api.Result.class;
                org.xms.g.utils.Utils.invokeBridgeMethod(org.xms.g.common.api.ResultCallback.this, "onResult", params, types, true);
            }
        };
    }
    
    public static org.xms.g.common.api.ResultCallback dynamicCast(java.lang.Object param0) {
        if (param0 instanceof org.xms.g.common.api.ResultCallback) {
            return ((org.xms.g.common.api.ResultCallback) param0);
        }
        if (param0 instanceof org.xms.g.utils.XGettable) {
            com.google.android.gms.common.api.ResultCallback gReturn = ((com.google.android.gms.common.api.ResultCallback) ((org.xms.g.utils.XGettable) param0).getGInstance());
            com.huawei.hms.support.api.client.ResultCallback hReturn = ((com.huawei.hms.support.api.client.ResultCallback) ((org.xms.g.utils.XGettable) param0).getHInstance());
            return new org.xms.g.common.api.ResultCallback.XImpl(gReturn, hReturn);
        }
        return ((org.xms.g.common.api.ResultCallback) param0);
    }
    
    public static boolean isInstance(java.lang.Object param0) {
        if (!(param0 instanceof org.xms.g.utils.XObject)) {
            return false;
        }
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hms.support.api.client.ResultCallback;
        } else {
            return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.common.api.ResultCallback;
        }
    }
    
    public static class XImpl<XR extends org.xms.g.common.api.Result> extends org.xms.g.utils.XObject implements org.xms.g.common.api.ResultCallback<XR> {
        
        public XImpl(com.google.android.gms.common.api.ResultCallback param0, com.huawei.hms.support.api.client.ResultCallback param1) {
            super(param0, param1);
        }
        
        public static boolean isInstance(java.lang.Object param0) {
            if (!(param0 instanceof org.xms.g.utils.XObject)) {
                return false;
            }
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hms.support.api.client.ResultCallback;
            } else {
                return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.common.api.ResultCallback;
            }
        }
        
        public void onResult(XR param0) {
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                java.lang.Object hObj0 = org.xms.g.utils.Utils.getInstanceInInterface(param0, true);
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.support.api.client.ResultCallback) this.getHInstance()).onResult(((com.huawei.hms.support.api.client.Result) hObj0))", new Exception());
                ((com.huawei.hms.support.api.client.ResultCallback) this.getHInstance()).onResult(((com.huawei.hms.support.api.client.Result) hObj0));
            } else {
                java.lang.Object gObj0 = org.xms.g.utils.Utils.getInstanceInInterface(param0, false);
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.common.api.ResultCallback) this.getGInstance()).onResult(((com.google.android.gms.common.api.Result) gObj0))", new Exception());
                ((com.google.android.gms.common.api.ResultCallback) this.getGInstance()).onResult(((com.google.android.gms.common.api.Result) gObj0));
            }
        }
    }
}
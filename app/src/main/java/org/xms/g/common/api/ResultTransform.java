package org.xms.g.common.api;

public abstract class ResultTransform<XR extends org.xms.g.common.api.Result, XS extends org.xms.g.common.api.Result> extends org.xms.g.utils.XObject {
    private boolean wrapper = true;
    
    public ResultTransform(com.google.android.gms.common.api.ResultTransform param0, com.huawei.hms.support.api.client.ResultConvert param1) {
        super(param0, null);
        this.setHInstance(param1);
        wrapper = true;
    }
    
    public ResultTransform() {
        super(((com.google.android.gms.common.api.ResultTransform) null), null);
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            this.setHInstance(new HImpl());
        } else {
            this.setGInstance(new GImpl());
        }
        wrapper = false;
    }
    
    public final org.xms.g.common.api.PendingResult<XS> createFailedResult(org.xms.g.common.api.Status param0) {
        com.google.android.gms.common.api.PendingResult gReturn = null;
        com.huawei.hms.support.api.client.PendingResult hReturn = null;
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.support.api.client.ResultConvert) this.getHInstance()).newFailedPendingResult(((com.huawei.hms.support.api.client.Status) ((param0) == null ? null : (param0.getHInstance()))))", new Exception());
            hReturn = ((com.huawei.hms.support.api.client.ResultConvert) this.getHInstance()).newFailedPendingResult(((com.huawei.hms.support.api.client.Status) ((param0) == null ? null : (param0.getHInstance()))));
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.common.api.ResultTransform) this.getGInstance()).createFailedResult(((com.google.android.gms.common.api.Status) ((param0) == null ? null : (param0.getGInstance()))))", new Exception());
            gReturn = ((com.google.android.gms.common.api.ResultTransform) this.getGInstance()).createFailedResult(((com.google.android.gms.common.api.Status) ((param0) == null ? null : (param0.getGInstance()))));
        }
        if (gReturn == null && hReturn == null) {
            return null;
        }
        return new org.xms.g.common.api.PendingResult.XImpl(gReturn, hReturn);
    }
    
    public org.xms.g.common.api.Status onFailure(org.xms.g.common.api.Status param0) {
        if (wrapper) {
            com.google.android.gms.common.api.Status gReturn = null;
            com.huawei.hms.support.api.client.Status hReturn = null;
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.support.api.client.ResultConvert) this.getHInstance()).onFailed(((com.huawei.hms.support.api.client.Status) ((param0) == null ? null : (param0.getHInstance()))))", new Exception());
                hReturn = ((com.huawei.hms.support.api.client.ResultConvert) this.getHInstance()).onFailed(((com.huawei.hms.support.api.client.Status) ((param0) == null ? null : (param0.getHInstance()))));
            } else {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.common.api.ResultTransform) this.getGInstance()).onFailure(((com.google.android.gms.common.api.Status) ((param0) == null ? null : (param0.getGInstance()))))", new Exception());
                gReturn = ((com.google.android.gms.common.api.ResultTransform) this.getGInstance()).onFailure(((com.google.android.gms.common.api.Status) ((param0) == null ? null : (param0.getGInstance()))));
            }
            if (gReturn == null && hReturn == null) {
                return null;
            }
            return new org.xms.g.common.api.Status(gReturn, hReturn);
        } else {
            com.google.android.gms.common.api.Status gReturn = null;
            com.huawei.hms.support.api.client.Status hReturn = null;
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                hReturn = ((HImpl) ((com.huawei.hms.support.api.client.ResultConvert) this.getHInstance())).onFailedCallSuper(((com.huawei.hms.support.api.client.Status) ((param0) == null ? null : (param0.getHInstance()))));
            } else {
                gReturn = ((GImpl) ((com.google.android.gms.common.api.ResultTransform) this.getGInstance())).onFailureCallSuper(((com.google.android.gms.common.api.Status) ((param0) == null ? null : (param0.getGInstance()))));
            }
            if (gReturn == null && hReturn == null) {
                return null;
            }
            return new org.xms.g.common.api.Status(gReturn, hReturn);
        }
    }
    
    public abstract org.xms.g.common.api.PendingResult<XS> onSuccess(XR param0);
    
    public static org.xms.g.common.api.ResultTransform dynamicCast(java.lang.Object param0) {
        if (param0 instanceof org.xms.g.common.api.ResultTransform) {
            return ((org.xms.g.common.api.ResultTransform) param0);
        }
        if (param0 instanceof org.xms.g.utils.XGettable) {
            com.google.android.gms.common.api.ResultTransform gReturn = ((com.google.android.gms.common.api.ResultTransform) ((org.xms.g.utils.XGettable) param0).getGInstance());
            com.huawei.hms.support.api.client.ResultConvert hReturn = ((com.huawei.hms.support.api.client.ResultConvert) ((org.xms.g.utils.XGettable) param0).getHInstance());
            return new org.xms.g.common.api.ResultTransform.XImpl(gReturn, hReturn);
        }
        return ((org.xms.g.common.api.ResultTransform) param0);
    }
    
    public static boolean isInstance(java.lang.Object param0) {
        if (!(param0 instanceof org.xms.g.utils.XObject)) {
            return false;
        }
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hms.support.api.client.ResultConvert;
        } else {
            return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.common.api.ResultTransform;
        }
    }
    
    public class GImpl<R extends com.google.android.gms.common.api.Result, S extends com.google.android.gms.common.api.Result> extends com.google.android.gms.common.api.ResultTransform<R, S> {
        
        public com.google.android.gms.common.api.Status onFailure(com.google.android.gms.common.api.Status param0) {
            java.lang.Object xResult = org.xms.g.common.api.ResultTransform.this.onFailure(new org.xms.g.common.api.Status(param0, null));
            return ((com.google.android.gms.common.api.Status) ((xResult) == null ? null : (((org.xms.g.utils.XObject) xResult).getGInstance())));
        }
        
        public com.google.android.gms.common.api.Status onFailureCallSuper(com.google.android.gms.common.api.Status param0) {
            return super.onFailure(param0);
        }
        
        public com.google.android.gms.common.api.PendingResult<S> onSuccess(R param0) {
            java.lang.Object[] params = new java.lang.Object[1];
            java.lang.Class[] types = new java.lang.Class[1];
            params[0] = param0;
            types[0] = org.xms.g.common.api.Result.class;
            java.lang.Object result = org.xms.g.utils.Utils.invokeBridgeMethod(org.xms.g.common.api.ResultTransform.this, "onSuccess", params, types, false);
            return ((com.google.android.gms.common.api.PendingResult) org.xms.g.utils.Utils.handleInvokeBridgeReturnValue(result, false));
        }
        
        public GImpl() {
            super();
        }
    }
    
    public class HImpl<R extends com.huawei.hms.support.api.client.Result, S extends com.huawei.hms.support.api.client.Result> extends com.huawei.hms.support.api.client.ResultConvert<R, S> {
        
        public com.huawei.hms.support.api.client.Status onFailed(com.huawei.hms.support.api.client.Status param0) {
            java.lang.Object xResult = org.xms.g.common.api.ResultTransform.this.onFailure(new org.xms.g.common.api.Status(null, param0));
            return ((com.huawei.hms.support.api.client.Status) ((xResult) == null ? null : (((org.xms.g.utils.XObject) xResult).getHInstance())));
        }
        
        public com.huawei.hms.support.api.client.Status onFailedCallSuper(com.huawei.hms.support.api.client.Status param0) {
            return super.onFailed(param0);
        }
        
        public com.huawei.hms.support.api.client.PendingResult onSuccess(com.huawei.hms.support.api.client.Result param0) {
            throw new RuntimeException("Stub");
        }
        
        public HImpl() {
            super();
        }
    }
    
    public static class XImpl<XR extends org.xms.g.common.api.Result, XS extends org.xms.g.common.api.Result> extends org.xms.g.common.api.ResultTransform<XR, XS> {
        
        
        
        
        public XImpl(com.google.android.gms.common.api.ResultTransform param0, com.huawei.hms.support.api.client.ResultConvert param1) {
            super(param0, param1);
        }
        
        public static boolean isInstance(java.lang.Object param0) {
            if (!(param0 instanceof org.xms.g.utils.XObject)) {
                return false;
            }
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hms.support.api.client.ResultConvert;
            } else {
                return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.common.api.ResultTransform;
            }
        }
        
        public org.xms.g.common.api.PendingResult<XS> onSuccess(XR param0) {
            com.google.android.gms.common.api.PendingResult gReturn = null;
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                java.lang.Object hObj0 = org.xms.g.utils.Utils.getInstanceInInterface(param0, true);
                
                com.huawei.hms.support.api.client.PendingResult hReturn = null;
                hReturn = ((com.huawei.hms.support.api.client.ResultConvert) this.getHInstance()).onSuccess(((com.huawei.hms.support.api.client.Result) hObj0));
                if (hReturn == null)
                    return null;
                return new org.xms.g.common.api.PendingResult.XImpl(gReturn, hReturn);
                
            } else {
                java.lang.Object gObj0 = org.xms.g.utils.Utils.getInstanceInInterface(param0, false);
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.common.api.ResultTransform) this.getGInstance()).onSuccess(((com.google.android.gms.common.api.Result) gObj0))", new Exception());
                gReturn = ((com.google.android.gms.common.api.ResultTransform) this.getGInstance()).onSuccess(((com.google.android.gms.common.api.Result) gObj0));
            }
            if (gReturn == null) {
                return null;
            }
            return new org.xms.g.common.api.PendingResult.XImpl(gReturn, null);
        }
    }
}
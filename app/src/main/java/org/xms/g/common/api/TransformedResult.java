package org.xms.g.common.api;

public abstract class TransformedResult<XR extends org.xms.g.common.api.Result> extends org.xms.g.utils.XObject {
    private boolean wrapper = true;
    
    public TransformedResult(com.google.android.gms.common.api.TransformedResult param0, com.huawei.hms.support.api.client.ConvertedResult param1) {
        super(param0, null);
        this.setHInstance(param1);
        wrapper = true;
    }
    
    public TransformedResult() {
        super(((com.google.android.gms.common.api.TransformedResult) null), null);
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            this.setHInstance(new HImpl());
        } else {
            this.setGInstance(new GImpl());
        }
        wrapper = false;
    }
    
    public abstract void andFinally(org.xms.g.common.api.ResultCallbacks<? super XR> param0);
    
    public abstract <XS extends org.xms.g.common.api.Result> org.xms.g.common.api.TransformedResult<XS> then(org.xms.g.common.api.ResultTransform<? super XR, ? extends XS> param0);
    
    public static org.xms.g.common.api.TransformedResult dynamicCast(java.lang.Object param0) {
        if (param0 instanceof org.xms.g.common.api.TransformedResult) {
            return ((org.xms.g.common.api.TransformedResult) param0);
        }
        if (param0 instanceof org.xms.g.utils.XGettable) {
            com.google.android.gms.common.api.TransformedResult gReturn = ((com.google.android.gms.common.api.TransformedResult) ((org.xms.g.utils.XGettable) param0).getGInstance());
            com.huawei.hms.support.api.client.ConvertedResult hReturn = ((com.huawei.hms.support.api.client.ConvertedResult) ((org.xms.g.utils.XGettable) param0).getHInstance());
            return new org.xms.g.common.api.TransformedResult.XImpl(gReturn, hReturn);
        }
        return ((org.xms.g.common.api.TransformedResult) param0);
    }
    
    public static boolean isInstance(java.lang.Object param0) {
        if (!(param0 instanceof org.xms.g.utils.XObject)) {
            return false;
        }
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hms.support.api.client.ConvertedResult;
        } else {
            return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.common.api.TransformedResult;
        }
    }
    
    public class GImpl<R extends com.google.android.gms.common.api.Result> extends com.google.android.gms.common.api.TransformedResult<R> {
        
        public void andFinally(com.google.android.gms.common.api.ResultCallbacks<? super R> param0) {
            org.xms.g.common.api.TransformedResult.this.andFinally(new org.xms.g.common.api.ResultCallbacks.XImpl(param0, null));
        }
        
        public <S extends com.google.android.gms.common.api.Result> com.google.android.gms.common.api.TransformedResult<S> then(com.google.android.gms.common.api.ResultTransform<? super R, ? extends S> param0) {
            java.lang.Object xResult = org.xms.g.common.api.TransformedResult.this.then(new org.xms.g.common.api.ResultTransform.XImpl(param0, null));
            return ((com.google.android.gms.common.api.TransformedResult<S>) ((xResult) == null ? null : (((org.xms.g.utils.XObject) xResult).getGInstance())));
        }
        
        public GImpl() {
            super();
        }
    }
    
    public class HImpl<R extends com.huawei.hms.support.api.client.Result> extends com.huawei.hms.support.api.client.ConvertedResult<R> {
        
        public void finalExec(com.huawei.hms.support.api.client.ResultCallbacks<? super R> param0) {
            org.xms.g.common.api.TransformedResult.this.andFinally(new org.xms.g.common.api.ResultCallbacks.XImpl(null, param0));
        }
        
        public <S extends com.huawei.hms.support.api.client.Result> com.huawei.hms.support.api.client.ConvertedResult<S> convertResult(com.huawei.hms.support.api.client.ResultConvert<? super R, ? extends S> param0) {
            java.lang.Object xResult = org.xms.g.common.api.TransformedResult.this.then(new org.xms.g.common.api.ResultTransform.XImpl(null, param0));
            return ((com.huawei.hms.support.api.client.ConvertedResult<S>) ((xResult) == null ? null : (((org.xms.g.utils.XObject) xResult).getHInstance())));
        }
        
        public HImpl() {
            super();
        }
    }
    
    public static class XImpl<XR extends org.xms.g.common.api.Result> extends org.xms.g.common.api.TransformedResult<XR> {
        
        public XImpl(com.google.android.gms.common.api.TransformedResult param0, com.huawei.hms.support.api.client.ConvertedResult param1) {
            super(param0, param1);
        }
        
        public static boolean isInstance(java.lang.Object param0) {
            if (!(param0 instanceof org.xms.g.utils.XObject)) {
                return false;
            }
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hms.support.api.client.ConvertedResult;
            } else {
                return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.common.api.TransformedResult;
            }
        }
        
        public void andFinally(org.xms.g.common.api.ResultCallbacks<? super XR> param0) {
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.support.api.client.ConvertedResult) this.getHInstance()).finalExec(((com.huawei.hms.support.api.client.ResultCallbacks) ((param0) == null ? null : (param0.getHInstance()))))", new Exception());
                ((com.huawei.hms.support.api.client.ConvertedResult) this.getHInstance()).finalExec(((com.huawei.hms.support.api.client.ResultCallbacks) ((param0) == null ? null : (param0.getHInstance()))));
            } else {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.common.api.TransformedResult) this.getGInstance()).andFinally(((com.google.android.gms.common.api.ResultCallbacks) ((param0) == null ? null : (param0.getGInstance()))))", new Exception());
                ((com.google.android.gms.common.api.TransformedResult) this.getGInstance()).andFinally(((com.google.android.gms.common.api.ResultCallbacks) ((param0) == null ? null : (param0.getGInstance()))));
            }
        }
        
        public <XS extends org.xms.g.common.api.Result> org.xms.g.common.api.TransformedResult<XS> then(org.xms.g.common.api.ResultTransform<? super XR, ? extends XS> param0) {
            com.google.android.gms.common.api.TransformedResult gReturn = null;
            com.huawei.hms.support.api.client.ConvertedResult hReturn = null;
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.support.api.client.ConvertedResult) this.getHInstance()).convertResult(((com.huawei.hms.support.api.client.ResultConvert) ((param0) == null ? null : (param0.getHInstance()))))", new Exception());
                hReturn = ((com.huawei.hms.support.api.client.ConvertedResult) this.getHInstance()).convertResult(((com.huawei.hms.support.api.client.ResultConvert) ((param0) == null ? null : (param0.getHInstance()))));
            } else {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.common.api.TransformedResult) this.getGInstance()).then(((com.google.android.gms.common.api.ResultTransform) ((param0) == null ? null : (param0.getGInstance()))))", new Exception());
                gReturn = ((com.google.android.gms.common.api.TransformedResult) this.getGInstance()).then(((com.google.android.gms.common.api.ResultTransform) ((param0) == null ? null : (param0.getGInstance()))));
            }
            if (gReturn == null && hReturn == null) {
                return null;
            }
            return new org.xms.g.common.api.TransformedResult.XImpl(gReturn, hReturn);
        }
    }
}
package org.xms.g.common.api;

public abstract class OptionalPendingResult<XR extends org.xms.g.common.api.Result> extends org.xms.g.common.api.PendingResult<XR> {
    private boolean wrapper = true;
    
    public OptionalPendingResult(com.google.android.gms.common.api.OptionalPendingResult param0, com.huawei.hms.common.api.OptionalPendingResult param1) {
        super(param0, null);
        this.setHInstance(param1);
        wrapper = true;
    }
    
    public OptionalPendingResult() {
        super(((com.google.android.gms.common.api.OptionalPendingResult) null), null);
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            this.setHInstance(new HImpl());
        } else {
            this.setGInstance(new GImpl());
        }
        wrapper = false;
    }
    
    public abstract XR get();
    
    public abstract boolean isDone();
    
    public static org.xms.g.common.api.OptionalPendingResult dynamicCast(java.lang.Object param0) {
        if (param0 instanceof org.xms.g.common.api.OptionalPendingResult) {
            return ((org.xms.g.common.api.OptionalPendingResult) param0);
        }
        if (param0 instanceof org.xms.g.utils.XGettable) {
            com.google.android.gms.common.api.OptionalPendingResult gReturn = ((com.google.android.gms.common.api.OptionalPendingResult) ((org.xms.g.utils.XGettable) param0).getGInstance());
            com.huawei.hms.common.api.OptionalPendingResult hReturn = ((com.huawei.hms.common.api.OptionalPendingResult) ((org.xms.g.utils.XGettable) param0).getHInstance());
            return new org.xms.g.common.api.OptionalPendingResult.XImpl(gReturn, hReturn);
        }
        return ((org.xms.g.common.api.OptionalPendingResult) param0);
    }
    
    public static boolean isInstance(java.lang.Object param0) {
        if (!(param0 instanceof org.xms.g.utils.XObject)) {
            return false;
        }
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hms.common.api.OptionalPendingResult;
        } else {
            return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.common.api.OptionalPendingResult;
        }
    }
    
    public class GImpl<R extends com.google.android.gms.common.api.Result> extends com.google.android.gms.common.api.OptionalPendingResult<R> {
        
        public R get() {
            java.lang.Object retObj = null;
            retObj = org.xms.g.common.api.OptionalPendingResult.this.get();
            return ((R) org.xms.g.utils.Utils.getInstanceInInterface(retObj, false));
        }
        
        public boolean isDone() {
            return org.xms.g.common.api.OptionalPendingResult.this.isDone();
        }
        
        public R await() {
            java.lang.Object retObj = null;
            retObj = org.xms.g.common.api.OptionalPendingResult.this.await();
            return ((R) org.xms.g.utils.Utils.getInstanceInInterface(retObj, false));
        }
        
        public R await(long param0, java.util.concurrent.TimeUnit param1) {
            java.lang.Object retObj = null;
            retObj = org.xms.g.common.api.OptionalPendingResult.this.await(param0, param1);
            return ((R) org.xms.g.utils.Utils.getInstanceInInterface(retObj, false));
        }
        
        public void cancel() {
            org.xms.g.common.api.OptionalPendingResult.this.cancel();
        }
        
        public boolean isCanceled() {
            return org.xms.g.common.api.OptionalPendingResult.this.isCanceled();
        }
        
        public void setResultCallback(com.google.android.gms.common.api.ResultCallback<? super R> param0) {
            org.xms.g.common.api.OptionalPendingResult.this.setResultCallback(new org.xms.g.common.api.ResultCallback.XImpl(param0, null));
        }
        
        public void setResultCallback(com.google.android.gms.common.api.ResultCallback<? super R> param0, long param1, java.util.concurrent.TimeUnit param2) {
            org.xms.g.common.api.OptionalPendingResult.this.setResultCallback(new org.xms.g.common.api.ResultCallback.XImpl(param0, null), param1, param2);
        }
        
        public GImpl() {
            super();
        }
    }
    
    public class HImpl<R extends com.huawei.hms.support.api.client.Result> extends com.huawei.hms.common.api.OptionalPendingResult<R> {
        
        public R get() {
            java.lang.Object retObj = null;
            retObj = org.xms.g.common.api.OptionalPendingResult.this.get();
            return ((R) org.xms.g.utils.Utils.getInstanceInInterface(retObj, true));
        }
        
        public boolean isDone() {
            return org.xms.g.common.api.OptionalPendingResult.this.isDone();
        }
        
        public R await() {
            java.lang.Object retObj = null;
            retObj = org.xms.g.common.api.OptionalPendingResult.this.await();
            return ((R) org.xms.g.utils.Utils.getInstanceInInterface(retObj, true));
        }
        
        public R await(long param0, java.util.concurrent.TimeUnit param1) {
            java.lang.Object retObj = null;
            retObj = org.xms.g.common.api.OptionalPendingResult.this.await(param0, param1);
            return ((R) org.xms.g.utils.Utils.getInstanceInInterface(retObj, true));
        }
        
        public void setResultCallback(com.huawei.hms.support.api.client.ResultCallback<R> param0) {
            org.xms.g.common.api.OptionalPendingResult.this.setResultCallback(new org.xms.g.common.api.ResultCallback.XImpl(null, param0));
        }
        
        public void setResultCallback(android.os.Looper param0, com.huawei.hms.support.api.client.ResultCallback<R> param1) {
            throw new RuntimeException("Stub");
        }
        
        public void cancel() {
            org.xms.g.common.api.OptionalPendingResult.this.cancel();
        }
        
        public boolean isCanceled() {
            return org.xms.g.common.api.OptionalPendingResult.this.isCanceled();
        }
        
        public void setResultCallback(com.huawei.hms.support.api.client.ResultCallback<R> param0, long param1, java.util.concurrent.TimeUnit param2) {
            org.xms.g.common.api.OptionalPendingResult.this.setResultCallback(new org.xms.g.common.api.ResultCallback.XImpl(null, param0), param1, param2);
        }
        
        public HImpl() {
            super();
        }
    }
    
    public static class XImpl<XR extends org.xms.g.common.api.Result> extends org.xms.g.common.api.OptionalPendingResult<XR> {
        
        public XImpl(com.google.android.gms.common.api.OptionalPendingResult param0, com.huawei.hms.common.api.OptionalPendingResult param1) {
            super(param0, param1);
        }
        
        public static boolean isInstance(java.lang.Object param0) {
            if (!(param0 instanceof org.xms.g.utils.XObject)) {
                return false;
            }
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hms.common.api.OptionalPendingResult;
            } else {
                return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.common.api.OptionalPendingResult;
            }
        }
        
        public XR get() {
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.common.api.OptionalPendingResult) this.getHInstance()).get()", new Exception());
                java.lang.Object hmsObj = ((com.huawei.hms.common.api.OptionalPendingResult) this.getHInstance()).get();
                boolean flag = org.xms.g.utils.Utils.isHmsType(hmsObj);
                if (flag) {
                    java.lang.Object retObj = null;
                    retObj = org.xms.g.utils.Utils.getXmsObjectWithHmsObject(hmsObj);
                    return ((XR) retObj);
                } else {
                    return ((XR) hmsObj);
                }
            } else {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.common.api.OptionalPendingResult) this.getGInstance()).get()", new Exception());
                java.lang.Object gmsObj = ((com.google.android.gms.common.api.OptionalPendingResult) this.getGInstance()).get();
                boolean flag = org.xms.g.utils.Utils.isGmsType(gmsObj);
                if (flag) {
                    java.lang.Object retObj = null;
                    retObj = org.xms.g.utils.Utils.getXmsObjectWithGmsObject(gmsObj);
                    return ((XR) retObj);
                } else {
                    return ((XR) gmsObj);
                }
            }
        }
        
        public boolean isDone() {
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.common.api.OptionalPendingResult) this.getHInstance()).isDone()", new Exception());
                return ((com.huawei.hms.common.api.OptionalPendingResult) this.getHInstance()).isDone();
            } else {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.common.api.OptionalPendingResult) this.getGInstance()).isDone()", new Exception());
                return ((com.google.android.gms.common.api.OptionalPendingResult) this.getGInstance()).isDone();
            }
        }
        
        public XR await() {
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.common.api.OptionalPendingResult) this.getHInstance()).await()", new Exception());
                java.lang.Object hmsObj = ((com.huawei.hms.common.api.OptionalPendingResult) this.getHInstance()).await();
                boolean flag = org.xms.g.utils.Utils.isHmsType(hmsObj);
                if (flag) {
                    java.lang.Object retObj = null;
                    retObj = org.xms.g.utils.Utils.getXmsObjectWithHmsObject(hmsObj);
                    return ((XR) retObj);
                } else {
                    return ((XR) hmsObj);
                }
            } else {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.common.api.OptionalPendingResult) this.getGInstance()).await()", new Exception());
                java.lang.Object gmsObj = ((com.google.android.gms.common.api.OptionalPendingResult) this.getGInstance()).await();
                boolean flag = org.xms.g.utils.Utils.isGmsType(gmsObj);
                if (flag) {
                    java.lang.Object retObj = null;
                    retObj = org.xms.g.utils.Utils.getXmsObjectWithGmsObject(gmsObj);
                    return ((XR) retObj);
                } else {
                    return ((XR) gmsObj);
                }
            }
        }
        
        public XR await(long param0, java.util.concurrent.TimeUnit param1) {
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.common.api.OptionalPendingResult) this.getHInstance()).await(param0, param1)", new Exception());
                java.lang.Object hmsObj = ((com.huawei.hms.common.api.OptionalPendingResult) this.getHInstance()).await(param0, param1);
                boolean flag = org.xms.g.utils.Utils.isHmsType(hmsObj);
                if (flag) {
                    java.lang.Object retObj = null;
                    retObj = org.xms.g.utils.Utils.getXmsObjectWithHmsObject(hmsObj);
                    return ((XR) retObj);
                } else {
                    return ((XR) hmsObj);
                }
            } else {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.common.api.OptionalPendingResult) this.getGInstance()).await(param0, param1)", new Exception());
                java.lang.Object gmsObj = ((com.google.android.gms.common.api.OptionalPendingResult) this.getGInstance()).await(param0, param1);
                boolean flag = org.xms.g.utils.Utils.isGmsType(gmsObj);
                if (flag) {
                    java.lang.Object retObj = null;
                    retObj = org.xms.g.utils.Utils.getXmsObjectWithGmsObject(gmsObj);
                    return ((XR) retObj);
                } else {
                    return ((XR) gmsObj);
                }
            }
        }
        
        public void cancel() {
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.common.api.OptionalPendingResult) this.getHInstance()).cancel()", new Exception());
                ((com.huawei.hms.common.api.OptionalPendingResult) this.getHInstance()).cancel();
            } else {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.common.api.OptionalPendingResult) this.getGInstance()).cancel()", new Exception());
                ((com.google.android.gms.common.api.OptionalPendingResult) this.getGInstance()).cancel();
            }
        }
        
        public boolean isCanceled() {
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.common.api.OptionalPendingResult) this.getHInstance()).isCanceled()", new Exception());
                return ((com.huawei.hms.common.api.OptionalPendingResult) this.getHInstance()).isCanceled();
            } else {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.common.api.OptionalPendingResult) this.getGInstance()).isCanceled()", new Exception());
                return ((com.google.android.gms.common.api.OptionalPendingResult) this.getGInstance()).isCanceled();
            }
        }
        
        public void setResultCallback(org.xms.g.common.api.ResultCallback<? super XR> param0) {
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.common.api.OptionalPendingResult) this.getHInstance()).setResultCallback(((param0) == null ? null : (param0.getHInstanceResultCallback())))", new Exception());
                ((com.huawei.hms.common.api.OptionalPendingResult) this.getHInstance()).setResultCallback(((param0) == null ? null : (param0.getHInstanceResultCallback())));
            } else {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.common.api.OptionalPendingResult) this.getGInstance()).setResultCallback(((param0) == null ? null : (param0.getGInstanceResultCallback())))", new Exception());
                ((com.google.android.gms.common.api.OptionalPendingResult) this.getGInstance()).setResultCallback(((param0) == null ? null : (param0.getGInstanceResultCallback())));
            }
        }
        
        public void setResultCallback(org.xms.g.common.api.ResultCallback<? super XR> param0, long param1, java.util.concurrent.TimeUnit param2) {
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.common.api.OptionalPendingResult) this.getHInstance()).setResultCallback(((param0) == null ? null : (param0.getHInstanceResultCallback())), param1, param2)", new Exception());
                ((com.huawei.hms.common.api.OptionalPendingResult) this.getHInstance()).setResultCallback(((param0) == null ? null : (param0.getHInstanceResultCallback())), param1, param2);
            } else {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.common.api.OptionalPendingResult) this.getGInstance()).setResultCallback(((param0) == null ? null : (param0.getGInstanceResultCallback())), param1, param2)", new Exception());
                ((com.google.android.gms.common.api.OptionalPendingResult) this.getGInstance()).setResultCallback(((param0) == null ? null : (param0.getGInstanceResultCallback())), param1, param2);
            }
        }
    }
}
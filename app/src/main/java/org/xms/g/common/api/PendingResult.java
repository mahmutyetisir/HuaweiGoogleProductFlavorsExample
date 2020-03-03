package org.xms.g.common.api;

public abstract class PendingResult<XR extends org.xms.g.common.api.Result> extends org.xms.g.utils.XObject {
    private boolean wrapper = true;
    
    public PendingResult(com.google.android.gms.common.api.PendingResult param0, com.huawei.hms.support.api.client.PendingResult param1) {
        super(param0, null);
        this.setHInstance(param1);
        wrapper = true;
    }
    
    public abstract XR await();
    
    public abstract XR await(long param0, java.util.concurrent.TimeUnit param1);
    
    public abstract void cancel();
    
    public abstract boolean isCanceled();
    
    public abstract void setResultCallback(org.xms.g.common.api.ResultCallback<? super XR> param0);
    
    public abstract void setResultCallback(org.xms.g.common.api.ResultCallback<? super XR> param0, long param1, java.util.concurrent.TimeUnit param2);
    
    public <XS extends org.xms.g.common.api.Result> org.xms.g.common.api.TransformedResult<XS> then(org.xms.g.common.api.ResultTransform<? super XR, ? extends XS> param0) {
        com.google.android.gms.common.api.TransformedResult gReturn = null;
        com.huawei.hms.support.api.client.ConvertedResult hReturn = null;
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.support.api.client.PendingResult) this.getHInstance()).convertResult(((com.huawei.hms.support.api.client.ResultConvert) ((param0) == null ? null : (param0.getHInstance()))))", new Exception());
            hReturn = ((com.huawei.hms.support.api.client.PendingResult) this.getHInstance()).convertResult(((com.huawei.hms.support.api.client.ResultConvert) ((param0) == null ? null : (param0.getHInstance()))));
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.common.api.PendingResult) this.getGInstance()).then(((com.google.android.gms.common.api.ResultTransform) ((param0) == null ? null : (param0.getGInstance()))))", new Exception());
            gReturn = ((com.google.android.gms.common.api.PendingResult) this.getGInstance()).then(((com.google.android.gms.common.api.ResultTransform) ((param0) == null ? null : (param0.getGInstance()))));
        }
        if (gReturn == null && hReturn == null) {
            return null;
        }
        return new org.xms.g.common.api.TransformedResult.XImpl(gReturn, hReturn);
    }
    
    public static org.xms.g.common.api.PendingResult dynamicCast(java.lang.Object param0) {
        if (param0 instanceof org.xms.g.common.api.PendingResult) {
            return ((org.xms.g.common.api.PendingResult) param0);
        }
        if (param0 instanceof org.xms.g.utils.XGettable) {
            com.google.android.gms.common.api.PendingResult gReturn = ((com.google.android.gms.common.api.PendingResult) ((org.xms.g.utils.XGettable) param0).getGInstance());
            com.huawei.hms.support.api.client.PendingResult hReturn = ((com.huawei.hms.support.api.client.PendingResult) ((org.xms.g.utils.XGettable) param0).getHInstance());
            return new org.xms.g.common.api.PendingResult.XImpl(gReturn, hReturn);
        }
        return ((org.xms.g.common.api.PendingResult) param0);
    }
    
    public static boolean isInstance(java.lang.Object param0) {
        if (!(param0 instanceof org.xms.g.utils.XObject)) {
            return false;
        }
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hms.support.api.client.PendingResult;
        } else {
            return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.common.api.PendingResult;
        }
    }
    
    public static class XImpl<XR extends org.xms.g.common.api.Result> extends org.xms.g.common.api.PendingResult<XR> {
        
        public XImpl(com.google.android.gms.common.api.PendingResult param0, com.huawei.hms.support.api.client.PendingResult param1) {
            super(param0, param1);
        }
        
        public static boolean isInstance(java.lang.Object param0) {
            if (!(param0 instanceof org.xms.g.utils.XObject)) {
                return false;
            }
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hms.support.api.client.PendingResult;
            } else {
                return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.common.api.PendingResult;
            }
        }
        
        public XR await() {
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.support.api.client.PendingResult) this.getHInstance()).await()", new Exception());
                java.lang.Object hmsObj = ((com.huawei.hms.support.api.client.PendingResult) this.getHInstance()).await();
                boolean flag = org.xms.g.utils.Utils.isHmsType(hmsObj);
                if (flag) {
                    java.lang.Object retObj = null;
                    retObj = org.xms.g.utils.Utils.getXmsObjectWithHmsObject(hmsObj);
                    return ((XR) retObj);
                } else {
                    return ((XR) hmsObj);
                }
            } else {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.common.api.PendingResult) this.getGInstance()).await()", new Exception());
                java.lang.Object gmsObj = ((com.google.android.gms.common.api.PendingResult) this.getGInstance()).await();
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
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.support.api.client.PendingResult) this.getHInstance()).await(param0, param1)", new Exception());
                java.lang.Object hmsObj = ((com.huawei.hms.support.api.client.PendingResult) this.getHInstance()).await(param0, param1);
                boolean flag = org.xms.g.utils.Utils.isHmsType(hmsObj);
                if (flag) {
                    java.lang.Object retObj = null;
                    retObj = org.xms.g.utils.Utils.getXmsObjectWithHmsObject(hmsObj);
                    return ((XR) retObj);
                } else {
                    return ((XR) hmsObj);
                }
            } else {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.common.api.PendingResult) this.getGInstance()).await(param0, param1)", new Exception());
                java.lang.Object gmsObj = ((com.google.android.gms.common.api.PendingResult) this.getGInstance()).await(param0, param1);
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
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.support.api.client.PendingResult) this.getHInstance()).cancel()", new Exception());
                ((com.huawei.hms.support.api.client.PendingResult) this.getHInstance()).cancel();
            } else {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.common.api.PendingResult) this.getGInstance()).cancel()", new Exception());
                ((com.google.android.gms.common.api.PendingResult) this.getGInstance()).cancel();
            }
        }
        
        public boolean isCanceled() {
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.support.api.client.PendingResult) this.getHInstance()).isCanceled()", new Exception());
                return ((com.huawei.hms.support.api.client.PendingResult) this.getHInstance()).isCanceled();
            } else {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.common.api.PendingResult) this.getGInstance()).isCanceled()", new Exception());
                return ((com.google.android.gms.common.api.PendingResult) this.getGInstance()).isCanceled();
            }
        }
        
        public void setResultCallback(org.xms.g.common.api.ResultCallback<? super XR> param0) {
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.support.api.client.PendingResult) this.getHInstance()).setResultCallback(((param0) == null ? null : (param0.getHInstanceResultCallback())))", new Exception());
                ((com.huawei.hms.support.api.client.PendingResult) this.getHInstance()).setResultCallback(((param0) == null ? null : (param0.getHInstanceResultCallback())));
            } else {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.common.api.PendingResult) this.getGInstance()).setResultCallback(((param0) == null ? null : (param0.getGInstanceResultCallback())))", new Exception());
                ((com.google.android.gms.common.api.PendingResult) this.getGInstance()).setResultCallback(((param0) == null ? null : (param0.getGInstanceResultCallback())));
            }
        }
        
        public void setResultCallback(org.xms.g.common.api.ResultCallback<? super XR> param0, long param1, java.util.concurrent.TimeUnit param2) {
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.support.api.client.PendingResult) this.getHInstance()).setResultCallback(((param0) == null ? null : (param0.getHInstanceResultCallback())), param1, param2)", new Exception());
                ((com.huawei.hms.support.api.client.PendingResult) this.getHInstance()).setResultCallback(((param0) == null ? null : (param0.getHInstanceResultCallback())), param1, param2);
            } else {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.common.api.PendingResult) this.getGInstance()).setResultCallback(((param0) == null ? null : (param0.getGInstanceResultCallback())), param1, param2)", new Exception());
                ((com.google.android.gms.common.api.PendingResult) this.getGInstance()).setResultCallback(((param0) == null ? null : (param0.getGInstanceResultCallback())), param1, param2);
            }
        }
    }
}
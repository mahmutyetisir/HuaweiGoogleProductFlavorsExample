package org.xms.g.tasks;

public interface SuccessContinuation<XTResult, XTContinuationResult> extends org.xms.g.utils.XInterface {
    
    public org.xms.g.tasks.Task<XTContinuationResult> then(XTResult param0) throws java.lang.Exception;
    
    default <TResult, TContinuationResult> com.google.android.gms.tasks.SuccessContinuation<TResult, TContinuationResult> getGInstanceSuccessContinuation() {
        if (this instanceof org.xms.g.utils.XGettable) {
            return ((com.google.android.gms.tasks.SuccessContinuation<TResult, TContinuationResult>) ((org.xms.g.utils.XGettable) this).getGInstance());
        }
        return new com.google.android.gms.tasks.SuccessContinuation<TResult, TContinuationResult>() {
            
            public com.google.android.gms.tasks.Task<TContinuationResult> then(TResult param0) throws java.lang.Exception {
                java.lang.Object[] params = new java.lang.Object[1];
                java.lang.Class[] types = new java.lang.Class[1];
                params[0] = param0;
                types[0] = java.lang.Object.class;
                java.lang.Object result = org.xms.g.utils.Utils.invokeBridgeMethod(org.xms.g.tasks.SuccessContinuation.this, "then", params, types, false);
                return ((com.google.android.gms.tasks.Task) org.xms.g.utils.Utils.handleInvokeBridgeReturnValue(result, false));
            }
        };
    }
    
    default <TResult, TContinuationResult> com.huawei.hmf.tasks.SuccessContinuation<TResult, TContinuationResult> getHInstanceSuccessContinuation() {
        if (this instanceof org.xms.g.utils.XGettable) {
            return ((com.huawei.hmf.tasks.SuccessContinuation<TResult, TContinuationResult>) ((org.xms.g.utils.XGettable) this).getHInstance());
        }
        return new com.huawei.hmf.tasks.SuccessContinuation<TResult, TContinuationResult>() {
            
            public com.huawei.hmf.tasks.Task<TContinuationResult> then(TResult param0) throws java.lang.Exception {
                java.lang.Object[] params = new java.lang.Object[1];
                java.lang.Class[] types = new java.lang.Class[1];
                params[0] = param0;
                types[0] = java.lang.Object.class;
                java.lang.Object result = org.xms.g.utils.Utils.invokeBridgeMethod(org.xms.g.tasks.SuccessContinuation.this, "then", params, types, true);
                return ((com.huawei.hmf.tasks.Task) org.xms.g.utils.Utils.handleInvokeBridgeReturnValue(result, true));
            }
        };
    }
    
    public static org.xms.g.tasks.SuccessContinuation dynamicCast(java.lang.Object param0) {
        if (param0 instanceof org.xms.g.tasks.SuccessContinuation) {
            return ((org.xms.g.tasks.SuccessContinuation) param0);
        }
        if (param0 instanceof org.xms.g.utils.XGettable) {
            com.google.android.gms.tasks.SuccessContinuation gReturn = ((com.google.android.gms.tasks.SuccessContinuation) ((org.xms.g.utils.XGettable) param0).getGInstance());
            com.huawei.hmf.tasks.SuccessContinuation hReturn = ((com.huawei.hmf.tasks.SuccessContinuation) ((org.xms.g.utils.XGettable) param0).getHInstance());
            return new org.xms.g.tasks.SuccessContinuation.XImpl(gReturn, hReturn);
        }
        return ((org.xms.g.tasks.SuccessContinuation) param0);
    }
    
    public static boolean isInstance(java.lang.Object param0) {
        if (!(param0 instanceof org.xms.g.utils.XObject)) {
            return false;
        }
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hmf.tasks.SuccessContinuation;
        } else {
            return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.tasks.SuccessContinuation;
        }
    }
    
    public static class XImpl<XTResult, XTContinuationResult> extends org.xms.g.utils.XObject implements org.xms.g.tasks.SuccessContinuation<XTResult, XTContinuationResult> {
        
        public XImpl(com.google.android.gms.tasks.SuccessContinuation param0, com.huawei.hmf.tasks.SuccessContinuation param1) {
            super(param0, param1);
        }
        
        public static boolean isInstance(java.lang.Object param0) {
            if (!(param0 instanceof org.xms.g.utils.XObject)) {
                return false;
            }
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hmf.tasks.SuccessContinuation;
            } else {
                return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.tasks.SuccessContinuation;
            }
        }
        
        public org.xms.g.tasks.Task<XTContinuationResult> then(XTResult param0) throws java.lang.Exception {
            com.google.android.gms.tasks.Task gReturn = null;
            com.huawei.hmf.tasks.Task hReturn = null;
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                java.lang.Object hObj0 = org.xms.g.utils.Utils.getInstanceInInterface(param0, true);
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hmf.tasks.SuccessContinuation) this.getHInstance()).then(hObj0)", new Exception());
                hReturn = ((com.huawei.hmf.tasks.SuccessContinuation) this.getHInstance()).then(hObj0);
            } else {
                java.lang.Object gObj0 = org.xms.g.utils.Utils.getInstanceInInterface(param0, false);
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.tasks.SuccessContinuation) this.getGInstance()).then(gObj0)", new Exception());
                gReturn = ((com.google.android.gms.tasks.SuccessContinuation) this.getGInstance()).then(gObj0);
            }
            if (gReturn == null && hReturn == null) {
                return null;
            }
            return new org.xms.g.tasks.Task.XImpl(gReturn, hReturn);
        }
    }
}
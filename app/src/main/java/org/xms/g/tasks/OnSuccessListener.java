package org.xms.g.tasks;

public interface OnSuccessListener<XTResult> extends org.xms.g.utils.XInterface {
    
    public void onSuccess(XTResult param0);
    
    default <TResult> com.google.android.gms.tasks.OnSuccessListener<TResult> getGInstanceOnSuccessListener() {
        if (this instanceof org.xms.g.utils.XGettable) {
            return ((com.google.android.gms.tasks.OnSuccessListener<TResult>) ((org.xms.g.utils.XGettable) this).getGInstance());
        }
        return new com.google.android.gms.tasks.OnSuccessListener<TResult>() {
            
            public void onSuccess(TResult param0) {
                java.lang.Object[] params = new java.lang.Object[1];
                java.lang.Class[] types = new java.lang.Class[1];
                params[0] = param0;
                types[0] = java.lang.Object.class;
                org.xms.g.utils.Utils.invokeBridgeMethod(org.xms.g.tasks.OnSuccessListener.this, "onSuccess", params, types, false);
            }
        };
    }
    
    default <TResult> com.huawei.hmf.tasks.OnSuccessListener<TResult> getHInstanceOnSuccessListener() {
        if (this instanceof org.xms.g.utils.XGettable) {
            return ((com.huawei.hmf.tasks.OnSuccessListener<TResult>) ((org.xms.g.utils.XGettable) this).getHInstance());
        }
        return new com.huawei.hmf.tasks.OnSuccessListener<TResult>() {
            
            public void onSuccess(TResult param0) {
                java.lang.Object[] params = new java.lang.Object[1];
                java.lang.Class[] types = new java.lang.Class[1];
                params[0] = param0;
                types[0] = java.lang.Object.class;
                org.xms.g.utils.Utils.invokeBridgeMethod(org.xms.g.tasks.OnSuccessListener.this, "onSuccess", params, types, true);
            }
        };
    }
    
    public static org.xms.g.tasks.OnSuccessListener dynamicCast(java.lang.Object param0) {
        if (param0 instanceof org.xms.g.tasks.OnSuccessListener) {
            return ((org.xms.g.tasks.OnSuccessListener) param0);
        }
        if (param0 instanceof org.xms.g.utils.XGettable) {
            com.google.android.gms.tasks.OnSuccessListener gReturn = ((com.google.android.gms.tasks.OnSuccessListener) ((org.xms.g.utils.XGettable) param0).getGInstance());
            com.huawei.hmf.tasks.OnSuccessListener hReturn = ((com.huawei.hmf.tasks.OnSuccessListener) ((org.xms.g.utils.XGettable) param0).getHInstance());
            return new org.xms.g.tasks.OnSuccessListener.XImpl(gReturn, hReturn);
        }
        return ((org.xms.g.tasks.OnSuccessListener) param0);
    }
    
    public static boolean isInstance(java.lang.Object param0) {
        if (!(param0 instanceof org.xms.g.utils.XObject)) {
            return false;
        }
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hmf.tasks.OnSuccessListener;
        } else {
            return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.tasks.OnSuccessListener;
        }
    }
    
    public static class XImpl<XTResult> extends org.xms.g.utils.XObject implements org.xms.g.tasks.OnSuccessListener<XTResult> {
        
        public XImpl(com.google.android.gms.tasks.OnSuccessListener param0, com.huawei.hmf.tasks.OnSuccessListener param1) {
            super(param0, param1);
        }
        
        public static boolean isInstance(java.lang.Object param0) {
            if (!(param0 instanceof org.xms.g.utils.XObject)) {
                return false;
            }
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hmf.tasks.OnSuccessListener;
            } else {
                return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.tasks.OnSuccessListener;
            }
        }
        
        public void onSuccess(XTResult param0) {
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                java.lang.Object hObj0 = org.xms.g.utils.Utils.getInstanceInInterface(param0, true);
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hmf.tasks.OnSuccessListener) this.getHInstance()).onSuccess(hObj0)", new Exception());
                ((com.huawei.hmf.tasks.OnSuccessListener) this.getHInstance()).onSuccess(hObj0);
            } else {
                java.lang.Object gObj0 = org.xms.g.utils.Utils.getInstanceInInterface(param0, false);
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.tasks.OnSuccessListener) this.getGInstance()).onSuccess(gObj0)", new Exception());
                ((com.google.android.gms.tasks.OnSuccessListener) this.getGInstance()).onSuccess(gObj0);
            }
        }
    }
}
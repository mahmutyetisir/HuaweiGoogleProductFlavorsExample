package org.xms.g.tasks;

public interface OnCompleteListener<XTResult> extends org.xms.g.utils.XInterface {
    
    public void onComplete(org.xms.g.tasks.Task<XTResult> param0);
    
    default <TResult> com.google.android.gms.tasks.OnCompleteListener<TResult> getGInstanceOnCompleteListener() {
        if (this instanceof org.xms.g.utils.XGettable) {
            return ((com.google.android.gms.tasks.OnCompleteListener<TResult>) ((org.xms.g.utils.XGettable) this).getGInstance());
        }
        return new com.google.android.gms.tasks.OnCompleteListener<TResult>() {
            
            public void onComplete(com.google.android.gms.tasks.Task<TResult> param0) {
                org.xms.g.tasks.OnCompleteListener.this.onComplete(new org.xms.g.tasks.Task.XImpl(param0, null));
            }
        };
    }
    
    default <TResult> com.huawei.hmf.tasks.OnCompleteListener<TResult> getHInstanceOnCompleteListener() {
        if (this instanceof org.xms.g.utils.XGettable) {
            return ((com.huawei.hmf.tasks.OnCompleteListener<TResult>) ((org.xms.g.utils.XGettable) this).getHInstance());
        }
        return new com.huawei.hmf.tasks.OnCompleteListener<TResult>() {
            
            public void onComplete(com.huawei.hmf.tasks.Task<TResult> param0) {
                org.xms.g.tasks.OnCompleteListener.this.onComplete(new org.xms.g.tasks.Task.XImpl(null, param0));
            }
        };
    }
    
    public static org.xms.g.tasks.OnCompleteListener dynamicCast(java.lang.Object param0) {
        if (param0 instanceof org.xms.g.tasks.OnCompleteListener) {
            return ((org.xms.g.tasks.OnCompleteListener) param0);
        }
        if (param0 instanceof org.xms.g.utils.XGettable) {
            com.google.android.gms.tasks.OnCompleteListener gReturn = ((com.google.android.gms.tasks.OnCompleteListener) ((org.xms.g.utils.XGettable) param0).getGInstance());
            com.huawei.hmf.tasks.OnCompleteListener hReturn = ((com.huawei.hmf.tasks.OnCompleteListener) ((org.xms.g.utils.XGettable) param0).getHInstance());
            return new org.xms.g.tasks.OnCompleteListener.XImpl(gReturn, hReturn);
        }
        return ((org.xms.g.tasks.OnCompleteListener) param0);
    }
    
    public static boolean isInstance(java.lang.Object param0) {
        if (!(param0 instanceof org.xms.g.utils.XObject)) {
            return false;
        }
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hmf.tasks.OnCompleteListener;
        } else {
            return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.tasks.OnCompleteListener;
        }
    }
    
    public static class XImpl<XTResult> extends org.xms.g.utils.XObject implements org.xms.g.tasks.OnCompleteListener<XTResult> {
        
        public XImpl(com.google.android.gms.tasks.OnCompleteListener param0, com.huawei.hmf.tasks.OnCompleteListener param1) {
            super(param0, param1);
        }
        
        public static boolean isInstance(java.lang.Object param0) {
            if (!(param0 instanceof org.xms.g.utils.XObject)) {
                return false;
            }
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hmf.tasks.OnCompleteListener;
            } else {
                return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.tasks.OnCompleteListener;
            }
        }
        
        public void onComplete(org.xms.g.tasks.Task<XTResult> param0) {
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hmf.tasks.OnCompleteListener) this.getHInstance()).onComplete(((com.huawei.hmf.tasks.Task) ((param0) == null ? null : (param0.getHInstance()))))", new Exception());
                ((com.huawei.hmf.tasks.OnCompleteListener) this.getHInstance()).onComplete(((com.huawei.hmf.tasks.Task) ((param0) == null ? null : (param0.getHInstance()))));
            } else {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.tasks.OnCompleteListener) this.getGInstance()).onComplete(((com.google.android.gms.tasks.Task) ((param0) == null ? null : (param0.getGInstance()))))", new Exception());
                ((com.google.android.gms.tasks.OnCompleteListener) this.getGInstance()).onComplete(((com.google.android.gms.tasks.Task) ((param0) == null ? null : (param0.getGInstance()))));
            }
        }
    }
}
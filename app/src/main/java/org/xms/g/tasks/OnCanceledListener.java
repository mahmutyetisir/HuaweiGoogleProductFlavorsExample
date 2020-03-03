package org.xms.g.tasks;

public interface OnCanceledListener extends org.xms.g.utils.XInterface {
    
    public void onCanceled();
    
    default com.google.android.gms.tasks.OnCanceledListener getGInstanceOnCanceledListener() {
        if (this instanceof org.xms.g.utils.XGettable) {
            return ((com.google.android.gms.tasks.OnCanceledListener) ((org.xms.g.utils.XGettable) this).getGInstance());
        }
        return new com.google.android.gms.tasks.OnCanceledListener() {
            
            public void onCanceled() {
                org.xms.g.tasks.OnCanceledListener.this.onCanceled();
            }
        };
    }
    
    default com.huawei.hmf.tasks.OnCanceledListener getHInstanceOnCanceledListener() {
        if (this instanceof org.xms.g.utils.XGettable) {
            return ((com.huawei.hmf.tasks.OnCanceledListener) ((org.xms.g.utils.XGettable) this).getHInstance());
        }
        return new com.huawei.hmf.tasks.OnCanceledListener() {
            
            public void onCanceled() {
                org.xms.g.tasks.OnCanceledListener.this.onCanceled();
            }
        };
    }
    
    public static org.xms.g.tasks.OnCanceledListener dynamicCast(java.lang.Object param0) {
        if (param0 instanceof org.xms.g.tasks.OnCanceledListener) {
            return ((org.xms.g.tasks.OnCanceledListener) param0);
        }
        if (param0 instanceof org.xms.g.utils.XGettable) {
            com.google.android.gms.tasks.OnCanceledListener gReturn = ((com.google.android.gms.tasks.OnCanceledListener) ((org.xms.g.utils.XGettable) param0).getGInstance());
            com.huawei.hmf.tasks.OnCanceledListener hReturn = ((com.huawei.hmf.tasks.OnCanceledListener) ((org.xms.g.utils.XGettable) param0).getHInstance());
            return new org.xms.g.tasks.OnCanceledListener.XImpl(gReturn, hReturn);
        }
        return ((org.xms.g.tasks.OnCanceledListener) param0);
    }
    
    public static boolean isInstance(java.lang.Object param0) {
        if (!(param0 instanceof org.xms.g.utils.XObject)) {
            return false;
        }
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hmf.tasks.OnCanceledListener;
        } else {
            return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.tasks.OnCanceledListener;
        }
    }
    
    public static class XImpl extends org.xms.g.utils.XObject implements org.xms.g.tasks.OnCanceledListener {
        
        public XImpl(com.google.android.gms.tasks.OnCanceledListener param0, com.huawei.hmf.tasks.OnCanceledListener param1) {
            super(param0, param1);
        }
        
        public static boolean isInstance(java.lang.Object param0) {
            if (!(param0 instanceof org.xms.g.utils.XObject)) {
                return false;
            }
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hmf.tasks.OnCanceledListener;
            } else {
                return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.tasks.OnCanceledListener;
            }
        }
        
        public void onCanceled() {
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hmf.tasks.OnCanceledListener) this.getHInstance()).onCanceled()", new Exception());
                ((com.huawei.hmf.tasks.OnCanceledListener) this.getHInstance()).onCanceled();
            } else {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.tasks.OnCanceledListener) this.getGInstance()).onCanceled()", new Exception());
                ((com.google.android.gms.tasks.OnCanceledListener) this.getGInstance()).onCanceled();
            }
        }
    }
}
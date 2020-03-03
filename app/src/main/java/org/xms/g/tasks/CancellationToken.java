package org.xms.g.tasks;

public abstract class CancellationToken extends org.xms.g.utils.XObject {
    private boolean wrapper = true;
    
    public CancellationToken(com.google.android.gms.tasks.CancellationToken param0, com.huawei.hmf.tasks.CancellationToken param1) {
        super(param0, null);
        this.setHInstance(param1);
        wrapper = true;
    }
    
    public abstract boolean isCancellationRequested();
    
    public abstract org.xms.g.tasks.CancellationToken onCanceledRequested(org.xms.g.tasks.OnTokenCanceledListener param0);
    
    public static org.xms.g.tasks.CancellationToken dynamicCast(java.lang.Object param0) {
        if (param0 instanceof org.xms.g.tasks.CancellationToken) {
            return ((org.xms.g.tasks.CancellationToken) param0);
        }
        if (param0 instanceof org.xms.g.utils.XGettable) {
            com.google.android.gms.tasks.CancellationToken gReturn = ((com.google.android.gms.tasks.CancellationToken) ((org.xms.g.utils.XGettable) param0).getGInstance());
            com.huawei.hmf.tasks.CancellationToken hReturn = ((com.huawei.hmf.tasks.CancellationToken) ((org.xms.g.utils.XGettable) param0).getHInstance());
            return new org.xms.g.tasks.CancellationToken.XImpl(gReturn, hReturn);
        }
        return ((org.xms.g.tasks.CancellationToken) param0);
    }
    
    public static boolean isInstance(java.lang.Object param0) {
        if (!(param0 instanceof org.xms.g.utils.XObject)) {
            return false;
        }
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hmf.tasks.CancellationToken;
        } else {
            return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.tasks.CancellationToken;
        }
    }
    
    public static class XImpl extends org.xms.g.tasks.CancellationToken {
        
        
        
        
        public XImpl(com.google.android.gms.tasks.CancellationToken param0, com.huawei.hmf.tasks.CancellationToken param1) {
            super(param0, param1);
        }
        
        public static boolean isInstance(java.lang.Object param0) {
            if (!(param0 instanceof org.xms.g.utils.XObject)) {
                return false;
            }
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hmf.tasks.CancellationToken;
            } else {
                return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.tasks.CancellationToken;
            }
        }
        
        public boolean isCancellationRequested() {
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hmf.tasks.CancellationToken) this.getHInstance()).isCancellationRequested()", new Exception());
                return ((com.huawei.hmf.tasks.CancellationToken) this.getHInstance()).isCancellationRequested();
            } else {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.tasks.CancellationToken) this.getGInstance()).isCancellationRequested()", new Exception());
                return ((com.google.android.gms.tasks.CancellationToken) this.getGInstance()).isCancellationRequested();
            }
        }
        
        public org.xms.g.tasks.CancellationToken onCanceledRequested(org.xms.g.tasks.OnTokenCanceledListener param0) {
            com.google.android.gms.tasks.CancellationToken gReturn = null;
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                
                com.huawei.hmf.tasks.CancellationToken hReturn = null;
                Runnable action = new Runnable() {
                    @Override
                    public void run() {
                        param0.onCanceled();
                    }
                };
                hReturn = ((com.huawei.hmf.tasks.CancellationToken) this.getHInstance()).register(action);
                if(hReturn==null){
                    return null;
                }
                return new org.xms.g.tasks.CancellationToken.XImpl(gReturn, hReturn);
                
            } else {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.tasks.CancellationToken) this.getGInstance()).onCanceledRequested(((param0) == null ? null : (param0.getGInstanceOnTokenCanceledListener())))", new Exception());
                gReturn = ((com.google.android.gms.tasks.CancellationToken) this.getGInstance()).onCanceledRequested(((param0) == null ? null : (param0.getGInstanceOnTokenCanceledListener())));
            }
            if (gReturn == null) {
                return null;
            }
            return new org.xms.g.tasks.CancellationToken.XImpl(gReturn, null);
        }
    }
}
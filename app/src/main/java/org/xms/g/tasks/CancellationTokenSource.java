package org.xms.g.tasks;

public class CancellationTokenSource extends org.xms.g.utils.XObject {
    private boolean wrapper = true;
    
    public CancellationTokenSource(com.google.android.gms.tasks.CancellationTokenSource param0, com.huawei.hmf.tasks.CancellationTokenSource param1) {
        super(param0, null);
        this.setHInstance(param1);
        wrapper = true;
    }
    
    public void cancel() {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hmf.tasks.CancellationTokenSource) this.getHInstance()).cancel()", new Exception());
            ((com.huawei.hmf.tasks.CancellationTokenSource) this.getHInstance()).cancel();
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.tasks.CancellationTokenSource) this.getGInstance()).cancel()", new Exception());
            ((com.google.android.gms.tasks.CancellationTokenSource) this.getGInstance()).cancel();
        }
    }
    
    public org.xms.g.tasks.CancellationToken getToken() {
        com.google.android.gms.tasks.CancellationToken gReturn = null;
        com.huawei.hmf.tasks.CancellationToken hReturn = null;
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hmf.tasks.CancellationTokenSource) this.getHInstance()).getToken()", new Exception());
            hReturn = ((com.huawei.hmf.tasks.CancellationTokenSource) this.getHInstance()).getToken();
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.tasks.CancellationTokenSource) this.getGInstance()).getToken()", new Exception());
            gReturn = ((com.google.android.gms.tasks.CancellationTokenSource) this.getGInstance()).getToken();
        }
        if (gReturn == null && hReturn == null) {
            return null;
        }
        return new org.xms.g.tasks.CancellationToken.XImpl(gReturn, hReturn);
    }
    
    public static org.xms.g.tasks.CancellationTokenSource dynamicCast(java.lang.Object param0) {
        return ((org.xms.g.tasks.CancellationTokenSource) param0);
    }
    
    public static boolean isInstance(java.lang.Object param0) {
        if (!(param0 instanceof org.xms.g.utils.XObject)) {
            return false;
        }
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hmf.tasks.CancellationTokenSource;
        } else {
            return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.tasks.CancellationTokenSource;
        }
    }
}
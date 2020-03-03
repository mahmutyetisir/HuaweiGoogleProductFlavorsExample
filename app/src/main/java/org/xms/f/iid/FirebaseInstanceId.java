package org.xms.f.iid;

public class FirebaseInstanceId extends org.xms.g.utils.XObject {
    private boolean wrapper = true;
    
    public FirebaseInstanceId(com.google.firebase.iid.FirebaseInstanceId param0, com.huawei.hms.aaid.HmsInstanceId param1) {
        super(param0, null);
        this.setHInstance(param1);
        wrapper = true;
    }
    
    public static org.xms.f.iid.FirebaseInstanceId getInstance() {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static org.xms.f.iid.FirebaseInstanceId getInstance(org.xms.f.FirebaseApp param0) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public org.xms.g.tasks.Task<org.xms.f.iid.InstanceIdResult> getInstanceId() {
        com.google.android.gms.tasks.Task gReturn = null;
        com.huawei.hmf.tasks.Task hReturn = null;
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.aaid.HmsInstanceId) this.getHInstance()).getAAID()", new Exception());
            hReturn = ((com.huawei.hms.aaid.HmsInstanceId) this.getHInstance()).getAAID();
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.firebase.iid.FirebaseInstanceId) this.getGInstance()).getInstanceId()", new Exception());
            gReturn = ((com.google.firebase.iid.FirebaseInstanceId) this.getGInstance()).getInstanceId();
        }
        if (gReturn == null && hReturn == null) {
            return null;
        }
        return new org.xms.g.tasks.Task.XImpl(gReturn, hReturn);
    }
    
    public java.lang.String getId() {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.aaid.HmsInstanceId) this.getHInstance()).getId()", new Exception());
            return ((com.huawei.hms.aaid.HmsInstanceId) this.getHInstance()).getId();
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.firebase.iid.FirebaseInstanceId) this.getGInstance()).getId()", new Exception());
            return ((com.google.firebase.iid.FirebaseInstanceId) this.getGInstance()).getId();
        }
    }
    
    public long getCreationTime() {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.aaid.HmsInstanceId) this.getHInstance()).getCreationTime()", new Exception());
            return ((com.huawei.hms.aaid.HmsInstanceId) this.getHInstance()).getCreationTime();
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.firebase.iid.FirebaseInstanceId) this.getGInstance()).getCreationTime()", new Exception());
            return ((com.google.firebase.iid.FirebaseInstanceId) this.getGInstance()).getCreationTime();
        }
    }
    
    public void deleteInstanceId() {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public java.lang.String getToken() {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.aaid.HmsInstanceId) this.getHInstance()).getToken()", new Exception());
            return ((com.huawei.hms.aaid.HmsInstanceId) this.getHInstance()).getToken();
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.firebase.iid.FirebaseInstanceId) this.getGInstance()).getToken()", new Exception());
            return ((com.google.firebase.iid.FirebaseInstanceId) this.getGInstance()).getToken();
        }
    }
    
    public java.lang.String getToken(java.lang.String param0, java.lang.String param1) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public void deleteToken(java.lang.String param0, java.lang.String param1) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static org.xms.f.iid.FirebaseInstanceId dynamicCast(java.lang.Object param0) {
        return ((org.xms.f.iid.FirebaseInstanceId) param0);
    }
    
    public static boolean isInstance(java.lang.Object param0) {
        if (!(param0 instanceof org.xms.g.utils.XObject)) {
            return false;
        }
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hms.aaid.HmsInstanceId;
        } else {
            return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.firebase.iid.FirebaseInstanceId;
        }
    }
}
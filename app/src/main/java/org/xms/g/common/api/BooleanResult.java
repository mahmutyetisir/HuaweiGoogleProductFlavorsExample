package org.xms.g.common.api;

public class BooleanResult extends org.xms.g.utils.XObject {
    private boolean wrapper = true;
    
    public BooleanResult(com.google.android.gms.common.api.BooleanResult param0, com.huawei.hms.common.api.BooleanResult param1) {
        super(param0, null);
        this.setHInstance(param1);
        wrapper = true;
    }
    
    public boolean equals(java.lang.Object param0) {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.common.api.BooleanResult) this.getHInstance()).equals(param0)", new Exception());
            return ((com.huawei.hms.common.api.BooleanResult) this.getHInstance()).equals(param0);
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.common.api.BooleanResult) this.getGInstance()).equals(param0)", new Exception());
            return ((com.google.android.gms.common.api.BooleanResult) this.getGInstance()).equals(param0);
        }
    }
    
    public org.xms.g.common.api.Status getStatus() {
        com.google.android.gms.common.api.Status gReturn = null;
        com.huawei.hms.support.api.client.Status hReturn = null;
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.common.api.BooleanResult) this.getHInstance()).getStatus()", new Exception());
            hReturn = ((com.huawei.hms.common.api.BooleanResult) this.getHInstance()).getStatus();
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.common.api.BooleanResult) this.getGInstance()).getStatus()", new Exception());
            gReturn = ((com.google.android.gms.common.api.BooleanResult) this.getGInstance()).getStatus();
        }
        if (gReturn == null && hReturn == null) {
            return null;
        }
        return new org.xms.g.common.api.Status(gReturn, hReturn);
    }
    
    public boolean getValue() {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.common.api.BooleanResult) this.getHInstance()).getValue()", new Exception());
            return ((com.huawei.hms.common.api.BooleanResult) this.getHInstance()).getValue();
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.common.api.BooleanResult) this.getGInstance()).getValue()", new Exception());
            return ((com.google.android.gms.common.api.BooleanResult) this.getGInstance()).getValue();
        }
    }
    
    public final int hashCode() {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.common.api.BooleanResult) this.getHInstance()).hashCode()", new Exception());
            return ((com.huawei.hms.common.api.BooleanResult) this.getHInstance()).hashCode();
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.common.api.BooleanResult) this.getGInstance()).hashCode()", new Exception());
            return ((com.google.android.gms.common.api.BooleanResult) this.getGInstance()).hashCode();
        }
    }
    
    public static org.xms.g.common.api.BooleanResult dynamicCast(java.lang.Object param0) {
        return ((org.xms.g.common.api.BooleanResult) param0);
    }
    
    public static boolean isInstance(java.lang.Object param0) {
        if (!(param0 instanceof org.xms.g.utils.XObject)) {
            return false;
        }
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hms.common.api.BooleanResult;
        } else {
            return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.common.api.BooleanResult;
        }
    }
}
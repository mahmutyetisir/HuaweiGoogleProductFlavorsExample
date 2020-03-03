package org.xms.g.common.api;

public interface Result extends org.xms.g.utils.XInterface {
    
    public org.xms.g.common.api.Status getStatus();
    
    default com.google.android.gms.common.api.Result getGInstanceResult() {
        if (this instanceof org.xms.g.utils.XGettable) {
            return ((com.google.android.gms.common.api.Result) ((org.xms.g.utils.XGettable) this).getGInstance());
        }
        return new com.google.android.gms.common.api.Result() {
            
            public com.google.android.gms.common.api.Status getStatus() {
                java.lang.Object xResult = org.xms.g.common.api.Result.this.getStatus();
                return ((com.google.android.gms.common.api.Status) ((xResult) == null ? null : (((org.xms.g.utils.XObject) xResult).getGInstance())));
            }
        };
    }
    
    default com.huawei.hms.support.api.client.Result getHInstanceResult() {
        if (this instanceof org.xms.g.utils.XGettable) {
            return ((com.huawei.hms.support.api.client.Result) ((org.xms.g.utils.XGettable) this).getHInstance());
        }
        return new com.huawei.hms.support.api.client.Result() {
            
            public com.huawei.hms.support.api.client.Status getStatus() {
                java.lang.Object xResult = org.xms.g.common.api.Result.this.getStatus();
                return ((com.huawei.hms.support.api.client.Status) ((xResult) == null ? null : (((org.xms.g.utils.XObject) xResult).getHInstance())));
            }
        };
    }
    
    public static org.xms.g.common.api.Result dynamicCast(java.lang.Object param0) {
        if (param0 instanceof org.xms.g.common.api.Result) {
            return ((org.xms.g.common.api.Result) param0);
        }
        if (param0 instanceof org.xms.g.utils.XGettable) {
            com.google.android.gms.common.api.Result gReturn = ((com.google.android.gms.common.api.Result) ((org.xms.g.utils.XGettable) param0).getGInstance());
            com.huawei.hms.support.api.client.Result hReturn = ((com.huawei.hms.support.api.client.Result) ((org.xms.g.utils.XGettable) param0).getHInstance());
            return new org.xms.g.common.api.Result.XImpl(gReturn, hReturn);
        }
        return ((org.xms.g.common.api.Result) param0);
    }
    
    public static boolean isInstance(java.lang.Object param0) {
        if (!(param0 instanceof org.xms.g.utils.XObject)) {
            return false;
        }
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hms.support.api.client.Result;
        } else {
            return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.common.api.Result;
        }
    }
    
    public static class XImpl extends org.xms.g.utils.XObject implements org.xms.g.common.api.Result {
        
        public XImpl(com.google.android.gms.common.api.Result param0, com.huawei.hms.support.api.client.Result param1) {
            super(param0, param1);
        }
        
        public static boolean isInstance(java.lang.Object param0) {
            if (!(param0 instanceof org.xms.g.utils.XObject)) {
                return false;
            }
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hms.support.api.client.Result;
            } else {
                return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.common.api.Result;
            }
        }
        
        public org.xms.g.common.api.Status getStatus() {
            com.google.android.gms.common.api.Status gReturn = null;
            com.huawei.hms.support.api.client.Status hReturn = null;
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.support.api.client.Result) this.getHInstance()).getStatus()", new Exception());
                hReturn = ((com.huawei.hms.support.api.client.Result) this.getHInstance()).getStatus();
            } else {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.common.api.Result) this.getGInstance()).getStatus()", new Exception());
                gReturn = ((com.google.android.gms.common.api.Result) this.getGInstance()).getStatus();
            }
            if (gReturn == null && hReturn == null) {
                return null;
            }
            return new org.xms.g.common.api.Status(gReturn, hReturn);
        }
    }
}
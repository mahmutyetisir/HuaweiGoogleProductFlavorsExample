package org.xms.f.iid;

public interface InstanceIdResult extends org.xms.g.utils.XInterface {
    
    public java.lang.String getId();
    
    public java.lang.String getToken();
    
    default com.google.firebase.iid.InstanceIdResult getGInstanceInstanceIdResult() {
        if (this instanceof org.xms.g.utils.XGettable) {
            return ((com.google.firebase.iid.InstanceIdResult) ((org.xms.g.utils.XGettable) this).getGInstance());
        }
        return new com.google.firebase.iid.InstanceIdResult() {
            
            public java.lang.String getId() {
                return org.xms.f.iid.InstanceIdResult.this.getId();
            }
            
            public java.lang.String getToken() {
                throw new java.lang.RuntimeException("Not Supported");
            }
        };
    }
    
    default com.huawei.hms.aaid.entity.AAIDResult getHInstanceInstanceIdResult() {
        if (this instanceof org.xms.g.utils.XGettable) {
            return ((com.huawei.hms.aaid.entity.AAIDResult) ((org.xms.g.utils.XGettable) this).getHInstance());
        }
        return new com.huawei.hms.aaid.entity.AAIDResult() {
            
            public java.lang.String getId() {
                return org.xms.f.iid.InstanceIdResult.this.getId();
            }
        };
    }
    
    public static org.xms.f.iid.InstanceIdResult dynamicCast(java.lang.Object param0) {
        if (param0 instanceof org.xms.f.iid.InstanceIdResult) {
            return ((org.xms.f.iid.InstanceIdResult) param0);
        }
        if (param0 instanceof org.xms.g.utils.XGettable) {
            com.google.firebase.iid.InstanceIdResult gReturn = ((com.google.firebase.iid.InstanceIdResult) ((org.xms.g.utils.XGettable) param0).getGInstance());
            com.huawei.hms.aaid.entity.AAIDResult hReturn = ((com.huawei.hms.aaid.entity.AAIDResult) ((org.xms.g.utils.XGettable) param0).getHInstance());
            return new org.xms.f.iid.InstanceIdResult.XImpl(gReturn, hReturn);
        }
        return ((org.xms.f.iid.InstanceIdResult) param0);
    }
    
    public static boolean isInstance(java.lang.Object param0) {
        if (!(param0 instanceof org.xms.g.utils.XObject)) {
            return false;
        }
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hms.aaid.entity.AAIDResult;
        } else {
            return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.firebase.iid.InstanceIdResult;
        }
    }
    
    public static class XImpl extends org.xms.g.utils.XObject implements org.xms.f.iid.InstanceIdResult {
        
        public XImpl(com.google.firebase.iid.InstanceIdResult param0, com.huawei.hms.aaid.entity.AAIDResult param1) {
            super(param0, param1);
        }
        
        public static boolean isInstance(java.lang.Object param0) {
            if (!(param0 instanceof org.xms.g.utils.XObject)) {
                return false;
            }
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hms.aaid.entity.AAIDResult;
            } else {
                return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.firebase.iid.InstanceIdResult;
            }
        }
        
        public java.lang.String getId() {
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.aaid.entity.AAIDResult) this.getHInstance()).getId()", new Exception());
                return ((com.huawei.hms.aaid.entity.AAIDResult) this.getHInstance()).getId();
            } else {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.firebase.iid.InstanceIdResult) this.getGInstance()).getId()", new Exception());
                return ((com.google.firebase.iid.InstanceIdResult) this.getGInstance()).getId();
            }
        }
        
        public java.lang.String getToken() {
            throw new java.lang.RuntimeException("Not Supported");
        }
    }
}
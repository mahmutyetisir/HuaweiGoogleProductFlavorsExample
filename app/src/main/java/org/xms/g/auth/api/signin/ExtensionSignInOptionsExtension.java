package org.xms.g.auth.api.signin;

public interface ExtensionSignInOptionsExtension extends org.xms.g.utils.XInterface {
    
    public int getExtensionType();
    
    public java.util.List<org.xms.g.common.api.Scope> getImpliedScopes();
    
    public android.os.Bundle toBundle();
    
    default com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension getGInstanceExtensionSignInOptionsExtension() {
        if (this instanceof org.xms.g.utils.XGettable) {
            return ((com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension) ((org.xms.g.utils.XGettable) this).getGInstance());
        }
        return new com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension() {
            
            public int getExtensionType() {
                return org.xms.g.auth.api.signin.ExtensionSignInOptionsExtension.this.getExtensionType();
            }
            
            public java.util.List<com.google.android.gms.common.api.Scope> getImpliedScopes() {
                return ((java.util.List) org.xms.g.utils.Utils.mapCollection(((java.util.List) org.xms.g.auth.api.signin.ExtensionSignInOptionsExtension.this.getImpliedScopes()), new java.util.function.Function<org.xms.g.common.api.Scope, com.google.android.gms.common.api.Scope>() {
                    
                    public com.google.android.gms.common.api.Scope apply(org.xms.g.common.api.Scope param0) {
                        return ((com.google.android.gms.common.api.Scope) org.xms.g.utils.Utils.getInstanceInInterface(param0, false));
                    }
                }));
            }
            
            public android.os.Bundle toBundle() {
                return org.xms.g.auth.api.signin.ExtensionSignInOptionsExtension.this.toBundle();
            }
        };
    }
    
    default com.huawei.hms.support.hwid.request.HuaweiIdAuthExtendedParams getHInstanceExtensionSignInOptionsExtension() {
        if (this instanceof org.xms.g.utils.XGettable) {
            return ((com.huawei.hms.support.hwid.request.HuaweiIdAuthExtendedParams) ((org.xms.g.utils.XGettable) this).getHInstance());
        }
        return new com.huawei.hms.support.hwid.request.HuaweiIdAuthExtendedParams() {
            
            public int getExtendedParamType() {
                return org.xms.g.auth.api.signin.ExtensionSignInOptionsExtension.this.getExtensionType();
            }
            
            public java.util.List<com.huawei.hms.support.api.entity.auth.Scope> getExtendedScopes() {
                return ((java.util.List) org.xms.g.utils.Utils.mapCollection(((java.util.List) org.xms.g.auth.api.signin.ExtensionSignInOptionsExtension.this.getImpliedScopes()), new java.util.function.Function<org.xms.g.common.api.Scope, com.huawei.hms.support.api.entity.auth.Scope>() {
                    
                    public com.huawei.hms.support.api.entity.auth.Scope apply(org.xms.g.common.api.Scope param0) {
                        return ((com.huawei.hms.support.api.entity.auth.Scope) org.xms.g.utils.Utils.getInstanceInInterface(param0, true));
                    }
                }));
            }
            
            public android.os.Bundle getExtendedBundle() {
                return org.xms.g.auth.api.signin.ExtensionSignInOptionsExtension.this.toBundle();
            }
        };
    }
    
    public static org.xms.g.auth.api.signin.ExtensionSignInOptionsExtension dynamicCast(java.lang.Object param0) {
        if (param0 instanceof org.xms.g.auth.api.signin.ExtensionSignInOptionsExtension) {
            return ((org.xms.g.auth.api.signin.ExtensionSignInOptionsExtension) param0);
        }
        if (param0 instanceof org.xms.g.utils.XGettable) {
            com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension gReturn = ((com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension) ((org.xms.g.utils.XGettable) param0).getGInstance());
            com.huawei.hms.support.hwid.request.HuaweiIdAuthExtendedParams hReturn = ((com.huawei.hms.support.hwid.request.HuaweiIdAuthExtendedParams) ((org.xms.g.utils.XGettable) param0).getHInstance());
            return new org.xms.g.auth.api.signin.ExtensionSignInOptionsExtension.XImpl(gReturn, hReturn);
        }
        return ((org.xms.g.auth.api.signin.ExtensionSignInOptionsExtension) param0);
    }
    
    public static boolean isInstance(java.lang.Object param0) {
        if (!(param0 instanceof org.xms.g.utils.XObject)) {
            return false;
        }
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hms.support.hwid.request.HuaweiIdAuthExtendedParams;
        } else {
            return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension;
        }
    }
    
    public static class XImpl extends org.xms.g.utils.XObject implements org.xms.g.auth.api.signin.ExtensionSignInOptionsExtension {
        
        public XImpl(com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension param0, com.huawei.hms.support.hwid.request.HuaweiIdAuthExtendedParams param1) {
            super(param0, param1);
        }
        
        public static boolean isInstance(java.lang.Object param0) {
            if (!(param0 instanceof org.xms.g.utils.XObject)) {
                return false;
            }
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hms.support.hwid.request.HuaweiIdAuthExtendedParams;
            } else {
                return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension;
            }
        }
        
        public int getExtensionType() {
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.support.hwid.request.HuaweiIdAuthExtendedParams) this.getHInstance()).getExtendedParamType()", new Exception());
                return ((com.huawei.hms.support.hwid.request.HuaweiIdAuthExtendedParams) this.getHInstance()).getExtendedParamType();
            } else {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension) this.getGInstance()).getExtensionType()", new Exception());
                return ((com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension) this.getGInstance()).getExtensionType();
            }
        }
        
        public java.util.List<org.xms.g.common.api.Scope> getImpliedScopes() {
            java.util.List hReturn = null;
            java.util.List gReturn = null;
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.support.hwid.request.HuaweiIdAuthExtendedParams) this.getHInstance()).getExtendedScopes()", new Exception());
                hReturn = ((com.huawei.hms.support.hwid.request.HuaweiIdAuthExtendedParams) this.getHInstance()).getExtendedScopes();
            } else {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension) this.getGInstance()).getImpliedScopes()", new Exception());
                gReturn = ((com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension) this.getGInstance()).getImpliedScopes();
            }
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                return ((java.util.List) org.xms.g.utils.Utils.mapCollection(hReturn, new java.util.function.Function<com.huawei.hms.support.api.entity.auth.Scope, org.xms.g.common.api.Scope>() {
                    
                    public org.xms.g.common.api.Scope apply(com.huawei.hms.support.api.entity.auth.Scope param0) {
                        return new org.xms.g.common.api.Scope(null, param0);
                    }
                }));
            } else {
                return ((java.util.List) org.xms.g.utils.Utils.mapCollection(gReturn, new java.util.function.Function<com.google.android.gms.common.api.Scope, org.xms.g.common.api.Scope>() {
                    
                    public org.xms.g.common.api.Scope apply(com.google.android.gms.common.api.Scope param0) {
                        return new org.xms.g.common.api.Scope(param0, null);
                    }
                }));
            }
        }
        
        public android.os.Bundle toBundle() {
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.support.hwid.request.HuaweiIdAuthExtendedParams) this.getHInstance()).getExtendedBundle()", new Exception());
                return ((com.huawei.hms.support.hwid.request.HuaweiIdAuthExtendedParams) this.getHInstance()).getExtendedBundle();
            } else {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension) this.getGInstance()).toBundle()", new Exception());
                return ((com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension) this.getGInstance()).toBundle();
            }
        }
    }
}
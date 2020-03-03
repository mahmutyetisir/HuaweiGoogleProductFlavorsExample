package org.xms.g.common.api;

public final class Api<XO extends org.xms.g.common.api.Api.ApiOptions> extends org.xms.g.utils.XObject {
    
    public Api(com.google.android.gms.common.api.Api param0, com.huawei.hms.api.Api param1) {
        super(param0, null);
        this.setHInstance(param1);
    }
    
    public static org.xms.g.common.api.Api dynamicCast(java.lang.Object param0) {
        return ((org.xms.g.common.api.Api) param0);
    }
    
    public static boolean isInstance(java.lang.Object param0) {
        if (!(param0 instanceof org.xms.g.utils.XObject)) {
            return false;
        }
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hms.api.Api;
        } else {
            return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.common.api.Api;
        }
    }
    
    public static interface ApiOptions extends org.xms.g.utils.XInterface {
        
        default com.google.android.gms.common.api.Api.ApiOptions getGInstanceApiOptions() {
            if (this instanceof org.xms.g.utils.XGettable) {
                return ((com.google.android.gms.common.api.Api.ApiOptions) ((org.xms.g.utils.XGettable) this).getGInstance());
            }
            return new com.google.android.gms.common.api.Api.ApiOptions() {
            };
        }
        
        default com.huawei.hms.api.Api.ApiOptions getHInstanceApiOptions() {
            if (this instanceof org.xms.g.utils.XGettable) {
                return ((com.huawei.hms.api.Api.ApiOptions) ((org.xms.g.utils.XGettable) this).getHInstance());
            }
            return new com.huawei.hms.api.Api.ApiOptions() {
            };
        }
        
        public static org.xms.g.common.api.Api.ApiOptions dynamicCast(java.lang.Object param0) {
            if (param0 instanceof org.xms.g.common.api.Api.ApiOptions) {
                return ((org.xms.g.common.api.Api.ApiOptions) param0);
            }
            if (param0 instanceof org.xms.g.utils.XGettable) {
                com.google.android.gms.common.api.Api.ApiOptions gReturn = ((com.google.android.gms.common.api.Api.ApiOptions) ((org.xms.g.utils.XGettable) param0).getGInstance());
                com.huawei.hms.api.Api.ApiOptions hReturn = ((com.huawei.hms.api.Api.ApiOptions) ((org.xms.g.utils.XGettable) param0).getHInstance());
                return new org.xms.g.common.api.Api.ApiOptions.XImpl(gReturn, hReturn);
            }
            return ((org.xms.g.common.api.Api.ApiOptions) param0);
        }
        
        public static boolean isInstance(java.lang.Object param0) {
            if (!(param0 instanceof org.xms.g.utils.XObject)) {
                return false;
            }
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hms.api.Api.ApiOptions;
            } else {
                return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.common.api.Api.ApiOptions;
            }
        }
        
        public static class XImpl extends org.xms.g.utils.XObject implements org.xms.g.common.api.Api.ApiOptions {
            
            public XImpl(com.google.android.gms.common.api.Api.ApiOptions param0, com.huawei.hms.api.Api.ApiOptions param1) {
                super(param0, param1);
            }
            
            public static boolean isInstance(java.lang.Object param0) {
                if (!(param0 instanceof org.xms.g.utils.XObject)) {
                    return false;
                }
                if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                    return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hms.api.Api.ApiOptions;
                } else {
                    return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.common.api.Api.ApiOptions;
                }
            }
        }
        
        public static interface HasAccountOptions extends org.xms.g.utils.XInterface, org.xms.g.common.api.Api.ApiOptions.HasOptions, org.xms.g.common.api.Api.ApiOptions.NotRequiredOptions {
            
            public android.accounts.Account getAccount();
            
            default com.google.android.gms.common.api.Api.ApiOptions.HasAccountOptions getGInstanceHasAccountOptions() {
                if (this instanceof org.xms.g.utils.XGettable) {
                    return ((com.google.android.gms.common.api.Api.ApiOptions.HasAccountOptions) ((org.xms.g.utils.XGettable) this).getGInstance());
                }
                return new com.google.android.gms.common.api.Api.ApiOptions.HasAccountOptions() {
                    
                    public android.accounts.Account getAccount() {
                        return org.xms.g.common.api.Api.ApiOptions.HasAccountOptions.this.getAccount();
                    }
                };
            }
            
            default com.huawei.hms.support.api.hwid.HuaweiAccountOptions.HasAccountOptions getHInstanceHasAccountOptions() {
                if (this instanceof org.xms.g.utils.XGettable) {
                    return ((com.huawei.hms.support.api.hwid.HuaweiAccountOptions.HasAccountOptions) ((org.xms.g.utils.XGettable) this).getHInstance());
                }
                return new com.huawei.hms.support.api.hwid.HuaweiAccountOptions.HasAccountOptions() {
                    
                    public android.accounts.Account getAccount() {
                        return org.xms.g.common.api.Api.ApiOptions.HasAccountOptions.this.getAccount();
                    }
                };
            }
            
            public static org.xms.g.common.api.Api.ApiOptions.HasAccountOptions dynamicCast(java.lang.Object param0) {
                if (param0 instanceof org.xms.g.common.api.Api.ApiOptions.HasAccountOptions) {
                    return ((org.xms.g.common.api.Api.ApiOptions.HasAccountOptions) param0);
                }
                if (param0 instanceof org.xms.g.utils.XGettable) {
                    com.google.android.gms.common.api.Api.ApiOptions.HasAccountOptions gReturn = ((com.google.android.gms.common.api.Api.ApiOptions.HasAccountOptions) ((org.xms.g.utils.XGettable) param0).getGInstance());
                    com.huawei.hms.support.api.hwid.HuaweiAccountOptions.HasAccountOptions hReturn = ((com.huawei.hms.support.api.hwid.HuaweiAccountOptions.HasAccountOptions) ((org.xms.g.utils.XGettable) param0).getHInstance());
                    return new org.xms.g.common.api.Api.ApiOptions.HasAccountOptions.XImpl(gReturn, hReturn);
                }
                return ((org.xms.g.common.api.Api.ApiOptions.HasAccountOptions) param0);
            }
            
            public static boolean isInstance(java.lang.Object param0) {
                if (!(param0 instanceof org.xms.g.utils.XObject)) {
                    return false;
                }
                if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                    return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hms.support.api.hwid.HuaweiAccountOptions.HasAccountOptions;
                } else {
                    return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.common.api.Api.ApiOptions.HasAccountOptions;
                }
            }
            
            public static class XImpl extends org.xms.g.utils.XObject implements org.xms.g.common.api.Api.ApiOptions.HasAccountOptions {
                
                public XImpl(com.google.android.gms.common.api.Api.ApiOptions.HasAccountOptions param0, com.huawei.hms.support.api.hwid.HuaweiAccountOptions.HasAccountOptions param1) {
                    super(param0, param1);
                }
                
                public static boolean isInstance(java.lang.Object param0) {
                    if (!(param0 instanceof org.xms.g.utils.XObject)) {
                        return false;
                    }
                    if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                        return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hms.support.api.hwid.HuaweiAccountOptions.HasAccountOptions;
                    } else {
                        return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.common.api.Api.ApiOptions.HasAccountOptions;
                    }
                }
                
                public android.accounts.Account getAccount() {
                    if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                        org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.support.api.hwid.HuaweiAccountOptions.HasAccountOptions) this.getHInstance()).getAccount()", new Exception());
                        return ((com.huawei.hms.support.api.hwid.HuaweiAccountOptions.HasAccountOptions) this.getHInstance()).getAccount();
                    } else {
                        org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.common.api.Api.ApiOptions.HasAccountOptions) this.getGInstance()).getAccount()", new Exception());
                        return ((com.google.android.gms.common.api.Api.ApiOptions.HasAccountOptions) this.getGInstance()).getAccount();
                    }
                }
            }
        }
        
        public static interface HasExtensionSignInAccountOptions extends org.xms.g.utils.XInterface, org.xms.g.common.api.Api.ApiOptions.HasOptions {
            
            public org.xms.g.auth.api.signin.ExtensionSignInAccount getGoogleSignInAccount();
            
            default com.google.android.gms.common.api.Api.ApiOptions.HasGoogleSignInAccountOptions getGInstanceHasExtensionSignInAccountOptions() {
                if (this instanceof org.xms.g.utils.XGettable) {
                    return ((com.google.android.gms.common.api.Api.ApiOptions.HasGoogleSignInAccountOptions) ((org.xms.g.utils.XGettable) this).getGInstance());
                }
                return new com.google.android.gms.common.api.Api.ApiOptions.HasGoogleSignInAccountOptions() {
                    
                    public com.google.android.gms.auth.api.signin.GoogleSignInAccount getGoogleSignInAccount() {
                        java.lang.Object xResult = org.xms.g.common.api.Api.ApiOptions.HasExtensionSignInAccountOptions.this.getGoogleSignInAccount();
                        return ((com.google.android.gms.auth.api.signin.GoogleSignInAccount) ((xResult) == null ? null : (((org.xms.g.utils.XObject) xResult).getGInstance())));
                    }
                };
            }
            
            default com.huawei.hms.support.api.hwid.HuaweiAccountOptions.HasAuthHuaweiIdOptions getHInstanceHasExtensionSignInAccountOptions() {
                if (this instanceof org.xms.g.utils.XGettable) {
                    return ((com.huawei.hms.support.api.hwid.HuaweiAccountOptions.HasAuthHuaweiIdOptions) ((org.xms.g.utils.XGettable) this).getHInstance());
                }
                return new com.huawei.hms.support.api.hwid.HuaweiAccountOptions.HasAuthHuaweiIdOptions() {
                    
                    public com.huawei.hms.support.hwid.result.AuthHuaweiId getAuthHuaweiId() {
                        java.lang.Object xResult = org.xms.g.common.api.Api.ApiOptions.HasExtensionSignInAccountOptions.this.getGoogleSignInAccount();
                        return ((com.huawei.hms.support.hwid.result.AuthHuaweiId) ((xResult) == null ? null : (((org.xms.g.utils.XObject) xResult).getHInstance())));
                    }
                };
            }
            
            public static org.xms.g.common.api.Api.ApiOptions.HasExtensionSignInAccountOptions dynamicCast(java.lang.Object param0) {
                if (param0 instanceof org.xms.g.common.api.Api.ApiOptions.HasExtensionSignInAccountOptions) {
                    return ((org.xms.g.common.api.Api.ApiOptions.HasExtensionSignInAccountOptions) param0);
                }
                if (param0 instanceof org.xms.g.utils.XGettable) {
                    com.google.android.gms.common.api.Api.ApiOptions.HasGoogleSignInAccountOptions gReturn = ((com.google.android.gms.common.api.Api.ApiOptions.HasGoogleSignInAccountOptions) ((org.xms.g.utils.XGettable) param0).getGInstance());
                    com.huawei.hms.support.api.hwid.HuaweiAccountOptions.HasAuthHuaweiIdOptions hReturn = ((com.huawei.hms.support.api.hwid.HuaweiAccountOptions.HasAuthHuaweiIdOptions) ((org.xms.g.utils.XGettable) param0).getHInstance());
                    return new org.xms.g.common.api.Api.ApiOptions.HasExtensionSignInAccountOptions.XImpl(gReturn, hReturn);
                }
                return ((org.xms.g.common.api.Api.ApiOptions.HasExtensionSignInAccountOptions) param0);
            }
            
            public static boolean isInstance(java.lang.Object param0) {
                if (!(param0 instanceof org.xms.g.utils.XObject)) {
                    return false;
                }
                if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                    return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hms.support.api.hwid.HuaweiAccountOptions.HasAuthHuaweiIdOptions;
                } else {
                    return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.common.api.Api.ApiOptions.HasGoogleSignInAccountOptions;
                }
            }
            
            public static class XImpl extends org.xms.g.utils.XObject implements org.xms.g.common.api.Api.ApiOptions.HasExtensionSignInAccountOptions {
                
                public XImpl(com.google.android.gms.common.api.Api.ApiOptions.HasGoogleSignInAccountOptions param0, com.huawei.hms.support.api.hwid.HuaweiAccountOptions.HasAuthHuaweiIdOptions param1) {
                    super(param0, param1);
                }
                
                public static boolean isInstance(java.lang.Object param0) {
                    if (!(param0 instanceof org.xms.g.utils.XObject)) {
                        return false;
                    }
                    if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                        return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hms.support.api.hwid.HuaweiAccountOptions.HasAuthHuaweiIdOptions;
                    } else {
                        return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.common.api.Api.ApiOptions.HasGoogleSignInAccountOptions;
                    }
                }
                
                public org.xms.g.auth.api.signin.ExtensionSignInAccount getGoogleSignInAccount() {
                    com.google.android.gms.auth.api.signin.GoogleSignInAccount gReturn = null;
                    com.huawei.hms.support.hwid.result.AuthHuaweiId hReturn = null;
                    if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                        org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.support.api.hwid.HuaweiAccountOptions.HasAuthHuaweiIdOptions) this.getHInstance()).getAuthHuaweiId()", new Exception());
                        hReturn = ((com.huawei.hms.support.api.hwid.HuaweiAccountOptions.HasAuthHuaweiIdOptions) this.getHInstance()).getAuthHuaweiId();
                    } else {
                        org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.common.api.Api.ApiOptions.HasGoogleSignInAccountOptions) this.getGInstance()).getGoogleSignInAccount()", new Exception());
                        gReturn = ((com.google.android.gms.common.api.Api.ApiOptions.HasGoogleSignInAccountOptions) this.getGInstance()).getGoogleSignInAccount();
                    }
                    if (gReturn == null && hReturn == null) {
                        return null;
                    }
                    return new org.xms.g.auth.api.signin.ExtensionSignInAccount(gReturn, hReturn);
                }
            }
        }
        
        public static interface HasOptions extends org.xms.g.utils.XInterface, org.xms.g.common.api.Api.ApiOptions {
            
            default com.google.android.gms.common.api.Api.ApiOptions.HasOptions getGInstanceHasOptions() {
                if (this instanceof org.xms.g.utils.XGettable) {
                    return ((com.google.android.gms.common.api.Api.ApiOptions.HasOptions) ((org.xms.g.utils.XGettable) this).getGInstance());
                }
                return new com.google.android.gms.common.api.Api.ApiOptions.HasOptions() {
                };
            }
            
            default com.huawei.hms.api.Api.ApiOptions.HasOptions getHInstanceHasOptions() {
                if (this instanceof org.xms.g.utils.XGettable) {
                    return ((com.huawei.hms.api.Api.ApiOptions.HasOptions) ((org.xms.g.utils.XGettable) this).getHInstance());
                }
                return new com.huawei.hms.api.Api.ApiOptions.HasOptions() {
                };
            }
            
            public static org.xms.g.common.api.Api.ApiOptions.HasOptions dynamicCast(java.lang.Object param0) {
                if (param0 instanceof org.xms.g.common.api.Api.ApiOptions.HasOptions) {
                    return ((org.xms.g.common.api.Api.ApiOptions.HasOptions) param0);
                }
                if (param0 instanceof org.xms.g.utils.XGettable) {
                    com.google.android.gms.common.api.Api.ApiOptions.HasOptions gReturn = ((com.google.android.gms.common.api.Api.ApiOptions.HasOptions) ((org.xms.g.utils.XGettable) param0).getGInstance());
                    com.huawei.hms.api.Api.ApiOptions.HasOptions hReturn = ((com.huawei.hms.api.Api.ApiOptions.HasOptions) ((org.xms.g.utils.XGettable) param0).getHInstance());
                    return new org.xms.g.common.api.Api.ApiOptions.HasOptions.XImpl(gReturn, hReturn);
                }
                return ((org.xms.g.common.api.Api.ApiOptions.HasOptions) param0);
            }
            
            public static boolean isInstance(java.lang.Object param0) {
                if (!(param0 instanceof org.xms.g.utils.XObject)) {
                    return false;
                }
                if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                    return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hms.api.Api.ApiOptions.HasOptions;
                } else {
                    return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
                }
            }
            
            public static class XImpl extends org.xms.g.utils.XObject implements org.xms.g.common.api.Api.ApiOptions.HasOptions {
                
                public XImpl(com.google.android.gms.common.api.Api.ApiOptions.HasOptions param0, com.huawei.hms.api.Api.ApiOptions.HasOptions param1) {
                    super(param0, param1);
                }
                
                public static boolean isInstance(java.lang.Object param0) {
                    if (!(param0 instanceof org.xms.g.utils.XObject)) {
                        return false;
                    }
                    if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                        return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hms.api.Api.ApiOptions.HasOptions;
                    } else {
                        return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
                    }
                }
            }
        }
        
        public static final class NoOptions extends org.xms.g.utils.XObject implements org.xms.g.common.api.Api.ApiOptions.NotRequiredOptions {
            
            public NoOptions(com.google.android.gms.common.api.Api.ApiOptions.NoOptions param0, com.huawei.hms.api.Api.ApiOptions.NoOptions param1) {
                super(param0, null);
                this.setHInstance(param1);
            }
            
            public static org.xms.g.common.api.Api.ApiOptions.NoOptions dynamicCast(java.lang.Object param0) {
                if (param0 instanceof org.xms.g.common.api.Api.ApiOptions.NoOptions) {
                    return ((org.xms.g.common.api.Api.ApiOptions.NoOptions) param0);
                }
                if (param0 instanceof org.xms.g.utils.XGettable) {
                    com.google.android.gms.common.api.Api.ApiOptions.NoOptions gReturn = ((com.google.android.gms.common.api.Api.ApiOptions.NoOptions) ((org.xms.g.utils.XGettable) param0).getGInstance());
                    com.huawei.hms.api.Api.ApiOptions.NoOptions hReturn = ((com.huawei.hms.api.Api.ApiOptions.NoOptions) ((org.xms.g.utils.XGettable) param0).getHInstance());
                    return new org.xms.g.common.api.Api.ApiOptions.NoOptions(gReturn, hReturn);
                }
                return ((org.xms.g.common.api.Api.ApiOptions.NoOptions) param0);
            }
            
            public static boolean isInstance(java.lang.Object param0) {
                if (!(param0 instanceof org.xms.g.utils.XObject)) {
                    return false;
                }
                if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                    return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hms.api.Api.ApiOptions.NoOptions;
                } else {
                    return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
                }
            }
        }
        
        public static interface NotRequiredOptions extends org.xms.g.utils.XInterface, org.xms.g.common.api.Api.ApiOptions {
            
            default com.google.android.gms.common.api.Api.ApiOptions.NotRequiredOptions getGInstanceNotRequiredOptions() {
                if (this instanceof org.xms.g.utils.XGettable) {
                    return ((com.google.android.gms.common.api.Api.ApiOptions.NotRequiredOptions) ((org.xms.g.utils.XGettable) this).getGInstance());
                }
                return new com.google.android.gms.common.api.Api.ApiOptions.NotRequiredOptions() {
                };
            }
            
            default com.huawei.hms.api.Api.ApiOptions.NotRequiredOptions getHInstanceNotRequiredOptions() {
                if (this instanceof org.xms.g.utils.XGettable) {
                    return ((com.huawei.hms.api.Api.ApiOptions.NotRequiredOptions) ((org.xms.g.utils.XGettable) this).getHInstance());
                }
                return new com.huawei.hms.api.Api.ApiOptions.NotRequiredOptions() {
                };
            }
            
            public static org.xms.g.common.api.Api.ApiOptions.NotRequiredOptions dynamicCast(java.lang.Object param0) {
                if (param0 instanceof org.xms.g.common.api.Api.ApiOptions.NotRequiredOptions) {
                    return ((org.xms.g.common.api.Api.ApiOptions.NotRequiredOptions) param0);
                }
                if (param0 instanceof org.xms.g.utils.XGettable) {
                    com.google.android.gms.common.api.Api.ApiOptions.NotRequiredOptions gReturn = ((com.google.android.gms.common.api.Api.ApiOptions.NotRequiredOptions) ((org.xms.g.utils.XGettable) param0).getGInstance());
                    com.huawei.hms.api.Api.ApiOptions.NotRequiredOptions hReturn = ((com.huawei.hms.api.Api.ApiOptions.NotRequiredOptions) ((org.xms.g.utils.XGettable) param0).getHInstance());
                    return new org.xms.g.common.api.Api.ApiOptions.NotRequiredOptions.XImpl(gReturn, hReturn);
                }
                return ((org.xms.g.common.api.Api.ApiOptions.NotRequiredOptions) param0);
            }
            
            public static boolean isInstance(java.lang.Object param0) {
                if (!(param0 instanceof org.xms.g.utils.XObject)) {
                    return false;
                }
                if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                    return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hms.api.Api.ApiOptions.NotRequiredOptions;
                } else {
                    return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.common.api.Api.ApiOptions.NotRequiredOptions;
                }
            }
            
            public static class XImpl extends org.xms.g.utils.XObject implements org.xms.g.common.api.Api.ApiOptions.NotRequiredOptions {
                
                public XImpl(com.google.android.gms.common.api.Api.ApiOptions.NotRequiredOptions param0, com.huawei.hms.api.Api.ApiOptions.NotRequiredOptions param1) {
                    super(param0, param1);
                }
                
                public static boolean isInstance(java.lang.Object param0) {
                    if (!(param0 instanceof org.xms.g.utils.XObject)) {
                        return false;
                    }
                    if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                        return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hms.api.Api.ApiOptions.NotRequiredOptions;
                    } else {
                        return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.common.api.Api.ApiOptions.NotRequiredOptions;
                    }
                }
            }
        }
        
        public static interface Optional extends org.xms.g.utils.XInterface, org.xms.g.common.api.Api.ApiOptions.HasOptions, org.xms.g.common.api.Api.ApiOptions.NotRequiredOptions {
            
            default com.google.android.gms.common.api.Api.ApiOptions.Optional getGInstanceOptional() {
                if (this instanceof org.xms.g.utils.XGettable) {
                    return ((com.google.android.gms.common.api.Api.ApiOptions.Optional) ((org.xms.g.utils.XGettable) this).getGInstance());
                }
                return new com.google.android.gms.common.api.Api.ApiOptions.Optional() {
                };
            }
            
            default com.huawei.hms.api.Api.ApiOptions.Optional getHInstanceOptional() {
                if (this instanceof org.xms.g.utils.XGettable) {
                    return ((com.huawei.hms.api.Api.ApiOptions.Optional) ((org.xms.g.utils.XGettable) this).getHInstance());
                }
                return new com.huawei.hms.api.Api.ApiOptions.Optional() {
                };
            }
            
            public static org.xms.g.common.api.Api.ApiOptions.Optional dynamicCast(java.lang.Object param0) {
                if (param0 instanceof org.xms.g.common.api.Api.ApiOptions.Optional) {
                    return ((org.xms.g.common.api.Api.ApiOptions.Optional) param0);
                }
                if (param0 instanceof org.xms.g.utils.XGettable) {
                    com.google.android.gms.common.api.Api.ApiOptions.Optional gReturn = ((com.google.android.gms.common.api.Api.ApiOptions.Optional) ((org.xms.g.utils.XGettable) param0).getGInstance());
                    com.huawei.hms.api.Api.ApiOptions.Optional hReturn = ((com.huawei.hms.api.Api.ApiOptions.Optional) ((org.xms.g.utils.XGettable) param0).getHInstance());
                    return new org.xms.g.common.api.Api.ApiOptions.Optional.XImpl(gReturn, hReturn);
                }
                return ((org.xms.g.common.api.Api.ApiOptions.Optional) param0);
            }
            
            public static boolean isInstance(java.lang.Object param0) {
                if (!(param0 instanceof org.xms.g.utils.XObject)) {
                    return false;
                }
                if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                    return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hms.api.Api.ApiOptions.Optional;
                } else {
                    return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.common.api.Api.ApiOptions.Optional;
                }
            }
            
            public static class XImpl extends org.xms.g.utils.XObject implements org.xms.g.common.api.Api.ApiOptions.Optional {
                
                public XImpl(com.google.android.gms.common.api.Api.ApiOptions.Optional param0, com.huawei.hms.api.Api.ApiOptions.Optional param1) {
                    super(param0, param1);
                }
                
                public static boolean isInstance(java.lang.Object param0) {
                    if (!(param0 instanceof org.xms.g.utils.XObject)) {
                        return false;
                    }
                    if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                        return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hms.api.Api.ApiOptions.Optional;
                    } else {
                        return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.common.api.Api.ApiOptions.Optional;
                    }
                }
            }
        }
    }
}
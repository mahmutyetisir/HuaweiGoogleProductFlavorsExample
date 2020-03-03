package org.xms.g.auth.api;

public final class Auth extends org.xms.g.utils.XObject {
    
    public Auth(com.google.android.gms.auth.api.Auth param0, com.huawei.hms.support.hwid.HuaweiIdAuthAPIManager param1) {
        super(param0, null);
        this.setHInstance(param1);
    }
    
    public static org.xms.g.common.api.Api getCREDENTIALS_API() {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static org.xms.g.auth.api.credentials.CredentialsApi getCredentialsApi() {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static org.xms.g.common.api.Api getGOOGLE_SIGN_IN_API() {
        com.google.android.gms.common.api.Api gReturn = null;
        com.huawei.hms.api.Api hReturn = null;
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.huawei.hms.support.hwid.HuaweiIdAuthAPIManager.HUAWEI_OAUTH_API", new Exception());
            hReturn = com.huawei.hms.support.hwid.HuaweiIdAuthAPIManager.HUAWEI_OAUTH_API;
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.google.android.gms.auth.api.Auth.GOOGLE_SIGN_IN_API", new Exception());
            gReturn = com.google.android.gms.auth.api.Auth.GOOGLE_SIGN_IN_API;
        }
        if (gReturn == null && hReturn == null) {
            return null;
        }
        return new org.xms.g.common.api.Api(gReturn, hReturn);
    }
    
    public static org.xms.g.auth.api.signin.ExtensionSignInApi getGoogleSignInApi() {
        com.google.android.gms.auth.api.signin.GoogleSignInApi gReturn = null;
        com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIService hReturn = null;
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.huawei.hms.support.hwid.HuaweiIdAuthAPIManager.HuaweiIdAuthAPIService", new Exception());
            hReturn = com.huawei.hms.support.hwid.HuaweiIdAuthAPIManager.HuaweiIdAuthAPIService;
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.google.android.gms.auth.api.Auth.GoogleSignInApi", new Exception());
            gReturn = com.google.android.gms.auth.api.Auth.GoogleSignInApi;
        }
        if (gReturn == null && hReturn == null) {
            return null;
        }
        return new org.xms.g.auth.api.signin.ExtensionSignInApi.XImpl(gReturn, hReturn);
    }
    
    public static org.xms.g.auth.api.Auth dynamicCast(java.lang.Object param0) {
        return ((org.xms.g.auth.api.Auth) param0);
    }
    
    public static boolean isInstance(java.lang.Object param0) {
        if (!(param0 instanceof org.xms.g.utils.XObject)) {
            return false;
        }
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hms.support.hwid.HuaweiIdAuthAPIManager;
        } else {
            return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.auth.api.Auth;
        }
    }
    
    public static class AuthCredentialsOptions extends org.xms.g.utils.XObject implements org.xms.g.common.api.Api.ApiOptions.Optional {
        
        
        
        
        public AuthCredentialsOptions(com.google.android.gms.auth.api.Auth.AuthCredentialsOptions param0, java.lang.Object param1) {
            super(param0, null);
            this.setHInstance(param1);
        }
        
        public static org.xms.g.auth.api.Auth.AuthCredentialsOptions dynamicCast(java.lang.Object param0) {
            if (param0 instanceof org.xms.g.auth.api.Auth.AuthCredentialsOptions) {
                return ((org.xms.g.auth.api.Auth.AuthCredentialsOptions) param0);
            }
            if (param0 instanceof org.xms.g.utils.XGettable) {
                com.google.android.gms.auth.api.Auth.AuthCredentialsOptions gReturn = ((com.google.android.gms.auth.api.Auth.AuthCredentialsOptions) ((org.xms.g.utils.XGettable) param0).getGInstance());
                
                throw new RuntimeException("TODO block must be filled");
                
            }
            return ((org.xms.g.auth.api.Auth.AuthCredentialsOptions) param0);
        }
        
        public static boolean isInstance(java.lang.Object param0) {
            if (!(param0 instanceof org.xms.g.utils.XObject)) {
                return false;
            }
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                
                throw new RuntimeException("TODO block must be filled");
                
            } else {
                return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.auth.api.Auth.AuthCredentialsOptions;
            }
        }
        
        public static class Builder extends org.xms.g.utils.XObject {
            
            public Builder(com.google.android.gms.auth.api.Auth.AuthCredentialsOptions.Builder param0, java.lang.Object param1) {
                super(param0, null);
            }
            
            public org.xms.g.auth.api.Auth.AuthCredentialsOptions.Builder forceEnableSaveDialog() {
                throw new java.lang.RuntimeException("Not Supported");
            }
            
            public static org.xms.g.auth.api.Auth.AuthCredentialsOptions.Builder dynamicCast(java.lang.Object param0) {
                throw new java.lang.RuntimeException("Not Supported");
            }
            
            public static boolean isInstance(java.lang.Object param0) {
                throw new java.lang.RuntimeException("Not Supported");
            }
        }
    }
}
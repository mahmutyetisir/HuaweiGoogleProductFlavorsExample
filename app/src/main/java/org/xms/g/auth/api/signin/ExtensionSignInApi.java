package org.xms.g.auth.api.signin;

public interface ExtensionSignInApi extends org.xms.g.utils.XInterface {
    
    public static String getEXTRA_SIGN_IN_ACCOUNT() {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIService.EXTRA_AUTH_HUAWEI_ID", new Exception());
            return com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIService.EXTRA_AUTH_HUAWEI_ID;
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.google.android.gms.auth.api.signin.GoogleSignInApi.EXTRA_SIGN_IN_ACCOUNT", new Exception());
            return com.google.android.gms.auth.api.signin.GoogleSignInApi.EXTRA_SIGN_IN_ACCOUNT;
        }
    }
    
    public android.content.Intent getSignInIntent(org.xms.g.common.api.ExtensionApiClient param0);
    
    public org.xms.g.auth.api.signin.ExtensionSignInResult getSignInResultFromIntent(android.content.Intent param0);
    
    public org.xms.g.common.api.PendingResult<org.xms.g.common.api.Status> revokeAccess(org.xms.g.common.api.ExtensionApiClient param0);
    
    public org.xms.g.common.api.PendingResult<org.xms.g.common.api.Status> signOut(org.xms.g.common.api.ExtensionApiClient param0);
    
    public org.xms.g.common.api.OptionalPendingResult<org.xms.g.auth.api.signin.ExtensionSignInResult> silentSignIn(org.xms.g.common.api.ExtensionApiClient param0);
    
    default com.google.android.gms.auth.api.signin.GoogleSignInApi getGInstanceExtensionSignInApi() {
        if (this instanceof org.xms.g.utils.XGettable) {
            return ((com.google.android.gms.auth.api.signin.GoogleSignInApi) ((org.xms.g.utils.XGettable) this).getGInstance());
        }
        return new com.google.android.gms.auth.api.signin.GoogleSignInApi() {
            
            public android.content.Intent getSignInIntent(com.google.android.gms.common.api.GoogleApiClient param0) {
                return org.xms.g.auth.api.signin.ExtensionSignInApi.this.getSignInIntent(new org.xms.g.common.api.ExtensionApiClient.XImpl(param0, null));
            }
            
            public com.google.android.gms.auth.api.signin.GoogleSignInResult getSignInResultFromIntent(android.content.Intent param0) {
                java.lang.Object xResult = org.xms.g.auth.api.signin.ExtensionSignInApi.this.getSignInResultFromIntent(param0);
                return ((com.google.android.gms.auth.api.signin.GoogleSignInResult) ((xResult) == null ? null : (((org.xms.g.utils.XObject) xResult).getGInstance())));
            }
            
            public com.google.android.gms.common.api.PendingResult<com.google.android.gms.common.api.Status> revokeAccess(com.google.android.gms.common.api.GoogleApiClient param0) {
                java.lang.Object xResult = org.xms.g.auth.api.signin.ExtensionSignInApi.this.revokeAccess(new org.xms.g.common.api.ExtensionApiClient.XImpl(param0, null));
                return ((com.google.android.gms.common.api.PendingResult<com.google.android.gms.common.api.Status>) ((xResult) == null ? null : (((org.xms.g.utils.XObject) xResult).getGInstance())));
            }
            
            public com.google.android.gms.common.api.PendingResult<com.google.android.gms.common.api.Status> signOut(com.google.android.gms.common.api.GoogleApiClient param0) {
                java.lang.Object xResult = org.xms.g.auth.api.signin.ExtensionSignInApi.this.signOut(new org.xms.g.common.api.ExtensionApiClient.XImpl(param0, null));
                return ((com.google.android.gms.common.api.PendingResult<com.google.android.gms.common.api.Status>) ((xResult) == null ? null : (((org.xms.g.utils.XObject) xResult).getGInstance())));
            }
            
            public com.google.android.gms.common.api.OptionalPendingResult<com.google.android.gms.auth.api.signin.GoogleSignInResult> silentSignIn(com.google.android.gms.common.api.GoogleApiClient param0) {
                java.lang.Object xResult = org.xms.g.auth.api.signin.ExtensionSignInApi.this.silentSignIn(new org.xms.g.common.api.ExtensionApiClient.XImpl(param0, null));
                return ((com.google.android.gms.common.api.OptionalPendingResult<com.google.android.gms.auth.api.signin.GoogleSignInResult>) ((xResult) == null ? null : (((org.xms.g.utils.XObject) xResult).getGInstance())));
            }
        };
    }
    
    default com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIService getHInstanceExtensionSignInApi() {
        if (this instanceof org.xms.g.utils.XGettable) {
            return ((com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIService) ((org.xms.g.utils.XGettable) this).getHInstance());
        }
        return new com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIService() {
            
            public android.content.Intent getSignInIntent(com.huawei.hms.api.HuaweiApiClient param0) {
                return org.xms.g.auth.api.signin.ExtensionSignInApi.this.getSignInIntent(new org.xms.g.common.api.ExtensionApiClient.XImpl(null, param0));
            }
            
            public com.huawei.hms.support.hwid.result.HuaweiIdAuthResult parseHuaweiIdFromIntent(android.content.Intent param0) {
                java.lang.Object xResult = org.xms.g.auth.api.signin.ExtensionSignInApi.this.getSignInResultFromIntent(param0);
                return ((com.huawei.hms.support.hwid.result.HuaweiIdAuthResult) ((xResult) == null ? null : (((org.xms.g.utils.XObject) xResult).getHInstance())));
            }
            
            public com.huawei.hms.support.api.client.PendingResult<com.huawei.hms.support.api.client.Status> cancelAuthorization(com.huawei.hms.api.HuaweiApiClient param0) {
                java.lang.Object xResult = org.xms.g.auth.api.signin.ExtensionSignInApi.this.revokeAccess(new org.xms.g.common.api.ExtensionApiClient.XImpl(null, param0));
                return ((com.huawei.hms.support.api.client.PendingResult<com.huawei.hms.support.api.client.Status>) ((xResult) == null ? null : (((org.xms.g.utils.XObject) xResult).getHInstance())));
            }
            
            public com.huawei.hms.support.api.client.PendingResult<com.huawei.hms.support.api.client.Status> signOut(com.huawei.hms.api.HuaweiApiClient param0) {
                java.lang.Object xResult = org.xms.g.auth.api.signin.ExtensionSignInApi.this.signOut(new org.xms.g.common.api.ExtensionApiClient.XImpl(null, param0));
                return ((com.huawei.hms.support.api.client.PendingResult<com.huawei.hms.support.api.client.Status>) ((xResult) == null ? null : (((org.xms.g.utils.XObject) xResult).getHInstance())));
            }
            
            public com.huawei.hms.common.api.OptionalPendingResult<com.huawei.hms.support.hwid.result.HuaweiIdAuthResult> silentSignIn(com.huawei.hms.api.HuaweiApiClient param0) {
                java.lang.Object xResult = org.xms.g.auth.api.signin.ExtensionSignInApi.this.silentSignIn(new org.xms.g.common.api.ExtensionApiClient.XImpl(null, param0));
                return ((com.huawei.hms.common.api.OptionalPendingResult<com.huawei.hms.support.hwid.result.HuaweiIdAuthResult>) ((xResult) == null ? null : (((org.xms.g.utils.XObject) xResult).getHInstance())));
            }
            
            public com.huawei.hms.support.api.client.PendingResult<com.huawei.hms.support.api.hwid.SignInResult> signIn(android.app.Activity param0, com.huawei.hms.api.HuaweiApiClient param1) {
                throw new RuntimeException("Stub");
            }
            
            public com.huawei.hms.support.api.client.PendingResult<com.huawei.hms.support.api.hwid.SignInResult> signInBackend(com.huawei.hms.api.HuaweiApiClient param0) {
                throw new RuntimeException("Stub");
            }
            
            public com.huawei.hms.support.api.hwid.SignInResult getHwIdSignInResultFromIntent(android.content.Intent param0) {
                throw new RuntimeException("Stub");
            }
            
            public com.huawei.hms.support.api.client.PendingResult<com.huawei.hms.support.api.hwid.AddressResult> queryShippingAddress(com.huawei.hms.api.HuaweiApiClient param0, com.huawei.hms.support.hwid.result.AuthHuaweiId param1) {
                throw new RuntimeException("Stub");
            }
        };
    }
    
    public static org.xms.g.auth.api.signin.ExtensionSignInApi dynamicCast(java.lang.Object param0) {
        if (param0 instanceof org.xms.g.auth.api.signin.ExtensionSignInApi) {
            return ((org.xms.g.auth.api.signin.ExtensionSignInApi) param0);
        }
        if (param0 instanceof org.xms.g.utils.XGettable) {
            com.google.android.gms.auth.api.signin.GoogleSignInApi gReturn = ((com.google.android.gms.auth.api.signin.GoogleSignInApi) ((org.xms.g.utils.XGettable) param0).getGInstance());
            com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIService hReturn = ((com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIService) ((org.xms.g.utils.XGettable) param0).getHInstance());
            return new org.xms.g.auth.api.signin.ExtensionSignInApi.XImpl(gReturn, hReturn);
        }
        return ((org.xms.g.auth.api.signin.ExtensionSignInApi) param0);
    }
    
    public static boolean isInstance(java.lang.Object param0) {
        if (!(param0 instanceof org.xms.g.utils.XObject)) {
            return false;
        }
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIService;
        } else {
            return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.auth.api.signin.GoogleSignInApi;
        }
    }
    
    public static class XImpl extends org.xms.g.utils.XObject implements org.xms.g.auth.api.signin.ExtensionSignInApi {
        
        public XImpl(com.google.android.gms.auth.api.signin.GoogleSignInApi param0, com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIService param1) {
            super(param0, param1);
        }
        
        public static boolean isInstance(java.lang.Object param0) {
            if (!(param0 instanceof org.xms.g.utils.XObject)) {
                return false;
            }
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIService;
            } else {
                return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.auth.api.signin.GoogleSignInApi;
            }
        }
        
        public android.content.Intent getSignInIntent(org.xms.g.common.api.ExtensionApiClient param0) {
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIService) this.getHInstance()).getSignInIntent(((com.huawei.hms.api.HuaweiApiClient) ((param0) == null ? null : (param0.getHInstance()))))", new Exception());
                return ((com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIService) this.getHInstance()).getSignInIntent(((com.huawei.hms.api.HuaweiApiClient) ((param0) == null ? null : (param0.getHInstance()))));
            } else {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.auth.api.signin.GoogleSignInApi) this.getGInstance()).getSignInIntent(((com.google.android.gms.common.api.GoogleApiClient) ((param0) == null ? null : (param0.getGInstance()))))", new Exception());
                return ((com.google.android.gms.auth.api.signin.GoogleSignInApi) this.getGInstance()).getSignInIntent(((com.google.android.gms.common.api.GoogleApiClient) ((param0) == null ? null : (param0.getGInstance()))));
            }
        }
        
        public org.xms.g.auth.api.signin.ExtensionSignInResult getSignInResultFromIntent(android.content.Intent param0) {
            com.google.android.gms.auth.api.signin.GoogleSignInResult gReturn = null;
            com.huawei.hms.support.hwid.result.HuaweiIdAuthResult hReturn = null;
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIService) this.getHInstance()).parseHuaweiIdFromIntent(param0)", new Exception());
                hReturn = ((com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIService) this.getHInstance()).parseHuaweiIdFromIntent(param0);
            } else {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.auth.api.signin.GoogleSignInApi) this.getGInstance()).getSignInResultFromIntent(param0)", new Exception());
                gReturn = ((com.google.android.gms.auth.api.signin.GoogleSignInApi) this.getGInstance()).getSignInResultFromIntent(param0);
            }
            if (gReturn == null && hReturn == null) {
                return null;
            }
            return new org.xms.g.auth.api.signin.ExtensionSignInResult(gReturn, hReturn);
        }
        
        public org.xms.g.common.api.PendingResult<org.xms.g.common.api.Status> revokeAccess(org.xms.g.common.api.ExtensionApiClient param0) {
            com.google.android.gms.common.api.PendingResult gReturn = null;
            com.huawei.hms.support.api.client.PendingResult hReturn = null;
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIService) this.getHInstance()).cancelAuthorization(((com.huawei.hms.api.HuaweiApiClient) ((param0) == null ? null : (param0.getHInstance()))))", new Exception());
                hReturn = ((com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIService) this.getHInstance()).cancelAuthorization(((com.huawei.hms.api.HuaweiApiClient) ((param0) == null ? null : (param0.getHInstance()))));
            } else {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.auth.api.signin.GoogleSignInApi) this.getGInstance()).revokeAccess(((com.google.android.gms.common.api.GoogleApiClient) ((param0) == null ? null : (param0.getGInstance()))))", new Exception());
                gReturn = ((com.google.android.gms.auth.api.signin.GoogleSignInApi) this.getGInstance()).revokeAccess(((com.google.android.gms.common.api.GoogleApiClient) ((param0) == null ? null : (param0.getGInstance()))));
            }
            if (gReturn == null && hReturn == null) {
                return null;
            }
            return new org.xms.g.common.api.PendingResult.XImpl(gReturn, hReturn);
        }
        
        public org.xms.g.common.api.PendingResult<org.xms.g.common.api.Status> signOut(org.xms.g.common.api.ExtensionApiClient param0) {
            com.google.android.gms.common.api.PendingResult gReturn = null;
            com.huawei.hms.support.api.client.PendingResult hReturn = null;
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIService) this.getHInstance()).signOut(((com.huawei.hms.api.HuaweiApiClient) ((param0) == null ? null : (param0.getHInstance()))))", new Exception());
                hReturn = ((com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIService) this.getHInstance()).signOut(((com.huawei.hms.api.HuaweiApiClient) ((param0) == null ? null : (param0.getHInstance()))));
            } else {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.auth.api.signin.GoogleSignInApi) this.getGInstance()).signOut(((com.google.android.gms.common.api.GoogleApiClient) ((param0) == null ? null : (param0.getGInstance()))))", new Exception());
                gReturn = ((com.google.android.gms.auth.api.signin.GoogleSignInApi) this.getGInstance()).signOut(((com.google.android.gms.common.api.GoogleApiClient) ((param0) == null ? null : (param0.getGInstance()))));
            }
            if (gReturn == null && hReturn == null) {
                return null;
            }
            return new org.xms.g.common.api.PendingResult.XImpl(gReturn, hReturn);
        }
        
        public org.xms.g.common.api.OptionalPendingResult<org.xms.g.auth.api.signin.ExtensionSignInResult> silentSignIn(org.xms.g.common.api.ExtensionApiClient param0) {
            com.google.android.gms.common.api.OptionalPendingResult gReturn = null;
            com.huawei.hms.common.api.OptionalPendingResult hReturn = null;
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIService) this.getHInstance()).silentSignIn(((com.huawei.hms.api.HuaweiApiClient) ((param0) == null ? null : (param0.getHInstance()))))", new Exception());
                hReturn = ((com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIService) this.getHInstance()).silentSignIn(((com.huawei.hms.api.HuaweiApiClient) ((param0) == null ? null : (param0.getHInstance()))));
            } else {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.auth.api.signin.GoogleSignInApi) this.getGInstance()).silentSignIn(((com.google.android.gms.common.api.GoogleApiClient) ((param0) == null ? null : (param0.getGInstance()))))", new Exception());
                gReturn = ((com.google.android.gms.auth.api.signin.GoogleSignInApi) this.getGInstance()).silentSignIn(((com.google.android.gms.common.api.GoogleApiClient) ((param0) == null ? null : (param0.getGInstance()))));
            }
            if (gReturn == null && hReturn == null) {
                return null;
            }
            return new org.xms.g.common.api.OptionalPendingResult.XImpl(gReturn, hReturn);
        }
    }
}
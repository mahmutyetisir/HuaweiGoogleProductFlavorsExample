package org.xms.g.auth.api.signin;





public final class ExtensionSignIn extends org.xms.g.utils.XObject {
    
    
    
    
    public ExtensionSignIn(com.google.android.gms.auth.api.signin.GoogleSignIn param0, com.huawei.hms.support.hwid.HuaweiIdAuthManager param1) {
        super(param0, null);
        this.setHInstance(param1);
    }
    
    public static org.xms.g.auth.api.signin.ExtensionSignInAccount getAccountForExtension(android.content.Context param0, org.xms.g.auth.api.signin.ExtensionSignInOptionsExtension param1) {
        com.google.android.gms.auth.api.signin.GoogleSignInAccount gReturn = null;
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            
            org.xms.g.utils.XmsLog.d("XMSRouter",
                "com.huawei.hms.support.hwid.HuaweiIdAuthManager.getExtendedAuthResult(param1 == null ? null : param1.getHInstanceExtensionSignInOptionsExtension())",
                new Exception());
            com.huawei.hms.support.hwid.result.AuthHuaweiId hReturn = com.huawei.hms.support.hwid.HuaweiIdAuthManager
                .getExtendedAuthResult(param1 == null ? null : param1.getHInstanceExtensionSignInOptionsExtension());
            if (hReturn == null) {
                return null;
            }
            return new org.xms.g.auth.api.signin.ExtensionSignInAccount(null, hReturn);
            
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.google.android.gms.auth.api.signin.GoogleSignIn.getAccountForExtension(param0, ((param1) == null ? null : (param1.getGInstanceExtensionSignInOptionsExtension())))", new Exception());
            gReturn = com.google.android.gms.auth.api.signin.GoogleSignIn.getAccountForExtension(param0, ((param1) == null ? null : (param1.getGInstanceExtensionSignInOptionsExtension())));
        }
        if (gReturn == null) {
            return null;
        }
        return new org.xms.g.auth.api.signin.ExtensionSignInAccount(gReturn, null);
    }
    
    public static org.xms.g.auth.api.signin.ExtensionSignInAccount getAccountForScopes(android.content.Context param0, org.xms.g.common.api.Scope param1, org.xms.g.common.api.Scope... param2) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static org.xms.g.auth.api.signin.ExtensionSignInClient getClient(android.content.Context param0, org.xms.g.auth.api.signin.ExtensionSignInOptions param1) {
        com.google.android.gms.auth.api.signin.GoogleSignInClient gReturn = null;
        com.huawei.hms.support.hwid.service.HuaweiIdAuthService hReturn = null;
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.huawei.hms.support.hwid.HuaweiIdAuthManager.getService(param0, ((com.huawei.hms.support.hwid.request.HuaweiIdAuthParams) ((param1) == null ? null : (param1.getHInstance()))))", new Exception());
            hReturn = com.huawei.hms.support.hwid.HuaweiIdAuthManager.getService(param0, ((com.huawei.hms.support.hwid.request.HuaweiIdAuthParams) ((param1) == null ? null : (param1.getHInstance()))));
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.google.android.gms.auth.api.signin.GoogleSignIn.getClient(param0, ((com.google.android.gms.auth.api.signin.GoogleSignInOptions) ((param1) == null ? null : (param1.getGInstance()))))", new Exception());
            gReturn = com.google.android.gms.auth.api.signin.GoogleSignIn.getClient(param0, ((com.google.android.gms.auth.api.signin.GoogleSignInOptions) ((param1) == null ? null : (param1.getGInstance()))));
        }
        if (gReturn == null && hReturn == null) {
            return null;
        }
        return new org.xms.g.auth.api.signin.ExtensionSignInClient(gReturn, hReturn);
    }
    
    public static org.xms.g.auth.api.signin.ExtensionSignInClient getClient(android.app.Activity param0, org.xms.g.auth.api.signin.ExtensionSignInOptions param1) {
        com.google.android.gms.auth.api.signin.GoogleSignInClient gReturn = null;
        com.huawei.hms.support.hwid.service.HuaweiIdAuthService hReturn = null;
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.huawei.hms.support.hwid.HuaweiIdAuthManager.getService(param0, ((com.huawei.hms.support.hwid.request.HuaweiIdAuthParams) ((param1) == null ? null : (param1.getHInstance()))))", new Exception());
            hReturn = com.huawei.hms.support.hwid.HuaweiIdAuthManager.getService(param0, ((com.huawei.hms.support.hwid.request.HuaweiIdAuthParams) ((param1) == null ? null : (param1.getHInstance()))));
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.google.android.gms.auth.api.signin.GoogleSignIn.getClient(param0, ((com.google.android.gms.auth.api.signin.GoogleSignInOptions) ((param1) == null ? null : (param1.getGInstance()))))", new Exception());
            gReturn = com.google.android.gms.auth.api.signin.GoogleSignIn.getClient(param0, ((com.google.android.gms.auth.api.signin.GoogleSignInOptions) ((param1) == null ? null : (param1.getGInstance()))));
        }
        if (gReturn == null && hReturn == null) {
            return null;
        }
        return new org.xms.g.auth.api.signin.ExtensionSignInClient(gReturn, hReturn);
    }
    
    public static org.xms.g.auth.api.signin.ExtensionSignInAccount getLastSignedInAccount(android.content.Context param0) {
        com.google.android.gms.auth.api.signin.GoogleSignInAccount gReturn = null;
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.huawei.hms.support.hwid.HuaweiIdAuthManager.getAuthResult()",
                new Exception());
            com.huawei.hms.support.hwid.result.AuthHuaweiId hReturn =
                com.huawei.hms.support.hwid.HuaweiIdAuthManager.getAuthResult();
            if (hReturn == null) {
                return null;
            }
            return new org.xms.g.auth.api.signin.ExtensionSignInAccount(null, hReturn);
            
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.google.android.gms.auth.api.signin.GoogleSignIn.getLastSignedInAccount(param0)", new Exception());
            gReturn = com.google.android.gms.auth.api.signin.GoogleSignIn.getLastSignedInAccount(param0);
        }
        if (gReturn == null) {
            return null;
        }
        return new org.xms.g.auth.api.signin.ExtensionSignInAccount(gReturn, null);
    }
    
    public static org.xms.g.tasks.Task<org.xms.g.auth.api.signin.ExtensionSignInAccount> getSignedInAccountFromIntent(android.content.Intent param0) {
        com.google.android.gms.tasks.Task gReturn = null;
        com.huawei.hmf.tasks.Task hReturn = null;
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.huawei.hms.support.hwid.HuaweiIdAuthManager.parseAuthResultFromIntent(param0)", new Exception());
            hReturn = com.huawei.hms.support.hwid.HuaweiIdAuthManager.parseAuthResultFromIntent(param0);
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.google.android.gms.auth.api.signin.GoogleSignIn.getSignedInAccountFromIntent(param0)", new Exception());
            gReturn = com.google.android.gms.auth.api.signin.GoogleSignIn.getSignedInAccountFromIntent(param0);
        }
        if (gReturn == null && hReturn == null) {
            return null;
        }
        return new org.xms.g.tasks.Task.XImpl(gReturn, hReturn);
    }
    
    public static boolean hasPermissions(org.xms.g.auth.api.signin.ExtensionSignInAccount param0, org.xms.g.auth.api.signin.ExtensionSignInOptionsExtension param1) {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.huawei.hms.support.hwid.HuaweiIdAuthManager.containScopes(((com.huawei.hms.support.hwid.result.AuthHuaweiId) ((param0) == null ? null : (param0.getHInstance()))), ((param1) == null ? null : (param1.getHInstanceExtensionSignInOptionsExtension())))", new Exception());
            return com.huawei.hms.support.hwid.HuaweiIdAuthManager.containScopes(((com.huawei.hms.support.hwid.result.AuthHuaweiId) ((param0) == null ? null : (param0.getHInstance()))), ((param1) == null ? null : (param1.getHInstanceExtensionSignInOptionsExtension())));
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.google.android.gms.auth.api.signin.GoogleSignIn.hasPermissions(((com.google.android.gms.auth.api.signin.GoogleSignInAccount) ((param0) == null ? null : (param0.getGInstance()))), ((param1) == null ? null : (param1.getGInstanceExtensionSignInOptionsExtension())))", new Exception());
            return com.google.android.gms.auth.api.signin.GoogleSignIn.hasPermissions(((com.google.android.gms.auth.api.signin.GoogleSignInAccount) ((param0) == null ? null : (param0.getGInstance()))), ((param1) == null ? null : (param1.getGInstanceExtensionSignInOptionsExtension())));
        }
    }
    
    public static boolean hasPermissions(org.xms.g.auth.api.signin.ExtensionSignInAccount param0, org.xms.g.common.api.Scope... param1) {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            
            org.xms.g.utils.XmsLog.d("XMSRouter",
                "com.huawei.hms.support.hwid.HuaweiIdAuthManager.containScopes(((com.huawei.hms.support.hwid.result.AuthHuaweiId) (param0 == null ? null : param0.getHInstance())),scopeList)",
                new Exception());
            java.util.List<com.huawei.hms.support.api.entity.auth.Scope> scopeList = null;
            if (param1 != null) {
                scopeList = new java.util.ArrayList<>();
                for (org.xms.g.common.api.Scope scope : param1) {
                    scopeList.add((com.huawei.hms.support.api.entity.auth.Scope) scope.getHInstance());
                }
            }
            return com.huawei.hms.support.hwid.HuaweiIdAuthManager.containScopes(
                ((com.huawei.hms.support.hwid.result.AuthHuaweiId) (param0 == null ? null : param0.getHInstance())),
                scopeList);
            
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.google.android.gms.auth.api.signin.GoogleSignIn.hasPermissions(((com.google.android.gms.auth.api.signin.GoogleSignInAccount) ((param0) == null ? null : (param0.getGInstance()))), ((com.google.android.gms.common.api.Scope[]) org.xms.g.utils.Utils.genericArrayCopy(param1, com.google.android.gms.common.api.Scope.class, x -> (com.google.android.gms.common.api.Scope)x.getGInstance())))", new Exception());
            return com.google.android.gms.auth.api.signin.GoogleSignIn.hasPermissions(((com.google.android.gms.auth.api.signin.GoogleSignInAccount) ((param0) == null ? null : (param0.getGInstance()))), ((com.google.android.gms.common.api.Scope[]) org.xms.g.utils.Utils.genericArrayCopy(param1, com.google.android.gms.common.api.Scope.class, x -> (com.google.android.gms.common.api.Scope)x.getGInstance())));
        }
    }
    
    public static void requestPermissions(android.app.Activity param0, int param1, org.xms.g.auth.api.signin.ExtensionSignInAccount param2, org.xms.g.common.api.Scope... param3) {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            
            org.xms.g.utils.XmsLog.d("XMSRouter",
                "com.huawei.hms.support.hwid.HuaweiIdAuthManager.addAuthScopes(param0, param1, scopeList)",
                new Exception());
            java.util.List<com.huawei.hms.support.api.entity.auth.Scope> scopeList = null;
            if (param3 != null) {
                scopeList = new java.util.ArrayList<>();
                for (org.xms.g.common.api.Scope scope : param3) {
                    scopeList.add((com.huawei.hms.support.api.entity.auth.Scope) scope.getHInstance());
                }
            }
            com.huawei.hms.support.hwid.HuaweiIdAuthManager.addAuthScopes(param0, param1, scopeList);
            
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.google.android.gms.auth.api.signin.GoogleSignIn.requestPermissions(param0, param1, ((com.google.android.gms.auth.api.signin.GoogleSignInAccount) ((param2) == null ? null : (param2.getGInstance()))), ((com.google.android.gms.common.api.Scope[]) org.xms.g.utils.Utils.genericArrayCopy(param3, com.google.android.gms.common.api.Scope.class, x -> (com.google.android.gms.common.api.Scope)x.getGInstance())))", new Exception());
            com.google.android.gms.auth.api.signin.GoogleSignIn.requestPermissions(param0, param1, ((com.google.android.gms.auth.api.signin.GoogleSignInAccount) ((param2) == null ? null : (param2.getGInstance()))), ((com.google.android.gms.common.api.Scope[]) org.xms.g.utils.Utils.genericArrayCopy(param3, com.google.android.gms.common.api.Scope.class, x -> (com.google.android.gms.common.api.Scope)x.getGInstance())));
        }
    }
    
    public static void requestPermissions(android.app.Activity param0, int param1, org.xms.g.auth.api.signin.ExtensionSignInAccount param2, org.xms.g.auth.api.signin.ExtensionSignInOptionsExtension param3) {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            
            org.xms.g.utils.XmsLog.d("XMSRouter",
                "com.huawei.hms.support.hwid.HuaweiIdAuthManager.addAuthScopes(param0, param1, param3 == null ? null : param3.getHInstanceExtensionSignInOptionsExtension())",
                new Exception());
            com.huawei.hms.support.hwid.HuaweiIdAuthManager.addAuthScopes(param0, param1,
                param3 == null ? null : param3.getHInstanceExtensionSignInOptionsExtension());
            
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.google.android.gms.auth.api.signin.GoogleSignIn.requestPermissions(param0, param1, ((com.google.android.gms.auth.api.signin.GoogleSignInAccount) ((param2) == null ? null : (param2.getGInstance()))), ((param3) == null ? null : (param3.getGInstanceExtensionSignInOptionsExtension())))", new Exception());
            com.google.android.gms.auth.api.signin.GoogleSignIn.requestPermissions(param0, param1, ((com.google.android.gms.auth.api.signin.GoogleSignInAccount) ((param2) == null ? null : (param2.getGInstance()))), ((param3) == null ? null : (param3.getGInstanceExtensionSignInOptionsExtension())));
        }
    }
    
    public static void requestPermissions(androidx.fragment.app.Fragment param0, int param1, org.xms.g.auth.api.signin.ExtensionSignInAccount param2, org.xms.g.auth.api.signin.ExtensionSignInOptionsExtension param3) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static void requestPermissions(androidx.fragment.app.Fragment param0, int param1, org.xms.g.auth.api.signin.ExtensionSignInAccount param2, org.xms.g.common.api.Scope... param3) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static org.xms.g.auth.api.signin.ExtensionSignIn dynamicCast(java.lang.Object param0) {
        return ((org.xms.g.auth.api.signin.ExtensionSignIn) param0);
    }
    
    public static boolean isInstance(java.lang.Object param0) {
        if (!(param0 instanceof org.xms.g.utils.XObject)) {
            return false;
        }
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hms.support.hwid.HuaweiIdAuthManager;
        } else {
            return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.auth.api.signin.GoogleSignIn;
        }
    }
}
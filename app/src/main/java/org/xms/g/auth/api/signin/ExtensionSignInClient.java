package org.xms.g.auth.api.signin;

public class ExtensionSignInClient extends org.xms.g.common.api.ExtensionApi<org.xms.g.auth.api.signin.ExtensionSignInOptions> {
    private boolean wrapper = true;
    
    public ExtensionSignInClient(com.google.android.gms.auth.api.signin.GoogleSignInClient param0, com.huawei.hms.support.hwid.service.HuaweiIdAuthService param1) {
        super(param0, null);
        this.setHInstance(param1);
        wrapper = true;
    }
    
    public android.content.Intent getSignInIntent() {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.support.hwid.service.HuaweiIdAuthService) this.getHInstance()).getSignInIntent()", new Exception());
            return ((com.huawei.hms.support.hwid.service.HuaweiIdAuthService) this.getHInstance()).getSignInIntent();
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.auth.api.signin.GoogleSignInClient) this.getGInstance()).getSignInIntent()", new Exception());
            return ((com.google.android.gms.auth.api.signin.GoogleSignInClient) this.getGInstance()).getSignInIntent();
        }
    }
    
    public org.xms.g.tasks.Task<java.lang.Void> revokeAccess() {
        com.google.android.gms.tasks.Task gReturn = null;
        com.huawei.hmf.tasks.Task hReturn = null;
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.support.hwid.service.HuaweiIdAuthService) this.getHInstance()).cancelAuthorization()", new Exception());
            hReturn = ((com.huawei.hms.support.hwid.service.HuaweiIdAuthService) this.getHInstance()).cancelAuthorization();
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.auth.api.signin.GoogleSignInClient) this.getGInstance()).revokeAccess()", new Exception());
            gReturn = ((com.google.android.gms.auth.api.signin.GoogleSignInClient) this.getGInstance()).revokeAccess();
        }
        if (gReturn == null && hReturn == null) {
            return null;
        }
        return new org.xms.g.tasks.Task.XImpl(gReturn, hReturn);
    }
    
    public org.xms.g.tasks.Task<java.lang.Void> signOut() {
        com.google.android.gms.tasks.Task gReturn = null;
        com.huawei.hmf.tasks.Task hReturn = null;
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.support.hwid.service.HuaweiIdAuthService) this.getHInstance()).signOut()", new Exception());
            hReturn = ((com.huawei.hms.support.hwid.service.HuaweiIdAuthService) this.getHInstance()).signOut();
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.auth.api.signin.GoogleSignInClient) this.getGInstance()).signOut()", new Exception());
            gReturn = ((com.google.android.gms.auth.api.signin.GoogleSignInClient) this.getGInstance()).signOut();
        }
        if (gReturn == null && hReturn == null) {
            return null;
        }
        return new org.xms.g.tasks.Task.XImpl(gReturn, hReturn);
    }
    
    public org.xms.g.tasks.Task<org.xms.g.auth.api.signin.ExtensionSignInAccount> silentSignIn() {
        com.google.android.gms.tasks.Task gReturn = null;
        com.huawei.hmf.tasks.Task hReturn = null;
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.support.hwid.service.HuaweiIdAuthService) this.getHInstance()).silentSignIn()", new Exception());
            hReturn = ((com.huawei.hms.support.hwid.service.HuaweiIdAuthService) this.getHInstance()).silentSignIn();
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.auth.api.signin.GoogleSignInClient) this.getGInstance()).silentSignIn()", new Exception());
            gReturn = ((com.google.android.gms.auth.api.signin.GoogleSignInClient) this.getGInstance()).silentSignIn();
        }
        if (gReturn == null && hReturn == null) {
            return null;
        }
        return new org.xms.g.tasks.Task.XImpl(gReturn, hReturn);
    }
    
    public java.lang.Object getApiKey() {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static org.xms.g.auth.api.signin.ExtensionSignInClient dynamicCast(java.lang.Object param0) {
        if (param0 instanceof org.xms.g.auth.api.signin.ExtensionSignInClient) {
            return ((org.xms.g.auth.api.signin.ExtensionSignInClient) param0);
        }
        if (param0 instanceof org.xms.g.utils.XGettable) {
            com.google.android.gms.auth.api.signin.GoogleSignInClient gReturn = ((com.google.android.gms.auth.api.signin.GoogleSignInClient) ((org.xms.g.utils.XGettable) param0).getGInstance());
            com.huawei.hms.support.hwid.service.HuaweiIdAuthService hReturn = ((com.huawei.hms.support.hwid.service.HuaweiIdAuthService) ((org.xms.g.utils.XGettable) param0).getHInstance());
            return new org.xms.g.auth.api.signin.ExtensionSignInClient(gReturn, hReturn);
        }
        return ((org.xms.g.auth.api.signin.ExtensionSignInClient) param0);
    }
    
    public static boolean isInstance(java.lang.Object param0) {
        if (!(param0 instanceof org.xms.g.utils.XObject)) {
            return false;
        }
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hms.support.hwid.service.HuaweiIdAuthService;
        } else {
            return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.auth.api.signin.GoogleSignInClient;
        }
    }
}
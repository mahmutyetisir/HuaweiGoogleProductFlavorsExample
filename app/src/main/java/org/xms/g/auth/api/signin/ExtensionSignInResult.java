package org.xms.g.auth.api.signin;

public class ExtensionSignInResult extends org.xms.g.utils.XObject implements org.xms.g.common.api.Result {
    private boolean wrapper = true;
    
    public ExtensionSignInResult(com.google.android.gms.auth.api.signin.GoogleSignInResult param0, com.huawei.hms.support.hwid.result.HuaweiIdAuthResult param1) {
        super(param0, null);
        this.setHInstance(param1);
        wrapper = true;
    }
    
    public org.xms.g.auth.api.signin.ExtensionSignInAccount getSignInAccount() {
        com.google.android.gms.auth.api.signin.GoogleSignInAccount gReturn = null;
        com.huawei.hms.support.hwid.result.AuthHuaweiId hReturn = null;
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.support.hwid.result.HuaweiIdAuthResult) this.getHInstance()).getHuaweiId()", new Exception());
            hReturn = ((com.huawei.hms.support.hwid.result.HuaweiIdAuthResult) this.getHInstance()).getHuaweiId();
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.auth.api.signin.GoogleSignInResult) this.getGInstance()).getSignInAccount()", new Exception());
            gReturn = ((com.google.android.gms.auth.api.signin.GoogleSignInResult) this.getGInstance()).getSignInAccount();
        }
        if (gReturn == null && hReturn == null) {
            return null;
        }
        return new org.xms.g.auth.api.signin.ExtensionSignInAccount(gReturn, hReturn);
    }
    
    public org.xms.g.common.api.Status getStatus() {
        com.google.android.gms.common.api.Status gReturn = null;
        com.huawei.hms.support.api.client.Status hReturn = null;
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.support.hwid.result.HuaweiIdAuthResult) this.getHInstance()).getStatus()", new Exception());
            hReturn = ((com.huawei.hms.support.hwid.result.HuaweiIdAuthResult) this.getHInstance()).getStatus();
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.auth.api.signin.GoogleSignInResult) this.getGInstance()).getStatus()", new Exception());
            gReturn = ((com.google.android.gms.auth.api.signin.GoogleSignInResult) this.getGInstance()).getStatus();
        }
        if (gReturn == null && hReturn == null) {
            return null;
        }
        return new org.xms.g.common.api.Status(gReturn, hReturn);
    }
    
    public boolean isSuccess() {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.support.hwid.result.HuaweiIdAuthResult) this.getHInstance()).isSuccess()", new Exception());
            return ((com.huawei.hms.support.hwid.result.HuaweiIdAuthResult) this.getHInstance()).isSuccess();
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.auth.api.signin.GoogleSignInResult) this.getGInstance()).isSuccess()", new Exception());
            return ((com.google.android.gms.auth.api.signin.GoogleSignInResult) this.getGInstance()).isSuccess();
        }
    }
    
    public static org.xms.g.auth.api.signin.ExtensionSignInResult dynamicCast(java.lang.Object param0) {
        if (param0 instanceof org.xms.g.auth.api.signin.ExtensionSignInResult) {
            return ((org.xms.g.auth.api.signin.ExtensionSignInResult) param0);
        }
        if (param0 instanceof org.xms.g.utils.XGettable) {
            com.google.android.gms.auth.api.signin.GoogleSignInResult gReturn = ((com.google.android.gms.auth.api.signin.GoogleSignInResult) ((org.xms.g.utils.XGettable) param0).getGInstance());
            com.huawei.hms.support.hwid.result.HuaweiIdAuthResult hReturn = ((com.huawei.hms.support.hwid.result.HuaweiIdAuthResult) ((org.xms.g.utils.XGettable) param0).getHInstance());
            return new org.xms.g.auth.api.signin.ExtensionSignInResult(gReturn, hReturn);
        }
        return ((org.xms.g.auth.api.signin.ExtensionSignInResult) param0);
    }
    
    public static boolean isInstance(java.lang.Object param0) {
        if (!(param0 instanceof org.xms.g.utils.XObject)) {
            return false;
        }
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hms.support.hwid.result.HuaweiIdAuthResult;
        } else {
            return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.auth.api.signin.GoogleSignInResult;
        }
    }
}
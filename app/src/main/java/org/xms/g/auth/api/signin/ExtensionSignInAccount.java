package org.xms.g.auth.api.signin;

public class ExtensionSignInAccount extends org.xms.g.utils.XObject implements android.os.Parcelable {
    private boolean wrapper = true;
    public final static android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {
        
        public org.xms.g.auth.api.signin.ExtensionSignInAccount createFromParcel(android.os.Parcel param0) {
            com.google.android.gms.auth.api.signin.GoogleSignInAccount gReturn = null;
            com.huawei.hms.support.hwid.result.AuthHuaweiId hReturn = null;
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                hReturn = com.huawei.hms.support.hwid.result.AuthHuaweiId.CREATOR.createFromParcel(param0);
            } else {
                gReturn = com.google.android.gms.auth.api.signin.GoogleSignInAccount.CREATOR.createFromParcel(param0);
            }
            return new org.xms.g.auth.api.signin.ExtensionSignInAccount(gReturn, hReturn);
        }
        
        public org.xms.g.auth.api.signin.ExtensionSignInAccount[] newArray(int param0) {
            return new org.xms.g.auth.api.signin.ExtensionSignInAccount[param0];
        }
    };
    
    public ExtensionSignInAccount(com.google.android.gms.auth.api.signin.GoogleSignInAccount param0, com.huawei.hms.support.hwid.result.AuthHuaweiId param1) {
        super(param0, null);
        this.setHInstance(param1);
        wrapper = true;
    }
    
    public android.accounts.Account getAccount() {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.support.hwid.result.AuthHuaweiId) this.getHInstance()).getHuaweiAccount()", new Exception());
            return ((com.huawei.hms.support.hwid.result.AuthHuaweiId) this.getHInstance()).getHuaweiAccount();
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.auth.api.signin.GoogleSignInAccount) this.getGInstance()).getAccount()", new Exception());
            return ((com.google.android.gms.auth.api.signin.GoogleSignInAccount) this.getGInstance()).getAccount();
        }
    }
    
    public java.lang.String getDisplayName() {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.support.hwid.result.AuthHuaweiId) this.getHInstance()).getDisplayName()", new Exception());
            return ((com.huawei.hms.support.hwid.result.AuthHuaweiId) this.getHInstance()).getDisplayName();
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.auth.api.signin.GoogleSignInAccount) this.getGInstance()).getDisplayName()", new Exception());
            return ((com.google.android.gms.auth.api.signin.GoogleSignInAccount) this.getGInstance()).getDisplayName();
        }
    }
    
    public java.lang.String getEmail() {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.support.hwid.result.AuthHuaweiId) this.getHInstance()).getEmail()", new Exception());
            return ((com.huawei.hms.support.hwid.result.AuthHuaweiId) this.getHInstance()).getEmail();
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.auth.api.signin.GoogleSignInAccount) this.getGInstance()).getEmail()", new Exception());
            return ((com.google.android.gms.auth.api.signin.GoogleSignInAccount) this.getGInstance()).getEmail();
        }
    }
    
    public java.lang.String getFamilyName() {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.support.hwid.result.AuthHuaweiId) this.getHInstance()).getFamilyName()", new Exception());
            return ((com.huawei.hms.support.hwid.result.AuthHuaweiId) this.getHInstance()).getFamilyName();
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.auth.api.signin.GoogleSignInAccount) this.getGInstance()).getFamilyName()", new Exception());
            return ((com.google.android.gms.auth.api.signin.GoogleSignInAccount) this.getGInstance()).getFamilyName();
        }
    }
    
    public java.lang.String getGivenName() {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.support.hwid.result.AuthHuaweiId) this.getHInstance()).getGivenName()", new Exception());
            return ((com.huawei.hms.support.hwid.result.AuthHuaweiId) this.getHInstance()).getGivenName();
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.auth.api.signin.GoogleSignInAccount) this.getGInstance()).getGivenName()", new Exception());
            return ((com.google.android.gms.auth.api.signin.GoogleSignInAccount) this.getGInstance()).getGivenName();
        }
    }
    
    public java.util.Set<org.xms.g.common.api.Scope> getGrantedScopes() {
        java.util.Set hReturn = null;
        java.util.Set gReturn = null;
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.support.hwid.result.AuthHuaweiId) this.getHInstance()).getAuthorizedScopes()", new Exception());
            hReturn = ((com.huawei.hms.support.hwid.result.AuthHuaweiId) this.getHInstance()).getAuthorizedScopes();
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.auth.api.signin.GoogleSignInAccount) this.getGInstance()).getGrantedScopes()", new Exception());
            gReturn = ((com.google.android.gms.auth.api.signin.GoogleSignInAccount) this.getGInstance()).getGrantedScopes();
        }
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            return ((java.util.Set) org.xms.g.utils.Utils.mapCollection(hReturn, new java.util.function.Function<com.huawei.hms.support.api.entity.auth.Scope, org.xms.g.common.api.Scope>() {
                
                public org.xms.g.common.api.Scope apply(com.huawei.hms.support.api.entity.auth.Scope param0) {
                    return new org.xms.g.common.api.Scope(null, param0);
                }
            }));
        } else {
            return ((java.util.Set) org.xms.g.utils.Utils.mapCollection(gReturn, new java.util.function.Function<com.google.android.gms.common.api.Scope, org.xms.g.common.api.Scope>() {
                
                public org.xms.g.common.api.Scope apply(com.google.android.gms.common.api.Scope param0) {
                    return new org.xms.g.common.api.Scope(param0, null);
                }
            }));
        }
    }
    
    public java.lang.String getId() {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.support.hwid.result.AuthHuaweiId) this.getHInstance()).getUnionId()", new Exception());
            return ((com.huawei.hms.support.hwid.result.AuthHuaweiId) this.getHInstance()).getUnionId();
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.auth.api.signin.GoogleSignInAccount) this.getGInstance()).getId()", new Exception());
            return ((com.google.android.gms.auth.api.signin.GoogleSignInAccount) this.getGInstance()).getId();
        }
    }
    
    public java.lang.String getIdToken() {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.support.hwid.result.AuthHuaweiId) this.getHInstance()).getIdToken()", new Exception());
            return ((com.huawei.hms.support.hwid.result.AuthHuaweiId) this.getHInstance()).getIdToken();
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.auth.api.signin.GoogleSignInAccount) this.getGInstance()).getIdToken()", new Exception());
            return ((com.google.android.gms.auth.api.signin.GoogleSignInAccount) this.getGInstance()).getIdToken();
        }
    }
    
    public android.net.Uri getPhotoUrl() {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.support.hwid.result.AuthHuaweiId) this.getHInstance()).getAvatarUri()", new Exception());
            return ((com.huawei.hms.support.hwid.result.AuthHuaweiId) this.getHInstance()).getAvatarUri();
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.auth.api.signin.GoogleSignInAccount) this.getGInstance()).getPhotoUrl()", new Exception());
            return ((com.google.android.gms.auth.api.signin.GoogleSignInAccount) this.getGInstance()).getPhotoUrl();
        }
    }
    
    public java.lang.String getServerAuthCode() {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.support.hwid.result.AuthHuaweiId) this.getHInstance()).getAuthorizationCode()", new Exception());
            return ((com.huawei.hms.support.hwid.result.AuthHuaweiId) this.getHInstance()).getAuthorizationCode();
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.auth.api.signin.GoogleSignInAccount) this.getGInstance()).getServerAuthCode()", new Exception());
            return ((com.google.android.gms.auth.api.signin.GoogleSignInAccount) this.getGInstance()).getServerAuthCode();
        }
    }
    
    public int hashCode() {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.support.hwid.result.AuthHuaweiId) this.getHInstance()).hashCode()", new Exception());
            return ((com.huawei.hms.support.hwid.result.AuthHuaweiId) this.getHInstance()).hashCode();
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.auth.api.signin.GoogleSignInAccount) this.getGInstance()).hashCode()", new Exception());
            return ((com.google.android.gms.auth.api.signin.GoogleSignInAccount) this.getGInstance()).hashCode();
        }
    }
    
    public void writeToParcel(android.os.Parcel param0, int param1) {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.support.hwid.result.AuthHuaweiId) this.getHInstance()).writeToParcel(param0, param1)", new Exception());
            ((com.huawei.hms.support.hwid.result.AuthHuaweiId) this.getHInstance()).writeToParcel(param0, param1);
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.auth.api.signin.GoogleSignInAccount) this.getGInstance()).writeToParcel(param0, param1)", new Exception());
            ((com.google.android.gms.auth.api.signin.GoogleSignInAccount) this.getGInstance()).writeToParcel(param0, param1);
        }
    }
    
    public int describeContents() {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static org.xms.g.auth.api.signin.ExtensionSignInAccount dynamicCast(java.lang.Object param0) {
        return ((org.xms.g.auth.api.signin.ExtensionSignInAccount) param0);
    }
    
    public static boolean isInstance(java.lang.Object param0) {
        if (!(param0 instanceof org.xms.g.utils.XObject)) {
            return false;
        }
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hms.support.hwid.result.AuthHuaweiId;
        } else {
            return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.auth.api.signin.GoogleSignInAccount;
        }
    }
}
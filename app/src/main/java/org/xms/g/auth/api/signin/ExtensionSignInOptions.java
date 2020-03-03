package org.xms.g.auth.api.signin;

public class ExtensionSignInOptions extends org.xms.g.utils.XObject implements org.xms.g.common.api.Api.ApiOptions.Optional, android.os.Parcelable {
    private boolean wrapper = true;
    public final static android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public org.xms.g.auth.api.signin.ExtensionSignInOptions createFromParcel(android.os.Parcel param0) {
            com.google.android.gms.auth.api.signin.GoogleSignInOptions gReturn = null;
            com.huawei.hms.support.hwid.request.HuaweiIdAuthParams hReturn = null;
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                hReturn = com.huawei.hms.support.hwid.request.HuaweiIdAuthParams.CREATOR.createFromParcel(param0);
            } else {
                gReturn = com.google.android.gms.auth.api.signin.GoogleSignInOptions.CREATOR.createFromParcel(param0);
            }
            return new org.xms.g.auth.api.signin.ExtensionSignInOptions(gReturn, hReturn);
        }

        public org.xms.g.auth.api.signin.ExtensionSignInOptions[] newArray(int param0) {
            return new org.xms.g.auth.api.signin.ExtensionSignInOptions[param0];
        }
    };

    public ExtensionSignInOptions(com.google.android.gms.auth.api.signin.GoogleSignInOptions param0, com.huawei.hms.support.hwid.request.HuaweiIdAuthParams param1) {
        super(param0, null);
        this.setHInstance(param1);
        wrapper = true;
    }

    public static org.xms.g.auth.api.signin.ExtensionSignInOptions getDEFAULT_GAMES_SIGN_IN() {
        com.google.android.gms.auth.api.signin.GoogleSignInOptions gReturn = null;
        com.huawei.hms.support.hwid.request.HuaweiIdAuthParams hReturn = null;
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.huawei.hms.support.hwid.request.HuaweiIdAuthParams.DEFAULT_AUTH_REQUEST_PARAM_GAME", new Exception());
            hReturn = com.huawei.hms.support.hwid.request.HuaweiIdAuthParams.DEFAULT_AUTH_REQUEST_PARAM_GAME;
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.google.android.gms.auth.api.signin.GoogleSignInOptions.DEFAULT_GAMES_SIGN_IN", new Exception());
            gReturn = com.google.android.gms.auth.api.signin.GoogleSignInOptions.DEFAULT_GAMES_SIGN_IN;
        }
        if (gReturn == null && hReturn == null) {
            return null;
        }
        return new org.xms.g.auth.api.signin.ExtensionSignInOptions(gReturn, hReturn);
    }

    public static org.xms.g.auth.api.signin.ExtensionSignInOptions getDEFAULT_SIGN_IN() {
        com.google.android.gms.auth.api.signin.GoogleSignInOptions gReturn = null;
        com.huawei.hms.support.hwid.request.HuaweiIdAuthParams hReturn = null;
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.huawei.hms.support.hwid.request.HuaweiIdAuthParams.DEFAULT_AUTH_REQUEST_PARAM", new Exception());
            hReturn = com.huawei.hms.support.hwid.request.HuaweiIdAuthParams.DEFAULT_AUTH_REQUEST_PARAM;
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.google.android.gms.auth.api.signin.GoogleSignInOptions.DEFAULT_SIGN_IN", new Exception());
            gReturn = com.google.android.gms.auth.api.signin.GoogleSignInOptions.DEFAULT_SIGN_IN;
        }
        if (gReturn == null && hReturn == null) {
            return null;
        }
        return new org.xms.g.auth.api.signin.ExtensionSignInOptions(gReturn, hReturn);
    }

    public boolean equals(java.lang.Object param0) {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.support.hwid.request.HuaweiIdAuthParams) this.getHInstance()).equals(param0)", new Exception());
            return ((com.huawei.hms.support.hwid.request.HuaweiIdAuthParams) this.getHInstance()).equals(param0);
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.auth.api.signin.GoogleSignInOptions) this.getGInstance()).equals(param0)", new Exception());
            return ((com.google.android.gms.auth.api.signin.GoogleSignInOptions) this.getGInstance()).equals(param0);
        }
    }

    public org.xms.g.common.api.Scope[] getScopeArray() {
        com.google.android.gms.common.api.Scope[] gReturn = null;
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            java.util.List<com.huawei.hms.support.api.entity.auth.Scope> hReturn = null;
            org.xms.g.utils.XmsLog.d("XMSRouter",
                "((com.huawei.hms.support.hwid.request.HuaweiIdAuthParams) getHInstance()).getRequestScopeList()",
                new Exception());
            hReturn = ((com.huawei.hms.support.hwid.request.HuaweiIdAuthParams) getHInstance()).getRequestScopeList();
            if (hReturn == null) {
                return null;
            }
            com.huawei.hms.support.api.entity.auth.Scope[] hArray =
                hReturn.toArray(new com.huawei.hms.support.api.entity.auth.Scope[hReturn.size()]);
            return org.xms.g.utils.Utils.genericArrayCopy(hArray, org.xms.g.common.api.Scope.class,
                new java.util.function.Function<com.huawei.hms.support.api.entity.auth.Scope,
                    org.xms.g.common.api.Scope>() {
                    @Override
                    public org.xms.g.common.api.Scope apply(com.huawei.hms.support.api.entity.auth.Scope param0) {
                        return new org.xms.g.common.api.Scope(null, param0);
                    }
                });
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.auth.api.signin.GoogleSignInOptions) this.getGInstance()).getScopeArray()", new Exception());
            gReturn = ((com.google.android.gms.auth.api.signin.GoogleSignInOptions) this.getGInstance()).getScopeArray();
            if (gReturn == null) {
                return null;
            }
            return org.xms.g.utils.Utils.genericArrayCopy(gReturn, org.xms.g.common.api.Scope.class, new java.util.function.Function<com.google.android.gms.common.api.Scope, org.xms.g.common.api.Scope>() {

                public org.xms.g.common.api.Scope apply(com.google.android.gms.common.api.Scope param0) {
                    return new org.xms.g.common.api.Scope(param0, null);
                }
            });
        }
    }

    public int hashCode() {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.support.hwid.request.HuaweiIdAuthParams) this.getHInstance()).hashCode()", new Exception());
            return ((com.huawei.hms.support.hwid.request.HuaweiIdAuthParams) this.getHInstance()).hashCode();
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.auth.api.signin.GoogleSignInOptions) this.getGInstance()).hashCode()", new Exception());
            return ((com.google.android.gms.auth.api.signin.GoogleSignInOptions) this.getGInstance()).hashCode();
        }
    }

    public void writeToParcel(android.os.Parcel param0, int param1) {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.support.hwid.request.HuaweiIdAuthParams) this.getHInstance()).writeToParcel(param0, param1)", new Exception());
            ((com.huawei.hms.support.hwid.request.HuaweiIdAuthParams) this.getHInstance()).writeToParcel(param0, param1);
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.auth.api.signin.GoogleSignInOptions) this.getGInstance()).writeToParcel(param0, param1)", new Exception());
            ((com.google.android.gms.auth.api.signin.GoogleSignInOptions) this.getGInstance()).writeToParcel(param0, param1);
        }
    }

    public int describeContents() {
        throw new java.lang.RuntimeException("Not Supported");
    }

    public static org.xms.g.auth.api.signin.ExtensionSignInOptions dynamicCast(java.lang.Object param0) {
        if (param0 instanceof org.xms.g.auth.api.signin.ExtensionSignInOptions) {
            return ((org.xms.g.auth.api.signin.ExtensionSignInOptions) param0);
        }
        if (param0 instanceof org.xms.g.utils.XGettable) {
            com.google.android.gms.auth.api.signin.GoogleSignInOptions gReturn = ((com.google.android.gms.auth.api.signin.GoogleSignInOptions) ((org.xms.g.utils.XGettable) param0).getGInstance());
            com.huawei.hms.support.hwid.request.HuaweiIdAuthParams hReturn = ((com.huawei.hms.support.hwid.request.HuaweiIdAuthParams) ((org.xms.g.utils.XGettable) param0).getHInstance());
            return new org.xms.g.auth.api.signin.ExtensionSignInOptions(gReturn, hReturn);
        }
        return ((org.xms.g.auth.api.signin.ExtensionSignInOptions) param0);
    }

    public static boolean isInstance(java.lang.Object param0) {
        if (!(param0 instanceof org.xms.g.utils.XObject)) {
            return false;
        }
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hms.support.hwid.request.HuaweiIdAuthParams;
        } else {
            return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.auth.api.signin.GoogleSignInOptions;
        }
    }

    public static final class Builder extends org.xms.g.utils.XObject {

        public Builder(com.google.android.gms.auth.api.signin.GoogleSignInOptions.Builder param0, com.huawei.hms.support.hwid.request.HuaweiIdAuthParamsHelper param1) {
            super(param0, null);
            this.setHInstance(param1);
        }

        public Builder() {
            super(((com.google.android.gms.auth.api.signin.GoogleSignInOptions.Builder) null), null);
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                this.setHInstance(new com.huawei.hms.support.hwid.request.HuaweiIdAuthParamsHelper());
            } else {
                this.setGInstance(new com.google.android.gms.auth.api.signin.GoogleSignInOptions.Builder());
            }
        }

        public Builder(org.xms.g.auth.api.signin.ExtensionSignInOptions param0) {
            super(((com.google.android.gms.auth.api.signin.GoogleSignInOptions.Builder) null), null);
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                this.setHInstance(new com.huawei.hms.support.hwid.request.HuaweiIdAuthParamsHelper(((com.huawei.hms.support.hwid.request.HuaweiIdAuthParams) ((param0) == null ? null : (param0.getHInstance())))));
            } else {
                this.setGInstance(new com.google.android.gms.auth.api.signin.GoogleSignInOptions.Builder(((com.google.android.gms.auth.api.signin.GoogleSignInOptions) ((param0) == null ? null : (param0.getGInstance())))));
            }
        }

        public final org.xms.g.auth.api.signin.ExtensionSignInOptions.Builder addExtension(org.xms.g.auth.api.signin.ExtensionSignInOptionsExtension param0) {
            throw new java.lang.RuntimeException("Not Supported");
        }

        public final org.xms.g.auth.api.signin.ExtensionSignInOptions build() {
            com.google.android.gms.auth.api.signin.GoogleSignInOptions gReturn = null;
            com.huawei.hms.support.hwid.request.HuaweiIdAuthParams hReturn = null;
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.support.hwid.request.HuaweiIdAuthParamsHelper) this.getHInstance()).createParams()", new Exception());
                hReturn = ((com.huawei.hms.support.hwid.request.HuaweiIdAuthParamsHelper) this.getHInstance()).createParams();
            } else {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.auth.api.signin.GoogleSignInOptions.Builder) this.getGInstance()).build()", new Exception());
                gReturn = ((com.google.android.gms.auth.api.signin.GoogleSignInOptions.Builder) this.getGInstance()).build();
            }
            if (gReturn == null && hReturn == null) {
                return null;
            }
            return new org.xms.g.auth.api.signin.ExtensionSignInOptions(gReturn, hReturn);
        }

        public final org.xms.g.auth.api.signin.ExtensionSignInOptions.Builder requestEmail() {
            com.google.android.gms.auth.api.signin.GoogleSignInOptions.Builder gReturn = null;
            com.huawei.hms.support.hwid.request.HuaweiIdAuthParamsHelper hReturn = null;
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.support.hwid.request.HuaweiIdAuthParamsHelper) this.getHInstance()).setEmail()", new Exception());
                hReturn = ((com.huawei.hms.support.hwid.request.HuaweiIdAuthParamsHelper) this.getHInstance()).setEmail();
            } else {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.auth.api.signin.GoogleSignInOptions.Builder) this.getGInstance()).requestEmail()", new Exception());
                gReturn = ((com.google.android.gms.auth.api.signin.GoogleSignInOptions.Builder) this.getGInstance()).requestEmail();
            }
            if (gReturn == null && hReturn == null) {
                return null;
            }
            return new org.xms.g.auth.api.signin.ExtensionSignInOptions.Builder(gReturn, hReturn);
        }

        public final org.xms.g.auth.api.signin.ExtensionSignInOptions.Builder requestId() {
            com.google.android.gms.auth.api.signin.GoogleSignInOptions.Builder gReturn = null;
            com.huawei.hms.support.hwid.request.HuaweiIdAuthParamsHelper hReturn = null;
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.support.hwid.request.HuaweiIdAuthParamsHelper) this.getHInstance()).setId()", new Exception());
                hReturn = ((com.huawei.hms.support.hwid.request.HuaweiIdAuthParamsHelper) this.getHInstance()).setId();
            } else {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.auth.api.signin.GoogleSignInOptions.Builder) this.getGInstance()).requestId()", new Exception());
                gReturn = ((com.google.android.gms.auth.api.signin.GoogleSignInOptions.Builder) this.getGInstance()).requestId();
            }
            if (gReturn == null && hReturn == null) {
                return null;
            }
            return new org.xms.g.auth.api.signin.ExtensionSignInOptions.Builder(gReturn, hReturn);
        }

        public final org.xms.g.auth.api.signin.ExtensionSignInOptions.Builder requestIdToken(java.lang.String param0) {
            com.google.android.gms.auth.api.signin.GoogleSignInOptions.Builder gReturn = null;
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                org.xms.g.utils.XmsLog.d("XMSRouter",
                    "((com.huawei.hms.support.hwid.request.HuaweiIdAuthParamsHelper) getHInstance()).setIdToken()",
                    new Exception());
                com.huawei.hms.support.hwid.request.HuaweiIdAuthParamsHelper hReturn =
                    ((com.huawei.hms.support.hwid.request.HuaweiIdAuthParamsHelper) getHInstance()).setIdToken();
                if (hReturn == null) {
                    return null;
                }
                return new org.xms.g.auth.api.signin.ExtensionSignInOptions.Builder(null, hReturn);
            } else {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.auth.api.signin.GoogleSignInOptions.Builder) this.getGInstance()).requestIdToken(param0)", new Exception());
                gReturn = ((com.google.android.gms.auth.api.signin.GoogleSignInOptions.Builder) this.getGInstance()).requestIdToken(param0);
            }
            if (gReturn == null) {
                return null;
            }
            return new org.xms.g.auth.api.signin.ExtensionSignInOptions.Builder(gReturn, null);
        }

        public final org.xms.g.auth.api.signin.ExtensionSignInOptions.Builder requestProfile() {
            com.google.android.gms.auth.api.signin.GoogleSignInOptions.Builder gReturn = null;
            com.huawei.hms.support.hwid.request.HuaweiIdAuthParamsHelper hReturn = null;
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.support.hwid.request.HuaweiIdAuthParamsHelper) this.getHInstance()).setProfile()", new Exception());
                hReturn = ((com.huawei.hms.support.hwid.request.HuaweiIdAuthParamsHelper) this.getHInstance()).setProfile();
            } else {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.auth.api.signin.GoogleSignInOptions.Builder) this.getGInstance()).requestProfile()", new Exception());
                gReturn = ((com.google.android.gms.auth.api.signin.GoogleSignInOptions.Builder) this.getGInstance()).requestProfile();
            }
            if (gReturn == null && hReturn == null) {
                return null;
            }
            return new org.xms.g.auth.api.signin.ExtensionSignInOptions.Builder(gReturn, hReturn);
        }

        public final org.xms.g.auth.api.signin.ExtensionSignInOptions.Builder requestScopes(org.xms.g.common.api.Scope param0, org.xms.g.common.api.Scope... param1) {
            com.google.android.gms.auth.api.signin.GoogleSignInOptions.Builder gReturn = null;
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                org.xms.g.utils.XmsLog.d("XMSRouter",
                    "((com.huawei.hms.support.hwid.request.HuaweiIdAuthParamsHelper) getHInstance()).setScopeList(scopeList)",
                    new Exception());
                java.util.List<com.huawei.hms.support.api.entity.auth.Scope> scopeList = null;
                if (param0 != null || param1 != null) {
                    scopeList = new java.util.ArrayList<>();
                    if (param0 != null) {
                        scopeList.add((com.huawei.hms.support.api.entity.auth.Scope) param0.getHInstance());
                    }
                    if (param1 != null) {
                        for (org.xms.g.common.api.Scope scope : param1) {
                            scopeList.add((com.huawei.hms.support.api.entity.auth.Scope) scope.getHInstance());
                        }
                    }
                }
                com.huawei.hms.support.hwid.request.HuaweiIdAuthParamsHelper hReturn =
                    ((com.huawei.hms.support.hwid.request.HuaweiIdAuthParamsHelper) getHInstance())
                        .setScopeList(scopeList);
                if (hReturn == null) {
                    return null;
                }
                return new org.xms.g.auth.api.signin.ExtensionSignInOptions.Builder(null, hReturn);
            } else {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.auth.api.signin.GoogleSignInOptions.Builder) this.getGInstance()).requestScopes(((com.google.android.gms.common.api.Scope) ((param0) == null ? null : (param0.getGInstance()))), ((com.google.android.gms.common.api.Scope[]) org.xms.g.utils.Utils.genericArrayCopy(param1, com.google.android.gms.common.api.Scope.class, x -> (com.google.android.gms.common.api.Scope)x.getGInstance())))", new Exception());
                gReturn = ((com.google.android.gms.auth.api.signin.GoogleSignInOptions.Builder) this.getGInstance()).requestScopes(((com.google.android.gms.common.api.Scope) ((param0) == null ? null : (param0.getGInstance()))), ((com.google.android.gms.common.api.Scope[]) org.xms.g.utils.Utils.genericArrayCopy(param1, com.google.android.gms.common.api.Scope.class, x -> (com.google.android.gms.common.api.Scope)x.getGInstance())));
            }
            if (gReturn == null) {
                return null;
            }
            return new org.xms.g.auth.api.signin.ExtensionSignInOptions.Builder(gReturn, null);
        }

        public final org.xms.g.auth.api.signin.ExtensionSignInOptions.Builder requestServerAuthCode(java.lang.String param0) {
            com.google.android.gms.auth.api.signin.GoogleSignInOptions.Builder gReturn = null;
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                org.xms.g.utils.XmsLog.d("XMSRouter",
                    "((com.huawei.hms.support.hwid.request.HuaweiIdAuthParamsHelper) getHInstance()).setAuthorizationCode()",
                    new Exception());
                com.huawei.hms.support.hwid.request.HuaweiIdAuthParamsHelper hReturn =
                    ((com.huawei.hms.support.hwid.request.HuaweiIdAuthParamsHelper) getHInstance())
                        .setAuthorizationCode();
                if (hReturn == null) {
                    return null;
                }
                return new org.xms.g.auth.api.signin.ExtensionSignInOptions.Builder(null, hReturn);
            } else {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.auth.api.signin.GoogleSignInOptions.Builder) this.getGInstance()).requestServerAuthCode(param0)", new Exception());
                gReturn = ((com.google.android.gms.auth.api.signin.GoogleSignInOptions.Builder) this.getGInstance()).requestServerAuthCode(param0);
            }
            if (gReturn == null) {
                return null;
            }
            return new org.xms.g.auth.api.signin.ExtensionSignInOptions.Builder(gReturn, null);
        }

        public final org.xms.g.auth.api.signin.ExtensionSignInOptions.Builder requestServerAuthCode(java.lang.String param0, boolean param1) {
            throw new java.lang.RuntimeException("Not Supported");
        }

        public final org.xms.g.auth.api.signin.ExtensionSignInOptions.Builder setAccountName(java.lang.String param0) {
            throw new java.lang.RuntimeException("Not Supported");
        }

        public final org.xms.g.auth.api.signin.ExtensionSignInOptions.Builder setHostedDomain(java.lang.String param0) {
            throw new java.lang.RuntimeException("Not Supported");
        }

        public static org.xms.g.auth.api.signin.ExtensionSignInOptions.Builder dynamicCast(java.lang.Object param0) {
            if (param0 instanceof org.xms.g.auth.api.signin.ExtensionSignInOptions.Builder) {
                return ((org.xms.g.auth.api.signin.ExtensionSignInOptions.Builder) param0);
            }
            if (param0 instanceof org.xms.g.utils.XGettable) {
                com.google.android.gms.auth.api.signin.GoogleSignInOptions.Builder gReturn = ((com.google.android.gms.auth.api.signin.GoogleSignInOptions.Builder) ((org.xms.g.utils.XGettable) param0).getGInstance());
                com.huawei.hms.support.hwid.request.HuaweiIdAuthParamsHelper hReturn = ((com.huawei.hms.support.hwid.request.HuaweiIdAuthParamsHelper) ((org.xms.g.utils.XGettable) param0).getHInstance());
                return new org.xms.g.auth.api.signin.ExtensionSignInOptions.Builder(gReturn, hReturn);
            }
            return ((org.xms.g.auth.api.signin.ExtensionSignInOptions.Builder) param0);
        }

        public static boolean isInstance(java.lang.Object param0) {
            if (!(param0 instanceof org.xms.g.utils.XObject)) {
                return false;
            }
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hms.support.hwid.request.HuaweiIdAuthParamsHelper;
            } else {
                return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.auth.api.signin.GoogleSignInOptions.Builder;
            }
        }
    }
}

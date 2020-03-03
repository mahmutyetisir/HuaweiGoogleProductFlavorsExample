package org.xms.g.auth;





public final class ExtensionAuthUtil extends org.xms.g.utils.XObject {
    
    
    
    
    public ExtensionAuthUtil(com.google.android.gms.auth.GoogleAuthUtil param0, com.huawei.hms.support.hwid.tools.HuaweiIdAuthTool param1) {
        super(param0, null);
        this.setHInstance(param1);
    }
    
    public static int getCHANGE_TYPE_ACCOUNT_ADDED() {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static int getCHANGE_TYPE_ACCOUNT_REMOVED() {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static int getCHANGE_TYPE_ACCOUNT_RENAMED_FROM() {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static int getCHANGE_TYPE_ACCOUNT_RENAMED_TO() {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static int getGCORE_REQUEST_GOOGLE_ACCOUNTS_MIN_VERSION() {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static java.lang.String getGOOGLE_ACCOUNT_TYPE() {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.huawei.hms.support.hwid.tools.HuaweiIdAuthTool.HUAWEI_ACCOUNT_TYPE", new Exception());
            return com.huawei.hms.support.hwid.tools.HuaweiIdAuthTool.HUAWEI_ACCOUNT_TYPE;
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.google.android.gms.auth.GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE", new Exception());
            return com.google.android.gms.auth.GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE;
        }
    }
    
    public static java.lang.String getKEY_REQUEST_ACTIONS() {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static java.lang.String getKEY_REQUEST_VISIBLE_ACTIVITIES() {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static java.lang.String getKEY_SUPPRESS_PROGRESS_SCREEN() {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static java.lang.String getWORK_ACCOUNT_TYPE() {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static void clearToken(android.content.Context param0, java.lang.String param1) throws org.xms.g.auth.ExtensionPlayServicesAvailabilityException, org.xms.g.auth.ExtensionAuthException, java.io.IOException {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            try {
                org.xms.g.utils.XmsLog.d("XMSRouter", "com.huawei.hms.support.hwid.tools.HuaweiIdAuthTool.deleteAuthInfo(param0, param1)", new Exception());
                com.huawei.hms.support.hwid.tools.HuaweiIdAuthTool.deleteAuthInfo(param0, param1);
            }
            catch (com.huawei.hms.support.hwid.common.HuaweiIdAuthException e) {
                throw new org.xms.g.auth.ExtensionAuthException(((com.google.android.gms.auth.GoogleAuthException) null), e);
            }
        } else {
            try {
                org.xms.g.utils.XmsLog.d("XMSRouter", "com.google.android.gms.auth.GoogleAuthUtil.clearToken(param0, param1)", new Exception());
                com.google.android.gms.auth.GoogleAuthUtil.clearToken(param0, param1);
            }
            catch (com.google.android.gms.auth.GooglePlayServicesAvailabilityException e) {
                throw new org.xms.g.auth.ExtensionPlayServicesAvailabilityException(e, null);
            }
            catch (com.google.android.gms.auth.GoogleAuthException e) {
                throw new org.xms.g.auth.ExtensionAuthException(e, ((com.huawei.hms.support.hwid.common.HuaweiIdAuthException) null));
            }
        }
    }
    
    public static java.util.List<org.xms.g.auth.AccountChangeEvent> getAccountChangeEvents(android.content.Context param0, int param1, java.lang.String param2) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static java.lang.String getAccountId(android.content.Context param0, java.lang.String param1) throws org.xms.g.auth.ExtensionAuthException, java.io.IOException {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            try {
                org.xms.g.utils.XmsLog.d("XMSRouter", "com.huawei.hms.support.hwid.tools.HuaweiIdAuthTool.requestUnionId(param0, param1)", new Exception());
                return com.huawei.hms.support.hwid.tools.HuaweiIdAuthTool.requestUnionId(param0, param1);
            }
            catch (com.huawei.hms.support.hwid.common.HuaweiIdAuthException e) {
                throw new org.xms.g.auth.ExtensionAuthException(((com.google.android.gms.auth.GoogleAuthException) null), e);
            }
        } else {
            try {
                org.xms.g.utils.XmsLog.d("XMSRouter", "com.google.android.gms.auth.GoogleAuthUtil.getAccountId(param0, param1)", new Exception());
                return com.google.android.gms.auth.GoogleAuthUtil.getAccountId(param0, param1);
            }
            catch (com.google.android.gms.auth.GoogleAuthException e) {
                throw new org.xms.g.auth.ExtensionAuthException(e, ((com.huawei.hms.support.hwid.common.HuaweiIdAuthException) null));
            }
        }
    }
    
    public static java.lang.String getToken(android.content.Context param0, android.accounts.Account param1, java.lang.String param2, android.os.Bundle param3) throws org.xms.g.auth.UserRecoverableAuthException, java.io.IOException, org.xms.g.auth.ExtensionAuthException {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            
            try {
                org.xms.g.utils.XmsLog.d("XMSRouter",
                    "com.huawei.hms.support.hwid.tools.HuaweiIdAuthTool.requestAccessToken(param0, param1, scopeList, param3)",
                    new Exception());
                java.util.List<com.huawei.hms.support.api.entity.auth.Scope> scopeList = null;
                if (param2 != null) {
                    scopeList = new java.util.ArrayList<>();
                    String prefix = "oauth2:";
                    if (param2.startsWith(prefix)) {
                        String scopes = param2.split(prefix)[1];
                        for (String scope : scopes.split(" ")) {
                            scopeList.add(new com.huawei.hms.support.api.entity.auth.Scope(scope));
                        }
                    }
                }
                return com.huawei.hms.support.hwid.tools.HuaweiIdAuthTool.requestAccessToken(param0, param1, scopeList,
                    param3);
            } catch (com.huawei.hms.support.hwid.common.HuaweiIdAuthException e) {
                throw new org.xms.g.auth.ExtensionAuthException((com.google.android.gms.auth.GoogleAuthException) null,
                    e);
            }
            
        } else {
            try {
                org.xms.g.utils.XmsLog.d("XMSRouter", "com.google.android.gms.auth.GoogleAuthUtil.getToken(param0, param1, param2, param3)", new Exception());
                return com.google.android.gms.auth.GoogleAuthUtil.getToken(param0, param1, param2, param3);
            }
            catch (com.google.android.gms.auth.UserRecoverableAuthException e) {
                throw new org.xms.g.auth.UserRecoverableAuthException(e, null);
            }
            catch (com.google.android.gms.auth.GoogleAuthException e) {
                throw new org.xms.g.auth.ExtensionAuthException(e, ((com.huawei.hms.support.hwid.common.HuaweiIdAuthException) null));
            }
        }
    }
    
    public static java.lang.String getToken(android.content.Context param0, android.accounts.Account param1, java.lang.String param2) throws org.xms.g.auth.UserRecoverableAuthException, java.io.IOException, org.xms.g.auth.ExtensionAuthException {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            
            try {
                org.xms.g.utils.XmsLog.d("XMSRouter",
                    "com.huawei.hms.support.hwid.tools.HuaweiIdAuthTool.requestAccessToken(param0, param1, scopeList)",
                    new Exception());
                java.util.List<com.huawei.hms.support.api.entity.auth.Scope> scopeList = null;
                if (param2 != null) {
                    scopeList = new java.util.ArrayList<>();
                    String prefix = "oauth2:";
                    if (param2.startsWith(prefix)) {
                        String scopes = param2.split(prefix)[1];
                        for (String scope : scopes.split(" ")) {
                            scopeList.add(new com.huawei.hms.support.api.entity.auth.Scope(scope));
                        }
                    }
                }
                return com.huawei.hms.support.hwid.tools.HuaweiIdAuthTool.requestAccessToken(param0, param1, scopeList);
            } catch (com.huawei.hms.support.hwid.common.HuaweiIdAuthException e) {
                throw new org.xms.g.auth.ExtensionAuthException((com.google.android.gms.auth.GoogleAuthException) null,
                    e);
            }
            
        } else {
            try {
                org.xms.g.utils.XmsLog.d("XMSRouter", "com.google.android.gms.auth.GoogleAuthUtil.getToken(param0, param1, param2)", new Exception());
                return com.google.android.gms.auth.GoogleAuthUtil.getToken(param0, param1, param2);
            }
            catch (com.google.android.gms.auth.UserRecoverableAuthException e) {
                throw new org.xms.g.auth.UserRecoverableAuthException(e, null);
            }
            catch (com.google.android.gms.auth.GoogleAuthException e) {
                throw new org.xms.g.auth.ExtensionAuthException(e, ((com.huawei.hms.support.hwid.common.HuaweiIdAuthException) null));
            }
        }
    }
    
    public static java.lang.String getToken(android.content.Context param0, java.lang.String param1, java.lang.String param2, android.os.Bundle param3) throws org.xms.g.auth.UserRecoverableAuthException, java.io.IOException, org.xms.g.auth.ExtensionAuthException {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            
            try {
                org.xms.g.utils.XmsLog.d("XMSRouter",
                    "com.huawei.hms.support.hwid.tools.HuaweiIdAuthTool.requestAccessToken(param0, param1, scopeList, param3)",
                    new Exception());
                java.util.List<com.huawei.hms.support.api.entity.auth.Scope> scopeList = null;
                if (param2 != null) {
                    scopeList = new java.util.ArrayList<>();
                    String prefix = "oauth2:";
                    if (param2.startsWith(prefix)) {
                        String scopes = param2.split(prefix)[1];
                        for (String scope : scopes.split(" ")) {
                            scopeList.add(new com.huawei.hms.support.api.entity.auth.Scope(scope));
                        }
                    }
                }
                return com.huawei.hms.support.hwid.tools.HuaweiIdAuthTool.requestAccessToken(param0, param1, scopeList,
                    param3);
            } catch (com.huawei.hms.support.hwid.common.HuaweiIdAuthException e) {
                throw new org.xms.g.auth.ExtensionAuthException((com.google.android.gms.auth.GoogleAuthException) null,
                    e);
            }
            
        } else {
            try {
                org.xms.g.utils.XmsLog.d("XMSRouter", "com.google.android.gms.auth.GoogleAuthUtil.getToken(param0, param1, param2, param3)", new Exception());
                return com.google.android.gms.auth.GoogleAuthUtil.getToken(param0, param1, param2, param3);
            }
            catch (com.google.android.gms.auth.UserRecoverableAuthException e) {
                throw new org.xms.g.auth.UserRecoverableAuthException(e, null);
            }
            catch (com.google.android.gms.auth.GoogleAuthException e) {
                throw new org.xms.g.auth.ExtensionAuthException(e, ((com.huawei.hms.support.hwid.common.HuaweiIdAuthException) null));
            }
        }
    }
    
    public static java.lang.String getToken(android.content.Context param0, java.lang.String param1, java.lang.String param2) throws org.xms.g.auth.UserRecoverableAuthException, java.io.IOException, org.xms.g.auth.ExtensionAuthException {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            
            try {
                org.xms.g.utils.XmsLog.d("XMSRouter",
                        "com.huawei.hms.support.hwid.tools.HuaweiIdAuthTool.requestAccessToken(param0, param1, scopeList)",
                        new Exception());
                java.util.List<com.huawei.hms.support.api.entity.auth.Scope> scopeList = null;
                if (param2 != null) {
                    scopeList = new java.util.ArrayList<>();
                    String prefix = "oauth2:";
                    if (param2.startsWith(prefix)) {
                        String scopes = param2.split(prefix)[1];
                        for (String scope : scopes.split(" ")) {
                            scopeList.add(new com.huawei.hms.support.api.entity.auth.Scope(scope));
                        }
                    }
                }
                return com.huawei.hms.support.hwid.tools.HuaweiIdAuthTool.requestAccessToken(param0, param1, scopeList);
            } catch (com.huawei.hms.support.hwid.common.HuaweiIdAuthException e) {
                throw new org.xms.g.auth.ExtensionAuthException((com.google.android.gms.auth.GoogleAuthException) null,
                        e);
            }
            
        } else {
            try {
                org.xms.g.utils.XmsLog.d("XMSRouter", "com.google.android.gms.auth.GoogleAuthUtil.getToken(param0, param1, param2)", new Exception());
                return com.google.android.gms.auth.GoogleAuthUtil.getToken(param0, param1, param2);
            }
            catch (com.google.android.gms.auth.UserRecoverableAuthException e) {
                throw new org.xms.g.auth.UserRecoverableAuthException(e, null);
            }
            catch (com.google.android.gms.auth.GoogleAuthException e) {
                throw new org.xms.g.auth.ExtensionAuthException(e, ((com.huawei.hms.support.hwid.common.HuaweiIdAuthException) null));
            }
        }
    }
    
    public static java.lang.String getTokenWithNotification(android.content.Context param0, java.lang.String param1, java.lang.String param2, android.os.Bundle param3, java.lang.String param4, android.os.Bundle param5) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static java.lang.String getTokenWithNotification(android.content.Context param0, android.accounts.Account param1, java.lang.String param2, android.os.Bundle param3) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static java.lang.String getTokenWithNotification(android.content.Context param0, java.lang.String param1, java.lang.String param2, android.os.Bundle param3, android.content.Intent param4) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static java.lang.String getTokenWithNotification(android.content.Context param0, android.accounts.Account param1, java.lang.String param2, android.os.Bundle param3, java.lang.String param4, android.os.Bundle param5) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static java.lang.String getTokenWithNotification(android.content.Context param0, java.lang.String param1, java.lang.String param2, android.os.Bundle param3) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static java.lang.String getTokenWithNotification(android.content.Context param0, android.accounts.Account param1, java.lang.String param2, android.os.Bundle param3, android.content.Intent param4) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static void invalidateToken(android.content.Context param0, java.lang.String param1) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static android.os.Bundle removeAccount(android.content.Context param0, android.accounts.Account param1) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static java.lang.Boolean requestGoogleAccountsAccess(android.content.Context param0) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static org.xms.g.auth.ExtensionAuthUtil dynamicCast(java.lang.Object param0) {
        return ((org.xms.g.auth.ExtensionAuthUtil) param0);
    }
    
    public static boolean isInstance(java.lang.Object param0) {
        if (!(param0 instanceof org.xms.g.utils.XObject)) {
            return false;
        }
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hms.support.hwid.tools.HuaweiIdAuthTool;
        } else {
            return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.auth.GoogleAuthUtil;
        }
    }
}
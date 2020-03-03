package org.xms.g.auth.account;

public interface WorkAccountApi extends org.xms.g.utils.XInterface {
    
    public org.xms.g.common.api.PendingResult<org.xms.g.auth.account.WorkAccountApi.AddAccountResult> addWorkAccount(org.xms.g.common.api.ExtensionApiClient param0, java.lang.String param1);
    
    public org.xms.g.common.api.PendingResult<org.xms.g.common.api.Result> removeWorkAccount(org.xms.g.common.api.ExtensionApiClient param0, android.accounts.Account param1);
    
    public void setWorkAuthenticatorEnabled(org.xms.g.common.api.ExtensionApiClient param0, boolean param1);
    
    public org.xms.g.common.api.PendingResult<org.xms.g.common.api.Result> setWorkAuthenticatorEnabledWithResult(org.xms.g.common.api.ExtensionApiClient param0, boolean param1);
    
    default com.google.android.gms.auth.account.WorkAccountApi getGInstanceWorkAccountApi() {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    default java.lang.Object getHInstanceWorkAccountApi() {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static org.xms.g.auth.account.WorkAccountApi dynamicCast(java.lang.Object param0) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static boolean isInstance(java.lang.Object param0) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static class XImpl extends org.xms.g.utils.XObject implements org.xms.g.auth.account.WorkAccountApi {
        
        public XImpl(com.google.android.gms.auth.account.WorkAccountApi param0, java.lang.Object param1) {
            super(param0, param1);
        }
        
        public static boolean isInstance(java.lang.Object param0) {
            throw new java.lang.RuntimeException("Not Supported");
        }
        
        public org.xms.g.common.api.PendingResult<org.xms.g.auth.account.WorkAccountApi.AddAccountResult> addWorkAccount(org.xms.g.common.api.ExtensionApiClient param0, java.lang.String param1) {
            throw new java.lang.RuntimeException("Not Supported");
        }
        
        public org.xms.g.common.api.PendingResult<org.xms.g.common.api.Result> removeWorkAccount(org.xms.g.common.api.ExtensionApiClient param0, android.accounts.Account param1) {
            throw new java.lang.RuntimeException("Not Supported");
        }
        
        public void setWorkAuthenticatorEnabled(org.xms.g.common.api.ExtensionApiClient param0, boolean param1) {
            throw new java.lang.RuntimeException("Not Supported");
        }
        
        public org.xms.g.common.api.PendingResult<org.xms.g.common.api.Result> setWorkAuthenticatorEnabledWithResult(org.xms.g.common.api.ExtensionApiClient param0, boolean param1) {
            throw new java.lang.RuntimeException("Not Supported");
        }
    }
    
    public static interface AddAccountResult extends org.xms.g.utils.XInterface, org.xms.g.common.api.Result {
        
        public android.accounts.Account getAccount();
        
        default com.google.android.gms.auth.account.WorkAccountApi.AddAccountResult getGInstanceAddAccountResult() {
            throw new java.lang.RuntimeException("Not Supported");
        }
        
        default java.lang.Object getHInstanceAddAccountResult() {
            throw new java.lang.RuntimeException("Not Supported");
        }
        
        public static org.xms.g.auth.account.WorkAccountApi.AddAccountResult dynamicCast(java.lang.Object param0) {
            throw new java.lang.RuntimeException("Not Supported");
        }
        
        public static boolean isInstance(java.lang.Object param0) {
            throw new java.lang.RuntimeException("Not Supported");
        }
        
        public static class XImpl extends org.xms.g.utils.XObject implements org.xms.g.auth.account.WorkAccountApi.AddAccountResult {
            
            public XImpl(com.google.android.gms.auth.account.WorkAccountApi.AddAccountResult param0, java.lang.Object param1) {
                super(param0, param1);
            }
            
            public static boolean isInstance(java.lang.Object param0) {
                throw new java.lang.RuntimeException("Not Supported");
            }
            
            public android.accounts.Account getAccount() {
                throw new java.lang.RuntimeException("Not Supported");
            }
            
            public org.xms.g.common.api.Status getStatus() {
                throw new java.lang.RuntimeException("Not Supported");
            }
        }
    }
}
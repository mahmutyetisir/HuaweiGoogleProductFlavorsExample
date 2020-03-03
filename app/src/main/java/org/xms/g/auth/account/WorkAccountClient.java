package org.xms.g.auth.account;

public class WorkAccountClient extends org.xms.g.common.api.ExtensionApi<org.xms.g.common.api.Api.ApiOptions.NoOptions> {
    private boolean wrapper = true;
    
    public WorkAccountClient(com.google.android.gms.auth.account.WorkAccountClient param0, java.lang.Object param1) {
        super(param0, null);
    }
    
    public org.xms.g.tasks.Task<android.accounts.Account> addWorkAccount(java.lang.String param0) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public org.xms.g.tasks.Task<java.lang.Void> removeWorkAccount(android.accounts.Account param0) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public org.xms.g.tasks.Task<java.lang.Void> setWorkAuthenticatorEnabled(boolean param0) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public java.lang.Object getApiKey() {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static org.xms.g.auth.account.WorkAccountClient dynamicCast(java.lang.Object param0) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static boolean isInstance(java.lang.Object param0) {
        throw new java.lang.RuntimeException("Not Supported");
    }
}
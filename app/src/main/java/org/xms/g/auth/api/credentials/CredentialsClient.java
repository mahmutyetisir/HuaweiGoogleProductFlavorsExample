package org.xms.g.auth.api.credentials;

public class CredentialsClient extends org.xms.g.utils.XObject {
    private boolean wrapper = true;
    
    public CredentialsClient(com.google.android.gms.auth.api.credentials.CredentialsClient param0, java.lang.Object param1) {
        super(param0, null);
    }
    
    public org.xms.g.tasks.Task<java.lang.Void> delete(org.xms.g.auth.api.credentials.Credential param0) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public org.xms.g.tasks.Task<java.lang.Void> disableAutoSignIn() {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public android.app.PendingIntent getHintPickerIntent(org.xms.g.auth.api.credentials.HintRequest param0) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public org.xms.g.tasks.Task<org.xms.g.auth.api.credentials.CredentialRequestResponse> request(org.xms.g.auth.api.credentials.CredentialRequest param0) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public org.xms.g.tasks.Task<java.lang.Void> save(org.xms.g.auth.api.credentials.Credential param0) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static org.xms.g.auth.api.credentials.CredentialsClient dynamicCast(java.lang.Object param0) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static boolean isInstance(java.lang.Object param0) {
        throw new java.lang.RuntimeException("Not Supported");
    }
}
package org.xms.g.auth.api.credentials;

public class CredentialRequestResponse extends org.xms.g.common.api.Response<org.xms.g.auth.api.credentials.CredentialRequestResult> {
    private boolean wrapper = true;
    
    public CredentialRequestResponse(com.google.android.gms.auth.api.credentials.CredentialRequestResponse param0, java.lang.Object param1) {
        super(param0, null);
    }
    
    public org.xms.g.auth.api.credentials.Credential getCredential() {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static org.xms.g.auth.api.credentials.CredentialRequestResponse dynamicCast(java.lang.Object param0) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static boolean isInstance(java.lang.Object param0) {
        throw new java.lang.RuntimeException("Not Supported");
    }
}
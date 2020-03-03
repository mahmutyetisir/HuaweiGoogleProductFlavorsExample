package org.xms.g.auth.api.credentials;

public abstract class CredentialRequestResult extends org.xms.g.utils.XObject implements org.xms.g.common.api.Result {
    private boolean wrapper = true;
    
    public CredentialRequestResult(com.google.android.gms.auth.api.credentials.CredentialRequestResult param0, java.lang.Object param1) {
        super(param0, null);
    }
    
    public abstract org.xms.g.auth.api.credentials.Credential getCredential();
    
    public static org.xms.g.auth.api.credentials.CredentialRequestResult dynamicCast(java.lang.Object param0) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static boolean isInstance(java.lang.Object param0) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static class XImpl extends org.xms.g.auth.api.credentials.CredentialRequestResult {
        
        public XImpl(com.google.android.gms.auth.api.credentials.CredentialRequestResult param0, java.lang.Object param1) {
            super(param0, param1);
        }
        
        public static boolean isInstance(java.lang.Object param0) {
            throw new java.lang.RuntimeException("Not Supported");
        }
        
        public org.xms.g.auth.api.credentials.Credential getCredential() {
            throw new java.lang.RuntimeException("Not Supported");
        }
        
        public org.xms.g.common.api.Status getStatus() {
            throw new java.lang.RuntimeException("Not Supported");
        }
    }
}
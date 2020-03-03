package org.xms.g.auth;

public class UserRecoverableAuthException extends org.xms.g.auth.ExtensionAuthException {
    private boolean wrapper = true;
    
    public UserRecoverableAuthException(com.google.android.gms.auth.UserRecoverableAuthException param0, java.lang.Object param1) {
        super(param0, null);
    }
    
    public UserRecoverableAuthException(java.lang.String param0, android.content.Intent param1) {
        super(((com.google.android.gms.auth.UserRecoverableAuthException) null), null);
    }
    
    public android.content.Intent getIntent() {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static org.xms.g.auth.UserRecoverableAuthException dynamicCast(java.lang.Object param0) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static boolean isInstance(java.lang.Object param0) {
        throw new java.lang.RuntimeException("Not Supported");
    }
}
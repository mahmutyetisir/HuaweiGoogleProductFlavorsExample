package org.xms.g.auth;

public class UserRecoverableNotifiedException extends org.xms.g.auth.ExtensionAuthException {
    private boolean wrapper = true;
    
    public UserRecoverableNotifiedException(com.google.android.gms.auth.UserRecoverableNotifiedException param0, java.lang.Object param1) {
        super(param0, null);
    }
    
    public UserRecoverableNotifiedException(java.lang.String param0) {
        super(((com.google.android.gms.auth.UserRecoverableNotifiedException) null), null);
    }
    
    public static org.xms.g.auth.UserRecoverableNotifiedException dynamicCast(java.lang.Object param0) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static boolean isInstance(java.lang.Object param0) {
        throw new java.lang.RuntimeException("Not Supported");
    }
}
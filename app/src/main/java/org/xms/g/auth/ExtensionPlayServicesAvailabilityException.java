package org.xms.g.auth;

public class ExtensionPlayServicesAvailabilityException extends org.xms.g.auth.UserRecoverableAuthException {
    private boolean wrapper = true;
    
    public ExtensionPlayServicesAvailabilityException(com.google.android.gms.auth.GooglePlayServicesAvailabilityException param0, java.lang.Object param1) {
        super(param0, null);
    }
    
    public int getConnectionStatusCode() {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static org.xms.g.auth.ExtensionPlayServicesAvailabilityException dynamicCast(java.lang.Object param0) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static boolean isInstance(java.lang.Object param0) {
        throw new java.lang.RuntimeException("Not Supported");
    }
}
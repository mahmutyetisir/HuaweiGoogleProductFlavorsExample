package org.xms.f;

public class FirebaseApiNotAvailableException extends org.xms.f.FirebaseException {
    private boolean wrapper = true;
    
    public FirebaseApiNotAvailableException(com.google.firebase.FirebaseApiNotAvailableException param0, java.lang.Object param1) {
        super(param0, null);
    }
    
    public FirebaseApiNotAvailableException(java.lang.String param0) {
        super(((com.google.firebase.FirebaseApiNotAvailableException) null), null);
    }
    
    public static org.xms.f.FirebaseApiNotAvailableException dynamicCast(java.lang.Object param0) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static boolean isInstance(java.lang.Object param0) {
        throw new java.lang.RuntimeException("Not Supported");
    }
}
package org.xms.f;

public class FirebaseException extends java.lang.Exception implements org.xms.g.utils.XGettable {
    private boolean wrapper = true;
    public com.google.firebase.FirebaseException gInstance;
    public java.lang.Object hInstance;
    
    public FirebaseException(com.google.firebase.FirebaseException param0, java.lang.Object param1) {
        gInstance = param0;
        hInstance = param1;
        wrapper = true;
    }
    
    public FirebaseException(java.lang.String param0) {
    }
    
    public FirebaseException(java.lang.String param0, java.lang.Throwable param1) {
    }
    
    public FirebaseException() {
    }
    
    public void setGInstance(com.google.firebase.FirebaseException param0) {
        this.gInstance = param0;
    }
    
    public void setHInstance(java.lang.Object param0) {
        this.hInstance = param0;
    }
    
    public java.lang.Object getGInstance() {
        return this.gInstance;
    }
    
    public java.lang.Object getHInstance() {
        return this.hInstance;
    }
    
    public static org.xms.f.FirebaseException dynamicCast(java.lang.Object param0) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static boolean isInstance(java.lang.Object param0) {
        throw new java.lang.RuntimeException("Not Supported");
    }
}
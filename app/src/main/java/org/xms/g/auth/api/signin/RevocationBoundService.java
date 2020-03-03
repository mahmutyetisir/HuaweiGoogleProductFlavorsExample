package org.xms.g.auth.api.signin;

public final class RevocationBoundService extends android.app.Service implements org.xms.g.utils.XGettable {
    public com.google.android.gms.auth.api.signin.RevocationBoundService gInstance;
    public java.lang.Object hInstance;
    
    public RevocationBoundService(com.google.android.gms.auth.api.signin.RevocationBoundService param0, java.lang.Object param1) {
        gInstance = param0;
        hInstance = param1;
    }
    
    public RevocationBoundService() {
    }
    
    public final android.os.IBinder onBind(android.content.Intent param0) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public void setGInstance(com.google.android.gms.auth.api.signin.RevocationBoundService param0) {
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
    
    public static org.xms.g.auth.api.signin.RevocationBoundService dynamicCast(java.lang.Object param0) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static boolean isInstance(java.lang.Object param0) {
        throw new java.lang.RuntimeException("Not Supported");
    }
}
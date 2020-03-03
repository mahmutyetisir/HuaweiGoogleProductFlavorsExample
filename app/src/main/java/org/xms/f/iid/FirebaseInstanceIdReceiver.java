package org.xms.f.iid;

public final class FirebaseInstanceIdReceiver extends androidx.legacy.content.WakefulBroadcastReceiver implements org.xms.g.utils.XGettable {
    public com.google.firebase.iid.FirebaseInstanceIdReceiver gInstance;
    public java.lang.Object hInstance;
    
    public FirebaseInstanceIdReceiver(com.google.firebase.iid.FirebaseInstanceIdReceiver param0, java.lang.Object param1) {
        gInstance = param0;
        hInstance = param1;
    }
    
    public void onReceive(android.content.Context param0, android.content.Intent param1) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public void setGInstance(com.google.firebase.iid.FirebaseInstanceIdReceiver param0) {
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
    
    public static org.xms.f.iid.FirebaseInstanceIdReceiver dynamicCast(java.lang.Object param0) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static boolean isInstance(java.lang.Object param0) {
        throw new java.lang.RuntimeException("Not Supported");
    }
}
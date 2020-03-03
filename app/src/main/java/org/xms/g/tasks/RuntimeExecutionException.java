package org.xms.g.tasks;

public class RuntimeExecutionException extends java.lang.RuntimeException implements org.xms.g.utils.XGettable {
    private boolean wrapper = true;
    public com.google.android.gms.tasks.RuntimeExecutionException gInstance;
    public java.lang.Object hInstance;
    
    public RuntimeExecutionException(com.google.android.gms.tasks.RuntimeExecutionException param0, java.lang.Object param1) {
        gInstance = param0;
        hInstance = param1;
        wrapper = true;
    }
    
    public RuntimeExecutionException(java.lang.Throwable param0) {
    }
    
    public void setGInstance(com.google.android.gms.tasks.RuntimeExecutionException param0) {
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
    
    public static org.xms.g.tasks.RuntimeExecutionException dynamicCast(java.lang.Object param0) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static boolean isInstance(java.lang.Object param0) {
        throw new java.lang.RuntimeException("Not Supported");
    }
}
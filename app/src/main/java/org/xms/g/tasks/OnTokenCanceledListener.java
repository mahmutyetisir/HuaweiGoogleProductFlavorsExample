package org.xms.g.tasks;

public interface OnTokenCanceledListener extends org.xms.g.utils.XInterface {
    
    public void onCanceled();
    
    default com.google.android.gms.tasks.OnTokenCanceledListener getGInstanceOnTokenCanceledListener() {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    default java.lang.Object getHInstanceOnTokenCanceledListener() {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static org.xms.g.tasks.OnTokenCanceledListener dynamicCast(java.lang.Object param0) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static boolean isInstance(java.lang.Object param0) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static class XImpl extends org.xms.g.utils.XObject implements org.xms.g.tasks.OnTokenCanceledListener {
        
        public XImpl(com.google.android.gms.tasks.OnTokenCanceledListener param0, java.lang.Object param1) {
            super(param0, param1);
        }
        
        public static boolean isInstance(java.lang.Object param0) {
            throw new java.lang.RuntimeException("Not Supported");
        }
        
        public void onCanceled() {
            throw new java.lang.RuntimeException("Not Supported");
        }
    }
}
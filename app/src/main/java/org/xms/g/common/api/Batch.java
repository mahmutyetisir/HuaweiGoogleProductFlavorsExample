package org.xms.g.common.api;

public final class Batch extends org.xms.g.common.api.PendingResult<org.xms.g.common.api.Result> {
    
    public Batch(com.google.android.gms.common.api.Batch param0, java.lang.Object param1) {
        super(param0, null);
    }
    
    public java.lang.ref.WeakReference getMApiClient() {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public final void cancel() {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public void clearResultCallback() {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public final org.xms.g.common.api.BatchResult createFailedResult(org.xms.g.common.api.Status param0) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public boolean isCanceled() {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public org.xms.g.common.api.Result await() {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public org.xms.g.common.api.Result await(long param0, java.util.concurrent.TimeUnit param1) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public void setResultCallback(org.xms.g.common.api.ResultCallback<? super org.xms.g.common.api.Result> param0) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public void setResultCallback(org.xms.g.common.api.ResultCallback<? super org.xms.g.common.api.Result> param0, long param1, java.util.concurrent.TimeUnit param2) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static org.xms.g.common.api.Batch dynamicCast(java.lang.Object param0) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static boolean isInstance(java.lang.Object param0) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static final class Builder extends org.xms.g.utils.XObject {
        
        public Builder(com.google.android.gms.common.api.Batch.Builder param0, java.lang.Object param1) {
            super(param0, null);
        }
        
        public Builder(org.xms.g.common.api.ExtensionApiClient param0) {
            super(((com.google.android.gms.common.api.Batch.Builder) null), null);
        }
        
        public final <XR extends org.xms.g.common.api.Result> org.xms.g.common.api.BatchResultToken<XR> add(org.xms.g.common.api.PendingResult<XR> param0) {
            throw new java.lang.RuntimeException("Not Supported");
        }
        
        public final org.xms.g.common.api.Batch build() {
            throw new java.lang.RuntimeException("Not Supported");
        }
        
        public static org.xms.g.common.api.Batch.Builder dynamicCast(java.lang.Object param0) {
            throw new java.lang.RuntimeException("Not Supported");
        }
        
        public static boolean isInstance(java.lang.Object param0) {
            throw new java.lang.RuntimeException("Not Supported");
        }
    }
}
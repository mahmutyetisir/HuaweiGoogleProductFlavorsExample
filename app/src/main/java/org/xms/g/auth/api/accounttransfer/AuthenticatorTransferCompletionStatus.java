package org.xms.g.auth.api.accounttransfer;

public abstract class AuthenticatorTransferCompletionStatus extends org.xms.g.utils.XObject implements java.lang.annotation.Annotation {
    private boolean wrapper = true;
    
    public AuthenticatorTransferCompletionStatus(com.google.android.gms.auth.api.accounttransfer.AuthenticatorTransferCompletionStatus param0, java.lang.Object param1) {
        super(param0, null);
    }
    
    public static int getCOMPLETED_FAILURE() {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static int getCOMPLETED_SUCCESS() {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static org.xms.g.auth.api.accounttransfer.AuthenticatorTransferCompletionStatus dynamicCast(java.lang.Object param0) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static boolean isInstance(java.lang.Object param0) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static class XImpl extends org.xms.g.auth.api.accounttransfer.AuthenticatorTransferCompletionStatus {
        
        public XImpl(com.google.android.gms.auth.api.accounttransfer.AuthenticatorTransferCompletionStatus param0, java.lang.Object param1) {
            super(param0, param1);
        }
        
        public static boolean isInstance(java.lang.Object param0) {
            throw new java.lang.RuntimeException("Not Supported");
        }
        
        public boolean equals(java.lang.Object param0) {
            throw new java.lang.RuntimeException("Not Supported");
        }
        
        public int hashCode() {
            throw new java.lang.RuntimeException("Not Supported");
        }
        
        public java.lang.String toString() {
            throw new java.lang.RuntimeException("Not Supported");
        }
        
        public java.lang.Class<? extends java.lang.annotation.Annotation> annotationType() {
            throw new java.lang.RuntimeException("Not Supported");
        }
    }
}
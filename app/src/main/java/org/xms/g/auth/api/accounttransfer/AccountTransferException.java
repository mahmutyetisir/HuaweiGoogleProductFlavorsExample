package org.xms.g.auth.api.accounttransfer;

public class AccountTransferException extends org.xms.g.common.api.ApiException {
    private boolean wrapper = true;
    
    public AccountTransferException(com.google.android.gms.auth.api.accounttransfer.AccountTransferException param0, java.lang.Object param1) {
        super(param0, null);
    }
    
    public AccountTransferException(org.xms.g.common.api.Status param0) {
        super(((com.google.android.gms.auth.api.accounttransfer.AccountTransferException) null), null);
    }
    
    public static org.xms.g.auth.api.accounttransfer.AccountTransferException dynamicCast(java.lang.Object param0) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static boolean isInstance(java.lang.Object param0) {
        throw new java.lang.RuntimeException("Not Supported");
    }
}
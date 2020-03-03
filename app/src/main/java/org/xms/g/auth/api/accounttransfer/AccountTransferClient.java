package org.xms.g.auth.api.accounttransfer;

public class AccountTransferClient extends org.xms.g.common.api.ExtensionApi<org.xms.g.common.api.Api.ApiOptions> {
    private boolean wrapper = true;
    
    public AccountTransferClient(com.google.android.gms.auth.api.accounttransfer.AccountTransferClient param0, java.lang.Object param1) {
        super(param0, null);
    }
    
    public org.xms.g.tasks.Task<org.xms.g.auth.api.accounttransfer.DeviceMetaData> getDeviceMetaData(java.lang.String param0) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public org.xms.g.tasks.Task<java.lang.Void> notifyCompletion(java.lang.String param0, int param1) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public org.xms.g.tasks.Task<byte[]> retrieveData(java.lang.String param0) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public org.xms.g.tasks.Task<java.lang.Void> sendData(java.lang.String param0, byte[] param1) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public org.xms.g.tasks.Task<java.lang.Void> showUserChallenge(java.lang.String param0, android.app.PendingIntent param1) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public java.lang.Object getApiKey() {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static org.xms.g.auth.api.accounttransfer.AccountTransferClient dynamicCast(java.lang.Object param0) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static boolean isInstance(java.lang.Object param0) {
        throw new java.lang.RuntimeException("Not Supported");
    }
}
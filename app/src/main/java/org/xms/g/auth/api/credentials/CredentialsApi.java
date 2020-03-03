package org.xms.g.auth.api.credentials;

public interface CredentialsApi extends org.xms.g.utils.XInterface {
    
    public static int getACTIVITY_RESULT_ADD_ACCOUNT() {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static int getACTIVITY_RESULT_NO_HINTS_AVAILABLE() {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static int getACTIVITY_RESULT_OTHER_ACCOUNT() {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static int getCREDENTIAL_PICKER_REQUEST_CODE() {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public org.xms.g.common.api.PendingResult<org.xms.g.common.api.Status> delete(org.xms.g.common.api.ExtensionApiClient param0, org.xms.g.auth.api.credentials.Credential param1);
    
    public org.xms.g.common.api.PendingResult<org.xms.g.common.api.Status> disableAutoSignIn(org.xms.g.common.api.ExtensionApiClient param0);
    
    public android.app.PendingIntent getHintPickerIntent(org.xms.g.common.api.ExtensionApiClient param0, org.xms.g.auth.api.credentials.HintRequest param1);
    
    public org.xms.g.common.api.PendingResult<org.xms.g.auth.api.credentials.CredentialRequestResult> request(org.xms.g.common.api.ExtensionApiClient param0, org.xms.g.auth.api.credentials.CredentialRequest param1);
    
    public org.xms.g.common.api.PendingResult<org.xms.g.common.api.Status> save(org.xms.g.common.api.ExtensionApiClient param0, org.xms.g.auth.api.credentials.Credential param1);
    
    default com.google.android.gms.auth.api.credentials.CredentialsApi getGInstanceCredentialsApi() {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    default java.lang.Object getHInstanceCredentialsApi() {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static org.xms.g.auth.api.credentials.CredentialsApi dynamicCast(java.lang.Object param0) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static boolean isInstance(java.lang.Object param0) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static class XImpl extends org.xms.g.utils.XObject implements org.xms.g.auth.api.credentials.CredentialsApi {
        
        public XImpl(com.google.android.gms.auth.api.credentials.CredentialsApi param0, java.lang.Object param1) {
            super(param0, param1);
        }
        
        public static boolean isInstance(java.lang.Object param0) {
            throw new java.lang.RuntimeException("Not Supported");
        }
        
        public org.xms.g.common.api.PendingResult<org.xms.g.common.api.Status> delete(org.xms.g.common.api.ExtensionApiClient param0, org.xms.g.auth.api.credentials.Credential param1) {
            throw new java.lang.RuntimeException("Not Supported");
        }
        
        public org.xms.g.common.api.PendingResult<org.xms.g.common.api.Status> disableAutoSignIn(org.xms.g.common.api.ExtensionApiClient param0) {
            throw new java.lang.RuntimeException("Not Supported");
        }
        
        public android.app.PendingIntent getHintPickerIntent(org.xms.g.common.api.ExtensionApiClient param0, org.xms.g.auth.api.credentials.HintRequest param1) {
            throw new java.lang.RuntimeException("Not Supported");
        }
        
        public org.xms.g.common.api.PendingResult<org.xms.g.auth.api.credentials.CredentialRequestResult> request(org.xms.g.common.api.ExtensionApiClient param0, org.xms.g.auth.api.credentials.CredentialRequest param1) {
            throw new java.lang.RuntimeException("Not Supported");
        }
        
        public org.xms.g.common.api.PendingResult<org.xms.g.common.api.Status> save(org.xms.g.common.api.ExtensionApiClient param0, org.xms.g.auth.api.credentials.Credential param1) {
            throw new java.lang.RuntimeException("Not Supported");
        }
    }
}
package org.xms.g.auth.api.phone;

public abstract class SmsRetrieverClient extends org.xms.g.common.api.ExtensionApi<org.xms.g.common.api.Api.ApiOptions.NoOptions> {
    private boolean wrapper = true;
    
    public SmsRetrieverClient(com.google.android.gms.auth.api.phone.SmsRetrieverClient param0, java.lang.Object param1) {
        super(param0, null);
    }
    
    public abstract org.xms.g.tasks.Task<java.lang.Void> startSmsRetriever();
    
    public abstract org.xms.g.tasks.Task<java.lang.Void> startSmsUserConsent(java.lang.String param0);
    
    public static org.xms.g.auth.api.phone.SmsRetrieverClient dynamicCast(java.lang.Object param0) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static boolean isInstance(java.lang.Object param0) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static class XImpl extends org.xms.g.auth.api.phone.SmsRetrieverClient {
        
        public XImpl(com.google.android.gms.auth.api.phone.SmsRetrieverClient param0, java.lang.Object param1) {
            super(param0, param1);
        }
        
        public static boolean isInstance(java.lang.Object param0) {
            throw new java.lang.RuntimeException("Not Supported");
        }
        
        public org.xms.g.tasks.Task<java.lang.Void> startSmsRetriever() {
            throw new java.lang.RuntimeException("Not Supported");
        }
        
        public org.xms.g.tasks.Task<java.lang.Void> startSmsUserConsent(java.lang.String param0) {
            throw new java.lang.RuntimeException("Not Supported");
        }
        
        public java.lang.Object getApiKey() {
            throw new java.lang.RuntimeException("Not Supported");
        }
    }
}
package org.xms.g.auth.api.phone;

public interface SmsRetrieverApi extends org.xms.g.utils.XInterface {
    
    public org.xms.g.tasks.Task<java.lang.Void> startSmsRetriever();
    
    public org.xms.g.tasks.Task<java.lang.Void> startSmsUserConsent(java.lang.String param0);
    
    default com.google.android.gms.auth.api.phone.SmsRetrieverApi getGInstanceSmsRetrieverApi() {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    default java.lang.Object getHInstanceSmsRetrieverApi() {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static org.xms.g.auth.api.phone.SmsRetrieverApi dynamicCast(java.lang.Object param0) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static boolean isInstance(java.lang.Object param0) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static class XImpl extends org.xms.g.utils.XObject implements org.xms.g.auth.api.phone.SmsRetrieverApi {
        
        public XImpl(com.google.android.gms.auth.api.phone.SmsRetrieverApi param0, java.lang.Object param1) {
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
    }
}
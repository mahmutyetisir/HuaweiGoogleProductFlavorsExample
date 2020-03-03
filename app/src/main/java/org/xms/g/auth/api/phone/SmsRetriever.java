package org.xms.g.auth.api.phone;

public final class SmsRetriever extends org.xms.g.utils.XObject {
    
    public SmsRetriever(com.google.android.gms.auth.api.phone.SmsRetriever param0, com.huawei.hms.support.sms.common.ReadSmsConstant param1) {
        super(param0, null);
        this.setHInstance(param1);
    }
    
    public static java.lang.String getEXTRA_CONSENT_INTENT() {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static java.lang.String getEXTRA_SIM_SUBSCRIPTION_ID() {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static java.lang.String getEXTRA_SMS_MESSAGE() {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.huawei.hms.support.sms.common.ReadSmsConstant.EXTRA_SMS_MESSAGE", new Exception());
            return com.huawei.hms.support.sms.common.ReadSmsConstant.EXTRA_SMS_MESSAGE;
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.google.android.gms.auth.api.phone.SmsRetriever.EXTRA_SMS_MESSAGE", new Exception());
            return com.google.android.gms.auth.api.phone.SmsRetriever.EXTRA_SMS_MESSAGE;
        }
    }
    
    public static java.lang.String getEXTRA_STATUS() {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.huawei.hms.support.sms.common.ReadSmsConstant.EXTRA_STATUS", new Exception());
            return com.huawei.hms.support.sms.common.ReadSmsConstant.EXTRA_STATUS;
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.google.android.gms.auth.api.phone.SmsRetriever.EXTRA_STATUS", new Exception());
            return com.google.android.gms.auth.api.phone.SmsRetriever.EXTRA_STATUS;
        }
    }
    
    public static java.lang.String getSMS_RETRIEVED_ACTION() {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.huawei.hms.support.sms.common.ReadSmsConstant.READ_SMS_BROADCAST_ACTION", new Exception());
            return com.huawei.hms.support.sms.common.ReadSmsConstant.READ_SMS_BROADCAST_ACTION;
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.google.android.gms.auth.api.phone.SmsRetriever.SMS_RETRIEVED_ACTION", new Exception());
            return com.google.android.gms.auth.api.phone.SmsRetriever.SMS_RETRIEVED_ACTION;
        }
    }
    
    public static org.xms.g.auth.api.phone.SmsRetrieverClient getClient(android.app.Activity param0) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static org.xms.g.auth.api.phone.SmsRetrieverClient getClient(android.content.Context param0) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static org.xms.g.auth.api.phone.SmsRetriever dynamicCast(java.lang.Object param0) {
        return ((org.xms.g.auth.api.phone.SmsRetriever) param0);
    }
    
    public static boolean isInstance(java.lang.Object param0) {
        if (!(param0 instanceof org.xms.g.utils.XObject)) {
            return false;
        }
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hms.support.sms.common.ReadSmsConstant;
        } else {
            return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.auth.api.phone.SmsRetriever;
        }
    }
}
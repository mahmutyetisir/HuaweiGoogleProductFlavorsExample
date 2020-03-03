package org.xms.g.common.api;

public final class Status extends org.xms.g.utils.XObject implements org.xms.g.common.api.Result, android.os.Parcelable {
    public final static android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {
        
        public org.xms.g.common.api.Status createFromParcel(android.os.Parcel param0) {
            com.google.android.gms.common.api.Status gReturn = null;
            com.huawei.hms.support.api.client.Status hReturn = null;
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                hReturn = com.huawei.hms.support.api.client.Status.CREATOR.createFromParcel(param0);
            } else {
                gReturn = com.google.android.gms.common.api.Status.CREATOR.createFromParcel(param0);
            }
            return new org.xms.g.common.api.Status(gReturn, hReturn);
        }
        
        public org.xms.g.common.api.Status[] newArray(int param0) {
            return new org.xms.g.common.api.Status[param0];
        }
    };
    
    public Status(com.google.android.gms.common.api.Status param0, com.huawei.hms.support.api.client.Status param1) {
        super(param0, null);
        this.setHInstance(param1);
    }
    
    public Status(int param0) {
        super(((com.google.android.gms.common.api.Status) null), null);
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            this.setHInstance(new com.huawei.hms.support.api.client.Status(param0));
        } else {
            this.setGInstance(new com.google.android.gms.common.api.Status(param0));
        }
    }
    
    public Status(int param0, java.lang.String param1) {
        super(((com.google.android.gms.common.api.Status) null), null);
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            this.setHInstance(new com.huawei.hms.support.api.client.Status(param0, param1));
        } else {
            this.setGInstance(new com.google.android.gms.common.api.Status(param0, param1));
        }
    }
    
    public Status(int param0, java.lang.String param1, android.app.PendingIntent param2) {
        super(((com.google.android.gms.common.api.Status) null), null);
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            this.setHInstance(new com.huawei.hms.support.api.client.Status(param0, param1, param2));
        } else {
            this.setGInstance(new com.google.android.gms.common.api.Status(param0, param1, param2));
        }
    }
    
    public boolean equals(java.lang.Object param0) {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.support.api.client.Status) this.getHInstance()).equals(param0)", new Exception());
            return ((com.huawei.hms.support.api.client.Status) this.getHInstance()).equals(param0);
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.common.api.Status) this.getGInstance()).equals(param0)", new Exception());
            return ((com.google.android.gms.common.api.Status) this.getGInstance()).equals(param0);
        }
    }
    
    public final android.app.PendingIntent getResolution() {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.support.api.client.Status) this.getHInstance()).getResolution()", new Exception());
            return ((com.huawei.hms.support.api.client.Status) this.getHInstance()).getResolution();
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.common.api.Status) this.getGInstance()).getResolution()", new Exception());
            return ((com.google.android.gms.common.api.Status) this.getGInstance()).getResolution();
        }
    }
    
    public final org.xms.g.common.api.Status getStatus() {
        com.google.android.gms.common.api.Status gReturn = null;
        com.huawei.hms.support.api.client.Status hReturn = null;
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.support.api.client.Status) this.getHInstance()).getStatus()", new Exception());
            hReturn = ((com.huawei.hms.support.api.client.Status) this.getHInstance()).getStatus();
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.common.api.Status) this.getGInstance()).getStatus()", new Exception());
            gReturn = ((com.google.android.gms.common.api.Status) this.getGInstance()).getStatus();
        }
        if (gReturn == null && hReturn == null) {
            return null;
        }
        return new org.xms.g.common.api.Status(gReturn, hReturn);
    }
    
    public final int getStatusCode() {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.support.api.client.Status) this.getHInstance()).getStatusCode()", new Exception());
            return ((com.huawei.hms.support.api.client.Status) this.getHInstance()).getStatusCode();
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.common.api.Status) this.getGInstance()).getStatusCode()", new Exception());
            return ((com.google.android.gms.common.api.Status) this.getGInstance()).getStatusCode();
        }
    }
    
    public final java.lang.String getStatusMessage() {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.support.api.client.Status) this.getHInstance()).getStatusMessage()", new Exception());
            return ((com.huawei.hms.support.api.client.Status) this.getHInstance()).getStatusMessage();
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.common.api.Status) this.getGInstance()).getStatusMessage()", new Exception());
            return ((com.google.android.gms.common.api.Status) this.getGInstance()).getStatusMessage();
        }
    }
    
    public final boolean hasResolution() {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.support.api.client.Status) this.getHInstance()).hasResolution()", new Exception());
            return ((com.huawei.hms.support.api.client.Status) this.getHInstance()).hasResolution();
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.common.api.Status) this.getGInstance()).hasResolution()", new Exception());
            return ((com.google.android.gms.common.api.Status) this.getGInstance()).hasResolution();
        }
    }
    
    public final int hashCode() {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.support.api.client.Status) this.getHInstance()).hashCode()", new Exception());
            return ((com.huawei.hms.support.api.client.Status) this.getHInstance()).hashCode();
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.common.api.Status) this.getGInstance()).hashCode()", new Exception());
            return ((com.google.android.gms.common.api.Status) this.getGInstance()).hashCode();
        }
    }
    
    public final boolean isCanceled() {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.support.api.client.Status) this.getHInstance()).isCanceled()", new Exception());
            return ((com.huawei.hms.support.api.client.Status) this.getHInstance()).isCanceled();
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.common.api.Status) this.getGInstance()).isCanceled()", new Exception());
            return ((com.google.android.gms.common.api.Status) this.getGInstance()).isCanceled();
        }
    }
    
    public final boolean isInterrupted() {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.support.api.client.Status) this.getHInstance()).isInterrupted()", new Exception());
            return ((com.huawei.hms.support.api.client.Status) this.getHInstance()).isInterrupted();
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.common.api.Status) this.getGInstance()).isInterrupted()", new Exception());
            return ((com.google.android.gms.common.api.Status) this.getGInstance()).isInterrupted();
        }
    }
    
    public final boolean isSuccess() {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.support.api.client.Status) this.getHInstance()).isSuccess()", new Exception());
            return ((com.huawei.hms.support.api.client.Status) this.getHInstance()).isSuccess();
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.common.api.Status) this.getGInstance()).isSuccess()", new Exception());
            return ((com.google.android.gms.common.api.Status) this.getGInstance()).isSuccess();
        }
    }
    
    public void startResolutionForResult(android.app.Activity param0, int param1) throws android.content.IntentSender.SendIntentException {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.support.api.client.Status) this.getHInstance()).startResolutionForResult(param0, param1)", new Exception());
            ((com.huawei.hms.support.api.client.Status) this.getHInstance()).startResolutionForResult(param0, param1);
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.common.api.Status) this.getGInstance()).startResolutionForResult(param0, param1)", new Exception());
            ((com.google.android.gms.common.api.Status) this.getGInstance()).startResolutionForResult(param0, param1);
        }
    }
    
    public final java.lang.String toString() {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.support.api.client.Status) this.getHInstance()).toString()", new Exception());
            return ((com.huawei.hms.support.api.client.Status) this.getHInstance()).toString();
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.common.api.Status) this.getGInstance()).toString()", new Exception());
            return ((com.google.android.gms.common.api.Status) this.getGInstance()).toString();
        }
    }
    
    public void writeToParcel(android.os.Parcel param0, int param1) {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.support.api.client.Status) this.getHInstance()).writeToParcel(param0, param1)", new Exception());
            ((com.huawei.hms.support.api.client.Status) this.getHInstance()).writeToParcel(param0, param1);
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.common.api.Status) this.getGInstance()).writeToParcel(param0, param1)", new Exception());
            ((com.google.android.gms.common.api.Status) this.getGInstance()).writeToParcel(param0, param1);
        }
    }
    
    public int describeContents() {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static org.xms.g.common.api.Status dynamicCast(java.lang.Object param0) {
        if (param0 instanceof org.xms.g.common.api.Status) {
            return ((org.xms.g.common.api.Status) param0);
        }
        if (param0 instanceof org.xms.g.utils.XGettable) {
            com.google.android.gms.common.api.Status gReturn = ((com.google.android.gms.common.api.Status) ((org.xms.g.utils.XGettable) param0).getGInstance());
            com.huawei.hms.support.api.client.Status hReturn = ((com.huawei.hms.support.api.client.Status) ((org.xms.g.utils.XGettable) param0).getHInstance());
            return new org.xms.g.common.api.Status(gReturn, hReturn);
        }
        return ((org.xms.g.common.api.Status) param0);
    }
    
    public static boolean isInstance(java.lang.Object param0) {
        if (!(param0 instanceof org.xms.g.utils.XObject)) {
            return false;
        }
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hms.support.api.client.Status;
        } else {
            return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.common.api.Status;
        }
    }
}
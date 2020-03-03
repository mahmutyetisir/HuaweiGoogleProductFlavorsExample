package org.xms.g.common.api;

public final class PendingResults extends org.xms.g.utils.XObject {
    
    public PendingResults(com.google.android.gms.common.api.PendingResults param0, com.huawei.hms.support.api.client.PendingResultsCreator param1) {
        super(param0, null);
        this.setHInstance(param1);
    }
    
    public static org.xms.g.common.api.PendingResult<org.xms.g.common.api.Status> canceledPendingResult() {
        com.google.android.gms.common.api.PendingResult gReturn = null;
        com.huawei.hms.support.api.client.PendingResult hReturn = null;
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.huawei.hms.support.api.client.PendingResultsCreator.discardedPendingResult()", new Exception());
            hReturn = com.huawei.hms.support.api.client.PendingResultsCreator.discardedPendingResult();
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.google.android.gms.common.api.PendingResults.canceledPendingResult()", new Exception());
            gReturn = com.google.android.gms.common.api.PendingResults.canceledPendingResult();
        }
        if (gReturn == null && hReturn == null) {
            return null;
        }
        return new org.xms.g.common.api.PendingResult.XImpl(gReturn, hReturn);
    }
    
    public static <XR extends org.xms.g.common.api.Result> org.xms.g.common.api.PendingResult<XR> canceledPendingResult(XR param0) {
        com.google.android.gms.common.api.PendingResult gReturn = null;
        com.huawei.hms.support.api.client.PendingResult hReturn = null;
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            java.lang.Object hObj0 = org.xms.g.utils.Utils.getInstanceInInterface(param0, true);
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.huawei.hms.support.api.client.PendingResultsCreator.discardedPendingResult(((com.huawei.hms.support.api.client.Result) hObj0))", new Exception());
            hReturn = com.huawei.hms.support.api.client.PendingResultsCreator.discardedPendingResult(((com.huawei.hms.support.api.client.Result) hObj0));
        } else {
            java.lang.Object gObj0 = org.xms.g.utils.Utils.getInstanceInInterface(param0, false);
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.google.android.gms.common.api.PendingResults.canceledPendingResult(((com.google.android.gms.common.api.Result) gObj0))", new Exception());
            gReturn = com.google.android.gms.common.api.PendingResults.canceledPendingResult(((com.google.android.gms.common.api.Result) gObj0));
        }
        if (gReturn == null && hReturn == null) {
            return null;
        }
        return new org.xms.g.common.api.PendingResult.XImpl(gReturn, hReturn);
    }
    
    public static <XR extends org.xms.g.common.api.Result> org.xms.g.common.api.OptionalPendingResult<XR> immediatePendingResult(XR param0) {
        com.google.android.gms.common.api.OptionalPendingResult gReturn = null;
        com.huawei.hms.common.api.OptionalPendingResult hReturn = null;
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            java.lang.Object hObj0 = org.xms.g.utils.Utils.getInstanceInInterface(param0, true);
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.huawei.hms.support.api.client.PendingResultsCreator.instantPendingResult(((com.huawei.hms.support.api.client.Result) hObj0))", new Exception());
            hReturn = com.huawei.hms.support.api.client.PendingResultsCreator.instantPendingResult(((com.huawei.hms.support.api.client.Result) hObj0));
        } else {
            java.lang.Object gObj0 = org.xms.g.utils.Utils.getInstanceInInterface(param0, false);
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.google.android.gms.common.api.PendingResults.immediatePendingResult(((com.google.android.gms.common.api.Result) gObj0))", new Exception());
            gReturn = com.google.android.gms.common.api.PendingResults.immediatePendingResult(((com.google.android.gms.common.api.Result) gObj0));
        }
        if (gReturn == null && hReturn == null) {
            return null;
        }
        return new org.xms.g.common.api.OptionalPendingResult.XImpl(gReturn, hReturn);
    }
    
    public static org.xms.g.common.api.PendingResult<org.xms.g.common.api.Status> immediatePendingResult(org.xms.g.common.api.Status param0) {
        com.google.android.gms.common.api.PendingResult gReturn = null;
        com.huawei.hms.support.api.client.PendingResult hReturn = null;
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.huawei.hms.support.api.client.PendingResultsCreator.instantPendingResult(((com.huawei.hms.support.api.client.Status) ((param0) == null ? null : (param0.getHInstance()))))", new Exception());
            hReturn = com.huawei.hms.support.api.client.PendingResultsCreator.instantPendingResult(((com.huawei.hms.support.api.client.Status) ((param0) == null ? null : (param0.getHInstance()))));
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.google.android.gms.common.api.PendingResults.immediatePendingResult(((com.google.android.gms.common.api.Status) ((param0) == null ? null : (param0.getGInstance()))))", new Exception());
            gReturn = com.google.android.gms.common.api.PendingResults.immediatePendingResult(((com.google.android.gms.common.api.Status) ((param0) == null ? null : (param0.getGInstance()))));
        }
        if (gReturn == null && hReturn == null) {
            return null;
        }
        return new org.xms.g.common.api.PendingResult.XImpl(gReturn, hReturn);
    }
    
    public static org.xms.g.common.api.PendingResults dynamicCast(java.lang.Object param0) {
        return ((org.xms.g.common.api.PendingResults) param0);
    }
    
    public static boolean isInstance(java.lang.Object param0) {
        if (!(param0 instanceof org.xms.g.utils.XObject)) {
            return false;
        }
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hms.support.api.client.PendingResultsCreator;
        } else {
            return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.common.api.PendingResults;
        }
    }
}
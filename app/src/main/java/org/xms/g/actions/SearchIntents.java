package org.xms.g.actions;

public class SearchIntents extends org.xms.g.utils.XObject {
    private boolean wrapper = true;
    
    public SearchIntents(com.google.android.gms.actions.SearchIntents param0, com.huawei.hms.actions.SearchIntents param1) {
        super(param0, null);
        this.setHInstance(param1);
        wrapper = true;
    }
    
    public static java.lang.String getACTION_SEARCH() {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.huawei.hms.actions.SearchIntents.ACTION_SEARCH", new Exception());
            return com.huawei.hms.actions.SearchIntents.ACTION_SEARCH;
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.google.android.gms.actions.SearchIntents.ACTION_SEARCH", new Exception());
            return com.google.android.gms.actions.SearchIntents.ACTION_SEARCH;
        }
    }
    
    public static java.lang.String getEXTRA_QUERY() {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.huawei.hms.actions.SearchIntents.EXTRA_QUERY", new Exception());
            return com.huawei.hms.actions.SearchIntents.EXTRA_QUERY;
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.google.android.gms.actions.SearchIntents.EXTRA_QUERY", new Exception());
            return com.google.android.gms.actions.SearchIntents.EXTRA_QUERY;
        }
    }
    
    public static org.xms.g.actions.SearchIntents dynamicCast(java.lang.Object param0) {
        return ((org.xms.g.actions.SearchIntents) param0);
    }
    
    public static boolean isInstance(java.lang.Object param0) {
        if (!(param0 instanceof org.xms.g.utils.XObject)) {
            return false;
        }
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hms.actions.SearchIntents;
        } else {
            return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.actions.SearchIntents;
        }
    }
}
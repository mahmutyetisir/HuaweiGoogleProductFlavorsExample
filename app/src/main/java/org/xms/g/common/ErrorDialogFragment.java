package org.xms.g.common;

public class ErrorDialogFragment extends androidx.fragment.app.DialogFragment implements org.xms.g.utils.XGettable {
    public com.google.android.gms.common.ErrorDialogFragment gInstance;
    public com.huawei.hms.common.ErrorDialogFragment hInstance;
    private boolean wrapper = true;

    public ErrorDialogFragment(com.google.android.gms.common.ErrorDialogFragment param0, com.huawei.hms.common.ErrorDialogFragment param1) {
        gInstance = param0;
        hInstance = param1;
        wrapper = true;
    }

    public ErrorDialogFragment() {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            this.setHInstance(new com.huawei.hms.common.ErrorDialogFragment());
        } else {
            this.setGInstance(new com.google.android.gms.common.ErrorDialogFragment());
        }
        wrapper = true;
    }

    public static org.xms.g.common.ErrorDialogFragment newInstance(android.app.Dialog param0, android.content.DialogInterface.OnCancelListener param1) {
        com.google.android.gms.common.ErrorDialogFragment gReturn = null;
        com.huawei.hms.common.ErrorDialogFragment hReturn = null;
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.huawei.hms.common.ErrorDialogFragment.newInstance(param0, param1)", new Exception());
            hReturn = com.huawei.hms.common.ErrorDialogFragment.newInstance(param0, param1);
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.google.android.gms.common.ErrorDialogFragment.newInstance(param0, param1)", new Exception());
            gReturn = com.google.android.gms.common.ErrorDialogFragment.newInstance(param0, param1);
        }
        if (gReturn == null && hReturn == null) {
            return null;
        }
        return new org.xms.g.common.ErrorDialogFragment(gReturn, hReturn);
    }

    public static org.xms.g.common.ErrorDialogFragment newInstance(android.app.Dialog param0) {
        com.google.android.gms.common.ErrorDialogFragment gReturn = null;
        com.huawei.hms.common.ErrorDialogFragment hReturn = null;
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.huawei.hms.common.ErrorDialogFragment.newInstance(param0)", new Exception());
            hReturn = com.huawei.hms.common.ErrorDialogFragment.newInstance(param0);
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.google.android.gms.common.ErrorDialogFragment.newInstance(param0)", new Exception());
            gReturn = com.google.android.gms.common.ErrorDialogFragment.newInstance(param0);
        }
        if (gReturn == null && hReturn == null) {
            return null;
        }
        return new org.xms.g.common.ErrorDialogFragment(gReturn, hReturn);
    }

    public void onCancel(android.content.DialogInterface param0) {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.common.ErrorDialogFragment) this.getHInstance()).onCancel(param0)", new Exception());
            ((com.huawei.hms.common.ErrorDialogFragment) this.getHInstance()).onCancel(param0);
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.common.ErrorDialogFragment) this.getGInstance()).onCancel(param0)", new Exception());
            ((com.google.android.gms.common.ErrorDialogFragment) this.getGInstance()).onCancel(param0);
        }
    }

    public android.app.Dialog onCreateDialog(android.os.Bundle param0) {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.common.ErrorDialogFragment) this.getHInstance()).onCreateDialog(param0)", new Exception());
            return ((com.huawei.hms.common.ErrorDialogFragment) this.getHInstance()).onCreateDialog(param0);
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.common.ErrorDialogFragment) this.getGInstance()).onCreateDialog(param0)", new Exception());
            return ((com.google.android.gms.common.ErrorDialogFragment) this.getGInstance()).onCreateDialog(param0);
        }
    }

    public void show(android.app.FragmentManager param0, java.lang.String param1) {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.common.ErrorDialogFragment) this.getHInstance()).show(param0, param1)", new Exception());
            ((com.huawei.hms.common.ErrorDialogFragment) this.getHInstance()).show(param0, param1);
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.common.ErrorDialogFragment) this.getGInstance()).show(param0, param1)", new Exception());
            ((com.google.android.gms.common.ErrorDialogFragment) this.getGInstance()).show(param0, param1);
        }
    }

    public void setGInstance(com.google.android.gms.common.ErrorDialogFragment param0) {
        this.gInstance = param0;
    }

    public void setHInstance(com.huawei.hms.common.ErrorDialogFragment param0) {
        this.hInstance = param0;
    }

    public java.lang.Object getGInstance() {
        return this.gInstance;
    }

    public java.lang.Object getHInstance() {
        return this.hInstance;
    }

    public static org.xms.g.common.ErrorDialogFragment dynamicCast(java.lang.Object param0) {
        if (param0 instanceof org.xms.g.common.ErrorDialogFragment) {
            return ((org.xms.g.common.ErrorDialogFragment) param0);
        }
        if (param0 instanceof org.xms.g.utils.XGettable) {
            com.google.android.gms.common.ErrorDialogFragment gReturn = ((com.google.android.gms.common.ErrorDialogFragment) ((org.xms.g.utils.XGettable) param0).getGInstance());
            com.huawei.hms.common.ErrorDialogFragment hReturn = ((com.huawei.hms.common.ErrorDialogFragment) ((org.xms.g.utils.XGettable) param0).getHInstance());
            return new org.xms.g.common.ErrorDialogFragment(gReturn, hReturn);
        }
        return ((org.xms.g.common.ErrorDialogFragment) param0);
    }

    public static boolean isInstance(java.lang.Object param0) {
        if (!(param0 instanceof org.xms.g.utils.XObject)) {
            return false;
        }
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hms.common.ErrorDialogFragment;
        } else {
            return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.common.ErrorDialogFragment;
        }
    }
}

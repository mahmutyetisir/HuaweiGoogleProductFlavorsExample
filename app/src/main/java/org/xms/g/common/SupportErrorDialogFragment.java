package org.xms.g.common;

public class SupportErrorDialogFragment extends androidx.fragment.app.DialogFragment implements org.xms.g.utils.XGettable {
    private boolean wrapper = true;
    public com.google.android.gms.common.SupportErrorDialogFragment gInstance;
    public com.huawei.hms.common.ErrDlgFragmentForSupport hInstance;
    
    public SupportErrorDialogFragment(com.google.android.gms.common.SupportErrorDialogFragment param0, com.huawei.hms.common.ErrDlgFragmentForSupport param1) {
        gInstance = param0;
        hInstance = param1;
        wrapper = true;
    }
    
    public SupportErrorDialogFragment() {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            this.setHInstance(new HImpl());
        } else {
            this.setGInstance(new GImpl());
        }
        wrapper = false;
    }
    
    public static org.xms.g.common.SupportErrorDialogFragment newInstance(android.app.Dialog param0, android.content.DialogInterface.OnCancelListener param1) {
        com.google.android.gms.common.SupportErrorDialogFragment gReturn = null;
        com.huawei.hms.common.ErrDlgFragmentForSupport hReturn = null;
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.huawei.hms.common.ErrDlgFragmentForSupport.newInstance(param0, param1)", new Exception());
            hReturn = com.huawei.hms.common.ErrDlgFragmentForSupport.newInstance(param0, param1);
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.google.android.gms.common.SupportErrorDialogFragment.newInstance(param0, param1)", new Exception());
            gReturn = com.google.android.gms.common.SupportErrorDialogFragment.newInstance(param0, param1);
        }
        if (gReturn == null && hReturn == null) {
            return null;
        }
        return new org.xms.g.common.SupportErrorDialogFragment(gReturn, hReturn);
    }
    
    public static org.xms.g.common.SupportErrorDialogFragment newInstance(android.app.Dialog param0) {
        com.google.android.gms.common.SupportErrorDialogFragment gReturn = null;
        com.huawei.hms.common.ErrDlgFragmentForSupport hReturn = null;
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.huawei.hms.common.ErrDlgFragmentForSupport.newInstance(param0)", new Exception());
            hReturn = com.huawei.hms.common.ErrDlgFragmentForSupport.newInstance(param0);
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.google.android.gms.common.SupportErrorDialogFragment.newInstance(param0)", new Exception());
            gReturn = com.google.android.gms.common.SupportErrorDialogFragment.newInstance(param0);
        }
        if (gReturn == null && hReturn == null) {
            return null;
        }
        return new org.xms.g.common.SupportErrorDialogFragment(gReturn, hReturn);
    }
    
    public void onCancel(android.content.DialogInterface param0) {
        if (wrapper) {
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.common.ErrDlgFragmentForSupport) this.getHInstance()).onCancel(param0)", new Exception());
                ((com.huawei.hms.common.ErrDlgFragmentForSupport) this.getHInstance()).onCancel(param0);
            } else {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.common.SupportErrorDialogFragment) this.getGInstance()).onCancel(param0)", new Exception());
                ((com.google.android.gms.common.SupportErrorDialogFragment) this.getGInstance()).onCancel(param0);
            }
        } else {
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                ((HImpl) ((com.huawei.hms.common.ErrDlgFragmentForSupport) this.getHInstance())).onCancelCallSuper(param0);
            } else {
                ((GImpl) ((com.google.android.gms.common.SupportErrorDialogFragment) this.getGInstance())).onCancelCallSuper(param0);
            }
        }
    }
    
    public android.app.Dialog onCreateDialog(android.os.Bundle param0) {
        if (wrapper) {
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.common.ErrDlgFragmentForSupport) this.getHInstance()).onCreateDialog(param0)", new Exception());
                return ((com.huawei.hms.common.ErrDlgFragmentForSupport) this.getHInstance()).onCreateDialog(param0);
            } else {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.common.SupportErrorDialogFragment) this.getGInstance()).onCreateDialog(param0)", new Exception());
                return ((com.google.android.gms.common.SupportErrorDialogFragment) this.getGInstance()).onCreateDialog(param0);
            }
        } else {
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                return ((HImpl) ((com.huawei.hms.common.ErrDlgFragmentForSupport) this.getHInstance())).onCreateDialogCallSuper(param0);
            } else {
                return ((GImpl) ((com.google.android.gms.common.SupportErrorDialogFragment) this.getGInstance())).onCreateDialogCallSuper(param0);
            }
        }
    }
    
    public void show(androidx.fragment.app.FragmentManager param0, java.lang.String param1) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public void setGInstance(com.google.android.gms.common.SupportErrorDialogFragment param0) {
        this.gInstance = param0;
    }
    
    public void setHInstance(com.huawei.hms.common.ErrDlgFragmentForSupport param0) {
        this.hInstance = param0;
    }
    
    public java.lang.Object getGInstance() {
        return this.gInstance;
    }
    
    public java.lang.Object getHInstance() {
        return this.hInstance;
    }
    
    public static org.xms.g.common.SupportErrorDialogFragment dynamicCast(java.lang.Object param0) {
        return ((org.xms.g.common.SupportErrorDialogFragment) param0);
    }
    
    public static boolean isInstance(java.lang.Object param0) {
        if (!(param0 instanceof org.xms.g.utils.XObject)) {
            return false;
        }
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hms.common.ErrDlgFragmentForSupport;
        } else {
            return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.common.SupportErrorDialogFragment;
        }
    }
    
    public class GImpl extends com.google.android.gms.common.SupportErrorDialogFragment {
        
        public void onCancel(android.content.DialogInterface param0) {
            org.xms.g.common.SupportErrorDialogFragment.this.onCancel(param0);
        }
        
        public android.app.Dialog onCreateDialog(android.os.Bundle param0) {
            return org.xms.g.common.SupportErrorDialogFragment.this.onCreateDialog(param0);
        }
        
        public void show(androidx.fragment.app.FragmentManager param0, java.lang.String param1) {
            throw new java.lang.RuntimeException("Not Supported");
        }
        
        public void onCancelCallSuper(android.content.DialogInterface param0) {
            super.onCancel(param0);
        }
        
        public android.app.Dialog onCreateDialogCallSuper(android.os.Bundle param0) {
            return super.onCreateDialog(param0);
        }
        
        public void showCallSuper(androidx.fragment.app.FragmentManager param0, java.lang.String param1) {
            super.show(param0, param1);
        }
        
        public GImpl() {
            super();
        }
    }
    
    public class HImpl extends com.huawei.hms.common.ErrDlgFragmentForSupport {
        
        public void onCancel(android.content.DialogInterface param0) {
            org.xms.g.common.SupportErrorDialogFragment.this.onCancel(param0);
        }
        
        public android.app.Dialog onCreateDialog(android.os.Bundle param0) {
            return org.xms.g.common.SupportErrorDialogFragment.this.onCreateDialog(param0);
        }
        
        public void onCancelCallSuper(android.content.DialogInterface param0) {
            super.onCancel(param0);
        }
        
        public android.app.Dialog onCreateDialogCallSuper(android.os.Bundle param0) {
            return super.onCreateDialog(param0);
        }
        
        public HImpl() {
            super();
        }
    }
}
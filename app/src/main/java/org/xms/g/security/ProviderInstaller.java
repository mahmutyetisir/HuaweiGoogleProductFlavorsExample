package org.xms.g.security;

public class ProviderInstaller extends org.xms.g.utils.XObject {
    private boolean wrapper = true;
    
    public ProviderInstaller(com.google.android.gms.security.ProviderInstaller param0, com.huawei.hms.security.SecComponentInstallWizard param1) {
        super(param0, null);
        this.setHInstance(param1);
        wrapper = true;
    }
    
    public ProviderInstaller() {
        super(((com.google.android.gms.security.ProviderInstaller) null), null);
    }
    
    public static java.lang.String getPROVIDER_NAME() {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static void installIfNeeded(android.content.Context param0) throws org.xms.g.common.ExtensionPlayServicesRepairableException, org.xms.g.common.ExtensionPlayServicesNotAvailableException {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            try {
                org.xms.g.utils.XmsLog.d("XMSRouter", "com.huawei.hms.security.SecComponentInstallWizard.install(param0)", new Exception());
                com.huawei.hms.security.SecComponentInstallWizard.install(param0);
            }
            catch (com.huawei.hms.api.HuaweiServicesRepairableException e) {
                throw new org.xms.g.common.ExtensionPlayServicesRepairableException(((com.google.android.gms.common.GooglePlayServicesRepairableException) null), e);
            }
            catch (com.huawei.hms.api.HuaweiServicesNotAvailableException e) {
                throw new org.xms.g.common.ExtensionPlayServicesNotAvailableException(((com.google.android.gms.common.GooglePlayServicesNotAvailableException) null), e);
            }
        } else {
            try {
                org.xms.g.utils.XmsLog.d("XMSRouter", "com.google.android.gms.security.ProviderInstaller.installIfNeeded(param0)", new Exception());
                com.google.android.gms.security.ProviderInstaller.installIfNeeded(param0);
            }
            catch (com.google.android.gms.common.GooglePlayServicesRepairableException e) {
                throw new org.xms.g.common.ExtensionPlayServicesRepairableException(e, ((com.huawei.hms.api.HuaweiServicesRepairableException) null));
            }
            catch (com.google.android.gms.common.GooglePlayServicesNotAvailableException e) {
                throw new org.xms.g.common.ExtensionPlayServicesNotAvailableException(e, ((com.huawei.hms.api.HuaweiServicesNotAvailableException) null));
            }
        }
    }
    
    public static void installIfNeededAsync(android.content.Context param0, org.xms.g.security.ProviderInstaller.ProviderInstallListener param1) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static org.xms.g.security.ProviderInstaller dynamicCast(java.lang.Object param0) {
        return ((org.xms.g.security.ProviderInstaller) param0);
    }
    
    public static boolean isInstance(java.lang.Object param0) {
        if (!(param0 instanceof org.xms.g.utils.XObject)) {
            return false;
        }
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hms.security.SecComponentInstallWizard;
        } else {
            return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.security.ProviderInstaller;
        }
    }
    
    public static interface ProviderInstallListener extends org.xms.g.utils.XInterface {
        
        public void onProviderInstallFailed(int param0, android.content.Intent param1);
        
        public void onProviderInstalled();
        
        default com.google.android.gms.security.ProviderInstaller.ProviderInstallListener getGInstanceProviderInstallListener() {
            if (this instanceof org.xms.g.utils.XGettable) {
                return ((com.google.android.gms.security.ProviderInstaller.ProviderInstallListener) ((org.xms.g.utils.XGettable) this).getGInstance());
            }
            return new com.google.android.gms.security.ProviderInstaller.ProviderInstallListener() {
                
                public void onProviderInstallFailed(int param0, android.content.Intent param1) {
                    org.xms.g.security.ProviderInstaller.ProviderInstallListener.this.onProviderInstallFailed(param0, param1);
                }
                
                public void onProviderInstalled() {
                    org.xms.g.security.ProviderInstaller.ProviderInstallListener.this.onProviderInstalled();
                }
            };
        }
        
        default com.huawei.hms.security.SecComponentInstallWizard.SecComponentInstallWizardListener getHInstanceProviderInstallListener() {
            if (this instanceof org.xms.g.utils.XGettable) {
                return ((com.huawei.hms.security.SecComponentInstallWizard.SecComponentInstallWizardListener) ((org.xms.g.utils.XGettable) this).getHInstance());
            }
            return new com.huawei.hms.security.SecComponentInstallWizard.SecComponentInstallWizardListener() {
                
                public void onFailed(int param0, android.content.Intent param1) {
                    org.xms.g.security.ProviderInstaller.ProviderInstallListener.this.onProviderInstallFailed(param0, param1);
                }
                
                public void onSuccess() {
                    org.xms.g.security.ProviderInstaller.ProviderInstallListener.this.onProviderInstalled();
                }
            };
        }
        
        public static org.xms.g.security.ProviderInstaller.ProviderInstallListener dynamicCast(java.lang.Object param0) {
            if (param0 instanceof org.xms.g.security.ProviderInstaller.ProviderInstallListener) {
                return ((org.xms.g.security.ProviderInstaller.ProviderInstallListener) param0);
            }
            if (param0 instanceof org.xms.g.utils.XGettable) {
                com.google.android.gms.security.ProviderInstaller.ProviderInstallListener gReturn = ((com.google.android.gms.security.ProviderInstaller.ProviderInstallListener) ((org.xms.g.utils.XGettable) param0).getGInstance());
                com.huawei.hms.security.SecComponentInstallWizard.SecComponentInstallWizardListener hReturn = ((com.huawei.hms.security.SecComponentInstallWizard.SecComponentInstallWizardListener) ((org.xms.g.utils.XGettable) param0).getHInstance());
                return new org.xms.g.security.ProviderInstaller.ProviderInstallListener.XImpl(gReturn, hReturn);
            }
            return ((org.xms.g.security.ProviderInstaller.ProviderInstallListener) param0);
        }
        
        public static boolean isInstance(java.lang.Object param0) {
            if (!(param0 instanceof org.xms.g.utils.XObject)) {
                return false;
            }
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hms.security.SecComponentInstallWizard.SecComponentInstallWizardListener;
            } else {
                return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.security.ProviderInstaller.ProviderInstallListener;
            }
        }
        
        public static class XImpl extends org.xms.g.utils.XObject implements org.xms.g.security.ProviderInstaller.ProviderInstallListener {
            
            public XImpl(com.google.android.gms.security.ProviderInstaller.ProviderInstallListener param0, com.huawei.hms.security.SecComponentInstallWizard.SecComponentInstallWizardListener param1) {
                super(param0, param1);
            }
            
            public static boolean isInstance(java.lang.Object param0) {
                if (!(param0 instanceof org.xms.g.utils.XObject)) {
                    return false;
                }
                if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                    return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hms.security.SecComponentInstallWizard.SecComponentInstallWizardListener;
                } else {
                    return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.security.ProviderInstaller.ProviderInstallListener;
                }
            }
            
            public void onProviderInstallFailed(int param0, android.content.Intent param1) {
                if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                    org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.security.SecComponentInstallWizard.SecComponentInstallWizardListener) this.getHInstance()).onFailed(param0, param1)", new Exception());
                    ((com.huawei.hms.security.SecComponentInstallWizard.SecComponentInstallWizardListener) this.getHInstance()).onFailed(param0, param1);
                } else {
                    org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.security.ProviderInstaller.ProviderInstallListener) this.getGInstance()).onProviderInstallFailed(param0, param1)", new Exception());
                    ((com.google.android.gms.security.ProviderInstaller.ProviderInstallListener) this.getGInstance()).onProviderInstallFailed(param0, param1);
                }
            }
            
            public void onProviderInstalled() {
                if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                    org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.security.SecComponentInstallWizard.SecComponentInstallWizardListener) this.getHInstance()).onSuccess()", new Exception());
                    ((com.huawei.hms.security.SecComponentInstallWizard.SecComponentInstallWizardListener) this.getHInstance()).onSuccess();
                } else {
                    org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.security.ProviderInstaller.ProviderInstallListener) this.getGInstance()).onProviderInstalled()", new Exception());
                    ((com.google.android.gms.security.ProviderInstaller.ProviderInstallListener) this.getGInstance()).onProviderInstalled();
                }
            }
        }
    }
}
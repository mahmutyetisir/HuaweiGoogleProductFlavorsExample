package org.xms.g.common.api;





public abstract class ExtensionApi<XO extends org.xms.g.common.api.Api.ApiOptions> extends org.xms.g.utils.XObject implements org.xms.g.common.api.HasApiKey<XO> {
    private boolean wrapper = true;
    
    
    
    
    public ExtensionApi(com.google.android.gms.common.api.GoogleApi param0, java.lang.Object param1) {
        super(param0, null);
        this.setHInstance(param1);
        wrapper = true;
    }
    
    public static org.xms.g.common.api.ExtensionApi dynamicCast(java.lang.Object param0) {
        if (param0 instanceof org.xms.g.common.api.ExtensionApi) {
            return ((org.xms.g.common.api.ExtensionApi) param0);
        }
        if (param0 instanceof org.xms.g.utils.XGettable) {
            com.google.android.gms.common.api.GoogleApi gReturn = ((com.google.android.gms.common.api.GoogleApi) ((org.xms.g.utils.XGettable) param0).getGInstance());
            
            throw new RuntimeException("TODO block must be filled");
            
        }
        return ((org.xms.g.common.api.ExtensionApi) param0);
    }
    
    public static boolean isInstance(java.lang.Object param0) {
        if (!(param0 instanceof org.xms.g.utils.XObject)) {
            return false;
        }
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            
            throw new RuntimeException("TODO block must be filled");
            
        } else {
            return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.common.api.GoogleApi;
        }
    }
    
    public static class XImpl<XO extends org.xms.g.common.api.Api.ApiOptions> extends org.xms.g.common.api.ExtensionApi<XO> {
        
        
        
        
        public XImpl(com.google.android.gms.common.api.GoogleApi param0, java.lang.Object param1) {
            super(param0, param1);
        }
        
        public static boolean isInstance(java.lang.Object param0) {
            if (!(param0 instanceof org.xms.g.utils.XObject)) {
                return false;
            }
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                
                throw new RuntimeException("TODO block must be filled");
                
            } else {
                return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.common.api.GoogleApi;
            }
        }
        
        public java.lang.Object getApiKey() {
            throw new java.lang.RuntimeException("Not Supported");
        }
    }
}
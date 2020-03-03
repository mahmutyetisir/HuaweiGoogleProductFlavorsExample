package org.xms.f;





public class FirebaseApp extends org.xms.g.utils.XObject {
    private boolean wrapper = true;
    
    
    
    
    public FirebaseApp(com.google.firebase.FirebaseApp param0, java.lang.Object param1) {
        super(param0, null);
        this.setHInstance(param1);
        wrapper = true;
    }
    
    public static org.xms.f.FirebaseApp dynamicCast(java.lang.Object param0) {
        return ((org.xms.f.FirebaseApp) param0);
    }
    
    public static boolean isInstance(java.lang.Object param0) {
        if (!(param0 instanceof org.xms.g.utils.XObject)) {
            return false;
        }
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            
            throw new RuntimeException("TODO block must be filled");
            
        } else {
            return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.firebase.FirebaseApp;
        }
    }
}
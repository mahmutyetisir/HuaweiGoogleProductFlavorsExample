package org.xms.g.utils;

public class XObject implements XGettable {
    private Object gInstance;
    private Object hInstance;

    public XObject(Object gInst, Object hInst) {
        this.gInstance = gInst;
        this.hInstance = hInst;
    }

    public Object getGInstance() {
        if (gInstance == null) {
            org.xms.g.utils.XmsLog.d("1", "gInstance is null ", new Throwable());
        } else {
            org.xms.g.utils.XmsLog.d("2", "gInstance : " + gInstance.getClass().getName(), new Throwable());
        }
        return gInstance;
    }

    public Object getHInstance() {
        if (hInstance == null) {
            org.xms.g.utils.XmsLog.d("1", "hInstance is null ", new Throwable());
        } else {
            org.xms.g.utils.XmsLog.d("2", "hInstance : " + hInstance.getClass().getName(), new Throwable());
        }
        return hInstance;
    }

    public void setGInstance(Object gInst){
        this.gInstance = gInst;
    }

    public void setHInstance(Object hInst){
        this.hInstance = hInst;
    }

    public boolean isSameAs(Object that) {
        if (that == null) {
            return false;
        }

        if (!(that instanceof XObject)) {
            return false;
        }

        if (GlobalEnvSetting.isHms()) {
            return getHInstance() == ((XObject) that).getHInstance();
        } else {
            return getGInstance() == ((XObject) that).getGInstance();
        }
    }

    public static Class findGClass() {
        return null;
    }

    public static Class findXClass() {
        return null;
    }
}

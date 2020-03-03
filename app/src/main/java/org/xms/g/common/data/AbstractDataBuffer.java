package org.xms.g.common.data;

public abstract class AbstractDataBuffer<XT> extends org.xms.g.utils.XObject implements org.xms.g.common.data.DataBuffer<XT> {
    private boolean wrapper = true;
    
    public AbstractDataBuffer(com.google.android.gms.common.data.AbstractDataBuffer param0, com.huawei.hms.common.data.AbstractDataBuffer param1) {
        super(param0, null);
        this.setHInstance(param1);
        wrapper = true;
    }
    
    public void close() {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.common.data.AbstractDataBuffer) this.getHInstance()).close()", new Exception());
            ((com.huawei.hms.common.data.AbstractDataBuffer) this.getHInstance()).close();
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.common.data.AbstractDataBuffer) this.getGInstance()).close()", new Exception());
            ((com.google.android.gms.common.data.AbstractDataBuffer) this.getGInstance()).close();
        }
    }
    
    public abstract XT get(int param0);
    
    public int getCount() {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.common.data.AbstractDataBuffer) this.getHInstance()).getCount()", new Exception());
            return ((com.huawei.hms.common.data.AbstractDataBuffer) this.getHInstance()).getCount();
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.common.data.AbstractDataBuffer) this.getGInstance()).getCount()", new Exception());
            return ((com.google.android.gms.common.data.AbstractDataBuffer) this.getGInstance()).getCount();
        }
    }
    
    public boolean isClosed() {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.common.data.AbstractDataBuffer) this.getHInstance()).isClosed()", new Exception());
            return ((com.huawei.hms.common.data.AbstractDataBuffer) this.getHInstance()).isClosed();
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.common.data.AbstractDataBuffer) this.getGInstance()).isClosed()", new Exception());
            return ((com.google.android.gms.common.data.AbstractDataBuffer) this.getGInstance()).isClosed();
        }
    }
    
    public java.util.Iterator iterator() {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.common.data.AbstractDataBuffer) this.getHInstance()).iterator()", new Exception());
            return ((com.huawei.hms.common.data.AbstractDataBuffer) this.getHInstance()).iterator();
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.common.data.AbstractDataBuffer) this.getGInstance()).iterator()", new Exception());
            return ((com.google.android.gms.common.data.AbstractDataBuffer) this.getGInstance()).iterator();
        }
    }
    
    public void release() {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.common.data.AbstractDataBuffer) this.getHInstance()).release()", new Exception());
            ((com.huawei.hms.common.data.AbstractDataBuffer) this.getHInstance()).release();
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.common.data.AbstractDataBuffer) this.getGInstance()).release()", new Exception());
            ((com.google.android.gms.common.data.AbstractDataBuffer) this.getGInstance()).release();
        }
    }
    
    public java.util.Iterator singleRefIterator() {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.common.data.AbstractDataBuffer) this.getHInstance()).singleRefIterator()", new Exception());
            return ((com.huawei.hms.common.data.AbstractDataBuffer) this.getHInstance()).singleRefIterator();
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.common.data.AbstractDataBuffer) this.getGInstance()).singleRefIterator()", new Exception());
            return ((com.google.android.gms.common.data.AbstractDataBuffer) this.getGInstance()).singleRefIterator();
        }
    }
    
    public static org.xms.g.common.data.AbstractDataBuffer dynamicCast(java.lang.Object param0) {
        if (param0 instanceof org.xms.g.common.data.AbstractDataBuffer) {
            return ((org.xms.g.common.data.AbstractDataBuffer) param0);
        }
        if (param0 instanceof org.xms.g.utils.XGettable) {
            com.google.android.gms.common.data.AbstractDataBuffer gReturn = ((com.google.android.gms.common.data.AbstractDataBuffer) ((org.xms.g.utils.XGettable) param0).getGInstance());
            com.huawei.hms.common.data.AbstractDataBuffer hReturn = ((com.huawei.hms.common.data.AbstractDataBuffer) ((org.xms.g.utils.XGettable) param0).getHInstance());
            return new org.xms.g.common.data.AbstractDataBuffer.XImpl(gReturn, hReturn);
        }
        return ((org.xms.g.common.data.AbstractDataBuffer) param0);
    }
    
    public static boolean isInstance(java.lang.Object param0) {
        if (!(param0 instanceof org.xms.g.utils.XObject)) {
            return false;
        }
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hms.common.data.AbstractDataBuffer;
        } else {
            return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.common.data.AbstractDataBuffer;
        }
    }
    
    public static class XImpl<XT> extends org.xms.g.common.data.AbstractDataBuffer<XT> {
        
        public XImpl(com.google.android.gms.common.data.AbstractDataBuffer param0, com.huawei.hms.common.data.AbstractDataBuffer param1) {
            super(param0, param1);
        }
        
        public static boolean isInstance(java.lang.Object param0) {
            if (!(param0 instanceof org.xms.g.utils.XObject)) {
                return false;
            }
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hms.common.data.AbstractDataBuffer;
            } else {
                return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.common.data.AbstractDataBuffer;
            }
        }
        
        public XT get(int param0) {
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.common.data.AbstractDataBuffer) this.getHInstance()).get(param0)", new Exception());
                java.lang.Object hmsObj = ((com.huawei.hms.common.data.AbstractDataBuffer) this.getHInstance()).get(param0);
                boolean flag = org.xms.g.utils.Utils.isHmsType(hmsObj);
                if (flag) {
                    java.lang.Object retObj = null;
                    retObj = org.xms.g.utils.Utils.getXmsObjectWithHmsObject(hmsObj);
                    return ((XT) retObj);
                } else {
                    return ((XT) hmsObj);
                }
            } else {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.common.data.AbstractDataBuffer) this.getGInstance()).get(param0)", new Exception());
                java.lang.Object gmsObj = ((com.google.android.gms.common.data.AbstractDataBuffer) this.getGInstance()).get(param0);
                boolean flag = org.xms.g.utils.Utils.isGmsType(gmsObj);
                if (flag) {
                    java.lang.Object retObj = null;
                    retObj = org.xms.g.utils.Utils.getXmsObjectWithGmsObject(gmsObj);
                    return ((XT) retObj);
                } else {
                    return ((XT) gmsObj);
                }
            }
        }
    }
}
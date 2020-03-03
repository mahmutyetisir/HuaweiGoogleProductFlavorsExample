package org.xms.g.common.data;

public interface DataBuffer<XT> extends org.xms.g.utils.XInterface, org.xms.g.common.api.Releasable, java.io.Closeable, java.lang.Iterable<XT> {
    
    public void close();
    
    public XT get(int param0);
    
    public int getCount();
    
    public boolean isClosed();
    
    public java.util.Iterator<XT> iterator();
    
    public void release();
    
    public java.util.Iterator<XT> singleRefIterator();
    
    default <T> com.google.android.gms.common.data.DataBuffer<T> getGInstanceDataBuffer() {
        if (this instanceof org.xms.g.utils.XGettable) {
            return ((com.google.android.gms.common.data.DataBuffer<T>) ((org.xms.g.utils.XGettable) this).getGInstance());
        }
        throw new java.lang.RuntimeException("Not for inheriting");
    }
    
    default <T> com.huawei.hms.common.data.DataBuffer<T> getHInstanceDataBuffer() {
        if (this instanceof org.xms.g.utils.XGettable) {
            return ((com.huawei.hms.common.data.DataBuffer<T>) ((org.xms.g.utils.XGettable) this).getHInstance());
        }
        throw new java.lang.RuntimeException("Not for inheriting");
    }
    
    public static org.xms.g.common.data.DataBuffer dynamicCast(java.lang.Object param0) {
        if (param0 instanceof org.xms.g.common.data.DataBuffer) {
            return ((org.xms.g.common.data.DataBuffer) param0);
        }
        if (param0 instanceof org.xms.g.utils.XGettable) {
            com.google.android.gms.common.data.DataBuffer gReturn = ((com.google.android.gms.common.data.DataBuffer) ((org.xms.g.utils.XGettable) param0).getGInstance());
            com.huawei.hms.common.data.DataBuffer hReturn = ((com.huawei.hms.common.data.DataBuffer) ((org.xms.g.utils.XGettable) param0).getHInstance());
            return new org.xms.g.common.data.DataBuffer.XImpl(gReturn, hReturn);
        }
        return ((org.xms.g.common.data.DataBuffer) param0);
    }
    
    public static boolean isInstance(java.lang.Object param0) {
        if (!(param0 instanceof org.xms.g.utils.XObject)) {
            return false;
        }
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hms.common.data.DataBuffer;
        } else {
            return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.common.data.DataBuffer;
        }
    }
    
    public static class XImpl<XT> extends org.xms.g.utils.XObject implements org.xms.g.common.data.DataBuffer<XT> {
        
        public XImpl(com.google.android.gms.common.data.DataBuffer param0, com.huawei.hms.common.data.DataBuffer param1) {
            super(param0, param1);
        }
        
        public static boolean isInstance(java.lang.Object param0) {
            if (!(param0 instanceof org.xms.g.utils.XObject)) {
                return false;
            }
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hms.common.data.DataBuffer;
            } else {
                return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.common.data.DataBuffer;
            }
        }
        
        public void close() {
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.common.data.DataBuffer) this.getHInstance()).close()", new Exception());
                ((com.huawei.hms.common.data.DataBuffer) this.getHInstance()).close();
            } else {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.common.data.DataBuffer) this.getGInstance()).close()", new Exception());
                ((com.google.android.gms.common.data.DataBuffer) this.getGInstance()).close();
            }
        }
        
        public XT get(int param0) {
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.common.data.DataBuffer) this.getHInstance()).get(param0)", new Exception());
                java.lang.Object hmsObj = ((com.huawei.hms.common.data.DataBuffer) this.getHInstance()).get(param0);
                boolean flag = org.xms.g.utils.Utils.isHmsType(hmsObj);
                if (flag) {
                    java.lang.Object retObj = null;
                    retObj = org.xms.g.utils.Utils.getXmsObjectWithHmsObject(hmsObj);
                    return ((XT) retObj);
                } else {
                    return ((XT) hmsObj);
                }
            } else {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.common.data.DataBuffer) this.getGInstance()).get(param0)", new Exception());
                java.lang.Object gmsObj = ((com.google.android.gms.common.data.DataBuffer) this.getGInstance()).get(param0);
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
        
        public int getCount() {
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.common.data.DataBuffer) this.getHInstance()).getCount()", new Exception());
                return ((com.huawei.hms.common.data.DataBuffer) this.getHInstance()).getCount();
            } else {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.common.data.DataBuffer) this.getGInstance()).getCount()", new Exception());
                return ((com.google.android.gms.common.data.DataBuffer) this.getGInstance()).getCount();
            }
        }
        
        public boolean isClosed() {
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.common.data.DataBuffer) this.getHInstance()).isClosed()", new Exception());
                return ((com.huawei.hms.common.data.DataBuffer) this.getHInstance()).isClosed();
            } else {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.common.data.DataBuffer) this.getGInstance()).isClosed()", new Exception());
                return ((com.google.android.gms.common.data.DataBuffer) this.getGInstance()).isClosed();
            }
        }
        
        public java.util.Iterator<XT> iterator() {
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.common.data.DataBuffer) this.getHInstance()).iterator()", new Exception());
                return ((com.huawei.hms.common.data.DataBuffer) this.getHInstance()).iterator();
            } else {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.common.data.DataBuffer) this.getGInstance()).iterator()", new Exception());
                return ((com.google.android.gms.common.data.DataBuffer) this.getGInstance()).iterator();
            }
        }
        
        public void release() {
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.common.data.DataBuffer) this.getHInstance()).release()", new Exception());
                ((com.huawei.hms.common.data.DataBuffer) this.getHInstance()).release();
            } else {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.common.data.DataBuffer) this.getGInstance()).release()", new Exception());
                ((com.google.android.gms.common.data.DataBuffer) this.getGInstance()).release();
            }
        }
        
        public java.util.Iterator<XT> singleRefIterator() {
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hms.common.data.DataBuffer) this.getHInstance()).singleRefIterator()", new Exception());
                return ((com.huawei.hms.common.data.DataBuffer) this.getHInstance()).singleRefIterator();
            } else {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.common.data.DataBuffer) this.getGInstance()).singleRefIterator()", new Exception());
                return ((com.google.android.gms.common.data.DataBuffer) this.getGInstance()).singleRefIterator();
            }
        }
    }
}
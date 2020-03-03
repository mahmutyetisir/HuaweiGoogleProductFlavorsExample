package org.xms.g.common.data;

public final class DataBufferUtils extends org.xms.g.utils.XObject {
    
    public DataBufferUtils(com.google.android.gms.common.data.DataBufferUtils param0, com.huawei.hms.common.data.DataBufferUtils param1) {
        super(param0, null);
        this.setHInstance(param1);
    }
    
    public static <XT extends java.lang.Object, XE extends org.xms.g.common.data.Freezable<XT>> java.util.ArrayList<XT> freezeAndClose(org.xms.g.common.data.DataBuffer<XE> param0) {
        java.util.ArrayList hReturn = null;
        java.util.ArrayList gReturn = null;
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.huawei.hms.common.data.DataBufferUtils.freezeAndClose(((param0) == null ? null : (param0.getHInstanceDataBuffer())))", new Exception());
            hReturn = com.huawei.hms.common.data.DataBufferUtils.freezeAndClose(((param0) == null ? null : (param0.getHInstanceDataBuffer())));
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.google.android.gms.common.data.DataBufferUtils.freezeAndClose(((param0) == null ? null : (param0.getGInstanceDataBuffer())))", new Exception());
            gReturn = com.google.android.gms.common.data.DataBufferUtils.freezeAndClose(((param0) == null ? null : (param0.getGInstanceDataBuffer())));
        }
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            return ((java.util.ArrayList) org.xms.g.utils.Utils.mapCollection(hReturn, new java.util.function.Function<Object, XT>() {
                
                public XT apply(Object param0) {
                    return ((XT) org.xms.g.utils.Utils.getXmsObjectWithHmsObject(param0));
                }
            }));
        } else {
            return ((java.util.ArrayList) org.xms.g.utils.Utils.mapCollection(gReturn, new java.util.function.Function<Object, XT>() {
                
                public XT apply(Object param0) {
                    return ((XT) org.xms.g.utils.Utils.getXmsObjectWithGmsObject(param0));
                }
            }));
        }
    }
    
    public static boolean hasData(org.xms.g.common.data.DataBuffer<?> param0) {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.huawei.hms.common.data.DataBufferUtils.hasData(((param0) == null ? null : (param0.getHInstanceDataBuffer())))", new Exception());
            return com.huawei.hms.common.data.DataBufferUtils.hasData(((param0) == null ? null : (param0.getHInstanceDataBuffer())));
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.google.android.gms.common.data.DataBufferUtils.hasData(((param0) == null ? null : (param0.getGInstanceDataBuffer())))", new Exception());
            return com.google.android.gms.common.data.DataBufferUtils.hasData(((param0) == null ? null : (param0.getGInstanceDataBuffer())));
        }
    }
    
    public static boolean hasNextPage(org.xms.g.common.data.DataBuffer<?> param0) {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.huawei.hms.common.data.DataBufferUtils.hasNextPage(((param0) == null ? null : (param0.getHInstanceDataBuffer())))", new Exception());
            return com.huawei.hms.common.data.DataBufferUtils.hasNextPage(((param0) == null ? null : (param0.getHInstanceDataBuffer())));
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.google.android.gms.common.data.DataBufferUtils.hasNextPage(((param0) == null ? null : (param0.getGInstanceDataBuffer())))", new Exception());
            return com.google.android.gms.common.data.DataBufferUtils.hasNextPage(((param0) == null ? null : (param0.getGInstanceDataBuffer())));
        }
    }
    
    public static boolean hasPrevPage(org.xms.g.common.data.DataBuffer<?> param0) {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.huawei.hms.common.data.DataBufferUtils.hasPrevPage(((param0) == null ? null : (param0.getHInstanceDataBuffer())))", new Exception());
            return com.huawei.hms.common.data.DataBufferUtils.hasPrevPage(((param0) == null ? null : (param0.getHInstanceDataBuffer())));
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.google.android.gms.common.data.DataBufferUtils.hasPrevPage(((param0) == null ? null : (param0.getGInstanceDataBuffer())))", new Exception());
            return com.google.android.gms.common.data.DataBufferUtils.hasPrevPage(((param0) == null ? null : (param0.getGInstanceDataBuffer())));
        }
    }
    
    public static org.xms.g.common.data.DataBufferUtils dynamicCast(java.lang.Object param0) {
        return ((org.xms.g.common.data.DataBufferUtils) param0);
    }
    
    public static boolean isInstance(java.lang.Object param0) {
        if (!(param0 instanceof org.xms.g.utils.XObject)) {
            return false;
        }
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hms.common.data.DataBufferUtils;
        } else {
            return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.common.data.DataBufferUtils;
        }
    }
}
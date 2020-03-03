package org.xms.g.common.data;

import org.xms.g.utils.Utils;

import java.util.ArrayList;
import java.util.Iterator;

public final class FreezableUtils extends org.xms.g.utils.XObject {

    public FreezableUtils(com.google.android.gms.common.data.FreezableUtils param0, com.huawei.hms.common.data.FreezableUtils param1) {
        super(param0, null);
        this.setHInstance(param1);
    }

    public FreezableUtils() {
        super(((com.google.android.gms.common.data.FreezableUtils) null), null);
    }

    public static <XT, XE extends org.xms.g.common.data.Freezable<XT>> java.util.ArrayList<XT> freeze(XE[] param0) {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.huawei.hms.common.data.FreezableUtils.freeze(param0)", new Exception());
            return com.huawei.hms.common.data.FreezableUtils.freeze(Utils.mapArray2GH(param0, com.huawei.hms.common.data.Freezable.class, true));
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.google.android.gms.common.data.FreezableUtils.freeze(param0)", new Exception());
            return com.google.android.gms.common.data.FreezableUtils.freeze(Utils.mapArray2GH(param0, com.google.android.gms.common.data.Freezable.class, false));
        }
    }

    public static <XT, XE extends org.xms.g.common.data.Freezable<XT>> java.util.ArrayList<XT> freeze(java.util.ArrayList<XE> param0) {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.huawei.hms.common.data.FreezableUtils.freeze(param0)", new Exception());
            return com.huawei.hms.common.data.FreezableUtils.freeze((ArrayList) Utils.mapList2GH(param0, true));
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.google.android.gms.common.data.FreezableUtils.freeze(param0)", new Exception());
            return com.google.android.gms.common.data.FreezableUtils.freeze((ArrayList) Utils.mapList2GH(param0, false));
        }
    }

    public static <XT, XE extends org.xms.g.common.data.Freezable<XT>>
    java.util.ArrayList<XT> freezeIterable(java.lang.Iterable<XE> param0) {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.huawei.hms.common.data.FreezableUtils.freezeIterable(param0)", new Exception());
            Iterable hts = Utils.transformIterable(param0, e -> Utils.getInstanceInInterface(e, true));
            ArrayList arrayList = com.huawei.hms.common.data.FreezableUtils.freezeIterable(hts);
            return Utils.mapArrayList(arrayList, e -> (XT) Utils.getXmsObjectWithHmsObject(e));
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.google.android.gms.common.data.FreezableUtils.freezeIterable(param0)", new Exception());
            Iterable gts = Utils.transformIterable(param0, e -> Utils.getInstanceInInterface(e, false));
            ArrayList arrayList = com.google.android.gms.common.data.FreezableUtils.freezeIterable(gts);
            return Utils.mapArrayList(arrayList, e -> (XT) Utils.getXmsObjectWithGmsObject(e));
        }
    }

    public static org.xms.g.common.data.FreezableUtils dynamicCast(java.lang.Object param0) {
        if (param0 instanceof org.xms.g.common.data.FreezableUtils) {
            return ((org.xms.g.common.data.FreezableUtils) param0);
        }
        if (param0 instanceof org.xms.g.utils.XGettable) {
            com.google.android.gms.common.data.FreezableUtils gReturn = ((com.google.android.gms.common.data.FreezableUtils) ((org.xms.g.utils.XGettable) param0).getGInstance());
            com.huawei.hms.common.data.FreezableUtils hReturn = ((com.huawei.hms.common.data.FreezableUtils) ((org.xms.g.utils.XGettable) param0).getHInstance());
            return new org.xms.g.common.data.FreezableUtils(gReturn, hReturn);
        }
        return ((org.xms.g.common.data.FreezableUtils) param0);
    }

    public static boolean isInstance(java.lang.Object param0) {
        if (!(param0 instanceof org.xms.g.utils.XObject)) {
            return false;
        }
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hms.common.data.FreezableUtils;
        } else {
            return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.common.data.FreezableUtils;
        }
    }
}

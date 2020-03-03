package org.xms.g.tasks;





public final class Tasks extends org.xms.g.utils.XObject {
    
    
    
    
    public Tasks(com.google.android.gms.tasks.Tasks param0, com.huawei.hmf.tasks.Tasks param1) {
        super(param0, null);
        this.setHInstance(param1);
    }
    
    public static <XTResult> XTResult await(org.xms.g.tasks.Task<XTResult> param0, long param1, java.util.concurrent.TimeUnit param2) throws java.util.concurrent.ExecutionException, java.lang.InterruptedException, java.util.concurrent.TimeoutException {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.huawei.hmf.tasks.Tasks.await(((com.huawei.hmf.tasks.Task) ((param0) == null ? null : (param0.getHInstance()))), param1, param2)", new Exception());
            java.lang.Object hmsObj = com.huawei.hmf.tasks.Tasks.await(((com.huawei.hmf.tasks.Task) ((param0) == null ? null : (param0.getHInstance()))), param1, param2);
            boolean flag = org.xms.g.utils.Utils.isHmsType(hmsObj);
            if (flag) {
                java.lang.Object retObj = null;
                retObj = org.xms.g.utils.Utils.getXmsObjectWithHmsObject(hmsObj);
                return ((XTResult) retObj);
            } else {
                return ((XTResult) hmsObj);
            }
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.google.android.gms.tasks.Tasks.await(((com.google.android.gms.tasks.Task) ((param0) == null ? null : (param0.getGInstance()))), param1, param2)", new Exception());
            java.lang.Object gmsObj = com.google.android.gms.tasks.Tasks.await(((com.google.android.gms.tasks.Task) ((param0) == null ? null : (param0.getGInstance()))), param1, param2);
            boolean flag = org.xms.g.utils.Utils.isGmsType(gmsObj);
            if (flag) {
                java.lang.Object retObj = null;
                retObj = org.xms.g.utils.Utils.getXmsObjectWithGmsObject(gmsObj);
                return ((XTResult) retObj);
            } else {
                return ((XTResult) gmsObj);
            }
        }
    }
    
    public static <XTResult> XTResult await(org.xms.g.tasks.Task<XTResult> param0) throws java.util.concurrent.ExecutionException, java.lang.InterruptedException {
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.huawei.hmf.tasks.Tasks.await(((com.huawei.hmf.tasks.Task) ((param0) == null ? null : (param0.getHInstance()))))", new Exception());
            java.lang.Object hmsObj = com.huawei.hmf.tasks.Tasks.await(((com.huawei.hmf.tasks.Task) ((param0) == null ? null : (param0.getHInstance()))));
            boolean flag = org.xms.g.utils.Utils.isHmsType(hmsObj);
            if (flag) {
                java.lang.Object retObj = null;
                retObj = org.xms.g.utils.Utils.getXmsObjectWithHmsObject(hmsObj);
                return ((XTResult) retObj);
            } else {
                return ((XTResult) hmsObj);
            }
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.google.android.gms.tasks.Tasks.await(((com.google.android.gms.tasks.Task) ((param0) == null ? null : (param0.getGInstance()))))", new Exception());
            java.lang.Object gmsObj = com.google.android.gms.tasks.Tasks.await(((com.google.android.gms.tasks.Task) ((param0) == null ? null : (param0.getGInstance()))));
            boolean flag = org.xms.g.utils.Utils.isGmsType(gmsObj);
            if (flag) {
                java.lang.Object retObj = null;
                retObj = org.xms.g.utils.Utils.getXmsObjectWithGmsObject(gmsObj);
                return ((XTResult) retObj);
            } else {
                return ((XTResult) gmsObj);
            }
        }
    }
    
    public static <XTResult> org.xms.g.tasks.Task<XTResult> call(java.util.concurrent.Callable<XTResult> param0) {
        com.google.android.gms.tasks.Task gReturn = null;
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            
            com.huawei.hmf.tasks.Task hReturn = null;
            hReturn = com.huawei.hmf.tasks.Tasks.callInBackground(com.huawei.hmf.tasks.TaskExecutors.uiThread(),param0);
            if(hReturn==null){
                return null;
            }
            return new org.xms.g.tasks.Task.XImpl(gReturn, hReturn);
            
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.google.android.gms.tasks.Tasks.call(param0)", new Exception());
            gReturn = com.google.android.gms.tasks.Tasks.call(param0);
        }
        if (gReturn == null) {
            return null;
        }
        return new org.xms.g.tasks.Task.XImpl(gReturn, null);
    }
    
    public static <XTResult> org.xms.g.tasks.Task<XTResult> call(java.util.concurrent.Executor param0, java.util.concurrent.Callable<XTResult> param1) {
        com.google.android.gms.tasks.Task gReturn = null;
        com.huawei.hmf.tasks.Task hReturn = null;
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.huawei.hmf.tasks.Tasks.callInBackground(param0, param1)", new Exception());
            hReturn = com.huawei.hmf.tasks.Tasks.callInBackground(param0, param1);
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.google.android.gms.tasks.Tasks.call(param0, param1)", new Exception());
            gReturn = com.google.android.gms.tasks.Tasks.call(param0, param1);
        }
        if (gReturn == null && hReturn == null) {
            return null;
        }
        return new org.xms.g.tasks.Task.XImpl(gReturn, hReturn);
    }
    
    public static <XTResult> org.xms.g.tasks.Task<XTResult> forCanceled() {
        com.google.android.gms.tasks.Task gReturn = null;
        com.huawei.hmf.tasks.Task hReturn = null;
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.huawei.hmf.tasks.Tasks.fromCanceled()", new Exception());
            hReturn = com.huawei.hmf.tasks.Tasks.fromCanceled();
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.google.android.gms.tasks.Tasks.forCanceled()", new Exception());
            gReturn = com.google.android.gms.tasks.Tasks.forCanceled();
        }
        if (gReturn == null && hReturn == null) {
            return null;
        }
        return new org.xms.g.tasks.Task.XImpl(gReturn, hReturn);
    }
    
    public static <XTResult> org.xms.g.tasks.Task<XTResult> forException(java.lang.Exception param0) {
        com.google.android.gms.tasks.Task gReturn = null;
        com.huawei.hmf.tasks.Task hReturn = null;
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.huawei.hmf.tasks.Tasks.fromException(param0)", new Exception());
            hReturn = com.huawei.hmf.tasks.Tasks.fromException(param0);
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.google.android.gms.tasks.Tasks.forException(param0)", new Exception());
            gReturn = com.google.android.gms.tasks.Tasks.forException(param0);
        }
        if (gReturn == null && hReturn == null) {
            return null;
        }
        return new org.xms.g.tasks.Task.XImpl(gReturn, hReturn);
    }
    
    public static <XTResult> org.xms.g.tasks.Task<XTResult> forResult(XTResult param0) {
        com.google.android.gms.tasks.Task gReturn = null;
        com.huawei.hmf.tasks.Task hReturn = null;
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            java.lang.Object hObj0 = org.xms.g.utils.Utils.getInstanceInInterface(param0, true);
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.huawei.hmf.tasks.Tasks.fromResult(((XTResult) hObj0))", new Exception());
            hReturn = com.huawei.hmf.tasks.Tasks.fromResult(((XTResult) hObj0));
        } else {
            java.lang.Object gObj0 = org.xms.g.utils.Utils.getInstanceInInterface(param0, false);
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.google.android.gms.tasks.Tasks.forResult(((XTResult) gObj0))", new Exception());
            gReturn = com.google.android.gms.tasks.Tasks.forResult(((XTResult) gObj0));
        }
        if (gReturn == null && hReturn == null) {
            return null;
        }
        return new org.xms.g.tasks.Task.XImpl(gReturn, hReturn);
    }
    
    public static org.xms.g.tasks.Task<java.lang.Void> whenAll(org.xms.g.tasks.Task<?>... param0) {
        com.google.android.gms.tasks.Task gReturn = null;
        com.huawei.hmf.tasks.Task hReturn = null;
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.huawei.hmf.tasks.Tasks.join(((com.huawei.hmf.tasks.Task[]) org.xms.g.utils.Utils.genericArrayCopy(param0, com.huawei.hmf.tasks.Task.class, x -> (com.huawei.hmf.tasks.Task)x.getHInstance())))", new Exception());
            hReturn = com.huawei.hmf.tasks.Tasks.join(((com.huawei.hmf.tasks.Task[]) org.xms.g.utils.Utils.genericArrayCopy(param0, com.huawei.hmf.tasks.Task.class, x -> (com.huawei.hmf.tasks.Task)x.getHInstance())));
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.google.android.gms.tasks.Tasks.whenAll(((com.google.android.gms.tasks.Task[]) org.xms.g.utils.Utils.genericArrayCopy(param0, com.google.android.gms.tasks.Task.class, x -> (com.google.android.gms.tasks.Task)x.getGInstance())))", new Exception());
            gReturn = com.google.android.gms.tasks.Tasks.whenAll(((com.google.android.gms.tasks.Task[]) org.xms.g.utils.Utils.genericArrayCopy(param0, com.google.android.gms.tasks.Task.class, x -> (com.google.android.gms.tasks.Task)x.getGInstance())));
        }
        if (gReturn == null && hReturn == null) {
            return null;
        }
        return new org.xms.g.tasks.Task.XImpl(gReturn, hReturn);
    }
    
    public static org.xms.g.tasks.Task<java.lang.Void> whenAll(java.util.Collection<? extends org.xms.g.tasks.Task<?>> param0) {
        com.google.android.gms.tasks.Task gReturn = null;
        com.huawei.hmf.tasks.Task hReturn = null;
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.huawei.hmf.tasks.Tasks.join(org.xms.g.utils.Utils.mapCollection2GH(param0, true))", new Exception());
            hReturn = com.huawei.hmf.tasks.Tasks.join(org.xms.g.utils.Utils.mapCollection2GH(param0, true));
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.google.android.gms.tasks.Tasks.whenAll(org.xms.g.utils.Utils.mapCollection2GH(param0, false))", new Exception());
            gReturn = com.google.android.gms.tasks.Tasks.whenAll(org.xms.g.utils.Utils.mapCollection2GH(param0, false));
        }
        if (gReturn == null && hReturn == null) {
            return null;
        }
        return new org.xms.g.tasks.Task.XImpl(gReturn, hReturn);
    }
    
    public static org.xms.g.tasks.Task<java.util.List<org.xms.g.tasks.Task<?>>> whenAllComplete(org.xms.g.tasks.Task<?>... param0) {
        com.google.android.gms.tasks.Task gReturn = null;
        com.huawei.hmf.tasks.Task hReturn = null;
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.huawei.hmf.tasks.Tasks.allOf(((com.huawei.hmf.tasks.Task[]) org.xms.g.utils.Utils.genericArrayCopy(param0, com.huawei.hmf.tasks.Task.class, x -> (com.huawei.hmf.tasks.Task)x.getHInstance())))", new Exception());
            hReturn = com.huawei.hmf.tasks.Tasks.allOf(((com.huawei.hmf.tasks.Task[]) org.xms.g.utils.Utils.genericArrayCopy(param0, com.huawei.hmf.tasks.Task.class, x -> (com.huawei.hmf.tasks.Task)x.getHInstance())));
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.google.android.gms.tasks.Tasks.whenAllComplete(((com.google.android.gms.tasks.Task[]) org.xms.g.utils.Utils.genericArrayCopy(param0, com.google.android.gms.tasks.Task.class, x -> (com.google.android.gms.tasks.Task)x.getGInstance())))", new Exception());
            gReturn = com.google.android.gms.tasks.Tasks.whenAllComplete(((com.google.android.gms.tasks.Task[]) org.xms.g.utils.Utils.genericArrayCopy(param0, com.google.android.gms.tasks.Task.class, x -> (com.google.android.gms.tasks.Task)x.getGInstance())));
        }
        if (gReturn == null && hReturn == null) {
            return null;
        }
        return new org.xms.g.tasks.Task.XImpl(gReturn, hReturn);
    }
    
    public static org.xms.g.tasks.Task<java.util.List<org.xms.g.tasks.Task<?>>> whenAllComplete(java.util.Collection<? extends org.xms.g.tasks.Task<?>> param0) {
        com.google.android.gms.tasks.Task gReturn = null;
        com.huawei.hmf.tasks.Task hReturn = null;
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.huawei.hmf.tasks.Tasks.allOf(org.xms.g.utils.Utils.mapCollection2GH(param0, true))", new Exception());
            hReturn = com.huawei.hmf.tasks.Tasks.allOf(org.xms.g.utils.Utils.mapCollection2GH(param0, true));
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.google.android.gms.tasks.Tasks.whenAllComplete(org.xms.g.utils.Utils.mapCollection2GH(param0, false))", new Exception());
            gReturn = com.google.android.gms.tasks.Tasks.whenAllComplete(org.xms.g.utils.Utils.mapCollection2GH(param0, false));
        }
        if (gReturn == null && hReturn == null) {
            return null;
        }
        return new org.xms.g.tasks.Task.XImpl(gReturn, hReturn);
    }
    
    public static <XTResult> org.xms.g.tasks.Task<java.util.List<XTResult>> whenAllSuccess(org.xms.g.tasks.Task<?>... param0) {
        com.google.android.gms.tasks.Task gReturn = null;
        com.huawei.hmf.tasks.Task hReturn = null;
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.huawei.hmf.tasks.Tasks.successOf(((com.huawei.hmf.tasks.Task[]) org.xms.g.utils.Utils.genericArrayCopy(param0, com.huawei.hmf.tasks.Task.class, x -> (com.huawei.hmf.tasks.Task)x.getHInstance())))", new Exception());
            hReturn = com.huawei.hmf.tasks.Tasks.successOf(((com.huawei.hmf.tasks.Task[]) org.xms.g.utils.Utils.genericArrayCopy(param0, com.huawei.hmf.tasks.Task.class, x -> (com.huawei.hmf.tasks.Task)x.getHInstance())));
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.google.android.gms.tasks.Tasks.whenAllSuccess(((com.google.android.gms.tasks.Task[]) org.xms.g.utils.Utils.genericArrayCopy(param0, com.google.android.gms.tasks.Task.class, x -> (com.google.android.gms.tasks.Task)x.getGInstance())))", new Exception());
            gReturn = com.google.android.gms.tasks.Tasks.whenAllSuccess(((com.google.android.gms.tasks.Task[]) org.xms.g.utils.Utils.genericArrayCopy(param0, com.google.android.gms.tasks.Task.class, x -> (com.google.android.gms.tasks.Task)x.getGInstance())));
        }
        if (gReturn == null && hReturn == null) {
            return null;
        }
        return new org.xms.g.tasks.Task.XImpl(gReturn, hReturn);
    }
    
    public static <XTResult> org.xms.g.tasks.Task<java.util.List<XTResult>> whenAllSuccess(java.util.Collection param0) {
        com.google.android.gms.tasks.Task gReturn = null;
        com.huawei.hmf.tasks.Task hReturn = null;
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.huawei.hmf.tasks.Tasks.successOf(org.xms.g.utils.Utils.mapCollection2GH(param0, true))", new Exception());
            hReturn = com.huawei.hmf.tasks.Tasks.successOf(org.xms.g.utils.Utils.mapCollection2GH(param0, true));
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "com.google.android.gms.tasks.Tasks.whenAllSuccess(org.xms.g.utils.Utils.mapCollection2GH(param0, false))", new Exception());
            gReturn = com.google.android.gms.tasks.Tasks.whenAllSuccess(org.xms.g.utils.Utils.mapCollection2GH(param0, false));
        }
        if (gReturn == null && hReturn == null) {
            return null;
        }
        return new org.xms.g.tasks.Task.XImpl(gReturn, hReturn);
    }
    
    public static org.xms.g.tasks.Tasks dynamicCast(java.lang.Object param0) {
        return ((org.xms.g.tasks.Tasks) param0);
    }
    
    public static boolean isInstance(java.lang.Object param0) {
        if (!(param0 instanceof org.xms.g.utils.XObject)) {
            return false;
        }
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hmf.tasks.Tasks;
        } else {
            return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.tasks.Tasks;
        }
    }
}
package org.xms.g.tasks;

public abstract class Task<XTResult> extends org.xms.g.utils.XObject {
    private boolean wrapper = true;
    
    public Task(com.google.android.gms.tasks.Task param0, com.huawei.hmf.tasks.Task param1) {
        super(param0, null);
        this.setHInstance(param1);
        wrapper = true;
    }
    
    public org.xms.g.tasks.Task<XTResult> addOnCanceledListener(org.xms.g.tasks.OnCanceledListener param0) {
        com.google.android.gms.tasks.Task gReturn = null;
        com.huawei.hmf.tasks.Task hReturn = null;
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hmf.tasks.Task) this.getHInstance()).addOnCanceledListener(((param0) == null ? null : (param0.getHInstanceOnCanceledListener())))", new Exception());
            hReturn = ((com.huawei.hmf.tasks.Task) this.getHInstance()).addOnCanceledListener(((param0) == null ? null : (param0.getHInstanceOnCanceledListener())));
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.tasks.Task) this.getGInstance()).addOnCanceledListener(((param0) == null ? null : (param0.getGInstanceOnCanceledListener())))", new Exception());
            gReturn = ((com.google.android.gms.tasks.Task) this.getGInstance()).addOnCanceledListener(((param0) == null ? null : (param0.getGInstanceOnCanceledListener())));
        }
        if (gReturn == null && hReturn == null) {
            return null;
        }
        return new org.xms.g.tasks.Task.XImpl(gReturn, hReturn);
    }
    
    public org.xms.g.tasks.Task<XTResult> addOnCanceledListener(java.util.concurrent.Executor param0, org.xms.g.tasks.OnCanceledListener param1) {
        com.google.android.gms.tasks.Task gReturn = null;
        com.huawei.hmf.tasks.Task hReturn = null;
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hmf.tasks.Task) this.getHInstance()).addOnCanceledListener(param0, ((param1) == null ? null : (param1.getHInstanceOnCanceledListener())))", new Exception());
            hReturn = ((com.huawei.hmf.tasks.Task) this.getHInstance()).addOnCanceledListener(param0, ((param1) == null ? null : (param1.getHInstanceOnCanceledListener())));
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.tasks.Task) this.getGInstance()).addOnCanceledListener(param0, ((param1) == null ? null : (param1.getGInstanceOnCanceledListener())))", new Exception());
            gReturn = ((com.google.android.gms.tasks.Task) this.getGInstance()).addOnCanceledListener(param0, ((param1) == null ? null : (param1.getGInstanceOnCanceledListener())));
        }
        if (gReturn == null && hReturn == null) {
            return null;
        }
        return new org.xms.g.tasks.Task.XImpl(gReturn, hReturn);
    }
    
    public org.xms.g.tasks.Task<XTResult> addOnCanceledListener(android.app.Activity param0, org.xms.g.tasks.OnCanceledListener param1) {
        com.google.android.gms.tasks.Task gReturn = null;
        com.huawei.hmf.tasks.Task hReturn = null;
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hmf.tasks.Task) this.getHInstance()).addOnCanceledListener(param0, ((param1) == null ? null : (param1.getHInstanceOnCanceledListener())))", new Exception());
            hReturn = ((com.huawei.hmf.tasks.Task) this.getHInstance()).addOnCanceledListener(param0, ((param1) == null ? null : (param1.getHInstanceOnCanceledListener())));
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.tasks.Task) this.getGInstance()).addOnCanceledListener(param0, ((param1) == null ? null : (param1.getGInstanceOnCanceledListener())))", new Exception());
            gReturn = ((com.google.android.gms.tasks.Task) this.getGInstance()).addOnCanceledListener(param0, ((param1) == null ? null : (param1.getGInstanceOnCanceledListener())));
        }
        if (gReturn == null && hReturn == null) {
            return null;
        }
        return new org.xms.g.tasks.Task.XImpl(gReturn, hReturn);
    }
    
    public org.xms.g.tasks.Task<XTResult> addOnCompleteListener(org.xms.g.tasks.OnCompleteListener<XTResult> param0) {
        com.google.android.gms.tasks.Task gReturn = null;
        com.huawei.hmf.tasks.Task hReturn = null;
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hmf.tasks.Task) this.getHInstance()).addOnCompleteListener(((param0) == null ? null : (param0.getHInstanceOnCompleteListener())))", new Exception());
            hReturn = ((com.huawei.hmf.tasks.Task) this.getHInstance()).addOnCompleteListener(((param0) == null ? null : (param0.getHInstanceOnCompleteListener())));
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.tasks.Task) this.getGInstance()).addOnCompleteListener(((param0) == null ? null : (param0.getGInstanceOnCompleteListener())))", new Exception());
            gReturn = ((com.google.android.gms.tasks.Task) this.getGInstance()).addOnCompleteListener(((param0) == null ? null : (param0.getGInstanceOnCompleteListener())));
        }
        if (gReturn == null && hReturn == null) {
            return null;
        }
        return new org.xms.g.tasks.Task.XImpl(gReturn, hReturn);
    }
    
    public org.xms.g.tasks.Task<XTResult> addOnCompleteListener(android.app.Activity param0, org.xms.g.tasks.OnCompleteListener<XTResult> param1) {
        com.google.android.gms.tasks.Task gReturn = null;
        com.huawei.hmf.tasks.Task hReturn = null;
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hmf.tasks.Task) this.getHInstance()).addOnCompleteListener(param0, ((param1) == null ? null : (param1.getHInstanceOnCompleteListener())))", new Exception());
            hReturn = ((com.huawei.hmf.tasks.Task) this.getHInstance()).addOnCompleteListener(param0, ((param1) == null ? null : (param1.getHInstanceOnCompleteListener())));
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.tasks.Task) this.getGInstance()).addOnCompleteListener(param0, ((param1) == null ? null : (param1.getGInstanceOnCompleteListener())))", new Exception());
            gReturn = ((com.google.android.gms.tasks.Task) this.getGInstance()).addOnCompleteListener(param0, ((param1) == null ? null : (param1.getGInstanceOnCompleteListener())));
        }
        if (gReturn == null && hReturn == null) {
            return null;
        }
        return new org.xms.g.tasks.Task.XImpl(gReturn, hReturn);
    }
    
    public org.xms.g.tasks.Task<XTResult> addOnCompleteListener(java.util.concurrent.Executor param0, org.xms.g.tasks.OnCompleteListener<XTResult> param1) {
        com.google.android.gms.tasks.Task gReturn = null;
        com.huawei.hmf.tasks.Task hReturn = null;
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hmf.tasks.Task) this.getHInstance()).addOnCompleteListener(param0, ((param1) == null ? null : (param1.getHInstanceOnCompleteListener())))", new Exception());
            hReturn = ((com.huawei.hmf.tasks.Task) this.getHInstance()).addOnCompleteListener(param0, ((param1) == null ? null : (param1.getHInstanceOnCompleteListener())));
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.tasks.Task) this.getGInstance()).addOnCompleteListener(param0, ((param1) == null ? null : (param1.getGInstanceOnCompleteListener())))", new Exception());
            gReturn = ((com.google.android.gms.tasks.Task) this.getGInstance()).addOnCompleteListener(param0, ((param1) == null ? null : (param1.getGInstanceOnCompleteListener())));
        }
        if (gReturn == null && hReturn == null) {
            return null;
        }
        return new org.xms.g.tasks.Task.XImpl(gReturn, hReturn);
    }
    
    public abstract org.xms.g.tasks.Task<XTResult> addOnFailureListener(android.app.Activity param0, org.xms.g.tasks.OnFailureListener param1);
    
    public abstract org.xms.g.tasks.Task<XTResult> addOnFailureListener(org.xms.g.tasks.OnFailureListener param0);
    
    public abstract org.xms.g.tasks.Task<XTResult> addOnFailureListener(java.util.concurrent.Executor param0, org.xms.g.tasks.OnFailureListener param1);
    
    public abstract org.xms.g.tasks.Task<XTResult> addOnSuccessListener(java.util.concurrent.Executor param0, org.xms.g.tasks.OnSuccessListener<? super XTResult> param1);
    
    public abstract org.xms.g.tasks.Task<XTResult> addOnSuccessListener(org.xms.g.tasks.OnSuccessListener<? super XTResult> param0);
    
    public abstract org.xms.g.tasks.Task<XTResult> addOnSuccessListener(android.app.Activity param0, org.xms.g.tasks.OnSuccessListener<? super XTResult> param1);
    
    public <XTContinuationResult> org.xms.g.tasks.Task<XTContinuationResult> continueWith(org.xms.g.tasks.Continuation<XTResult, XTContinuationResult> param0) {
        com.google.android.gms.tasks.Task gReturn = null;
        com.huawei.hmf.tasks.Task hReturn = null;
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hmf.tasks.Task) this.getHInstance()).continueWith(((param0) == null ? null : (param0.getHInstanceContinuation())))", new Exception());
            hReturn = ((com.huawei.hmf.tasks.Task) this.getHInstance()).continueWith(((param0) == null ? null : (param0.getHInstanceContinuation())));
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.tasks.Task) this.getGInstance()).continueWith(((param0) == null ? null : (param0.getGInstanceContinuation())))", new Exception());
            gReturn = ((com.google.android.gms.tasks.Task) this.getGInstance()).continueWith(((param0) == null ? null : (param0.getGInstanceContinuation())));
        }
        if (gReturn == null && hReturn == null) {
            return null;
        }
        return new org.xms.g.tasks.Task.XImpl(gReturn, hReturn);
    }
    
    public <XTContinuationResult> org.xms.g.tasks.Task<XTContinuationResult> continueWith(java.util.concurrent.Executor param0, org.xms.g.tasks.Continuation<XTResult, XTContinuationResult> param1) {
        com.google.android.gms.tasks.Task gReturn = null;
        com.huawei.hmf.tasks.Task hReturn = null;
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hmf.tasks.Task) this.getHInstance()).continueWith(param0, ((param1) == null ? null : (param1.getHInstanceContinuation())))", new Exception());
            hReturn = ((com.huawei.hmf.tasks.Task) this.getHInstance()).continueWith(param0, ((param1) == null ? null : (param1.getHInstanceContinuation())));
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.tasks.Task) this.getGInstance()).continueWith(param0, ((param1) == null ? null : (param1.getGInstanceContinuation())))", new Exception());
            gReturn = ((com.google.android.gms.tasks.Task) this.getGInstance()).continueWith(param0, ((param1) == null ? null : (param1.getGInstanceContinuation())));
        }
        if (gReturn == null && hReturn == null) {
            return null;
        }
        return new org.xms.g.tasks.Task.XImpl(gReturn, hReturn);
    }
    
    public <XTContinuationResult> org.xms.g.tasks.Task<XTContinuationResult> continueWithTask(org.xms.g.tasks.Continuation<XTResult, org.xms.g.tasks.Task<XTContinuationResult>> param0) {
        com.google.android.gms.tasks.Task gReturn = null;
        com.huawei.hmf.tasks.Task hReturn = null;
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hmf.tasks.Task) this.getHInstance()).continueWithTask(((param0) == null ? null : (param0.getHInstanceContinuation())))", new Exception());
            hReturn = ((com.huawei.hmf.tasks.Task) this.getHInstance()).continueWithTask(((param0) == null ? null : (param0.getHInstanceContinuation())));
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.tasks.Task) this.getGInstance()).continueWithTask(((param0) == null ? null : (param0.getGInstanceContinuation())))", new Exception());
            gReturn = ((com.google.android.gms.tasks.Task) this.getGInstance()).continueWithTask(((param0) == null ? null : (param0.getGInstanceContinuation())));
        }
        if (gReturn == null && hReturn == null) {
            return null;
        }
        return new org.xms.g.tasks.Task.XImpl(gReturn, hReturn);
    }
    
    public <XTContinuationResult> org.xms.g.tasks.Task<XTContinuationResult> continueWithTask(java.util.concurrent.Executor param0, org.xms.g.tasks.Continuation<XTResult, org.xms.g.tasks.Task<XTContinuationResult>> param1) {
        com.google.android.gms.tasks.Task gReturn = null;
        com.huawei.hmf.tasks.Task hReturn = null;
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hmf.tasks.Task) this.getHInstance()).continueWithTask(param0, ((param1) == null ? null : (param1.getHInstanceContinuation())))", new Exception());
            hReturn = ((com.huawei.hmf.tasks.Task) this.getHInstance()).continueWithTask(param0, ((param1) == null ? null : (param1.getHInstanceContinuation())));
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.tasks.Task) this.getGInstance()).continueWithTask(param0, ((param1) == null ? null : (param1.getGInstanceContinuation())))", new Exception());
            gReturn = ((com.google.android.gms.tasks.Task) this.getGInstance()).continueWithTask(param0, ((param1) == null ? null : (param1.getGInstanceContinuation())));
        }
        if (gReturn == null && hReturn == null) {
            return null;
        }
        return new org.xms.g.tasks.Task.XImpl(gReturn, hReturn);
    }
    
    public abstract java.lang.Exception getException();
    
    public abstract XTResult getResult();
    
    public abstract <XX extends java.lang.Throwable> XTResult getResult(java.lang.Class<XX> param0) throws XX;
    
    public abstract boolean isCanceled();
    
    public abstract boolean isComplete();
    
    public abstract boolean isSuccessful();
    
    public <XTContinuationResult> org.xms.g.tasks.Task<XTContinuationResult> onSuccessTask(java.util.concurrent.Executor param0, org.xms.g.tasks.SuccessContinuation<XTResult, XTContinuationResult> param1) {
        com.google.android.gms.tasks.Task gReturn = null;
        com.huawei.hmf.tasks.Task hReturn = null;
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hmf.tasks.Task) this.getHInstance()).onSuccessTask(param0, ((param1) == null ? null : (param1.getHInstanceSuccessContinuation())))", new Exception());
            hReturn = ((com.huawei.hmf.tasks.Task) this.getHInstance()).onSuccessTask(param0, ((param1) == null ? null : (param1.getHInstanceSuccessContinuation())));
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.tasks.Task) this.getGInstance()).onSuccessTask(param0, ((param1) == null ? null : (param1.getGInstanceSuccessContinuation())))", new Exception());
            gReturn = ((com.google.android.gms.tasks.Task) this.getGInstance()).onSuccessTask(param0, ((param1) == null ? null : (param1.getGInstanceSuccessContinuation())));
        }
        if (gReturn == null && hReturn == null) {
            return null;
        }
        return new org.xms.g.tasks.Task.XImpl(gReturn, hReturn);
    }
    
    public <XTContinuationResult> org.xms.g.tasks.Task<XTContinuationResult> onSuccessTask(org.xms.g.tasks.SuccessContinuation<XTResult, XTContinuationResult> param0) {
        com.google.android.gms.tasks.Task gReturn = null;
        com.huawei.hmf.tasks.Task hReturn = null;
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hmf.tasks.Task) this.getHInstance()).onSuccessTask(((param0) == null ? null : (param0.getHInstanceSuccessContinuation())))", new Exception());
            hReturn = ((com.huawei.hmf.tasks.Task) this.getHInstance()).onSuccessTask(((param0) == null ? null : (param0.getHInstanceSuccessContinuation())));
        } else {
            org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.tasks.Task) this.getGInstance()).onSuccessTask(((param0) == null ? null : (param0.getGInstanceSuccessContinuation())))", new Exception());
            gReturn = ((com.google.android.gms.tasks.Task) this.getGInstance()).onSuccessTask(((param0) == null ? null : (param0.getGInstanceSuccessContinuation())));
        }
        if (gReturn == null && hReturn == null) {
            return null;
        }
        return new org.xms.g.tasks.Task.XImpl(gReturn, hReturn);
    }
    
    public static org.xms.g.tasks.Task dynamicCast(java.lang.Object param0) {
        if (param0 instanceof org.xms.g.tasks.Task) {
            return ((org.xms.g.tasks.Task) param0);
        }
        if (param0 instanceof org.xms.g.utils.XGettable) {
            com.google.android.gms.tasks.Task gReturn = ((com.google.android.gms.tasks.Task) ((org.xms.g.utils.XGettable) param0).getGInstance());
            com.huawei.hmf.tasks.Task hReturn = ((com.huawei.hmf.tasks.Task) ((org.xms.g.utils.XGettable) param0).getHInstance());
            return new org.xms.g.tasks.Task.XImpl(gReturn, hReturn);
        }
        return ((org.xms.g.tasks.Task) param0);
    }
    
    public static boolean isInstance(java.lang.Object param0) {
        if (!(param0 instanceof org.xms.g.utils.XObject)) {
            return false;
        }
        if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
            return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hmf.tasks.Task;
        } else {
            return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.tasks.Task;
        }
    }
    
    public static class XImpl<XTResult> extends org.xms.g.tasks.Task<XTResult> {
        
        public XImpl(com.google.android.gms.tasks.Task param0, com.huawei.hmf.tasks.Task param1) {
            super(param0, param1);
        }
        
        public static boolean isInstance(java.lang.Object param0) {
            if (!(param0 instanceof org.xms.g.utils.XObject)) {
                return false;
            }
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                return ((org.xms.g.utils.XObject) param0).getHInstance() instanceof com.huawei.hmf.tasks.Task;
            } else {
                return ((org.xms.g.utils.XObject) param0).getGInstance() instanceof com.google.android.gms.tasks.Task;
            }
        }
        
        public org.xms.g.tasks.Task<XTResult> addOnFailureListener(android.app.Activity param0, org.xms.g.tasks.OnFailureListener param1) {
            com.google.android.gms.tasks.Task gReturn = null;
            com.huawei.hmf.tasks.Task hReturn = null;
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hmf.tasks.Task) this.getHInstance()).addOnFailureListener(param0, ((param1) == null ? null : (param1.getHInstanceOnFailureListener())))", new Exception());
                hReturn = ((com.huawei.hmf.tasks.Task) this.getHInstance()).addOnFailureListener(param0, ((param1) == null ? null : (param1.getHInstanceOnFailureListener())));
            } else {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.tasks.Task) this.getGInstance()).addOnFailureListener(param0, ((param1) == null ? null : (param1.getGInstanceOnFailureListener())))", new Exception());
                gReturn = ((com.google.android.gms.tasks.Task) this.getGInstance()).addOnFailureListener(param0, ((param1) == null ? null : (param1.getGInstanceOnFailureListener())));
            }
            if (gReturn == null && hReturn == null) {
                return null;
            }
            return new org.xms.g.tasks.Task.XImpl(gReturn, hReturn);
        }
        
        public org.xms.g.tasks.Task<XTResult> addOnFailureListener(org.xms.g.tasks.OnFailureListener param0) {
            com.google.android.gms.tasks.Task gReturn = null;
            com.huawei.hmf.tasks.Task hReturn = null;
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hmf.tasks.Task) this.getHInstance()).addOnFailureListener(((param0) == null ? null : (param0.getHInstanceOnFailureListener())))", new Exception());
                hReturn = ((com.huawei.hmf.tasks.Task) this.getHInstance()).addOnFailureListener(((param0) == null ? null : (param0.getHInstanceOnFailureListener())));
            } else {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.tasks.Task) this.getGInstance()).addOnFailureListener(((param0) == null ? null : (param0.getGInstanceOnFailureListener())))", new Exception());
                gReturn = ((com.google.android.gms.tasks.Task) this.getGInstance()).addOnFailureListener(((param0) == null ? null : (param0.getGInstanceOnFailureListener())));
            }
            if (gReturn == null && hReturn == null) {
                return null;
            }
            return new org.xms.g.tasks.Task.XImpl(gReturn, hReturn);
        }
        
        public org.xms.g.tasks.Task<XTResult> addOnFailureListener(java.util.concurrent.Executor param0, org.xms.g.tasks.OnFailureListener param1) {
            com.google.android.gms.tasks.Task gReturn = null;
            com.huawei.hmf.tasks.Task hReturn = null;
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hmf.tasks.Task) this.getHInstance()).addOnFailureListener(param0, ((param1) == null ? null : (param1.getHInstanceOnFailureListener())))", new Exception());
                hReturn = ((com.huawei.hmf.tasks.Task) this.getHInstance()).addOnFailureListener(param0, ((param1) == null ? null : (param1.getHInstanceOnFailureListener())));
            } else {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.tasks.Task) this.getGInstance()).addOnFailureListener(param0, ((param1) == null ? null : (param1.getGInstanceOnFailureListener())))", new Exception());
                gReturn = ((com.google.android.gms.tasks.Task) this.getGInstance()).addOnFailureListener(param0, ((param1) == null ? null : (param1.getGInstanceOnFailureListener())));
            }
            if (gReturn == null && hReturn == null) {
                return null;
            }
            return new org.xms.g.tasks.Task.XImpl(gReturn, hReturn);
        }
        
        public org.xms.g.tasks.Task<XTResult> addOnSuccessListener(java.util.concurrent.Executor param0, org.xms.g.tasks.OnSuccessListener<? super XTResult> param1) {
            com.google.android.gms.tasks.Task gReturn = null;
            com.huawei.hmf.tasks.Task hReturn = null;
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hmf.tasks.Task) this.getHInstance()).addOnSuccessListener(param0, ((param1) == null ? null : (param1.getHInstanceOnSuccessListener())))", new Exception());
                hReturn = ((com.huawei.hmf.tasks.Task) this.getHInstance()).addOnSuccessListener(param0, ((param1) == null ? null : (param1.getHInstanceOnSuccessListener())));
            } else {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.tasks.Task) this.getGInstance()).addOnSuccessListener(param0, ((param1) == null ? null : (param1.getGInstanceOnSuccessListener())))", new Exception());
                gReturn = ((com.google.android.gms.tasks.Task) this.getGInstance()).addOnSuccessListener(param0, ((param1) == null ? null : (param1.getGInstanceOnSuccessListener())));
            }
            if (gReturn == null && hReturn == null) {
                return null;
            }
            return new org.xms.g.tasks.Task.XImpl(gReturn, hReturn);
        }
        
        public org.xms.g.tasks.Task<XTResult> addOnSuccessListener(org.xms.g.tasks.OnSuccessListener<? super XTResult> param0) {
            com.google.android.gms.tasks.Task gReturn = null;
            com.huawei.hmf.tasks.Task hReturn = null;
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hmf.tasks.Task) this.getHInstance()).addOnSuccessListener(((param0) == null ? null : (param0.getHInstanceOnSuccessListener())))", new Exception());
                hReturn = ((com.huawei.hmf.tasks.Task) this.getHInstance()).addOnSuccessListener(((param0) == null ? null : (param0.getHInstanceOnSuccessListener())));
            } else {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.tasks.Task) this.getGInstance()).addOnSuccessListener(((param0) == null ? null : (param0.getGInstanceOnSuccessListener())))", new Exception());
                gReturn = ((com.google.android.gms.tasks.Task) this.getGInstance()).addOnSuccessListener(((param0) == null ? null : (param0.getGInstanceOnSuccessListener())));
            }
            if (gReturn == null && hReturn == null) {
                return null;
            }
            return new org.xms.g.tasks.Task.XImpl(gReturn, hReturn);
        }
        
        public org.xms.g.tasks.Task<XTResult> addOnSuccessListener(android.app.Activity param0, org.xms.g.tasks.OnSuccessListener<? super XTResult> param1) {
            com.google.android.gms.tasks.Task gReturn = null;
            com.huawei.hmf.tasks.Task hReturn = null;
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hmf.tasks.Task) this.getHInstance()).addOnSuccessListener(param0, ((param1) == null ? null : (param1.getHInstanceOnSuccessListener())))", new Exception());
                hReturn = ((com.huawei.hmf.tasks.Task) this.getHInstance()).addOnSuccessListener(param0, ((param1) == null ? null : (param1.getHInstanceOnSuccessListener())));
            } else {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.tasks.Task) this.getGInstance()).addOnSuccessListener(param0, ((param1) == null ? null : (param1.getGInstanceOnSuccessListener())))", new Exception());
                gReturn = ((com.google.android.gms.tasks.Task) this.getGInstance()).addOnSuccessListener(param0, ((param1) == null ? null : (param1.getGInstanceOnSuccessListener())));
            }
            if (gReturn == null && hReturn == null) {
                return null;
            }
            return new org.xms.g.tasks.Task.XImpl(gReturn, hReturn);
        }
        
        public java.lang.Exception getException() {
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hmf.tasks.Task) this.getHInstance()).getException()", new Exception());
                return ((com.huawei.hmf.tasks.Task) this.getHInstance()).getException();
            } else {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.tasks.Task) this.getGInstance()).getException()", new Exception());
                return ((com.google.android.gms.tasks.Task) this.getGInstance()).getException();
            }
        }
        
        public XTResult getResult() {
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hmf.tasks.Task) this.getHInstance()).getResult()", new Exception());
                java.lang.Object hmsObj = ((com.huawei.hmf.tasks.Task) this.getHInstance()).getResult();
                boolean flag = org.xms.g.utils.Utils.isHmsType(hmsObj);
                if (flag) {
                    java.lang.Object retObj = null;
                    retObj = org.xms.g.utils.Utils.getXmsObjectWithHmsObject(hmsObj);
                    return ((XTResult) retObj);
                } else {
                    return ((XTResult) hmsObj);
                }
            } else {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.tasks.Task) this.getGInstance()).getResult()", new Exception());
                java.lang.Object gmsObj = ((com.google.android.gms.tasks.Task) this.getGInstance()).getResult();
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
        
        public <XX extends java.lang.Throwable> XTResult getResult(java.lang.Class<XX> param0) throws XX {
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                try {
                    java.lang.Class gObj0 = null;
                    gObj0 = org.xms.g.utils.Utils.getHmsClassWithXmsClass(param0);
                    org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hmf.tasks.Task) this.getHInstance()).getResultThrowException(gObj0)", new Exception());
                    java.lang.Object hmsObj = ((com.huawei.hmf.tasks.Task) this.getHInstance()).getResultThrowException(gObj0);
                    boolean flag = org.xms.g.utils.Utils.isHmsType(hmsObj);
                    if (flag) {
                        java.lang.Object retObj = null;
                        retObj = org.xms.g.utils.Utils.getXmsObjectWithHmsObject(hmsObj);
                        return ((XTResult) retObj);
                    } else {
                        return ((XTResult) hmsObj);
                    }
                }
                catch (java.lang.Throwable e) {
                    java.lang.Object retObj = null;
                    boolean flag = org.xms.g.utils.Utils.isHmsType(e);
                    if (flag) {
                        retObj = org.xms.g.utils.Utils.getXmsObjectWithHmsObject(e);
                    } else {
                        retObj = e;
                    }
                    throw ((XX) retObj);
                }
            } else {
                try {
                    java.lang.Class gObj0 = null;
                    gObj0 = org.xms.g.utils.Utils.getGmsClassWithXmsClass(param0);
                    org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.tasks.Task) this.getGInstance()).getResult(gObj0)", new Exception());
                    java.lang.Object gmsObj = ((com.google.android.gms.tasks.Task) this.getGInstance()).getResult(gObj0);
                    boolean flag = org.xms.g.utils.Utils.isGmsType(gmsObj);
                    if (flag) {
                        java.lang.Object retObj = null;
                        retObj = org.xms.g.utils.Utils.getXmsObjectWithGmsObject(gmsObj);
                        return ((XTResult) retObj);
                    } else {
                        return ((XTResult) gmsObj);
                    }
                }
                catch (java.lang.Throwable e) {
                    java.lang.Object retObj = null;
                    boolean flag = org.xms.g.utils.Utils.isGmsType(e);
                    if (flag) {
                        retObj = org.xms.g.utils.Utils.getXmsObjectWithGmsObject(e);
                    } else {
                        retObj = e;
                    }
                    throw ((XX) retObj);
                }
            }
        }
        
        public boolean isCanceled() {
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hmf.tasks.Task) this.getHInstance()).isCanceled()", new Exception());
                return ((com.huawei.hmf.tasks.Task) this.getHInstance()).isCanceled();
            } else {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.tasks.Task) this.getGInstance()).isCanceled()", new Exception());
                return ((com.google.android.gms.tasks.Task) this.getGInstance()).isCanceled();
            }
        }
        
        public boolean isComplete() {
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hmf.tasks.Task) this.getHInstance()).isComplete()", new Exception());
                return ((com.huawei.hmf.tasks.Task) this.getHInstance()).isComplete();
            } else {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.tasks.Task) this.getGInstance()).isComplete()", new Exception());
                return ((com.google.android.gms.tasks.Task) this.getGInstance()).isComplete();
            }
        }
        
        public boolean isSuccessful() {
            if (org.xms.g.utils.GlobalEnvSetting.isHms()) {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.huawei.hmf.tasks.Task) this.getHInstance()).isSuccessful()", new Exception());
                return ((com.huawei.hmf.tasks.Task) this.getHInstance()).isSuccessful();
            } else {
                org.xms.g.utils.XmsLog.d("XMSRouter", "((com.google.android.gms.tasks.Task) this.getGInstance()).isSuccessful()", new Exception());
                return ((com.google.android.gms.tasks.Task) this.getGInstance()).isSuccessful();
            }
        }
    }
}
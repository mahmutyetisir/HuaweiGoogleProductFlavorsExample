package org.xms.g.auth;

public class AccountChangeEvent extends org.xms.g.utils.XObject implements android.os.Parcelable {
    private boolean wrapper = true;
    public final static android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {
        
        public org.xms.g.auth.AccountChangeEvent createFromParcel(android.os.Parcel param0) {
            throw new java.lang.RuntimeException("Not Supported");
        }
        
        public org.xms.g.auth.AccountChangeEvent[] newArray(int param0) {
            throw new java.lang.RuntimeException("Not Supported");
        }
    };
    
    public AccountChangeEvent(com.google.android.gms.auth.AccountChangeEvent param0, java.lang.Object param1) {
        super(param0, null);
    }
    
    public AccountChangeEvent(long param0, java.lang.String param1, int param2, int param3, java.lang.String param4) {
        super(((com.google.android.gms.auth.AccountChangeEvent) null), null);
    }
    
    public boolean equals(java.lang.Object param0) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public java.lang.String getAccountName() {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public java.lang.String getChangeData() {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public int getChangeType() {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public int getEventIndex() {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public int hashCode() {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public java.lang.String toString() {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public void writeToParcel(android.os.Parcel param0, int param1) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public int describeContents() {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static org.xms.g.auth.AccountChangeEvent dynamicCast(java.lang.Object param0) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static boolean isInstance(java.lang.Object param0) {
        throw new java.lang.RuntimeException("Not Supported");
    }
}
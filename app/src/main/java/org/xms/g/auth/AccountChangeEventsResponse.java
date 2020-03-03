package org.xms.g.auth;

public class AccountChangeEventsResponse extends org.xms.g.utils.XObject implements android.os.Parcelable {
    private boolean wrapper = true;
    public final static android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {
        
        public org.xms.g.auth.AccountChangeEventsResponse createFromParcel(android.os.Parcel param0) {
            throw new java.lang.RuntimeException("Not Supported");
        }
        
        public org.xms.g.auth.AccountChangeEventsResponse[] newArray(int param0) {
            throw new java.lang.RuntimeException("Not Supported");
        }
    };
    
    public AccountChangeEventsResponse(com.google.android.gms.auth.AccountChangeEventsResponse param0, java.lang.Object param1) {
        super(param0, null);
    }
    
    public AccountChangeEventsResponse(java.util.List<org.xms.g.auth.AccountChangeEvent> param0) {
        super(((com.google.android.gms.auth.AccountChangeEventsResponse) null), null);
    }
    
    public java.util.List<org.xms.g.auth.AccountChangeEvent> getEvents() {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public void writeToParcel(android.os.Parcel param0, int param1) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public int describeContents() {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static org.xms.g.auth.AccountChangeEventsResponse dynamicCast(java.lang.Object param0) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static boolean isInstance(java.lang.Object param0) {
        throw new java.lang.RuntimeException("Not Supported");
    }
}
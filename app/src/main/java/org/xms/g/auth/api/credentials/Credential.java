package org.xms.g.auth.api.credentials;

public class Credential extends org.xms.g.utils.XObject implements android.os.Parcelable {
    private boolean wrapper = true;
    public final static android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {
        
        public org.xms.g.auth.api.credentials.Credential createFromParcel(android.os.Parcel param0) {
            throw new java.lang.RuntimeException("Not Supported");
        }
        
        public org.xms.g.auth.api.credentials.Credential[] newArray(int param0) {
            throw new java.lang.RuntimeException("Not Supported");
        }
    };
    
    public Credential(com.google.android.gms.auth.api.credentials.Credential param0, java.lang.Object param1) {
        super(param0, null);
    }
    
    public static java.lang.String getEXTRA_KEY() {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public boolean equals(java.lang.Object param0) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public java.lang.String getAccountType() {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public java.lang.String getFamilyName() {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public java.lang.String getGivenName() {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public java.lang.String getId() {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public java.util.List<org.xms.g.auth.api.credentials.IdToken> getIdTokens() {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public java.lang.String getName() {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public java.lang.String getPassword() {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public android.net.Uri getProfilePictureUri() {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public int hashCode() {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public void writeToParcel(android.os.Parcel param0, int param1) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public int describeContents() {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static org.xms.g.auth.api.credentials.Credential dynamicCast(java.lang.Object param0) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static boolean isInstance(java.lang.Object param0) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static class Builder extends org.xms.g.utils.XObject {
        
        public Builder(com.google.android.gms.auth.api.credentials.Credential.Builder param0, java.lang.Object param1) {
            super(param0, null);
        }
        
        public Builder(java.lang.String param0) {
            super(((com.google.android.gms.auth.api.credentials.Credential.Builder) null), null);
        }
        
        public Builder(org.xms.g.auth.api.credentials.Credential param0) {
            super(((com.google.android.gms.auth.api.credentials.Credential.Builder) null), null);
        }
        
        public org.xms.g.auth.api.credentials.Credential build() {
            throw new java.lang.RuntimeException("Not Supported");
        }
        
        public org.xms.g.auth.api.credentials.Credential.Builder setAccountType(java.lang.String param0) {
            throw new java.lang.RuntimeException("Not Supported");
        }
        
        public org.xms.g.auth.api.credentials.Credential.Builder setName(java.lang.String param0) {
            throw new java.lang.RuntimeException("Not Supported");
        }
        
        public org.xms.g.auth.api.credentials.Credential.Builder setPassword(java.lang.String param0) {
            throw new java.lang.RuntimeException("Not Supported");
        }
        
        public org.xms.g.auth.api.credentials.Credential.Builder setProfilePictureUri(android.net.Uri param0) {
            throw new java.lang.RuntimeException("Not Supported");
        }
        
        public static org.xms.g.auth.api.credentials.Credential.Builder dynamicCast(java.lang.Object param0) {
            throw new java.lang.RuntimeException("Not Supported");
        }
        
        public static boolean isInstance(java.lang.Object param0) {
            throw new java.lang.RuntimeException("Not Supported");
        }
    }
}
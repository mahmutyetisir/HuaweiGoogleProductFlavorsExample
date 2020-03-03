package org.xms.g.common;

public final class SignInButton extends android.widget.FrameLayout implements android.view.View.OnClickListener, org.xms.g.utils.XGettable {
    public com.google.android.gms.common.SignInButton gInstance;
    public java.lang.Object hInstance;
    
    public SignInButton(android.content.Context param0) {
        super(param0);
    }
    
    public SignInButton(android.content.Context param0, android.util.AttributeSet param1) {
        super(param0, param1);
    }
    
    public SignInButton(android.content.Context param0, android.util.AttributeSet param1, int param2) {
        super(param0, param1, param2);
    }
    
    public static int getCOLOR_AUTO() {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static int getCOLOR_DARK() {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static int getCOLOR_LIGHT() {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static int getSIZE_ICON_ONLY() {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static int getSIZE_STANDARD() {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static int getSIZE_WIDE() {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public final void onClick(android.view.View param0) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public final void setColorScheme(int param0) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public final void setEnabled(boolean param0) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public final void setOnClickListener(android.view.View.OnClickListener param0) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public final void setScopes(org.xms.g.common.api.Scope[] param0) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public final void setSize(int param0) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public final void setStyle(int param0, int param1, org.xms.g.common.api.Scope[] param2) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public final void setStyle(int param0, int param1) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public void setGInstance(com.google.android.gms.common.SignInButton param0) {
        this.gInstance = param0;
    }
    
    public void setHInstance(java.lang.Object param0) {
        this.hInstance = param0;
    }
    
    public java.lang.Object getGInstance() {
        return this.gInstance;
    }
    
    public java.lang.Object getHInstance() {
        return this.hInstance;
    }
    
    public static org.xms.g.common.SignInButton dynamicCast(java.lang.Object param0) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static boolean isInstance(java.lang.Object param0) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public org.xms.g.common.SignInButton wrapInst(com.google.android.gms.common.SignInButton param0, java.lang.Object param1) {
        gInstance = param0;
        hInstance = param1;
        return this;
    }
}
package org.xms.g.common.images;

public final class ImageManager extends org.xms.g.utils.XObject {
    
    public ImageManager(com.google.android.gms.common.images.ImageManager param0, java.lang.Object param1) {
        super(param0, null);
    }
    
    public final org.xms.g.common.images.ImageManager create(android.content.Context param0) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public final void loadImage(android.widget.ImageView param0, android.net.Uri param1, int param2) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public final void loadImage(org.xms.g.common.images.ImageManager.OnImageLoadedListener param0, android.net.Uri param1) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public final void loadImage(android.widget.ImageView param0, int param1) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public final void loadImage(org.xms.g.common.images.ImageManager.OnImageLoadedListener param0, android.net.Uri param1, int param2) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public final void loadImage(android.widget.ImageView param0, android.net.Uri param1) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static org.xms.g.common.images.ImageManager dynamicCast(java.lang.Object param0) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static boolean isInstance(java.lang.Object param0) {
        throw new java.lang.RuntimeException("Not Supported");
    }
    
    public static interface OnImageLoadedListener extends org.xms.g.utils.XInterface {
        
        public void onImageLoaded(android.net.Uri param0, android.graphics.drawable.Drawable param1, boolean param2);
        
        default com.google.android.gms.common.images.ImageManager.OnImageLoadedListener getGInstanceOnImageLoadedListener() {
            throw new java.lang.RuntimeException("Not Supported");
        }
        
        default java.lang.Object getHInstanceOnImageLoadedListener() {
            throw new java.lang.RuntimeException("Not Supported");
        }
        
        public static org.xms.g.common.images.ImageManager.OnImageLoadedListener dynamicCast(java.lang.Object param0) {
            throw new java.lang.RuntimeException("Not Supported");
        }
        
        public static boolean isInstance(java.lang.Object param0) {
            throw new java.lang.RuntimeException("Not Supported");
        }
        
        public static class XImpl extends org.xms.g.utils.XObject implements org.xms.g.common.images.ImageManager.OnImageLoadedListener {
            
            public XImpl(com.google.android.gms.common.images.ImageManager.OnImageLoadedListener param0, java.lang.Object param1) {
                super(param0, param1);
            }
            
            public static boolean isInstance(java.lang.Object param0) {
                throw new java.lang.RuntimeException("Not Supported");
            }
            
            public void onImageLoaded(android.net.Uri param0, android.graphics.drawable.Drawable param1, boolean param2) {
                throw new java.lang.RuntimeException("Not Supported");
            }
        }
    }
}
package se.hanell.test.testingopengl;

import android.content.Context;
import android.opengl.GLSurfaceView;

public class CustomGLSurfaceView extends GLSurfaceView {

    private final CustomGLRenderer customGLRenderer;

    public CustomGLSurfaceView(Context context) {
        super(context);

        setEGLContextClientVersion(2);
        customGLRenderer = new CustomGLRenderer();
        setRenderer(customGLRenderer);
        //setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
    }
}

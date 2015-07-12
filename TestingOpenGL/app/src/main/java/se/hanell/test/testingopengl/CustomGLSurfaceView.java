package se.hanell.test.testingopengl;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;

public class CustomGLSurfaceView extends GLSurfaceView {

    private final CustomGLRenderer customGLRenderer;
    private final float TOUCH_SCALE_FACTOR = 180.0f / 320;
    private float mPreviousX;
    private float mPreviousY;

    public CustomGLSurfaceView(Context context) {
        super(context);

        setEGLContextClientVersion(2);
        customGLRenderer = new CustomGLRenderer();
        setRenderer(customGLRenderer);
        setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()){
        case MotionEvent.ACTION_MOVE:
            float dx = x - mPreviousX;
            float dy = y - mPreviousY;

            if(y > getHeight()/2){
                dx = dx*-1;
            }
            if(x < getHeight()/2){
                dy = dy*-1;
            }
            customGLRenderer.setAngle(customGLRenderer.getAngle() + ((dx+dy)*TOUCH_SCALE_FACTOR));
            requestRender();
        }
        mPreviousX = x;
        mPreviousY = y;
        return true;
    }
}

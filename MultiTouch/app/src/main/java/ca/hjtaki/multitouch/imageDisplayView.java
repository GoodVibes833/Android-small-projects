package ca.hjtaki.multitouch;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class imageDisplayView extends View {

    Paint paint; // 그릴때
    Matrix matrix; // 확대축소

    public imageDisplayView(Context context) {
        super(context);
        init(context);
    }

    public imageDisplayView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public void init(Context context){
        paint = new Paint();
        matrix = new Matrix();



    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        //메모리에 똑같은 이미지를 만든다, 더블 버퍼링 : 메모리에 미리 그리고 나중에 화면에 뿌리면 속도가 안느리다



    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }


}

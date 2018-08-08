package ca.hjtaki.drawbitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class myView extends View {

    //미리 메모리에 만들어둔 비트맵을 drawBitmap()을 통해 화면에 보여주기만 한다 : 더블 버퍼링

    Bitmap bitmap;
    Bitmap mBitmap;
    Canvas mCanvas;


    public myView(Context context) {
        super(context);

        init(context);
    }

    public myView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);

    }

    private void init(Context context){
        //비트맵 불러오기
        bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.android);


    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        // 메모리에 비트맵 객체 만들기.
        super.onSizeChanged(w, h, oldw, oldh);
        mBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);

        //이 객체에 그리기를 하고싶다
        mCanvas = new Canvas();
        mCanvas.setBitmap(mBitmap);

        Paint paint = new Paint();
        paint.setColor(Color.RED);
        mCanvas.drawLine(100,100,400,200,paint);
        mCanvas.drawBitmap(bitmap,0,0,null);

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(mBitmap, 0,0,null);
    }
}

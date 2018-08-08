package ca.hjtaki.viewgraphic;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

public class CustomView extends View {
    Paint paint;
    int deviceWidth;
    int deviceHeihjt;
    ShapeDrawable drawable;

    public CustomView(Context context) {
        super(context);
        init(context);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init (Context context){
        //표준자바 문법이 아니다. 좀더 빠르게 하기 위해서, 안드로이드 UI시스템 설계
        paint = new Paint();
        paint.setColor(Color.RED);

        //단말 화면 크기 구하기
        WindowManager manager = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
        Display display = manager.getDefaultDisplay();
        deviceWidth = display.getWidth();
        deviceHeihjt = display.getHeight();



         drawable = new ShapeDrawable();
        RectShape rect = new RectShape();
        rect.resize(deviceWidth,deviceHeihjt/2.0f);
        drawable.setShape(rect);
        drawable.setBounds(0,0,deviceWidth,deviceHeihjt);

        LinearGradient gradient = new LinearGradient(0,0,0,deviceHeihjt,Color.BLUE,Color.YELLOW, Shader.TileMode.CLAMP);

        Paint curPaint = drawable.getPaint();
        curPaint.setShader(gradient);

    }
    // 이 켄버스에 그려주세요 화면에 보이기 전에 이 안에서 그려주세요
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//
//        paint.setStyle(Paint.Style.STROKE);
//        paint.setStrokeWidth(4.0f);
//        paint.setColor(Color.GREEN);
//        canvas.drawRect(10,10,100,100,paint);
//
//        paint.setStyle(Paint.Style.FILL);
//        paint.setARGB(128,0,0,255);
//        canvas.drawRect(120,10,210,100,paint);
//
//        DashPathEffect dashPathEffect = new DashPathEffect(new float[]{5,5},1);
//        paint.setStyle(Paint.Style.STROKE);
//        paint.setStrokeWidth(5.0f);
//        paint.setPathEffect(dashPathEffect);
//        paint.setColor(Color.GREEN);
//        canvas.drawRect(120,10,210,100,paint);
//
//        paint.setStyle(Paint.Style.FILL);
//        paint.setTextSize(40.0f);
//        canvas.drawText("안녕하세요",20,320,paint);


        drawable.draw(canvas);





    }


    //터치했을 때 호출이 된다.
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        if(action == MotionEvent.ACTION_DOWN){
            Toast.makeText(getContext(), "눌렸음", Toast.LENGTH_LONG).show();
        }
        return true;
    }
}

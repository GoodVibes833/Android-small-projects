package ca.hjtaki.twodimgraghic;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import java.util.jar.Attributes;

public class CanvasView extends View {

    public CanvasView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }



    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //drawing

        Paint red = new Paint();
        red.setARGB(255,255,0,0);
        red.setStyle(Paint.Style.FILL_AND_STROKE);

        canvas.drawRect(50,50,150,150,red);

        Paint blue = new Paint();
        blue.setARGB(255,0,0,255);
        blue.setTypeface(Typeface.create(Typeface.MONOSPACE,Typeface.BOLD));
        blue.setTextSize(50);
        blue.setStyle(Paint.Style.STROKE);

        canvas.drawCircle(150,200,100,blue);
        canvas.drawText("welcom Back!",200,200,blue);



        //exercise 1

        //face
        Paint yellow = new Paint();
        yellow.setARGB(255,255,255,0);
        yellow.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawCircle(185,185,100,yellow);

        //eye

        Paint blueStroke = new Paint();
        blueStroke.setARGB(255,0,0,255);
        blueStroke.setStyle(Paint.Style.FILL_AND_STROKE);

        canvas.drawCircle(140,140,30,blueStroke);
        canvas.drawCircle(230,140,30,blueStroke);

        //nose
        Paint black = new Paint();
        black.setARGB(255,0,0,0);
        canvas.drawCircle(190,180,20,black);

        //mouth
        canvas.drawRect(150,230,230,250,red);

        //text
        canvas.drawText("smilely face",300,300,blue);








    }
}

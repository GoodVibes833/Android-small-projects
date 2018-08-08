package ca.hjtaki.twodimgraghic;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class BounceBall extends View {
    private float ballX = 30;
    private float ballY = 30;
    private static float size = 25;
    private float velocityX = 10;
    private float velocityY = 10;

    public BounceBall(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint red = new Paint();
        red.setARGB(255,255,0,0);
        canvas.drawCircle(ballX,ballY,size,red);

        ballX += velocityX;
        ballY += velocityY;

        int width = canvas.getWidth();
        int height = canvas.getHeight();

        if(ballX + size >= width || ballX <= 0 + size){
            velocityX = -velocityX;
        }
        if(ballY + size >= height || ballY <= 0 + size){
            velocityY = -velocityY;
        }



    }
}

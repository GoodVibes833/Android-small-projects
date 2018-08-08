package ca.hjtaki.mybuttonbitmap;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class BitMapButton extends AppCompatButton {
    public BitMapButton(Context context) {
        super(context);
        init(context);
    }

    public BitMapButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context){
        setBackgroundResource(R.drawable.mediumsize);

        //픽셀말고 dp로 사용하고 싶을때
        float textSize = getResources().getDimension(R.dimen.text_size);
        setTextSize(textSize);
        setTextColor(Color.WHITE);

    }

    //터치 했을떄
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action =  event.getAction();

        switch (action){
            case MotionEvent.ACTION_DOWN:
                setBackgroundResource(R.drawable.gmail);
                break;

            case MotionEvent.ACTION_UP:
                setBackgroundResource(R.drawable.facebook);
                break;

        }
        invalidate(); // 버튼의 그래픽을 다시 그림
        return true;

    }



}

package ca.hjtaki.sliding;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout page;
    Button button;
    Animation translateLeft;
    Animation translateRight;

    boolean isOpen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        page = findViewById(R.id.page);
        translateLeft = AnimationUtils.loadAnimation(this,R.anim.translate_left);
        translateRight = AnimationUtils.loadAnimation(this,R.anim.translate_right);

        //등록해주기
        SlidingAnimationListener listener = new SlidingAnimationListener();
        translateRight.setAnimationListener(listener);
        translateLeft.setAnimationListener(listener);

        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isOpen){
                    page.startAnimation(translateRight);
                }else{
                    page.setVisibility(View.VISIBLE);
                    page.startAnimation(translateLeft);
                }



            }
        });



    }
class SlidingAnimationListener implements Animation.AnimationListener{
    @Override
    public void onAnimationStart(Animation animation) {


    }

    @Override
    public void onAnimationEnd(Animation animation) {
        if(isOpen){
            page.setVisibility(View.INVISIBLE);
            button.setText("open");
            isOpen=false;
        }else{
            button.setText("close");
            isOpen=true;

        }

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}

}

package ca.hjtaki.twodimgraghic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    AnimationHelper animationHelper;
    RainDrops rainDrops;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        another way to add canvas to main view
//        CanvasView canvasView = new CanvasView(this,null);
//        setContentView(canvasView);


        setContentView(R.layout.activity_main);

        rainDrops = findViewById(R.id.raindrops);
        animationHelper = new AnimationHelper(rainDrops,50);


    }


//    bounce ball
//    public void startMoving(View view){
//        final BounceBall bb = findViewById(R.id.bouncView);
//        Thread tread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true){
//                    //pause for 50ms = 0.05 sec - 20f/s
//                    try {
//                        Thread.sleep(50);
//                        bb.postInvalidate();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//                }
//
//        }});
//        tread.start();
//    }




    public void rainStart(View view) {
        animationHelper.start();

    }

    public void rainStop(View view) {
        animationHelper.stop();
    }

}




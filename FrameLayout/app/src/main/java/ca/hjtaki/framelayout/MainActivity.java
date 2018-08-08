package ca.hjtaki.framelayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imageView1;
    ImageView imageView2;

    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         imageView1=(ImageView)findViewById(R.id.imageView5); // ㅇㅏ이디 불러내기
         imageView2=(ImageView)findViewById(R.id.imageView8);

    }

    public void onButton1Clicked(View v){
        index +=1;

        if(index>1){
            index=0;
        }

        if(index==0){
            imageView1.setVisibility(View.VISIBLE);
            imageView2.setVisibility(View.INVISIBLE);
        }else if(index==1){

            imageView2.setVisibility(View.VISIBLE);
            imageView1.setVisibility(View.INVISIBLE);
        }

    }
}

package ca.hjtaki.layoutinflater;

import android.content.Context;
import android.support.v4.view.LayoutInflaterFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {
    FrameLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // 메모리의 인플레이션 : 전체 화면 객체화

        container =(FrameLayout)findViewById(R.id.container);



        Button button = findViewById(R.id.button); // 만들어준 버튼 주소 찾기
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
               LayoutInflater inflater= (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
               inflater.inflate(R.layout.sub,container,true);



            }
        });


    }
}

package ca.hjtaki.intent;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("name","mike");               // 화면을 보이는것 뿐 아니라 데이터를 보내고 싶다면
                                                                         // 엑스트라는 따로 읽지 않고 전달만 함
                setResult(Activity.RESULT_OK,intent);                   // 인텐트 안에 엑스트라 데이터를 넣어서 메인으로 전달


                finish();       //stack 구조 , 메인화면이 보임,

            }
        });

    }



}

package ca.hjtaki.intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MenuActivity.class);
                startActivityForResult(intent,101);



            }
        });
    }
    //메뉴에서 보내는 응답을 받을 메소드 만들기, 제너레이트 오버라이드 ...

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        //데이터를 확인해보자
        if(requestCode==101){
           String name[] = data.getStringArrayExtra("name");
            Toast.makeText(getApplicationContext(),"메뉴화면으로부터 응답"+name,Toast.LENGTH_LONG).show();

        }
    }
}

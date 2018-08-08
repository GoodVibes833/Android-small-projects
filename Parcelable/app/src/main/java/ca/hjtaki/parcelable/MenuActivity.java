package ca.hjtaki.parcelable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // 이전화면
            }
        });


        Intent passdedIntent = getIntent(); //받은데이터
        proccessIntent(passdedIntent);}

        private void proccessIntent(Intent intent){

        //방법1
            if(intent!=null){
                ArrayList<String> names =(ArrayList<String>) intent.getSerializableExtra("names");

                if(names !=null){
                    Toast.makeText(getApplicationContext(),"전달받은 이름 리스트 개수 : "+ names.size(),Toast.LENGTH_LONG).show();
                }




                //방법2
                //파슬을 여기서 받는다면
                SimpleData data = (SimpleData)intent.getParcelableExtra("data");
                if(intent!=null){
                    Toast.makeText(getApplicationContext(),"전달받은 simple data : "+ data.message,Toast.LENGTH_LONG).show();
                }


            }

    }
    }

    //얘는 전달되는 용량이 크다 파슬러블을 보자

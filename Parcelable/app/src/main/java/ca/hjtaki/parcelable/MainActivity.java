package ca.hjtaki.parcelable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button= (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MenuActivity.class);

                //여러개 데이터 전달

                ArrayList<String> names = new ArrayList();
                names.add("alex");
                names.add("han");

                intent.putExtra("names",names); // 시스템을 통해 메뉴로 전달됨


                //파슬로 해보자
                SimpleData data = new SimpleData(100,"hellow");
                intent.putExtra("data","data"); //받는쪽에서 이걸 받는다
                //여기 까지


                startActivityForResult(intent,101); // 결과를 받고싶다면
            }
        });
    }
}

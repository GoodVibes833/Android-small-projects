package ca.hjtaki.service;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText =  (EditText)findViewById(R.id.editText);
        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText.getText().toString();

                //시스템으로 실행하기위해 인텐ㅌ트
                Intent intent = new Intent(getApplicationContext(),MyService.class);
                intent.putExtra("command","show");
                intent.putExtra("name",name);
                startService(intent);
                // 두개의 값이 부가 데이터로 전달됨
                //인텐드를 쓰면 서비스가 실행이 된다 .
                //서비스로 가자


            }
        });

        Intent passedIntent = getIntent();
        processCommand(passedIntent);

    }


    @Override
    protected void onNewIntent(Intent intent) {
        processCommand(intent);

        super.onNewIntent(intent);
    }
    private void processCommand(Intent intent){
        if(intent!=null){
            String command = intent.getStringExtra("command");
            String name = intent.getStringExtra("name");

            Toast.makeText(this,"서브스로부터 전달받은 데이터 : " +command+ ","+name,Toast.LENGTH_LONG).show();
        }

    }
}

package ca.hjtaki.lifecycle;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
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

        Toast.makeText(this,"Oncreated() 호출됨",Toast.LENGTH_LONG).show();

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"onStart() 호출됨",Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this,"onStop() 호출됨",Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"onDestroy() 호출됨",Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this,"onPause() 호출됨",Toast.LENGTH_LONG).show();

        // 여기서 저장해야 한다

        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("name","소녀시대"); // 네임으로 하나 저장함
        editor.commit();

    }


    @Override
    protected void onResume() {
        super.onResume();

        Toast.makeText(this,"onResume() 호출됨",Toast.LENGTH_LONG).show();

        //복구를 해보자
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        if(pref!=null){
           String name =  pref.getString("name"," "); // 없으면 빈칸 내놔라
            Toast.makeText(this,"복구된이름 : "+ name, Toast.LENGTH_LONG).show();
        }

    }




}

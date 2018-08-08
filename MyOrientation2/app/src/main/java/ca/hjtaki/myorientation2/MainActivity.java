package ca.hjtaki.myorientation2;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    //방향이 바뀌었을때
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            Toast.makeText(this,"가로방향이 됨 ",Toast.LENGTH_LONG).show();
        }else if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Toast.makeText(this,"세로방향이 됨 ",Toast.LENGTH_LONG).show();

            //메니페스트 설정도 바꿔야함
            
    }
}}

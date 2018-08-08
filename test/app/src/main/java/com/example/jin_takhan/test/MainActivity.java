package com.example.jin_takhan.test;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void onButton1Click(view v){
        Toast.makeText(getApplicationContext(),"button clicked",Toast.LENGTH_LONG).show();
    }

    public void onButton2Click(view v){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"));
        startActivity(intent);
    }

    public void onButton3Click(view v){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:010-123-1234"));
        startActivity(intent);

    }
    public void onbutton4Clicked(view v){
        Intent intent = new Intent( this,MenuActivity.class);

    }

}

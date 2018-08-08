package com.example.jin_takhan.day2hello;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R .layout.activity_main);
    }

    public void onButton1Clicked(View v) {
        Toast.makeText(this, "button clicked", Toast.LENGTH_LONG).show();
    }
}

package ca.hjtaki.basicwidget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        
        RadioButton radioButton1 = findViewById(R.id.radioButton);
        boolean checked = radioButton1.isChecked();

    }

}

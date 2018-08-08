package ca.hjtaki.tutleninja;


import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Spinner spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView tv = findViewById(R.id.topTv);
                String text = (String) parent.getSelectedItem();
                tv.setText(text);

                ImageView imageView = findViewById(R.id.imageView);

                if(text.equals("Leo")){
                    imageView.setImageDrawable(getDrawable(R.drawable.blue));
                }
                if(text.equals("Mich")){
                    imageView.setImageDrawable(getDrawable(R.drawable.orange));
                }
                if(text.equals("Donatello")){
                    imageView.setImageDrawable(getDrawable(R.drawable.purple));
                }
                if(text.equals("Raphael")){
                    imageView.setImageDrawable(getDrawable(R.drawable.red));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        RadioGroup rg = findViewById(R.id.radioGroup1);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                ImageView imageView2 = findViewById(R.id.imageView2);

                switch(checkedId){
                    case R.id.rd1:
                        imageView2.setImageDrawable(getDrawable(R.drawable.blue));
                        break;
                    case R.id.rd2:
                        imageView2.setImageDrawable(getDrawable(R.drawable.orange));
                        break;
                    case R.id.rd3:
                        imageView2.setImageDrawable(getDrawable(R.drawable.purple));
                        break;
                    case R.id.rd4:
                        imageView2.setImageDrawable(getDrawable(R.drawable.red));
                        break;
                }
            }
        });
    }
}




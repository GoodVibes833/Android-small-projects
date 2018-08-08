package ca.hjtaki.spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    String [] items = {"소녀시대", "걸스데이", "티아라", "여자친구"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.spinner);
        textView = findViewById(R.id.textView);

        //어댑터를 이용한다 갖다가 쓰자

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, items

        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); //클릭후 보이는 선택 창
        spinner.setAdapter(adapter);

        //클래스를 쓰지 않고 array adapter 정의
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){


            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                textView.setText(items[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                textView.setText("선택 : ");

            }
        });
}}

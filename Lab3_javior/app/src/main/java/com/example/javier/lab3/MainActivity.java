package com.example.javier.lab3;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import java.nio.file.Files;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private Spinner spinner;
    private ImageView imv;
    private TextView tv;

   private int[]movie ={R.raw.catch_me_if_you_can,R.raw.flight_club,R.raw.forrest_gump
           ,R.raw.the_godfather,R.raw.good_will_hunting,R.raw.pulp_fiction,R.raw.the_hangover,
           R.raw.the_shawshank_redemption,R.raw.titanic};


    private int[] imgs ={R.drawable.catch_me_if_you_can,R.drawable.flight_club,
            R.drawable.forrest_gump,R.drawable.god_father,R.drawable.good_will_hunting,
            R.drawable.the_hangover,R.drawable.pulp_fiction,R.drawable.the_hangover
            , R.drawable.the_shaw_shank_redemption};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner  = findViewById(R.id.Movies);
        imv = findViewById(R.id.View);
        tv = findViewById(R.id.namesMovie);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                imv.setImageResource(imgs[position]);
                tv.setText(readContentsFromFile(movie[position]));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) { }

            private String readContentsFromFile(int file) {
                Scanner scan = new Scanner(getResources().openRawResource(file));
                String allText = "";
                while (scan.hasNextLine()) {
                    String line = scan.nextLine();
                    allText += line;
                }
                scan.close();
                return allText;
            }

        });

    }
}





























































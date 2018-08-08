package ca.hjtaki.progress;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    ProgressBar progressBar;
    SeekBar seekBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        progressBar = findViewById(R.id.progressBar);

        seekBar = findViewById(R.id.seekBar);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputStr = editText.getText().toString().trim(); // 텍스트 가져오기, 공백정리
                int input = Integer.parseInt(inputStr);
                progressBar.setProgress(input);
            }
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showProgressDialog();
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //값이 바뀔때 호출 되는놈
                editText.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        }
    public void showProgressDialog(){
        ProgressDialog dialog = new ProgressDialog(this);
        dialog.setProgress(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage("데이터 확인중");
        dialog.show();

    }


}

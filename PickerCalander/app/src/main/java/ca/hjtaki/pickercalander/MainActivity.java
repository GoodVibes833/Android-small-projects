package ca.hjtaki.pickercalander;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    DateTimePicker DateTimePicker;

    //날짜 시간 형식
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textView = findViewById(R.id.textView);
        DateTimePicker = findViewById(R.id.DateTimePicker);



        // 뷰를 통합을 시켰다. 이제 날짜 시간이 바뀌었을때 리스너로 전달 받도록 했다.
        //우리가 정의한 메소드가 나타난다.
        DateTimePicker.setOnDateTImeChangeListner(new OnDateTimeChangeListner() {
            @Override
            public void onDateTimeChage(DateTimePicker view, int year, int month, int day, int hour, int minute) {
                Calendar calendar = Calendar.getInstance();
                calendar.set(year,month,day,hour,minute);
                String currentTime = format.format(calendar.getTime());

                textView.setText(currentTime);


            }
        });




    }
}

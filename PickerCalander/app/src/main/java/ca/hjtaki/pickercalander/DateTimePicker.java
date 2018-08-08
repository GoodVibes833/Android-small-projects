package ca.hjtaki.pickercalander;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Date;

public class DateTimePicker extends LinearLayout {

    OnDateTimeChangeListner listner;

    DatePicker datePicker;
    TimePicker timePicker;
    CheckBox checkBox;


    //컨스트럭터 2개만
    public DateTimePicker(Context context) {
        super(context);
        init(context);
    }

    public DateTimePicker(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    //인플레이션 해서 붙이자, 위에도 넣는다.

    private void init(Context context){
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.picker,this,true);

    //뷰 두개를 찾아보자
         datePicker = findViewById(R.id.datePicker);
         timePicker = findViewById(R.id.timePicker);
         checkBox = findViewById(R.id.checkTImePicker);


     //현재시간 구하기
        Date date = new Date();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        int cuYear = calendar.get(Calendar.YEAR);
        int cuMonth = calendar.get(Calendar.MONTH);
        int cuDay = calendar.get(Calendar.DAY_OF_MONTH);
        int cuHour = calendar.get(Calendar.HOUR);
        int cuMin = calendar.get(Calendar.MINUTE);
        int cuSecond = calendar.get(Calendar.SECOND);


     //데이트 피커는 현재시간으로 이닛을 해야한다.

        datePicker.init(cuYear, cuMonth, cuDay, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                //날짜가 변경되었을떄 부르는 메소드
                if(listner!=null){
                    listner.onDateTimeChage(DateTimePicker.this,year,monthOfYear,dayOfMonth,timePicker.getCurrentHour(), timePicker.getCurrentMinute());
                }



            }
        });

        timePicker.setCurrentHour(cuHour);
        timePicker.setCurrentMinute(cuMin);
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                if(listner!=null){
                    listner.onDateTimeChage(DateTimePicker.this,datePicker.getYear(),datePicker.getMonth(), datePicker.getDayOfMonth(),hourOfDay,minute);
                }

            }
        });

        // 이 객체에서 날짜를 바꾼것을 메인에서도 알수있게 전달하는 코드를 만들어보자 . 이벤트로 전달. 매개체가 필요하다
        // 위 두개를 모두 사용가능하게 하기위해 아래에 메소드 정의 setOnDateTImeChangeListner.


        //체크되면 보이게
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                timePicker.setEnabled(isChecked);
                timePicker.setVisibility(checkBox.isChecked()? View.VISIBLE:View.INVISIBLE);


            }
        });



    }


    public void setOnDateTImeChangeListner(OnDateTimeChangeListner listner){
        this.listner = listner;
    }



    public void updateDateTime(int year, int monthOfyear, int dayOfmonth, int hour, int minute){
        datePicker.updateDate(year,monthOfyear,dayOfmonth);
        timePicker.setCurrentMinute(hour);
        timePicker.setCurrentMinute(minute);
    }


}

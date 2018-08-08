package ca.hjtaki.calandar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    TextView monthText;
    GridView monthView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        monthText = findViewById(R.id.monthText);
        monthView = findViewById(R.id.monthView);

        final monthAdapter adapter = new monthAdapter();
        monthView.setAdapter(adapter);

        monthText.setText(adapter.getCurrentYear()+ "년 " + adapter.getCurrentMonth() + "월");


       Button monthPrevious = findViewById(R.id.monthPrevious);
       monthPrevious.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               adapter.setPreviousMonth();
               adapter.notifyDataSetChanged();
               monthText.setText(adapter.getCurrentYear()+ "년 " + adapter.getCurrentMonth() + "월");


           }
       });


       Button monthNext= findViewById(R.id.monthNext);
       monthNext.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               adapter.setNextMonth();
               adapter.notifyDataSetChanged();
               monthText.setText(adapter.getCurrentYear()+ "년 " + adapter.getCurrentMonth() + "월");


           }
       });


        //어댑터를 만들자 아래처럼

    }

    class monthAdapter extends BaseAdapter {
        //고정된 정보를 배열로 만들자

        MonthItem[] items;
        Calendar calendar ;
        int firstDay;
        int lastDay;
        int currentYear;
        int currentMonth;


        public monthAdapter() {
            items = new MonthItem[7 * 6];
            Date date = new Date();
            calendar = Calendar.getInstance();
            calendar.setTime(date);

            recalculate();
            resetDayNumbers();
        }


        //다음달로 넘기기

        public void setPreviousMonth() {
            calendar.add(Calendar.MONTH , -1);
            recalculate();
            resetDayNumbers();
        }

        public void setNextMonth(){
            calendar.add(Calendar.MONTH,1);
            recalculate();
            resetDayNumbers();
        }

        public int getCurrentYear(){
            return currentYear;
        }

        public int getCurrentMonth(){
            return currentMonth;
        }



        //시작하는 요일
        public void recalculate(){
            calendar.set(Calendar.DAY_OF_MONTH,1); //현재 월에서 1일로 기본으로 함
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK); //그 주에서 몇번째 날이냐
            firstDay= getFirstDay(dayOfWeek);

            currentYear = calendar.get(calendar.YEAR);
            currentMonth = calendar.get(calendar.MONTH);

            lastDay = getLastDay();

        }


        public void resetDayNumbers(){
            for(int i =0; i<42; i++){
                int dayNumber = (i+1)-firstDay;
                if(dayNumber<1 || dayNumber >lastDay){
                    dayNumber = 0;
                }
                items[i] = new MonthItem(dayNumber);
            }
        }

        public int getFirstDay(int dayofweek){
            int result = 0;

            if(dayofweek == Calendar.SUNDAY){
                result = 0;
            }else if( dayofweek == Calendar.MONDAY){
                result = 1;
            }else if( dayofweek == Calendar.TUESDAY){
                result = 2;
            }else if( dayofweek == Calendar.WEDNESDAY){
                result = 3;
            }else if( dayofweek == Calendar.THURSDAY){
                result = 4;
            }else if( dayofweek == Calendar.FRIDAY){
                result = 5;
            }else if( dayofweek == Calendar.SATURDAY){
                result = 6;
            }
            return result;
        }


        public int getLastDay(){
            switch(currentMonth){
                case 0 :
                case 2 :
                case 4 :
                case 6 :
                case 7 :
                case 9 :
                case 11 :
                    return 31;
                case 3 :
                case 5 :
                case 8 :
                case 10 :
                    return 30;
                default:
                    if(((currentYear%4==0)&&(currentYear%100!=0)||(currentYear%400==0))){
                        return 29;
                    }else{
                        return 29;
                    }
            }
        }




        @Override
        public int getCount() {
            return 42;
        }

        @Override
        public Object getItem(int position) {
            return items[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            MonthItemView view = null;
            if(convertView == null){
                view = new MonthItemView(getApplicationContext());
            }else{
                view= (MonthItemView) convertView;
            }


            view.setDay(items[position].day);
            return view;
        }
    }
}

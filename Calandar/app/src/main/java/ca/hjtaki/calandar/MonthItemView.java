package ca.hjtaki.calandar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Calendar;

public class MonthItemView extends RelativeLayout {
    TextView textView;

    public MonthItemView(Context context) {
        super(context);
        init(context);
    }

    public MonthItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }


    public void init(Context context){
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.month_item,this,true);

        textView = findViewById(R.id.textView);


    }

    public void setDay(int day){
        textView.setText(String.valueOf(day));

    }
}

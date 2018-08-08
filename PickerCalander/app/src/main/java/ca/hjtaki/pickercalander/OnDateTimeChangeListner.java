package ca.hjtaki.pickercalander;

import android.widget.DatePicker;



public interface OnDateTimeChangeListner {

    public void onDateTimeChage(DateTimePicker view, int year, int month, int day, int hour, int minute);
}

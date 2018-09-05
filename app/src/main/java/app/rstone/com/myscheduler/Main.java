package app.rstone.com.myscheduler;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Context ctx = Main.this;
        TextView today = findViewById(R.id.today);
        today.setText(new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초").format(new Date()));
        CalendarView calender = findViewById(R.id.calender);
        TimePicker time = findViewById(R.id.time);
        TextView year = findViewById(R.id.year);
        TextView month = findViewById(R.id.month);
        TextView day = findViewById(R.id.day);
        TextView hour = findViewById(R.id.hour);
        TextView minute = findViewById(R.id.minute);
        time.setVisibility(View.INVISIBLE);
        class MyDate{String year, month ,day, hour, minute;}
        final MyDate m = new MyDate();
        findViewById(R.id.rdoCalendar).setOnClickListener(
            (View v)->{
                calender.setVisibility(View.VISIBLE);
                time.setVisibility(View.INVISIBLE);
            }
        );
        findViewById(R.id.rdoTime).setOnClickListener(
            (View v)->{
                calender.setVisibility(View.INVISIBLE);
                time.setVisibility(View.VISIBLE);
            }
        );
        findViewById(R.id.btnEnd).setOnClickListener(
            (View v)->{
                year.setText(m.year);
                month.setText(m.minute);
                day.setText(m.day);
                hour.setText(String.valueOf(time.getHour()));
                minute.setText(String.valueOf(time.getMinute()));
                }
        );
        calender.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                m.year=year+"";
                m.month=month+1+"";
                m.day=dayOfMonth+"";
            }
        });
    }
}

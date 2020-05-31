package com.example.appbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

import java.util.GregorianCalendar;

public class CalendarActivity extends AppCompatActivity {
    private Intent intent;
    private Toolbar myToolbar;
    private Button mChooseStartDate;
    private Button mChooseEndDate;
    private CalendarView mStartDateCalendar;
    private CalendarView mEndDateCalendar;
    private Button mBtnOK;
    private long mStartDate;
    private String mStartDateTxt;
    private long mEndDate;
    private String mEndDateTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        initViews();

        mChooseStartDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBtnOK.setVisibility(View.GONE);
                mStartDateCalendar.setVisibility(View.VISIBLE);
                mEndDateCalendar.setVisibility(View.GONE);
            }
        });

        mChooseEndDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBtnOK.setVisibility(View.GONE);
                mEndDateCalendar.setVisibility(View.VISIBLE);
                mStartDateCalendar.setVisibility(View.GONE);
            }
        });

        mStartDateCalendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                mStartDateTxt = i+"-"+i1+"-"+i2;
                mChooseStartDate.setText("Дата-время старт задачи:   " + mStartDateTxt);
                GregorianCalendar gregorianCalendar = new GregorianCalendar();
                gregorianCalendar.set(i, i1, i2);
                mStartDate = gregorianCalendar.getTimeInMillis();
                calendarView.setVisibility(View.GONE);
                mBtnOK.setVisibility(View.VISIBLE);
            }
        });

        mEndDateCalendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                mEndDateTxt = i+"-"+i1+"-"+i2;
                mChooseEndDate.setText("Дата-время стоп задачи:    " + mEndDateTxt);
                GregorianCalendar gregorianCalendar = new GregorianCalendar();
                gregorianCalendar.set(i, i1, i2);
                mEndDate = gregorianCalendar.getTimeInMillis();
                calendarView.setVisibility(View.GONE);
                mBtnOK.setVisibility(View.VISIBLE);
            }
        });

        mBtnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((mStartDate > mEndDate) || (mStartDateTxt == null) || (mEndDateTxt == null) ){
                    Toast.makeText(CalendarActivity.this, "Ошибка", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(CalendarActivity.this, "Старт задачи: "+ mStartDateTxt +" Стоп задачи: "+ mEndDateTxt, Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        myToolbar.getMenu().findItem(R.id.action_open_calendar).setEnabled(false);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.action_settings:
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                Toast.makeText(this, getString(R.string.mnSettings), Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_open_first:
                intent = new Intent(this, FirstActivity.class);
                startActivity(intent);
                Toast.makeText(this, getString(R.string.mnFirst), Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_open_splash:
                intent = new Intent(this, SplashScreenActivity.class);
                startActivity(intent);
                Toast.makeText(this, getString(R.string.mnSplash), Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_open_universal:
                intent = new Intent(this, UniversalActivity.class);
                startActivity(intent);
                Toast.makeText(this, getString(R.string.mnUniversal), Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_open_transition:
                intent = new Intent(this, TransitionActivity.class);
                startActivity(intent);
                Toast.makeText(this, getString(R.string.mnTransition), Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_open_monitoring:
                intent = new Intent(this, MonitoringActivity.class);
                startActivity(intent);
                Toast.makeText(this, getString(R.string.mnMonitoring), Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_open_checkbox:
                intent = new Intent(this, CheckboxActivity.class);
                startActivity(intent);
                Toast.makeText(this, getString(R.string.mnCheckbox), Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_open_spinner:
                intent = new Intent(this, SpinnerActivity.class);
                startActivity(intent);
                Toast.makeText(this, getString(R.string.mnSpinner), Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_open_calendar:
                intent = new Intent(this, CalendarActivity.class);
                startActivity(intent);
                Toast.makeText(this, getString(R.string.mnCalendar), Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_open_notes:
                intent = new Intent(this, NotesActivity.class);
                startActivity(intent);
                Toast.makeText(this, getString(R.string.mnNotes), Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initViews() {
        mChooseStartDate = findViewById(R.id.chooseStartDate);
        mChooseEndDate = findViewById(R.id.chooseEndDate);
        mStartDateCalendar = findViewById(R.id.startDateCalendar);
        mEndDateCalendar = findViewById(R.id.endtDateCalendar);
        mBtnOK = findViewById(R.id.btnOK);
        mStartDateCalendar.setVisibility(View.GONE);
        mEndDateCalendar.setVisibility(View.GONE);
    }
}
package com.example.appbar;

import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

public class PressureActivity extends AppCompatActivity {
    private Intent intent;
    private Toolbar myToolbar;
    private static final String TAG = "Индивидуальные показатели";
    ArrayList<Pressure> pressureList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pressure);
        myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        final EditText patientUpperPressure = findViewById(R.id.editUpperPressure);
        final EditText patientLowerPressure = findViewById(R.id.editLowerPressure);
        final EditText patientPulse = findViewById(R.id.editPuls);
        final CheckBox patientTachycardia = findViewById(R.id.chkTachycardia);
        final TextView textDataTime = findViewById(R.id.textDataTime);
        SimpleDateFormat dateActual = new SimpleDateFormat("dd MMM yyyy", Locale.getDefault());
        SimpleDateFormat timeActual = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
        String date = dateActual.format(Calendar.getInstance().getTime());
        String time = timeActual.format(Calendar.getInstance().getTime());
        textDataTime.setText("Дата: " + date + " Время: " + time);

        Button buttonSavePressure = findViewById(R.id.btnSavePressure);
        buttonSavePressure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String upperPressure = patientUpperPressure.getText().toString();
                String lowerPressure = patientLowerPressure.getText().toString();
                String pulse = patientPulse.getText().toString();
                boolean tachycardia = patientTachycardia.isChecked();
                String dataTime = textDataTime.getText().toString();

                if (upperPressure.isEmpty() || lowerPressure.isEmpty() || pulse.isEmpty()) {
// выводим сообщение "Введены не все данные"
                    Toast.makeText(PressureActivity.this, getString(R.string.notEnoughData), Toast.LENGTH_LONG).show();
                    return;
                }
                int upperOfPressure;
                int lowerOfPressure;
                int pulseOf;
                try {
                    upperOfPressure = Integer.parseInt(upperPressure);
                    lowerOfPressure = Integer.parseInt(lowerPressure);
                    pulseOf = Integer.parseInt(pulse);
                } catch (Exception ex) {
// выводим сообщение "Неверный формат" и сообщение в лог "Введены не корректные данные"
                    Toast.makeText(PressureActivity.this, getString(R.string.incorrectFormat), Toast.LENGTH_LONG).show();
                    Log.i(TAG, "Введены не корректные данные");
                    return;
                }
                Pressure pressure = new Pressure(upperOfPressure, lowerOfPressure, pulseOf, dataTime, tachycardia);
                pressureList.add(pressure);
// выводим сообщение "Данные пациента сохранены"
                Toast.makeText(PressureActivity.this, getString(R.string.Saved), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        myToolbar.getMenu().findItem(R.id.action_open_monitoring).setEnabled(false);
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
}
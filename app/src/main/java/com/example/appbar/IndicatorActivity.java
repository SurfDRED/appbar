package com.example.appbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

public class IndicatorActivity extends AppCompatActivity {
    private Intent intent;
    private Toolbar myToolbar;
    private static final String TAG = "Жизненные показатели";
    ArrayList<Indicators> indicatorList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indicator);
        myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        final EditText weight = findViewById(R.id.editWeight);
        final EditText steps = findViewById(R.id.editSteps);

        Button buttonSaveIndicator = findViewById(R.id.btnSaveIndicator);
        buttonSaveIndicator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String weightPatient = weight.getText().toString();
                String stepsPatient = steps.getText().toString();

                if (weightPatient.isEmpty() || stepsPatient.isEmpty()) {
// выводим сообщение "Введены не все данные"
                    Toast.makeText(IndicatorActivity.this, getString(R.string.notEnoughData), Toast.LENGTH_LONG).show();
                    return;
                }
                int weightOfPatient;
                int stepsOfPatient;
                try {
                    weightOfPatient = Integer.parseInt(weightPatient);
                    stepsOfPatient = Integer.parseInt(stepsPatient);
                } catch (Exception ex) {
// выводим сообщение "Неверный формат" и сообщение в лог "Введены не корректные данные"
                    Toast.makeText(IndicatorActivity.this, getString(R.string.incorrectFormat), Toast.LENGTH_LONG).show();
                    Log.i(TAG, "Введены не корректные данные");
                    return;
                }
                Indicators indicators = new Indicators(weightOfPatient, stepsOfPatient);
                indicatorList.add(indicators);
// выводим сообщение "Данные пациента сохранены"
                Toast.makeText(IndicatorActivity.this, getString(R.string.Saved), Toast.LENGTH_LONG).show();
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
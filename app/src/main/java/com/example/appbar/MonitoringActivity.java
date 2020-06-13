package com.example.appbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MonitoringActivity extends AppCompatActivity {
    private Toolbar myToolbar;
    private static final String TAG = "Карточка пациента";
    ArrayList<Patient> patientList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitoring);
        myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        final EditText user = findViewById(R.id.editPatient);
        final EditText age = findViewById(R.id.editAge);

        Button buttonSave = findViewById(R.id.btnSav);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userPatient = user.getText().toString();
                String agePatient = age.getText().toString();

                if (userPatient.isEmpty() || agePatient.isEmpty()) {
// выводим сообщение "Введены не все данные"
                    Toast.makeText(MonitoringActivity.this, getString(R.string.notEnoughData), Toast.LENGTH_LONG).show();
                    return;
                }
                int ageOfPatient;
                try {
                    ageOfPatient = Integer.parseInt(agePatient);
                } catch (Exception ex) {
// выводим сообщение "Неверный формат" и сообщение в лог "Введены не корректные данные"
                    Toast.makeText(MonitoringActivity.this, getString(R.string.incorrectFormat), Toast.LENGTH_LONG).show();
                    Log.i(TAG, "Введены не корректные данные");
                    return;
                }
                Patient card = new Patient(userPatient, ageOfPatient);
                patientList.add(card);
// выводим сообщение "Сохранена карточка пациента: XXXXXXX"
                Toast.makeText(MonitoringActivity.this, getString(R.string.cardSaved) + " " + userPatient, Toast.LENGTH_LONG).show();
            }
        });
        Button btnIndicator = findViewById(R.id.btnIndicator);
        btnIndicator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MonitoringActivity.this, IndicatorActivity.class);
                startActivity(intent);
            }
        });
        Button btnPressure = findViewById(R.id.btnPressure);
        btnPressure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MonitoringActivity.this, PressureActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        myToolbar.getMenu().findItem(R.id.action_open_monitoring).setEnabled(false);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Menu.HandleMenu(this, item.getItemId());
        return super.onOptionsItemSelected(item);
    }
}
package com.example.appbar;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

public class IndicatorActivity extends AppCompatActivity {
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
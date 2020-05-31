package com.example.appbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class UniversalActivity extends AppCompatActivity {
    private Toolbar myToolbar;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_universal);
        myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
// найдем View-элементы
        final TextView edUser = findViewById(R.id.edUser);
        final TextView edEmail = findViewById(R.id.edEmail);
        final TextView edInfo = findViewById(R.id.edInfo);
        Button exampleBtn = findViewById(R.id.buttonOk);
        Button exampleBtn2 = findViewById(R.id.buttonClear);
// обработка кнопки Ок
        exampleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edInfo.setText(String.format("Подписка на рассылку успешно оформлена для пользователя %S на электронный адрес: %s", edInfo.getText(), edEmail.getText()));
            }
        });
// обработка кнопки Clear
        exampleBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edUser.setText("");
                edEmail.setText("");
                edInfo.setText("");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        myToolbar.getMenu().findItem(R.id.action_open_universal).setEnabled(false);
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
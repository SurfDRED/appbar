package com.example.appbar;

import java.util.Random;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TransitionActivity extends AppCompatActivity {
    private Toolbar myToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition);
        myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
// Генерация случайных чисел с помощью класса Random
        final Random random = new Random();
// найдем элементы
        final TextView exampleText = findViewById(R.id.textView2);
        Button BtnForward = findViewById(R.id.butForward);
        Button BtnBack = findViewById(R.id.butBack);
// создаем обработчик нажатия Forward и выводим информацию
        exampleText.setText("http://myfile.org/"+ random.nextInt(100));
        BtnForward.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TransitionActivity.this, TransitionActivity.class);
                startActivity(intent);
            }
        });
// создаем обработчик нажатия Back
        BtnBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        myToolbar.getMenu().findItem(R.id.action_open_transition).setEnabled(false);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Menu.HandleMenu(this, item.getItemId());
        return super.onOptionsItemSelected(item);
    }
}
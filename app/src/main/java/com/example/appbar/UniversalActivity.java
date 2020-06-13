package com.example.appbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class UniversalActivity extends AppCompatActivity {
    private Toolbar myToolbar;

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
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        myToolbar.getMenu().findItem(R.id.action_open_universal).setEnabled(false);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Menu.HandleMenu(this, item.getItemId());
        return super.onOptionsItemSelected(item);
    }
}
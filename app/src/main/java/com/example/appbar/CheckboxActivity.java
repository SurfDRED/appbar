package com.example.appbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class CheckboxActivity extends AppCompatActivity {
    private Intent intent;
    private Toolbar myToolbar;
    private EditText mInputMoney;
    private EditText mInputInfo;
    private Button mBtnOk;
    private CheckBox mBankCardChkBx;
    private CheckBox mMobilePhoneChkBx;
    private CheckBox mCashAddressChkBx;
    private String miniInfo;
    private boolean statusPaid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkbox);
        myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        initViews();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        myToolbar.getMenu().findItem(R.id.action_open_checkbox).setEnabled(false);
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

    private void resetCheckBoxes(){
        mBankCardChkBx.setChecked(false);
        mMobilePhoneChkBx.setChecked(false);
        mCashAddressChkBx.setChecked(false);
    }

    private void initViews() {
        mInputMoney = findViewById(R.id.inputMoney);
        mInputInfo = findViewById(R.id.inputInfo);
        mBtnOk = findViewById(R.id.btnOK);
        mBankCardChkBx = findViewById(R.id.bankCardChkBx);
        mMobilePhoneChkBx = findViewById(R.id.mobilePhoneChkBx);
        mCashAddressChkBx = findViewById(R.id.cashAddressChkBx);
        mBankCardChkBx.setOnCheckedChangeListener(checkedChangeListener);
        mMobilePhoneChkBx.setOnCheckedChangeListener(checkedChangeListener);
        mCashAddressChkBx.setOnCheckedChangeListener(checkedChangeListener);

        mBtnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userMoney = mInputMoney.getText().toString();
                String userInfo = mInputInfo.getText().toString();

                if (userMoney.isEmpty() || userInfo.isEmpty() || statusPaid == Boolean.FALSE) {
                    Toast.makeText(CheckboxActivity.this, getString(R.string.notEnoughData), Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(CheckboxActivity.this, miniInfo + " " + userInfo, Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    CompoundButton.OnCheckedChangeListener checkedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if (b) {
                switch (compoundButton.getId()) {
                    case R.id.bankCardChkBx:
                        resetCheckBoxes();
                        mBankCardChkBx.setChecked(true);
                        mInputInfo.setInputType(InputType.TYPE_CLASS_NUMBER);
                        mInputInfo.setHint("Только цифры");
                        miniInfo = "Оплата с карты";
                        statusPaid = true;
                        break;
                    case R.id.mobilePhoneChkBx:
                        resetCheckBoxes();
                        mMobilePhoneChkBx.setChecked(true);
                        mInputInfo.setInputType(InputType.TYPE_CLASS_PHONE);
                        mInputInfo.setHint("Только номер телефона");
                        miniInfo = "Оплата с телефона";
                        statusPaid = true;
                        break;
                    case R.id.cashAddressChkBx:
                        resetCheckBoxes();
                        mInputInfo.setInputType(InputType.TYPE_CLASS_TEXT);
                        mCashAddressChkBx.setChecked(true);
                        mInputInfo.setHint("Любой текст");
                        miniInfo = "Оплата в банке";
                        statusPaid = true;
                        break;
                    default:
                }
            } else   {
                statusPaid = false;
            }
        }
    };
}
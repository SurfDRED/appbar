package com.example.appbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class SpinnerActivity extends AppCompatActivity {
    private Toolbar myToolbar;
    private Spinner mCountriesSpinner;
    private Spinner mCitiesSpinner;
    private Spinner mHouseNumberSpinner;
    private Button mShowAddressBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        initViews();
    }
    private void initViews() {
        mCountriesSpinner = findViewById(R.id.countriesSpinner);
        mCitiesSpinner = findViewById(R.id.citiesSpinner);
        mHouseNumberSpinner = findViewById(R.id.houseNumberSpinner);
        mShowAddressBtn = findViewById(R.id.showAddress);
        mShowAddressBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SpinnerActivity.this
                        ,mCountriesSpinner.getSelectedItem().toString()
                                + " "
                                + mCitiesSpinner.getSelectedItem().toString()
                                + " "
                                + mHouseNumberSpinner.getSelectedItem().toString()
                        ,Toast.LENGTH_LONG)
                        .show();
            }
        });
        initSpinnerCountries();
        initHomeNumbersSpinner();
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        myToolbar.getMenu().findItem(R.id.action_open_spinner).setEnabled(false);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Menu.HandleMenu(this, item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    private void initHomeNumbersSpinner() {
        Integer[] homeNumbers = new Integer[50];
        for (int i = 1; i <= 50; i++) {
            homeNumbers[i - 1] = i;
        }
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this, R.layout.spiner, homeNumbers);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        mHouseNumberSpinner.setAdapter(adapter);
    }
    private void initSpinnerCities(String country) {
        ArrayAdapter<CharSequence> adapter = null;
        switch (country) {
            case "Россия":
                adapter = ArrayAdapter.createFromResource(this, R.array.r_cities, R.layout.spiner);
                break;
            case "Украина":
                adapter = ArrayAdapter.createFromResource(this, R.array.u_cities, R.layout.spiner);
                break;
            case "Белоруссия":
                adapter = ArrayAdapter.createFromResource(this, R.array.b_cities, R.layout.spiner);
                break;
        }
        if (adapter != null) {
            adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
            mCitiesSpinner.setAdapter(adapter);
        }
    }
    private void initSpinnerCountries() {
        ArrayAdapter<CharSequence> adapterCountries = ArrayAdapter.createFromResource(this, R.array.countries, R.layout.spiner);
        adapterCountries.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        mCountriesSpinner.setAdapter(adapterCountries);
        mCountriesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[] countries = getResources().getStringArray(R.array.countries);
                initSpinnerCities(countries[i]);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }
}
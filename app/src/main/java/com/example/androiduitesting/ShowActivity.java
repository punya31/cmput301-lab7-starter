package com.example.androiduitesting;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ShowActivity extends AppCompatActivity {


    public static final String additional_city_name = "com.example.androiduitesting.additional_city_name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        // Enables the back arrow in the Action Bar and sets title
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("ListyCity");
        }

        TextView nameView = findViewById(R.id.show_city_name);
        Button backBtn    = findViewById(R.id.button_back);

        // Retrieves the city name passed from MainActivity and displays
        String cityName = getIntent() != null
                ? getIntent().getStringExtra(additional_city_name)
                : null;
        if (cityName == null) {
            cityName = getIntent() != null ? getIntent().getStringExtra("city_name") : null;
        }

        if (cityName != null && !cityName.isEmpty()) {
            nameView.setText(cityName);
        }

        backBtn.setOnClickListener(v -> finish());
    }

    //handles back arrow
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) { finish(); return true; }
        return super.onOptionsItemSelected(item);
    }
}

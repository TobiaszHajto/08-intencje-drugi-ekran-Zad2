package com.example.a08_intencje_drugi_ekran_zad2;


import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Spinner spService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spService = findViewById(R.id.spService);

        ustawUslugi();

        findViewById(R.id.btnNext).setOnClickListener(v -> otworzPodsumowanie());
    }

    private void ustawUslugi() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.services,
                android.R.layout.simple_spinner_item
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spService.setAdapter(adapter);
    }

    private void otworzPodsumowanie() {
        Intent intent = new Intent(MainActivity.this, SummaryActivity.class);
        startActivity(intent);
    }
}
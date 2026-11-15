package com.example.a08_intencje_drugi_ekran_zad2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Spinner spService;
    private EditText etDate, etName, etPhone;
    private CheckBox cbFirstVisit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spService = findViewById(R.id.spService);
        etDate = findViewById(R.id.etDate);
        etName = findViewById(R.id.etName);
        etPhone = findViewById(R.id.etPhone);
        cbFirstVisit = findViewById(R.id.cbFirstVisit);

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

        String date = etDate.getText().toString().trim();
        String name = etName.getText().toString().trim();
        String phone = etPhone.getText().toString().trim();

        // Walidacja formularza

        if (spService.getSelectedItemPosition() == 0) {
            Toast.makeText(this, R.string.error_service, Toast.LENGTH_SHORT).show();
            return;
        }

        if (date.isEmpty()) {
            etDate.setError(getString(R.string.error_date));
            return;
        }

        if (name.isEmpty()) {
            etName.setError(getString(R.string.error_name));
            return;
        }

        if (phone.isEmpty()) {
            etPhone.setError(getString(R.string.error_phone));
            return;
        }

        // Przekazywanie danych

        Intent intent = new Intent(MainActivity.this, SummaryActivity.class);

        intent.putExtra(SummaryActivity.EXTRA_SERVICE, spService.getSelectedItem().toString());
        intent.putExtra(SummaryActivity.EXTRA_DATE, date);
        intent.putExtra(SummaryActivity.EXTRA_NAME, name);
        intent.putExtra(SummaryActivity.EXTRA_PHONE, phone);
        intent.putExtra(SummaryActivity.EXTRA_FIRST_VISIT, cbFirstVisit.isChecked());

        startActivity(intent);
    }
}
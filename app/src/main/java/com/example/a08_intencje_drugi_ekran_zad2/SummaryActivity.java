package com.example.a08_intencje_drugi_ekran_zad2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SummaryActivity extends AppCompatActivity {

    public static final String EXTRA_SERVICE = "SERVICE";
    public static final String EXTRA_DATE = "DATE";
    public static final String EXTRA_NAME = "NAME";
    public static final String EXTRA_PHONE = "PHONE";
    public static final String EXTRA_FIRST_VISIT = "FIRST_VISIT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        TextView tvSummary = findViewById(R.id.tvSummary);
        tvSummary.setText(pobierzPodsumowanie());

        findViewById(R.id.btnBack).setOnClickListener(v -> finish());
    }

    private String pobierzPodsumowanie() {

        Intent intent = getIntent();

        String service = intent.getStringExtra(EXTRA_SERVICE);
        String date = intent.getStringExtra(EXTRA_DATE);
        String name = intent.getStringExtra(EXTRA_NAME);
        String phone = intent.getStringExtra(EXTRA_PHONE);

        boolean firstVisit = intent.getBooleanExtra(EXTRA_FIRST_VISIT, false);

        String firstVisitText;

        if (firstVisit) {
            firstVisitText = getString(R.string.yes_short);
        } else {
            firstVisitText = getString(R.string.no_short);
        }

        return getString(
                R.string.summary_format,
                service,
                date,
                name,
                phone,
                firstVisitText
        );
    }
}
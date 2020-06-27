package com.example.farmbill;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.farmbill.utils.TotalCalculator;

public class Stats extends AppCompatActivity {

    private TextView ta, tb;
    private TotalCalculator totalCalculator;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);
        ta = findViewById(R.id.totalamount);
        tb = findViewById(R.id.totalbags);
        progressBar = findViewById(R.id.progressBar2);

        totalCalculator = new TotalCalculator(getApplicationContext(), progressBar, ta, tb);
        totalCalculator.getTotalAmount();
        totalCalculator.getTotalBags();
    }
}
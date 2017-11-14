package com.fastapps.gpa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.fastapps.gpa.Utilities.Utilities;

/**
 * Created by asimm on 10/7/2017.
 */

public class ResultActivity extends BaseActivity {

    TextView previousGPA, currentGPA, currentSGPA;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        setupViews();
        presentResult();
    }

    private void presentResult() {
        Intent intent = getIntent();
        double SGPA = intent.getDoubleExtra("GPA", 0.0);
        double prevCGPA = Utilities.getCGPA();
        prevCGPA = round(prevCGPA, 2);
        currentSGPA.setText(Double.toString(SGPA));
        previousGPA.setText(Double.toString(prevCGPA));
    }

    private void setupViews() {
        View view = findViewById(R.id.previousCGPA);
        previousGPA = view.findViewById(R.id.resultGPA);

        view = findViewById(R.id.currentCGPA);
        currentGPA = view.findViewById(R.id.resultGPA);

        view = findViewById(R.id.currentSGPA);
        currentSGPA = view.findViewById(R.id.resultGPA);
    }

    private double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        double tmp = Math.round(value);
        return (double) tmp / factor;
    }
}

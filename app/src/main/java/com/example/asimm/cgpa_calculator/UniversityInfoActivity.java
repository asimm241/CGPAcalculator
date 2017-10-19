package com.example.asimm.cgpa_calculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import com.example.asimm.cgpa_calculator.Utilities.Utilities;

/**
 * Created by asimm on 10/7/2017.
 */

public class UniversityInfoActivity extends BaseActivity implements View.OnClickListener {

    Spinner spinner;
    Button mNextButton;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_university_name);
        setUpViews();
    }

    private void setUpViews(){
        spinner = (Spinner)findViewById(R.id.universityinfoSpinner);
        mNextButton = (Button)findViewById(R.id.universityinfoNext);
        mNextButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.universityinfoNext:{
                String uni = spinner.getSelectedItem().toString();
                Utilities.saveUniversity(uni);
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        }
    }
}

package com.example.asimm.cgpa_calculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.asimm.cgpa_calculator.Utilities.Utilities;

/**
 * Created by asimm on 10/7/2017.
 */

public class SignupActivity extends BaseActivity implements View.OnClickListener {

    EditText mCGPA;
    Button mNEXT;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        setupViews();

    }

    private void setupViews(){
        mCGPA = (EditText)findViewById(R.id.signup_cgpa);
        mNEXT = (Button)findViewById(R.id.sign_next);
        mNEXT.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.sign_next:{
                String cgpaText = mCGPA.getText().toString();
                double cgpa = Float.parseFloat(cgpaText);
                Utilities.saveCGPA(cgpa);
                Utilities.setIsLogin(true);
                Intent intent = new Intent(this, UniversityInfoActivity.class);
                startActivity(intent);
                finish();

            }
        }
    }



}

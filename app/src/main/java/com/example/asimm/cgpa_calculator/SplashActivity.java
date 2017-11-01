package com.example.asimm.cgpa_calculator;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.asimm.cgpa_calculator.Utilities.Utilities;

/**
 * Created by asimm on 10/5/2017.
 */

public class SplashActivity extends BaseActivity {

    Handler handler = new Handler();

    Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        context = this;
        sleep();
    }


    private void sleep() {

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent;

                //// TODO: 11/1/2017 remove this in the future when sign up feature is implemented
//        if (Utilities.getIsLogin()) {
                if (true) {
                    intent = new Intent(context, MainActivity.class);

                } else {
                    intent = new Intent(context, SignupActivity.class);
                }

                startActivity(intent);
                finish();
            }
        }, 1000);
    }
}

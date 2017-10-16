package com.example.asimm.cgpa_calculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.asimm.cgpa_calculator.Utilities.Utilities;

/**
 * Created by asimm on 10/5/2017.
 */

public class SplashActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sleep();
        Intent intent;
        if (Utilities.getIsLogin()) {
            intent = new Intent(this, MainActivity.class);

        } else {
            intent = new Intent(this, SignupActivity.class);
        }

        startActivity(intent);
        finish();
    }

    private void sleep() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

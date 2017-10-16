package com.example.asimm.cgpa_calculator.App;

import android.app.Application;
import android.content.Context;

import com.example.asimm.cgpa_calculator.Utilities.Utilities;

/**
 * Created by asimm on 10/15/2017.
 */

public class App extends Application {

    Context applicationContext;

    @Override
    public void onCreate(){
        super.onCreate();
        applicationContext = getApplicationContext();
        Utilities.inIt(applicationContext);

    }
}

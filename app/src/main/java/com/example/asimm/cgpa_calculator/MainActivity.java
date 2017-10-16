package com.example.asimm.cgpa_calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends BaseActivity implements View.OnClickListener, Spinner.OnItemSelectedListener {

    Spinner mUniversity, mGrade1, mGrade2, mGrade3, mGrade4, mGrade5, mGrade6, mGrade7, mCredit1, mCredit2, mCredit3, mCredit4, mCredit5, mCredit6, mCredit7;
    Button mCalculateButton;
    ArrayAdapter<String> gradeAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpViews();
    }

    private void setUpViews() {

        String data[] = getResources().getStringArray(R.array.fast_grades);
        List<String> list = new ArrayList<String>(Arrays.asList(data));
        gradeAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        gradeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mUniversity = (Spinner) findViewById(R.id.university);
        mUniversity.setOnItemSelectedListener(this);

        View view = (View) findViewById(R.id.course1);
        mGrade1 = (Spinner) view.findViewById(R.id.grade);
        mCredit1 = (Spinner) view.findViewById(R.id.credit_hour);
        mGrade1.setAdapter(gradeAdapter);

        view = findViewById(R.id.course2);
        mGrade2 = (Spinner) view.findViewById(R.id.grade);
        mCredit2 = (Spinner) view.findViewById(R.id.credit_hour);
        mGrade2.setAdapter(gradeAdapter);

        view = findViewById(R.id.course3);
        mGrade3 = (Spinner) view.findViewById(R.id.grade);
        mCredit3 = (Spinner) view.findViewById(R.id.credit_hour);
        mGrade3.setAdapter(gradeAdapter);

        view = findViewById(R.id.course4);
        mGrade4 = (Spinner) view.findViewById(R.id.grade);
        mCredit4 = (Spinner) view.findViewById(R.id.credit_hour);
        mGrade4.setAdapter(gradeAdapter);

        view = findViewById(R.id.course5);
        mGrade5 = (Spinner) view.findViewById(R.id.grade);
        mCredit5 = (Spinner) view.findViewById(R.id.credit_hour);
        mGrade5.setAdapter(gradeAdapter);


        view = findViewById(R.id.course6);
        mGrade6 = (Spinner) view.findViewById(R.id.grade);
        mCredit6 = (Spinner) view.findViewById(R.id.credit_hour);
        mGrade6.setAdapter(gradeAdapter);


        view = findViewById(R.id.course7);
        mGrade7 = (Spinner) view.findViewById(R.id.grade);
        mCredit7 = (Spinner) view.findViewById(R.id.credit_hour);
        mGrade7.setAdapter(gradeAdapter);


        mCalculateButton = (Button) findViewById(R.id.button_calculate);
        mCalculateButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_calculate:
                String g1 = mGrade1.getSelectedItem().toString();
                int c1 = Integer.parseInt(mCredit1.getSelectedItem().toString());
                Course course1 = new Course(g1, c1);

                String g2 = mGrade2.getSelectedItem().toString();
                int c2 = Integer.parseInt(mCredit2.getSelectedItem().toString());
                Course course2 = new Course(g2, c2);

                String g3 = mGrade3.getSelectedItem().toString();
                int c3 = Integer.parseInt(mCredit3.getSelectedItem().toString());
                Course course3 = new Course(g3, c3);

                String g4 = mGrade4.getSelectedItem().toString();
                int c4 = Integer.parseInt(mCredit4.getSelectedItem().toString());
                Course course4 = new Course(g4, c4);

                String g5 = mGrade5.getSelectedItem().toString();
                int c5 = Integer.parseInt(mCredit5.getSelectedItem().toString());
                Course course5 = new Course(g5, c5);

                String g6 = mGrade6.getSelectedItem().toString();
                int c6 = Integer.parseInt(mCredit6.getSelectedItem().toString());
                Course course6 = new Course(g6, c6);

                String g7 = mGrade7.getSelectedItem().toString();
                int c7 = Integer.parseInt(mCredit7.getSelectedItem().toString());
                Course course7 = new Course(g7, c7);

                ArrayList<Course> courses = new ArrayList<>();
                courses.add(course1);
                courses.add(course2);
                courses.add(course3);
                courses.add(course4);
                courses.add(course5);
                courses.add(course6);
                courses.add(course7);

                calculateSGPA(courses);
                break;
            default:
                break;
        }
    }

    private double calculateSGPA(ArrayList<Course> courses) {
        double gpa = 0;
        double totalCreditHours = 0;
        for (int i = 0; i < courses.size(); i++) {
            totalCreditHours = courses.get(i).getCredit() + totalCreditHours;
        }

        gpa = getFAST_SGPA(courses, totalCreditHours);

        gpa = round(gpa, 2);
        Toast.makeText(this, "Gpa is : " + Double.toString(gpa), Toast.LENGTH_LONG).show();

        return gpa;
    }

    private double getFAST_SGPA(ArrayList<Course> courses, double totalCreditHours) {
        double gpa = 0;
        for (int i = 0; i < courses.size(); i++) {
            double P = getFASTPoint(courses.get(i).getGrade());
            double C = courses.get(i).getCredit();
            gpa = P * (C / totalCreditHours) + gpa;
        }

        return gpa;
    }

    private double getNUST_SGPA(ArrayList<Course> courses, double totalCreditHours) {
        double gpa = 0;
        for (int i = 0; i < courses.size(); i++) {
            double P = getNUSTPoint(courses.get(i).getGrade());
            double C = courses.get(i).getCredit();
            gpa = P * C + gpa;
        }

        gpa = gpa / totalCreditHours;

        return gpa;
    }

    private double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        double tmp = Math.round(value);
        return (double) tmp / factor;
    }

 /*   public void farmulafast(){
        P1 (C1/C) +P2 (C2/C)+P3(C3/C)+P4(C4/C);
    }*/


    private double getFASTPoint(String grade) {
        double points = 0;
        switch (grade) {
            case "A+":
                points = 4.0;
                break;
            case "A":
                points = 4.0;
                break;
            case "A-":
                points = 3.67;
                break;
            case "B+":
                points = 3.33;
                break;
            case "B":
                points = 3.00;
                break;
            case "B-":
                points = 2.67;
                break;
            case "C+":
                points = 2.33;
                break;
            case "C":
                points = 2.00;
                break;
            case "C-":
                points = 1.67;
                break;
            case "D+":
                points = 1.33;
                break;
            case "D":
                points = 1.00;
                break;
            case "F":
                points = 0.00;
                break;
            default:
                break;
        }
        return points;
    }

    private double getNUSTPoint(String grade) {
        double points = 0;
/*
        A     4.0
        B+   3.5
        B     3.0
        C+   2.5
        C     2.0
        D     1.0
        F      0.0*/
        switch (grade) {
            case "A":
                points = 4.0;
                break;
            case "B+":
                points = 3.5;
                break;
            case "B":
                points = 3.0;
                break;
            case "C+":
                points = 2.5;
                break;
            case "C":
                points = 2.0;
                break;
            case "D":
                points = 1.0;
                break;
            case "F":
                points = 0.0;
                break;
            default:
                break;
        }

        return points;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if (adapterView.getId() == R.id.university) {
            switch (i) {
                case 0:
                    String data[] = getResources().getStringArray(R.array.fast_grades);
                    List<String> list = new ArrayList<String>(Arrays.asList(data));
                    gradeAdapter.clear();
                    gradeAdapter.addAll(list);
                    gradeAdapter.notifyDataSetChanged();
                    break;
                case 1:
                    String data1[] = getResources().getStringArray(R.array.nust_grades);
                    List<String> list1 = new ArrayList<String>(Arrays.asList(data1));
                    gradeAdapter.clear();
                    gradeAdapter.addAll(list1);
                    gradeAdapter.clear();
                    gradeAdapter.addAll(Arrays.asList(data1));
                    gradeAdapter.notifyDataSetChanged();
                    break;
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}

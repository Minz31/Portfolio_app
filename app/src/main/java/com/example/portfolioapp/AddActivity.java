package com.example.portfolioapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.portfolioapp.models.Course;
import com.example.portfolioapp.models.Education;
import com.example.portfolioapp.models.Portfolio;

public class AddActivity extends AppCompatActivity {
    public static final String PARAM_PORTFOLIO = "param-portfolio";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
    }

    public void submitData(View view){
        EditText etName = findViewById(R.id.et_name);
        EditText etPosition = findViewById(R.id.et_title);
        EditText etEducationTitle = findViewById(R.id.et_education_university);
        EditText etEducationDegree = findViewById(R.id.et_education_degree);
        EditText etEducationYear = findViewById(R.id.et_education_year);
        EditText etCourseTitle = findViewById(R.id.et_course_organisation);
        EditText etCourseDegree = findViewById(R.id.et_course_title);
        EditText etCourseYear = findViewById(R.id.et_course_Year);
        EditText etGithub = findViewById(R.id.et_github);


        if(etName.getText().toString().isEmpty() || etName.getText().toString()==null){
                etName.setError("Valid Name Mandatory!!");
                etName.requestFocus();
        }

        Education education = new Education(etEducationTitle.getText().toString(),etEducationDegree.getText().toString(),etEducationYear.getText().toString());
        Course course = new Course(etCourseTitle.getText().toString(),etCourseDegree.getText().toString(),etCourseYear.getText().toString());

        Portfolio portfolio = new Portfolio(etName.getText().toString(),etPosition.getText().toString(),education,course,etGithub.getText().toString());

        Intent intent = new Intent();
        intent.putExtra(PARAM_PORTFOLIO,portfolio);
        setResult(RESULT_OK,intent);
        //activity lifecycle ends
        finish();
    }
}

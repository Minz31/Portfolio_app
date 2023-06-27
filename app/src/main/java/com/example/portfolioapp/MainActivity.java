package com.example.portfolioapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.example.portfolioapp.models.Portfolio;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.portfolioapp.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_DETAILS_CODE= 1337;
    private static final String TAG = "MainActivity";
    private String githubusername= null;

    @Override
     protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton addDetailButton = findViewById(R.id.btn_add_details);
        addDetailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
//                startActivity(intent);
                startActivityForResult(intent,REQUEST_DETAILS_CODE);
//                Toast.makeText(MainActivity.this, "Hello", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void openGithub(View view){
        String githuburl = "https://github.com/";
        if(githuburl!=null){
            Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/"+githubusername));
            startActivity(intent);
        }
        else{
            Toast.makeText(MainActivity.this, "No github Username Found!!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_DETAILS_CODE && resultCode==RESULT_OK && data!=null){
            Portfolio portfolio= data.getParcelableExtra(AddActivity.PARAM_PORTFOLIO);
            if(portfolio!= null){
                setDetails(portfolio);
            }
        }
    }
    private void setDetails(Portfolio portfolio){
        //check by printing portfolio
        Log.i(TAG,String.valueOf(portfolio));

        //set data to field
        TextView textViewName = findViewById(R.id.tv_name);
        TextView textViewPosition = findViewById(R.id.tv_title);
        TextView textViewEducationTitle = findViewById(R.id.tv_education_title);
        TextView textViewEducationDegree = findViewById(R.id.tv_education_degree);
        TextView textViewEducationYear = findViewById(R.id.tv_education_year);
        TextView textViewCourseTitle = findViewById(R.id.tv_course_title);
        TextView textViewCourseDegree = findViewById(R.id.tv_course_degree);
        TextView textViewCourseYear= findViewById(R.id.tv_course_year);

        textViewName.setText(portfolio.getName());
        textViewPosition.setText(portfolio.getPosition());
        textViewEducationTitle.setText(portfolio.getEducation().getTitle());
        textViewEducationDegree.setText(portfolio.getEducation().getDegree());
        textViewEducationYear.setText(portfolio.getEducation().getYear());
        textViewCourseTitle.setText(portfolio.getCourse().getName());
        textViewCourseDegree.setText(portfolio.getCourse().getOrganisation());
        textViewCourseYear.setText(portfolio.getCourse().getYear());

        githubusername = portfolio.getGithubusername();
    }

}
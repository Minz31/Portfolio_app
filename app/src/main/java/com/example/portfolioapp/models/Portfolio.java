package com.example.portfolioapp.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Portfolio implements Parcelable {
    private String name;
    private  String position;
    private  Education education;
    private Course course;
    private String githubusername;

    public Portfolio(String name, String position, Education education, Course course, String githubusername) {
        this.name = name;
        this.position = position;
        this.education = education;
        this.course = course;
        this.githubusername = githubusername;
    }

    protected Portfolio(Parcel in) {
        name = in.readString();
        position = in.readString();
        education = in.readParcelable(Education.class.getClassLoader());
        course = in.readParcelable(Course.class.getClassLoader());
        githubusername = in.readString();
    }

    public static final Creator<Portfolio> CREATOR = new Creator<Portfolio>() {
        @Override
        public Portfolio createFromParcel(Parcel in) {
            return new Portfolio(in);
        }

        @Override
        public Portfolio[] newArray(int size) {
            return new Portfolio[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getGithubusername() {
        return githubusername;
    }

    public void setGithubusername(String githubusername) {
        this.githubusername = githubusername;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(position);
        dest.writeParcelable(education, flags);
        dest.writeParcelable(course, flags);
        dest.writeString(githubusername);
    }
}

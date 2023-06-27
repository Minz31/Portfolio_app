package com.example.portfolioapp.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Education implements Parcelable {
    private  String title;
    private  String degree;
    private  String year;


    public Education(String title, String degree, String year) {
        this.title = title;
        this.degree = degree;
        this.year = year;
    }

    protected Education(Parcel in) {
        title = in.readString();
        degree = in.readString();
        year = in.readString();
    }

    public static final Creator<Education> CREATOR = new Creator<Education>() {
        @Override
        public Education createFromParcel(Parcel in) {
            return new Education(in);
        }

        @Override
        public Education[] newArray(int size) {
            return new Education[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {

        dest.writeString(title);
        dest.writeString(degree);
        dest.writeString(year);
    }
}

package com.iqbal.mymoviecatalogue;

import android.os.Parcel;
import android.os.Parcelable;

public class Film implements Parcelable {

    private int photo;
    private String name, score, runtime, year, status, language, budget, desc;

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.photo);
        dest.writeString(this.name);
        dest.writeString(this.score);
        dest.writeString(this.runtime);
        dest.writeString(this.year);
        dest.writeString(this.status);
        dest.writeString(this.language);
        dest.writeString(this.budget);
        dest.writeString(this.desc);
    }

    public Film() {
    }

    protected Film(Parcel in) {
        this.photo = in.readInt();
        this.name = in.readString();
        this.score = in.readString();
        this.runtime = in.readString();
        this.year = in.readString();
        this.status = in.readString();
        this.language = in.readString();
        this.budget = in.readString();
        this.desc = in.readString();
    }

    public static final Creator<Film> CREATOR = new Creator<Film>() {
        @Override
        public Film createFromParcel(Parcel source) {
            return new Film(source);
        }

        @Override
        public Film[] newArray(int size) {
            return new Film[size];
        }
    };
}

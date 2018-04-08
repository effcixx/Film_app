package com.example.ewaew.film_app;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Ewa Lyko on 26.03.2018.
 */


public class Film  implements Parcelable{

    private String title;
    private int idPoster;
    private String category;
    private ArrayList<Actor> actors;
    private ArrayList<Integer> pictures;

    Film(String title, int idPoster, String category, ArrayList<Actor> actors, ArrayList<Integer> pictures) {
        this.title = title;
        this.idPoster = idPoster;
        this.category = category;
        this.actors = actors;
        this.pictures = pictures;
    }

    private Film(Parcel input)
    {
        title = input.readString();
        idPoster = input.readInt();
        category = input.readString();
        actors = input.readArrayList(Film.class.getClassLoader());
        pictures = input.readArrayList(Integer.class.getClassLoader());
    }

    ArrayList<Actor> getActors() {
        return actors;
    }

    ArrayList<Integer> getPictures() {
        return pictures;
    }

    public String getTitle() {
        return title;
    }


    int getIdPicture() {
        return idPoster;
    }

    String getCategory() {
        return category;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeString(this.title);
        parcel.writeInt(this.idPoster);
        parcel.writeString(this.category);
        parcel.writeList(this.actors);
        parcel.writeList(this.pictures);

    }

    public static final Parcelable.Creator<Film> CREATOR
            = new Parcelable.Creator<Film>() {
        public Film createFromParcel(Parcel in) {
            return new Film(in);
        }

        public Film[] newArray(int size) {
            return new Film[size];
        }
    };
}

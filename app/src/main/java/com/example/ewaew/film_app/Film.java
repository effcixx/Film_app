package com.example.ewaew.film_app;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Ewa Lyko on 26.03.2018.
 */


public class Film  {

    private String title;
    private int idPoster;
    private String category;
    private ArrayList<Actor> actors;
    private ArrayList<Integer> pictures;

    public Film(String title, int idPoster, String category, ArrayList<Actor> actors,ArrayList<Integer>pictures) {
        this.title = title;
        this.idPoster = idPoster;
        this.category = category;
        this.actors = actors;
        this.pictures = pictures;
    }

    public ArrayList<Actor> getActors() {
        return actors;
    }

    public ArrayList<Integer> getPictures() {
        return pictures;
    }

    public String getTitle() {
        return title;
    }


    public int getIdPicture() {
        return idPoster;
    }

    public void setIdPicture(int idPicture) {
        this.idPoster = idPicture;
    }

    public String getCategory() {
        return category;
    }

}

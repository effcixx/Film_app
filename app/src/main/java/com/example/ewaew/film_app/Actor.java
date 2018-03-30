package com.example.ewaew.film_app;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Ewa Lyko on 28.03.2018.
 */

public class Actor implements Parcelable{
    private String surname;
    private String name;
    private int age;
    private int idPicture;

    public Actor(Parcel input)
    {
        surname = input.readString();
        name = input.readString();
        age = input.readInt();
        idPicture = input.readInt();
    }

    public Actor(String surname, String name, int age,int idPicture) {
        this.surname = surname;
        this.name = name;
        this.age = age;
        this.idPicture = idPicture;
    }

    public int getIdPicture() {
        return idPicture;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.surname);
        parcel.writeString(this.name);
        parcel.writeInt(this.age);
        parcel.writeInt(this.idPicture);
    }

    public static final Parcelable.Creator<Actor> CREATOR
            = new Parcelable.Creator<Actor>() {
        public Actor createFromParcel(Parcel in) {
            return new Actor(in);
        }

        public Actor[] newArray(int size) {
            return new Actor[size];
        }
    };
}


package com.example.ewaew.film_app;

import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class FilmDescription extends AppCompatActivity {

    private static final String FILM_TITLE="FILM_TITLE";
    private static final String FILM_POSTER="FILM_POSTER";
    private static final String FILM_CATEGORY="FILM_CATEGORY";
    private static final String FILM_ACTOR = "FILM_ACTOR";
    private static final String FILM_PICTURES ="FILM_PICTURES";

    private TextView filmCategory;
    private TextView filmTitle;
    private ImageView picture;

    private ArrayList<Actor> actorList;
    private ArrayList<Integer> pictureList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_description);
        initialize();

    }
    public void changeFragment(View view)
    {
        Fragment fragment;
        Bundle bundle = new Bundle();
        if (view == findViewById(R.id.picture_button))
        {
            fragment = new PicturesFromFilm();
            bundle.putIntegerArrayList(FILM_PICTURES,pictureList);
            fragment.setArguments(bundle);
        }
        else if(view == findViewById(R.id.actor_button))
        {
            fragment = new ActorsFromFilm();
            //Toast.makeText(getApplicationContext(),actorList.get(1).getName(),Toast.LENGTH_SHORT).show();
           // ActorsFromFilm.start(getApplicationContext(),actorList);
            bundle.putParcelableArrayList(FILM_ACTOR,actorList);
            fragment.setArguments(bundle);
        }
        else
        {
            fragment = new Fragment();
        }
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.my_fragment,fragment);
        fragmentTransaction.commit();
    }
    private void initialize() {

        Intent intent = getIntent();
        filmCategory =findViewById(R.id.filmCategory);
        filmTitle = findViewById(R.id.filmTitle);
        picture = findViewById(R.id.pictureOfFilm);
        filmCategory.setText(intent.getStringExtra(FILM_CATEGORY));
        filmTitle.setText(intent.getStringExtra(FILM_TITLE));
        picture.setImageResource(intent.getIntExtra(FILM_POSTER,0));
        actorList =intent.getParcelableArrayListExtra(FILM_ACTOR);
        pictureList = intent.getIntegerArrayListExtra(FILM_PICTURES);

    }

    public static void start(Context context,String title, int idPoster, String category,ArrayList<Actor>actorList,ArrayList<Integer>pictureList) {
        Intent starter = new Intent(context, FilmDescription.class);
        starter.putExtra(FILM_TITLE,title);
        starter.putExtra(FILM_CATEGORY,category);
        starter.putExtra(FILM_POSTER,idPoster);
        starter.putExtra(FILM_ACTOR,actorList);
        starter.putExtra(FILM_PICTURES,pictureList);
        context.startActivity(starter);
    }
}

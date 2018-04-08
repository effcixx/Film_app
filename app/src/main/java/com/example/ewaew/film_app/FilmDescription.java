package com.example.ewaew.film_app;

import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FilmDescription extends AppCompatActivity {

    private static final String FILM_TITLE="FILM_TITLE";
    private static final String FILM_POSTER="FILM_POSTER";
    private static final String FILM_CATEGORY="FILM_CATEGORY";
    private static final String FILM_ACTOR = "FILM_ACTOR";
    private static final String FILM_PICTURES ="FILM_PICTURES";

    private static final String TAG_AF = "AF";
    private static final String TAG_PF="PF";

    private TextView filmCategory;
    private TextView filmTitle;
    private ImageView picture;

    private Fragment actorF;
    private Fragment pictureF;

    private Button pictureButton;
    private Button actorsButton;
    private Button closeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_description);

        initialize();

        setFragment(savedInstanceState);

        onButtonClick();
    }

    private void setFragment(Bundle savedInstanceState) {
        if (savedInstanceState==null)
        {
            actorF = new ActorsFromFilm();
            pictureF = new PicturesFromFilm();

            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.contener,actorF,TAG_AF);
            fragmentTransaction.detach(actorF);
            fragmentTransaction.add(R.id.contener,pictureF,TAG_PF);
            fragmentTransaction.detach(pictureF);
            fragmentTransaction.commit();
        }
        else
        {
            actorF = getFragmentManager().findFragmentByTag(TAG_AF);
            pictureF = getFragmentManager().findFragmentByTag(TAG_PF);
        }
    }

    private void onButtonClick() {
        pictureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.attach(pictureF);
                fragmentTransaction.detach(actorF);
                fragmentTransaction.commit();
            }
        });
        actorsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.attach(actorF);
                fragmentTransaction.detach(pictureF);
                fragmentTransaction.commit();
            }
        });
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.detach(actorF);
                fragmentTransaction.detach(pictureF);
                fragmentTransaction.commit();
            }
        });
    }

    private void initialize() {

        pictureButton = findViewById(R.id.picture_button);
        actorsButton = findViewById(R.id.actor_button);
        closeButton = findViewById(R.id.close_button);

        Intent intent = getIntent();
        filmCategory =findViewById(R.id.filmCategory);
        filmTitle = findViewById(R.id.filmTitle);
        picture = findViewById(R.id.pictureOfFilm);
        filmCategory.setText(intent.getStringExtra(FILM_CATEGORY));
        filmTitle.setText(intent.getStringExtra(FILM_TITLE));
        picture.setImageResource(intent.getIntExtra(FILM_POSTER,0));
        ArrayList<Actor> actorList = intent.getParcelableArrayListExtra(FILM_ACTOR);
        ArrayList<Integer> pictureList = intent.getIntegerArrayListExtra(FILM_PICTURES);
        FrameLayout contener = findViewById(R.id.contener);
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

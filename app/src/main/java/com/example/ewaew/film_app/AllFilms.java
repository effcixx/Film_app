package com.example.ewaew.film_app;

import android.app.ListFragment;
import android.content.Context;
import android.content.res.Resources;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ewa Lyko on 30.03.2018.
 */

public class AllFilms {

    private List<Film> filmList = new ArrayList<>();

    public List<Film> getFilmList() {
        return filmList;
    }

    private ArrayList<Integer> picturesShawshank = new ArrayList<>();
    private ArrayList<Actor> actorsShawshank = new ArrayList<>();
    private ArrayList<Integer> picturesIntouchables= new ArrayList<>();
    private ArrayList<Actor> actorsIntouchables = new ArrayList<>();
    private ArrayList<Integer> picturesForestGump= new ArrayList<>();
    private ArrayList<Actor> actorsForestGump = new ArrayList<>();
    private ArrayList<Integer> picturesGreenMile = new ArrayList<>();
    private ArrayList<Actor> actorsGreenMile= new ArrayList<>();
    private ArrayList<Integer> picturesAngryMan = new ArrayList<>();
    private ArrayList<Actor> actorsAngryMan= new ArrayList<>();
    private ArrayList<Integer> picturesGodFather= new ArrayList<>();
    private ArrayList<Actor> actorsGodFather= new ArrayList<>();


    private static final AllFilms ourInstance = new AllFilms();
    private Context context;

    public static AllFilms getInstance() {
        return ourInstance;
    }

    private AllFilms() {
    }
    public void add()
    {
        shawshankFilm();
        intouchablesFilm();
        forestGumpFilm();
        greenMileFilm();
        angryManFilm();
        GodFatherFilm();

        filmList.add(new Film(context.getResources().getString(R.string.the_shawshank_redemption).toString(),R.drawable.shawshank_poster, context.getResources().getString(R.string.drama).toString(),actorsShawshank,picturesShawshank));
        filmList.add(new Film(context.getResources().getString(R.string.the_intouchables).toString(),R.drawable.intouchables_poster,context.getResources().getString(R.string.comedy_drama).toString(),actorsIntouchables,picturesIntouchables));
        filmList.add(new Film(context.getResources().getString(R.string.forest_gump).toString(),R.drawable.forest_gump_poster,context.getResources().getString(R.string.drama).toString(),actorsForestGump,picturesForestGump));
        filmList.add(new Film(context.getResources().getString(R.string.the_green_mile).toString(),R.drawable.the_green_mile_poster,context.getResources().getString(R.string.crime_drama).toString(),actorsGreenMile,picturesGreenMile));
        filmList.add(new Film(context.getResources().getString(R.string.angry_men).toString(),R.drawable.angry_men_poster,context.getResources().getString(R.string.courtroom_drama).toString(),actorsAngryMan,picturesAngryMan));
        filmList.add(new Film(context.getResources().getString(R.string.the_godfather).toString(),R.drawable.the_godfather_poster,context.getResources().getString(R.string.crime).toString(),actorsGodFather,picturesGodFather));

    }

    private void angryManFilm() {

        actorsAngryMan.add(new Actor(context.getResources().getString(R.string.balsam).toString(),context.getResources().getString(R.string.martin).toString(),76,R.drawable.martin_balsam));
        actorsAngryMan.add(new Actor(context.getResources().getString(R.string.fiedler).toString(),context.getResources().getString(R.string.john).toString(),80,R.drawable.john_fiedler));
        actorsAngryMan.add(new Actor(context.getResources().getString(R.string.cobb).toString(),context.getResources().getString(R.string.lee).toString(),64,R.drawable.lee_cobb));
        actorsAngryMan.add(new Actor(context.getResources().getString(R.string.marshall).toString(),context.getResources().getString(R.string.e_g).toString(),88,R.drawable.e_g_marshall));
        actorsAngryMan.add(new Actor(context.getResources().getString(R.string.klugman).toString(),context.getResources().getString(R.string.jack).toString(),90,R.drawable.jack_klugman));
        actorsAngryMan.add(new Actor(context.getResources().getString(R.string.binns).toString(),context.getResources().getString(R.string.edward).toString(),74,R.drawable.edward_binns));

        picturesAngryMan.add(R.drawable.angry_man_1);
        picturesAngryMan.add(R.drawable.angry_man_2);
        picturesAngryMan.add(R.drawable.angry_man_3);
        picturesAngryMan.add(R.drawable.angry_man_4);
        picturesAngryMan.add(R.drawable.angry_man_5);
        picturesAngryMan.add(R.drawable.angry_man_6);
    }

    private void GodFatherFilm() {

        actorsGodFather.add(new Actor(context.getResources().getString(R.string.hayden).toString(),context.getResources().getString(R.string.sterling).toString(),70,R.drawable.sterling_hayden));
        actorsGodFather.add(new Actor(context.getResources().getString(R.string.brando).toString(),context.getResources().getString(R.string.marlon).toString(),80,R.drawable.marlon_brando));
        actorsGodFather.add(new Actor(context.getResources().getString(R.string.pacino).toString(),context.getResources().getString(R.string.al).toString(),77,R.drawable.al_pacino));
        actorsGodFather.add(new Actor(context.getResources().getString(R.string.caan).toString(),context.getResources().getString(R.string.james).toString(),78,R.drawable.james_caan));
        actorsGodFather.add(new Actor(context.getResources().getString(R.string.castellano).toString(),context.getResources().getString(R.string.richard).toString(),55,R.drawable.richard_castellano));
        actorsGodFather.add(new Actor(context.getResources().getString(R.string.duvall).toString(),context.getResources().getString(R.string.robert).toString(),87,R.drawable.robert_duvall));



        picturesGodFather.add(R.drawable.god_father_1);
        picturesGodFather.add(R.drawable.god_father_2);
        picturesGodFather.add(R.drawable.god_father_3);
        picturesGodFather.add(R.drawable.god_father_4);
        picturesGodFather.add(R.drawable.god_father_5);
        picturesGodFather.add(R.drawable.god_father_6);
    }

    private void greenMileFilm() {


        actorsGreenMile.add(new Actor(context.getResources().getString(R.string.hanks).toString(),context.getResources().getString(R.string.tom).toString(),61,R.drawable.tom_hanks));
        actorsGreenMile.add(new Actor(context.getResources().getString(R.string.morse).toString(),context.getResources().getString(R.string.david).toString(),64,R.drawable.david_morse));
        actorsGreenMile.add(new Actor(context.getResources().getString(R.string.hunt).toString(),context.getResources().getString(R.string.bonnie).toString(),56,R.drawable.bonnie_hunt));
        actorsGreenMile.add(new Actor(context.getResources().getString(R.string.clarke_duncan).toString(),context.getResources().getString(R.string.michael).toString(),54,R.drawable.michael_clarke_duncam));
        actorsGreenMile.add(new Actor(context.getResources().getString(R.string.cromwell).toString(),context.getResources().getString(R.string.james).toString(),78,R.drawable.james_cromwell));
        actorsGreenMile.add(new Actor(context.getResources().getString(R.string.jater).toString(),context.getResources().getString(R.string.michael).toString(),50,R.drawable.michael_jeter));

        picturesGreenMile.add(R.drawable.green_mile_1);
        picturesGreenMile.add(R.drawable.green_mile_2);
        picturesGreenMile.add(R.drawable.green_mile_3);
        picturesGreenMile.add(R.drawable.green_mile_4);
        picturesGreenMile.add(R.drawable.green_mile_5);
        picturesGreenMile.add(R.drawable.green_mile_6);
    }


    public void initialize(Context context)
    {
        this.context=context;
    }
    public Context getApplicationContext()
    {
        return context;
    }
    private void shawshankFilm()
    {
        actorsShawshank.add(new Actor(context.getResources().getString(R.string.robbins).toString(),context.getResources().getString(R.string.tim).toString(),59,R.drawable.tim_robins));
        actorsShawshank.add(new Actor(context.getResources().getString(R.string.freeman).toString(),context.getResources().getString(R.string.morgan).toString(),80,R.drawable.morgan_freeman));
        actorsShawshank.add(new Actor(context.getResources().getString(R.string.gunton).toString(),context.getResources().getString(R.string.bob).toString(),72,R.drawable.bob_guton));
        actorsShawshank.add(new Actor(context.getResources().getString(R.string.sadler).toString(),context.getResources().getString(R.string.william).toString(),67,R.drawable.william_sadler));
        actorsShawshank.add(new Actor(context.getResources().getString(R.string.brown).toString(),context.getResources().getString(R.string.clancy).toString(),59,R.drawable.clancy_brown));
        actorsShawshank.add(new Actor(context.getResources().getString(R.string.bellows).toString(),context.getResources().getString(R.string.gil).toString(),50,R.drawable.gil_bellows));

        picturesShawshank.add(R.drawable.shawshank_1);
        picturesShawshank.add(R.drawable.shawshank_2);
        picturesShawshank.add(R.drawable.shawshank_3);
        picturesShawshank.add(R.drawable.shawshank_4);
        picturesShawshank.add(R.drawable.shawshank_5);
        picturesShawshank.add(R.drawable.shawshank_6);
    }
    private void intouchablesFilm() {

        actorsIntouchables.add(new Actor(context.getResources().getString(R.string.cluzet).toString(),context.getResources().getString(R.string.francois).toString(),62,R.drawable.francois_cluzet));
        actorsIntouchables.add(new Actor(context.getResources().getString(R.string.sy).toString(),context.getResources().getString(R.string.omar).toString(),40,R.drawable.omar_sy));
        actorsIntouchables.add(new Actor(context.getResources().getString(R.string.le_ny).toString(),context.getResources().getString(R.string.anne).toString(),48,R.drawable.anne_le_ny));
        actorsIntouchables.add(new Actor(context.getResources().getString(R.string.fleurot).toString(),context.getResources().getString(R.string.audrey).toString(),40,R.drawable.audrey_fleurot));
        actorsIntouchables.add(new Actor(context.getResources().getString(R.string.mollet).toString(),context.getResources().getString(R.string.clotilde).toString(),45,R.drawable.clotilde_mollet));
        actorsIntouchables.add(new Actor(context.getResources().getString(R.string.christian).toString(),context.getResources().getString(R.string.ameri).toString(),66,R.drawable.christian_ameri));

        picturesIntouchables.add(R.drawable.intouchables_1);
        picturesIntouchables.add(R.drawable.intouchables_2);
        picturesIntouchables.add(R.drawable.intouchables_3);
        picturesIntouchables.add(R.drawable.intouchables_4);
        picturesIntouchables.add(R.drawable.intouchables_5);
        picturesIntouchables.add(R.drawable.intouchables_6);
    }
    private void forestGumpFilm() {

        actorsForestGump.add(new Actor(context.getResources().getString(R.string.hanks).toString(),context.getResources().getString(R.string.tom).toString(),61,R.drawable.tom_hanks));
        actorsForestGump.add(new Actor(context.getResources().getString(R.string.wright).toString(),context.getResources().getString(R.string.robin).toString(),51,R.drawable.robin_wright));
        actorsForestGump.add(new Actor(context.getResources().getString(R.string.sinise).toString(),context.getResources().getString(R.string.gary).toString(),63,R.drawable.gary_sinise));
        actorsForestGump.add(new Actor(context.getResources().getString(R.string.williamson).toString(),context.getResources().getString(R.string.mykelti).toString(),61,R.drawable.mykelti_williamson));
        actorsForestGump.add(new Actor(context.getResources().getString(R.string.field).toString(),context.getResources().getString(R.string.sally).toString(),71,R.drawable.sally_field));
        actorsForestGump.add(new Actor(context.getResources().getString(R.string.conner_humphreys).toString(),context.getResources().getString(R.string.michael).toString(),33,R.drawable.michael_conner_humphreys));


        picturesForestGump.add(R.drawable.forest_gump_1);
        picturesForestGump.add(R.drawable.forest_gump_2);
        picturesForestGump.add(R.drawable.forest_gump_3);
        picturesForestGump.add(R.drawable.forest_gump_4);
        picturesForestGump.add(R.drawable.forest_gump_5);
        picturesForestGump.add(R.drawable.forest_gump_6);
    }

}

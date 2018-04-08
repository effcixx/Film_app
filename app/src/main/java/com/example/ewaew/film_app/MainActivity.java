package com.example.ewaew.film_app;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerItemTouchHelper.RecyclerItemTouchHelperListener {


    private RecyclerView recyclerView;
    private List<Film> filmList;
    private CoordinatorLayout coordinatorLayout;
    private MyAdapter adapter;
    private static final String FILM_LIST = "FILM_LIST";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();

        restoreListOrAddNew(savedInstanceState);


        adapter = new MyAdapter(filmList, this);
        recyclerView.setAdapter(adapter);

        ItemTouchHelper.SimpleCallback itemTouchHelperCallback = new RecyclerItemTouchHelper(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT,this);
        new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(recyclerView);


    }

    private void restoreListOrAddNew(Bundle savedInstanceState) {
        if(savedInstanceState==null)
            addFilmsToList();
        else
            filmList = savedInstanceState.getParcelableArrayList(FILM_LIST);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(FILM_LIST, (ArrayList<? extends Parcelable>) filmList);
    }


    private void initialize() {
        recyclerView = findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        coordinatorLayout = findViewById(R.id.coordinator_layout);
        filmList = new ArrayList<>();
    }

    private void addFilmsToList() {
        AllFilms allFilms = AllFilms.getInstance();
        AllFilms.getInstance().initialize(this);
        allFilms.add();
        filmList = allFilms.getFilmList();
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction, int position) {
        if (viewHolder instanceof MyAdapter.ViewHolder) {

            String name = filmList.get(viewHolder.getAdapterPosition()).getTitle();

            final Film deletedFilm = filmList.get(viewHolder.getAdapterPosition());
            final int deletedIndex = viewHolder.getAdapterPosition();

            adapter.removeFilm(viewHolder.getAdapterPosition());

            Snackbar snackbar = Snackbar
                    .make(coordinatorLayout, name + getString(R.string.removed), Snackbar.LENGTH_LONG);
            snackbar.setAction(R.string.undo, new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    adapter.restoreFilm(deletedFilm, deletedIndex);
                }
            });
            snackbar.setActionTextColor(Color.YELLOW);
            snackbar.show();
        }
    }


}

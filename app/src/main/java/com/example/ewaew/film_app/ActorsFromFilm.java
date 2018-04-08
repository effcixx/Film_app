package com.example.ewaew.film_app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;



public class ActorsFromFilm extends Fragment {

    private ArrayList<Actor> personList = new ArrayList<>();
    private CustomAdapter customAdapter;

    private static final String FILM_ACTOR = "FILM_ACTOR";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Intent intent = getActivity().getIntent();

        personList = intent.getParcelableArrayListExtra(FILM_ACTOR);
        if (getArguments() != null) {
            personList  =getArguments().getParcelableArrayList(FILM_ACTOR);
        }

        View view = inflater.inflate(R.layout.fragment_actors_from_film, container, false);
        ListView listView = view.findViewById(R.id.list_view);

        customAdapter = new CustomAdapter(getActivity());
        listView.setAdapter(customAdapter);
        return view;
    }

    @Override
    public LayoutInflater onGetLayoutInflater(Bundle savedInstanceState) {
        return super.onGetLayoutInflater(savedInstanceState);
    }

    class CustomAdapter extends BaseAdapter {

        LayoutInflater layoutInflater;
        Context context;
        CustomAdapter(Context context) {
            this.context= context;

        }

        @Override
        public int getCount() {
            return personList.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(final int i, View view, ViewGroup viewGroup) {
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View mV;
            if (view == null) {
                view = layoutInflater.inflate(R.layout.actor_list_item, null);
            }
            mV = view;


            TextView surname = mV.findViewById(R.id.surnamet);
            TextView name = mV.findViewById(R.id.namet);
            TextView age = mV.findViewById(R.id.aget);
            ImageView image = mV.findViewById(R.id.image1);

            surname.setText(personList.get(i).getSurname());
            name.setText(personList.get(i).getName());
            age.setText(Integer.toString(personList.get(i).getAge()));
            image.setImageResource(personList.get(i).getIdPicture());

            return mV;
        }
    }



}

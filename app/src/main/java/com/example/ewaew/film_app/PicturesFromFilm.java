package com.example.ewaew.film_app;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;



public class PicturesFromFilm extends Fragment {

    private ArrayList<Integer> imageList = new ArrayList<>();
    private GriedAdapter griedAdapter;

    private static final String FILM_PICTURES = "FILM_PICTURES";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pictures_from_film, container, false);
        GridView gridView = view.findViewById(R.id.pictures_gridview);

        Intent intent = getActivity().getIntent();
        imageList = intent.getIntegerArrayListExtra(FILM_PICTURES);
        if (getArguments() != null) {
            imageList =getArguments().getIntegerArrayList(FILM_PICTURES);
        }

        griedAdapter = new GriedAdapter(getActivity());
        gridView.setAdapter(griedAdapter);

        return view;

    }

    class GriedAdapter extends BaseAdapter {

        LayoutInflater layoutInflater;
        Context context;

        public GriedAdapter(Context context) {
            this.context = context;

        }

        @Override
        public int getCount() {
            return imageList.size();
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
                view = layoutInflater.inflate(R.layout.picture_item, null);
            }
            mV = (View) view;


            ImageView image = mV.findViewById(R.id.imageView);
            image.setImageResource(imageList.get(i));


            return mV;
        }
    }
}

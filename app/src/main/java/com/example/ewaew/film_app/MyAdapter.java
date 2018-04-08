package com.example.ewaew.film_app;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Ewa Lyko on 30.03.2018.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<Film> filmList;

    MyAdapter(List<Film> filmList, Context context) {
        this.filmList = filmList;
        this.context = context;
    }

    private Context context;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.film_list_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final Film film = filmList.get(position);
        holder.filmTitle.setText(film.getTitle());
        holder.filmCategory.setText(film.getCategory());
        holder.picture.setImageResource(film.getIdPicture());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FilmDescription.start(view.getContext(),film.getTitle(),film.getIdPicture(),film.getCategory(),film.getActors(),film.getPictures());
            }
        });
    }

    void removeFilm(int position)
    {
        filmList.remove(position);
        notifyItemRemoved(position);
    }
    void restoreFilm(Film film, int position)
    {
        filmList.add(position,film);
        notifyItemInserted(position);
    }
    @Override
    public int getItemCount() {
        return filmList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView filmCategory;
        private TextView filmTitle;
        private ImageView picture;
        RelativeLayout viewBackground, viewForeground;

        ViewHolder(View itemView) {
            super(itemView);

            filmCategory = itemView.findViewById(R.id.filmCategory);
            filmTitle = itemView.findViewById(R.id.filmTitle);
            picture = itemView.findViewById(R.id.pictureOfFilm);
            viewBackground = itemView.findViewById(R.id.view_background);
            viewForeground = itemView.findViewById(R.id.view_foreground);
        }
    }
}
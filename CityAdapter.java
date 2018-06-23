package com.example.arslan.weather;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.MyViewHolder> {

    private List<City> moviesList;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title,  genre;
        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            genre = (TextView) view.findViewById(R.id.genre);
        }
    }


    public CityAdapter(List<City> moviesList) {
        this.moviesList = moviesList;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_list_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        City city = moviesList.get(position);
        holder.title.setText(city.getTitle());
        holder.genre.setText(city.getDescr());
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}

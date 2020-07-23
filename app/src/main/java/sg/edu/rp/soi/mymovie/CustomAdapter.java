package sg.edu.rp.soi.mymovie;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
public class CustomAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<Movies> movieList;
    public CustomAdapter(Context context, int resource, ArrayList<Movies> objects) {
        super(context, resource, objects);
        parent_context = context;
        layout_id = resource;
        movieList = objects;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(layout_id, parent, false);
        ImageView ivRating = rowView.findViewById(R.id.imageView);
        TextView tvTitle = rowView.findViewById(R.id.tvtitle);
        TextView tvInfo = rowView.findViewById(R.id.tvinfo);
        Movies currentMovie = movieList.get(position);
        tvTitle.setText(currentMovie.getTitle());
        tvInfo.setText(currentMovie.getYear() + " - " + currentMovie.getGenre());
        if(currentMovie.getRated() == "g") {
            ivRating.setImageResource(R.drawable.rating_g);
        } else if(currentMovie.getRated() == "pg") {
            ivRating.setImageResource(R.drawable.rating_pg);
        } else if(currentMovie.getRated() == "pg13") {
            ivRating.setImageResource(R.drawable.rating_pg13);
        } else if(currentMovie.getRated() == "nc16") {
            ivRating.setImageResource(R.drawable.rating_nc16);
        } else if(currentMovie.getRated() == "m18") {
            ivRating.setImageResource(R.drawable.rating_m18);
        } else if(currentMovie.getRated() == "r21") {
            ivRating.setImageResource(R.drawable.rating_r21);
        }
        return rowView;
    }
}
package sg.edu.rp.soi.mymovie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    ImageView ivRating;
    TextView tvTitle, tvInfo, tvDesc, tvWatchedOn, tvCinema;
    RatingBar ratingBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ivRating = findViewById(R.id.imageViewRating);
        tvTitle = findViewById(R.id.tvtitle);
        tvInfo = findViewById(R.id.tvinfo);
        tvDesc = findViewById(R.id.tvdesc);
        tvWatchedOn = findViewById(R.id.tvwatched);
        tvCinema = findViewById(R.id.tvtheatre);
        ratingBar = findViewById(R.id.ratingBar);
        Intent intentReceived = getIntent();
        String title = intentReceived.getStringExtra("title");
        String year = intentReceived.getStringExtra("year");
        String rating = intentReceived.getStringExtra("rated");
        String genre = intentReceived.getStringExtra("genre");
        String description = intentReceived.getStringExtra("description");
        String watchedOn = intentReceived.getStringExtra("watched_on");
        String theatre = intentReceived.getStringExtra("in_theatre");
        tvTitle.setText(title);
        tvInfo.setText(year + " - " + genre);
        tvDesc.setText(description);
        tvWatchedOn.setText("Watched on: " + watchedOn);
        tvCinema.setText("In theatre: " + theatre);
        if(rating.equals("g")) {
            ivRating.setImageResource(R.drawable.rating_g);
        } else if(rating.equals("pg13")) {
            ivRating.setImageResource(R.drawable.rating_pg13);
        } else if(rating.equals("nc16")) {
            ivRating.setImageResource(R.drawable.rating_nc16);
        } else if(rating.equals("m18")) {
            ivRating.setImageResource(R.drawable.rating_m18);
        } else if(rating.equals("r21")) {
            ivRating.setImageResource(R.drawable.rating_r21);
        }else if(rating.equals(("pg"))){
            ivRating.setImageResource(R.drawable.rating_pg);
        }
    }
}

package sg.edu.rp.soi.mymovie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<Movies> movieList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            listView = findViewById(R.id.listViewMovie);
            movieList = new ArrayList<>();
            Movies movie1 = new Movies("The Avengers", "2012", "pg13", "Action | Sci-Fi", "15/12/2014", "Golden Village - Bishan", "Nick Fury of S.H.I.E.L.D. assembles a team of superheroes to save the planet from Loki and his army.");
            movieList.add(movie1);
            Movies movie2 = new Movies("Planes", "2013", "pg", "Adventure | Comedy", "10/11/2013", "Golden Village - Yishun", "A crop-dusting plane with a fear of heights lives his dream of competing in a famous around-the-world aerial race.");
            movieList.add(movie2);
            CustomAdapter adapter = new CustomAdapter(this, R.layout.row, movieList);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("title", movieList.get(position).getTitle());
                    intent.putExtra("year", movieList.get(position).getYear());
                    intent.putExtra("rated", movieList.get(position).getRated());
                    intent.putExtra("genre", movieList.get(position).getGenre());
                    intent.putExtra("watched_on", movieList.get(position).getWatched_on());
                    intent.putExtra("in_theatre", movieList.get(position).getIn_theatre());
                    intent.putExtra("description", movieList.get(position).getDescription());
                    startActivity(intent);
                }
            });
            Intent intentReceivedFromThird = getIntent();
            String title = intentReceivedFromThird.getStringExtra("title");
            String year = intentReceivedFromThird.getStringExtra("year");
            String rating = intentReceivedFromThird.getStringExtra("rated");
            String genre = intentReceivedFromThird.getStringExtra("genre");
            String description = intentReceivedFromThird.getStringExtra("description");
            String watchedOn = intentReceivedFromThird.getStringExtra("watched");
            String theatre = intentReceivedFromThird.getStringExtra("theatre");
            if (title != null) {
                Movies newMovie = new Movies(title, year, rating, genre, watchedOn, theatre, description);
                movieList.add(newMovie);
                adapter.notifyDataSetChanged();
            }
            Intent intentReceivedFromSecond = getIntent();
            String movieTitle = intentReceivedFromSecond.getStringExtra("titleDelete");
            if (movieTitle != null) {
                int position = movieList.indexOf(movieTitle);
                movieList.remove(position);
                adapter.notifyDataSetChanged();
            }
        }
        @Override
        public boolean onCreateOptionsMenu (Menu menu){
            getMenuInflater().inflate(R.menu.menu, menu);
            return true;
        }
        @Override
        public boolean onOptionsItemSelected (MenuItem item){
            Intent intentAdd = new Intent(getBaseContext(), ThirdActivity.class);
            startActivity(intentAdd);
            return super.onOptionsItemSelected(item);
        }
    }

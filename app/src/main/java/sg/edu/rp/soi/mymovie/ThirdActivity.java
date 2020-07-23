package sg.edu.rp.soi.mymovie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
public class ThirdActivity extends AppCompatActivity {
    Button btnAdd;
    EditText etTitle, etYear, etGenre, etRated, etDateWatched, etTheatre, etDescription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        btnAdd = findViewById(R.id.btnadd);
        etTitle = findViewById(R.id.ettitle);
        etYear = findViewById(R.id.etyear);
        etGenre = findViewById(R.id.etgenre);
        etRated = findViewById(R.id.etrated);
        etDateWatched = findViewById(R.id.etwatched);
        etTheatre = findViewById(R.id.ettheatre);
        etDescription = findViewById(R.id.etdesc);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAddToMain = new Intent(ThirdActivity.this, MainActivity.class);
                intentAddToMain.putExtra("title", etTitle.getText().toString());
                intentAddToMain.putExtra("year", etYear.getText().toString());
                intentAddToMain.putExtra("rated", etRated.getText().toString());
                intentAddToMain.putExtra("genre", etGenre.getText().toString());
                intentAddToMain.putExtra("watched", etDateWatched.getText().toString());
                intentAddToMain.putExtra("theatre", etTheatre.getText().toString());
                intentAddToMain.putExtra("description", etDescription.getText().toString());
                startActivity(intentAddToMain);
            }
        });
    }
}

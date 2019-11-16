package com.iqbal.mymoviecatalogue;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class FilmDetail extends AppCompatActivity {

    public static final String EXTRA_FILM = "extra_film";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_detail);

        String name, score, runtime, year, status, language, budget, desc;
        int path;

        TextView tvName, tvScore, tvRuntime, tvYear, tvStatus, tvLang, tvBudget, tvDesc;
        ImageView imgPhoto;

        tvName = findViewById(R.id.txt_name);
        tvScore = findViewById(R.id.txt_score);
        tvRuntime = findViewById(R.id.txt_runtime);
        tvYear = findViewById(R.id.txt_year);
        tvStatus = findViewById(R.id.txt_status);
        tvLang = findViewById(R.id.txt_lang);
        tvBudget = findViewById(R.id.txt_budget);
        tvDesc = findViewById(R.id.txt_desc);
        imgPhoto = findViewById(R.id.img_photo);

        Film film = getIntent().getParcelableExtra(EXTRA_FILM);
        name = film.getName();
        tvName.setText(name);

        score = film.getScore();
        tvScore.setText(score);

        runtime = film.getRuntime();
        tvRuntime.setText(runtime);

        year = film.getYear();
        tvYear.setText(year);

        status = film.getStatus();
        tvStatus.setText(status);

        language = film.getLanguage();
        tvLang.setText(language);

        budget = film.getBudget();
        tvBudget.setText(budget);

        desc = film.getDesc();
        tvDesc.setText(desc);

        path = film.getPhoto();
        imgPhoto.setImageResource(path);
    }
}

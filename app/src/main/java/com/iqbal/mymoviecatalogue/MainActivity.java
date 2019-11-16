package com.iqbal.mymoviecatalogue;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String[] dataName, dataDesc, dataScore, dataRuntime, dataYear, dataStatus, dataLang, dataBudget;
    private TypedArray dataPhoto;
    private FilmAdapter adapter;
    private ArrayList<Film> films;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new FilmAdapter(this);
        ListView listView = findViewById(R.id.lv_list);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent moveObject = new Intent(MainActivity.this, FilmDetail.class);
//                ArrayList<Film> films = new ArrayList<Film>();
                Film film = new Film();
                film.setPhoto(dataPhoto.getResourceId(position, -1));
                film.setName(dataName[position]);
                film.setScore(dataScore[position]);
                film.setRuntime(dataRuntime[position]);
                film.setYear(dataYear[position]);
                film.setStatus(dataStatus[position]);
                film.setLanguage(dataLang[position]);
                film.setBudget(dataBudget[position]);
                film.setDesc(dataDesc[position]);
//                films.add(film);
                moveObject.putExtra(FilmDetail.EXTRA_FILM, films.get(position));
                startActivity(moveObject);
            }
        });

    }

    private void prepare() {
        dataName = getResources().getStringArray(R.array.data_name);
        dataDesc = getResources().getStringArray(R.array.data_desc);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
        dataScore = getResources().getStringArray(R.array.data_score);
        dataRuntime = getResources().getStringArray(R.array.data_runtime);
        dataYear = getResources().getStringArray(R.array.data_year);
        dataStatus = getResources().getStringArray(R.array.data_status);
        dataLang = getResources().getStringArray(R.array.data_language);
        dataBudget = getResources().getStringArray(R.array.data_budget);
    }

    private void addItem() {
        films = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            Film film = new Film();
            film.setPhoto(dataPhoto.getResourceId(i, -1));
            film.setName(dataName[i]);
            film.setDesc(dataDesc[i]);
            film.setScore(dataScore[i]);
            film.setRuntime(dataRuntime[i]);
            film.setYear(dataYear[i]);
            film.setStatus(dataStatus[i]);
            film.setLanguage(dataLang[i]);
            film.setBudget(dataBudget[i]);
            films.add(film);
        }
        adapter.setFilms(films);
    }


}

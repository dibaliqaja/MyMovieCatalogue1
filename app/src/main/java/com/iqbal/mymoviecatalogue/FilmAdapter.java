package com.iqbal.mymoviecatalogue;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FilmAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Film> films;

    public void setFilms(ArrayList<Film> films) {
        this.films = films;
    }

    public FilmAdapter(Context context) {
        this.context = context;
        films = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return films.size();
    }

    @Override
    public Object getItem(int position) {
        return films.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_film, parent, false);
        }

        ViewHolder viewHolder = new ViewHolder(convertView);
        Film film = (Film) getItem(position);
        viewHolder.bind(film);
        return convertView;
    }

    private class ViewHolder {
        private TextView txtName, txtScore, txtRuntime, txtYear, txtLang, txtBudget, txtDesc;
        private ImageView imgPhoto;

        ViewHolder(View view) {
            txtName = view.findViewById(R.id.txt_name);
            txtScore = view.findViewById(R.id.txt_score);
            txtRuntime = view.findViewById(R.id.txt_runtime);
            txtYear = view.findViewById(R.id.txt_year);
            txtLang = view.findViewById(R.id.txt_lang);
            txtBudget = view.findViewById(R.id.txt_budget);
            txtDesc = view.findViewById(R.id.txt_desc);
            imgPhoto = view.findViewById(R.id.img_photo);
        }

        void bind(Film film) {
            txtName.setText(film.getName());
            txtDesc.setText(film.getDesc());
            txtScore.setText(film.getScore());
            txtRuntime.setText(film.getRuntime());
            txtYear.setText(film.getYear());
            txtLang.setText(film.getLanguage());
            txtBudget.setText(film.getBudget());
            imgPhoto.setImageResource(film.getPhoto());
        }
    }
}

package com.example.android.musicalstructureapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import com.example.android.musicalstructureapp.song.Genre;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView genreGridView = findViewById(R.id.music_genre_gridview);

        ArrayAdapter<Genre> genresAdapter = new ArrayAdapter<Genre>(this, android.R.layout.simple_list_item_1,
                Genre.values());

        genreGridView.setAdapter(genresAdapter);

        genreGridView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent intent = new Intent(MainActivity.this, SongsListActivity.class);
                        intent.putExtra("genre", Genre.values()[i].toString());
                        startActivity(intent);
                    }
                }
        );
    }
}

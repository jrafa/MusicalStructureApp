package com.example.android.musicalstructureapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.android.musicalstructureapp.song.Genre;
import com.example.android.musicalstructureapp.song.Song;
import com.example.android.musicalstructureapp.song.SongAdapter;

import java.util.ArrayList;

public class SongsListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list);

        Intent intent = getIntent();
        String genre = (String) intent.getSerializableExtra("genre");
        setTitle(genre);

        final ArrayList<Song> songs = addSongsExample();
        final ArrayList<Song> songsGenre = getSongsByGenre(songs, genre);
        final Button buttonGenre = findViewById(R.id.button_genre_songs);

        SongAdapter itemsAdapter = new SongAdapter(this, songsGenre);
        ListView listView = findViewById(R.id.songs_list);
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(SongsListActivity.this, SongDetailActivity.class);
                intent.putExtra("song", songsGenre.get(i));
                startActivity(intent);
            }
        });

        buttonGenre.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(SongsListActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    public ArrayList<Song> getSongsByGenre(ArrayList<Song> songs, String genre) {
        ArrayList<Song> songsGenre = new ArrayList<Song>();

        for (int i = 0; i < songs.size(); i++) {
            if (songs.get(i).getGenre().toString().equals(genre)) {
                songsGenre.add(songs.get(i));
            }
        }

        return songsGenre;
    }

    public ArrayList<Song> addSongsExample() {
        ArrayList<Song> songs = new ArrayList<Song>();

        for (int i = 0; i < 20; i++) {
            songs.add(new Song("Purple Rain", "Prince", Genre.POP));
            songs.add(new Song("Be the One", "Dua Lipa", Genre.POP));
            songs.add(new Song("Bohemian Rhapsody", "Queen", Genre.ROCK));
            songs.add(new Song("We Will Rock You", "Queen", Genre.ROCK));
            songs.add(new Song("Piano", "Piano", Genre.JAZZ));
            songs.add(new Song("Gangsta's Paradise", "Coolio", Genre.RAP));
            songs.add(new Song("Despacito", "Luis Fonsi", Genre.LATINO));
        }

        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        for (Character letter : alphabet) {
            songs.add(new Song("Étude in " + Character.toString(letter).toUpperCase() + " minor", "Frédéric Chopin", Genre.CLASSIC));
        }

        return songs;
    }
}

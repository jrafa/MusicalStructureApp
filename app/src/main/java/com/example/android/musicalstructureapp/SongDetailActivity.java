package com.example.android.musicalstructureapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.android.musicalstructureapp.song.Song;

public class SongDetailActivity extends AppCompatActivity {

    private Boolean paused = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_detail);

        Bundle data = getIntent().getExtras();
        final Song song = data.getParcelable("song");

        setTitle(song.getAuthor() + " - " + song.getTitle());

        TextView authorTextView = findViewById(R.id.author);
        TextView titleTextView = findViewById(R.id.title);

        final Button buttonPlayPause = findViewById(R.id.button_play_pause);
        final Button buttonPreviousSong = findViewById(R.id.button_previous_song);
        final Button buttonNextSong = findViewById(R.id.button_next_song);

        final Button buttonGenre = findViewById(R.id.button_genre);
        final Button buttonSongs = findViewById(R.id.button_songs);

        authorTextView.setText(song.getAuthor());
        titleTextView.setText(song.getTitle());

        buttonPlayPause.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (paused) {
                    buttonPlayPause.setBackgroundResource(R.drawable.ic_play);
                } else {
                    buttonPlayPause.setBackgroundResource(R.drawable.ic_pause);
                }
                paused = !paused;
            }
        });

        buttonPreviousSong.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.v("SongDetailActivity", "previous Song ...");
            }
        });

        buttonNextSong.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.v("SongDetailActivity", "next Song ...");
            }
        });

        buttonGenre.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(SongDetailActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        buttonSongs.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(SongDetailActivity.this, SongsListActivity.class);
                intent.putExtra("genre", song.getGenre().toString());
                startActivity(intent);
            }
        });
    }

}

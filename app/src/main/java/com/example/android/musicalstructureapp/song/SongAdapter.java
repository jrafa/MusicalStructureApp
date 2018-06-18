package com.example.android.musicalstructureapp.song;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.android.musicalstructureapp.R;

import java.util.ArrayList;


/**
 * Created by jrafa on 25.02.2018.
 */

public class SongAdapter extends ArrayAdapter<Song> {
    public SongAdapter(@NonNull Context context, ArrayList<Song> songs) {
        super(context, 0, songs);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Song song = getItem(position);
        TextView titleTextView = listItemView.findViewById(R.id.song_title);
        titleTextView.setText(song.getTitle());

        TextView authorTextView = listItemView.findViewById(R.id.song_author);
        authorTextView.setText(song.getAuthor());

        return listItemView;
    }
}

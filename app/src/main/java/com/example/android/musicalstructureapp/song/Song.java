package com.example.android.musicalstructureapp.song;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jrafa on 25.02.2018.
 */

public class Song implements Parcelable {

    private String title;
    private String author;
    private Genre genre;

    public Song(String title, String author, Genre genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    protected Song(Parcel in) {
        title = in.readString();
        author = in.readString();
        genre = (Genre) in.readValue(Genre.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(author);
        dest.writeValue(genre);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Song> CREATOR = new Creator<Song>() {
        @Override
        public Song createFromParcel(Parcel in) {
            return new Song(in);
        }

        @Override
        public Song[] newArray(int size) {
            return new Song[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String toString() {
        return this.genre.name();
    }
}

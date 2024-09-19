package com.example.recordshopapp.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.recordshopapp.BR;

import java.math.BigDecimal;
import java.time.Year;

// {
//         "id": 1,
//         "title": "lolo",
//         "releaseYear": "2002",
//         "genre": "WORLD_MUSIC",
//         "price": 60.00,
//         "stock": 35,
//         "artist": {
//         "name": "Lion"
//         }
//         }
public class Album extends BaseObservable {
    int id;
    String title;
    String releaseYear;
    String genre;
    BigDecimal price;
    int stock;
    Artist artist;

    public Album() {
    }

    public Album(int id, String title, String releaseYear, String genre, BigDecimal price, int stock, Artist artist) {
        this.id = id;
        this.title = title;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.price = price;
        this.stock = stock;
        this.artist = artist;
    }
    @Bindable
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        notifyPropertyChanged(BR.id);
    }
    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }
    @Bindable
    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
        notifyPropertyChanged(BR.releaseYear);
    }
    @Bindable
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
        notifyPropertyChanged(BR.genre);
    }
    @Bindable
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
        notifyPropertyChanged(BR.price);
    }
    @Bindable
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
        notifyPropertyChanged(BR.stock);
    }
    @Bindable
    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
        notifyPropertyChanged(BR.artist);
    }
}

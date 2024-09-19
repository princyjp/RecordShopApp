package com.example.recordshopapp.model;

import java.math.BigDecimal;
import java.time.Year;

public class AlbumDTO {
    long id;
    String title;
    Year releaseYear;
    Genre genre;
    BigDecimal price;
    int stock;
    Artist artist;


    public AlbumDTO(String title, Year releaseYear, Genre genre, BigDecimal price, int stock, Artist artist) {
        this(0L, title, releaseYear, genre, price, stock, artist);
    }

    public AlbumDTO(long id, String title, Year releaseYear, Genre genre, BigDecimal price, int stock, Artist artist) {
        this.id = id;
        this.title = title;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.price = price;
        this.stock = stock;
        this.artist = artist;
    }

    public AlbumDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Year getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Year releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "AlbumDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", releaseYear=" + releaseYear +
                ", genre=" + genre +
                ", price=" + price +
                ", stock=" + stock +
                ", artist=" + artist +
                '}';
    }
}

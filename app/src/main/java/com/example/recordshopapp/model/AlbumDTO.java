package com.example.recordshopapp.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
//import androidx.databinding.library.baseAdapters.BR;
import com.example.recordshopapp.BR;
import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;
import java.time.Year;

public class AlbumDTO extends BaseObservable {
    long id;
    @SerializedName("title")
    String title;
    @SerializedName("releaseYear")
    int releaseYear;
//    Year releaseYear;
    @SerializedName("genre")
    Genre genre;
    @SerializedName("price")
    BigDecimal priceDto;
    @SerializedName("stock")
    int stock;
    @SerializedName("artist")
    Artist artist;



    public AlbumDTO( long id,String title, int releaseYear, Genre genre, BigDecimal priceDto, int stock, Artist artist) {

        this.id = id;
        this.title = title;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.priceDto = priceDto;
        this.stock = stock;
        this.artist = artist;
    }

    public AlbumDTO() {
    }
//    @Bindable
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
//        notifyPropertyChanged(BR.id);
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
    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
        notifyPropertyChanged(BR.releaseYear);
    }
    @Bindable
    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
        notifyPropertyChanged(BR.genre);
    }
    @Bindable
    public BigDecimal getPriceDto() {
        return priceDto;
    }

    public void setPriceDto(BigDecimal priceDto) {
        this.priceDto = priceDto;
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

    @Override
    public String toString() {
        return "AlbumDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", releaseYear=" + releaseYear +
                ", genre=" + genre +
                ", price=" + priceDto +
                ", stock=" + stock +
                ", artist=" + artist.getName() +
                '}';
    }
}

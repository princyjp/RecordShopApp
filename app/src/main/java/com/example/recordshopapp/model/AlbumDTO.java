package com.example.recordshopapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
//import androidx.databinding.library.baseAdapters.BR;
import com.example.recordshopapp.BR;
import com.example.recordshopapp.util.Converter;
import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;
import java.time.Year;

public class AlbumDTO extends BaseObservable implements Parcelable {
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

    protected AlbumDTO(Parcel in) {
        id = in.readLong();
        title = in.readString();
        releaseYear = in.readInt();
        stock = in.readInt();
        genre = Genre.valueOf(in.readString());
        artist = new Artist(in.readString());
        priceDto = Converter.stringToBigDecimal(in.readString());
    }
    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeLong(id);
        parcel.writeString(title);
        parcel.writeInt(releaseYear);
        parcel.writeInt(stock);
        parcel.writeString(genre.name());
        parcel.writeString(artist.getName());
        parcel.writeString(Converter.bigDecimalToString(priceDto));
    }
    public static final Creator<AlbumDTO> CREATOR = new Creator<AlbumDTO>() {
        @Override
        public AlbumDTO createFromParcel(Parcel in) {
            return new AlbumDTO(in);
        }

        @Override
        public AlbumDTO[] newArray(int size) {
            return new AlbumDTO[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }


}

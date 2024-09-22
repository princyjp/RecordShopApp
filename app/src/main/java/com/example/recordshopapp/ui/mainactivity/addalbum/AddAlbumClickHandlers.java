package com.example.recordshopapp.ui.mainactivity.addalbum;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.recordshopapp.R;
import com.example.recordshopapp.model.AlbumDTO;
import com.example.recordshopapp.model.Genre;
import com.example.recordshopapp.ui.mainactivity.MainActivity;
import com.example.recordshopapp.ui.mainactivity.MainActivityViewModel;

import java.time.Year;
import java.util.ArrayList;

public class AddAlbumClickHandlers {
    AlbumDTO albumDTO;
    Context context;
    MainActivityViewModel mainActivityViewModel;


    public AddAlbumClickHandlers(AlbumDTO albumDTO, Context context, MainActivityViewModel mainActivityViewModel) {
        this.albumDTO = albumDTO;
        this.context = context;
        this.mainActivityViewModel = mainActivityViewModel;
    }

    public void onAddBtnClick(View view) {

        if (albumDTO == null || albumDTO.getTitle() == null || albumDTO.getArtist() == null || albumDTO.getReleaseYear() == 0 ||
                albumDTO.getGenre() == null || albumDTO.getPriceDto() == null || albumDTO.getStock() == 0) {

            Toast.makeText(context, "Fields can't be empty", Toast.LENGTH_SHORT).show();
        }
//        else if (albumDTO.getReleaseYear().isAfter(Year.now()) || albumDTO.getReleaseYear().isBefore(Year.of(1857))) {
        else if (albumDTO.getReleaseYear() > Year.now().getValue() || albumDTO.getReleaseYear() < 1857) {
            Toast.makeText(context, "Invalid year. Year should be between 1857 & present", Toast.LENGTH_SHORT).show();
        } else {
            Log.i("onAddBtnClick", albumDTO.toString());
            Toast.makeText(context, "SUCCESS", Toast.LENGTH_SHORT).show();
            AlbumDTO newAlbum = new AlbumDTO(
                                            albumDTO.getId(),
                                            albumDTO.getTitle(),
                                            albumDTO.getReleaseYear(),
                                            albumDTO.getGenre(),
                                            albumDTO.getPriceDto(),
                                            albumDTO.getStock(),
                                            albumDTO.getArtist());

            mainActivityViewModel.postAlbum(newAlbum);

            Intent intent = new Intent(context, MainActivity.class);
            context.startActivity(intent);
        }

    }

    public void onBackBtnClick(View view) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);

    }

}

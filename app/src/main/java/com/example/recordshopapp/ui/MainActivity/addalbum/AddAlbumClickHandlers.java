package com.example.recordshopapp.ui.MainActivity.addalbum;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.example.recordshopapp.model.AlbumDTO;
import com.example.recordshopapp.ui.MainActivity.MainActivity;
import com.example.recordshopapp.ui.MainActivity.MainActivityViewModel;

public class AddAlbumClickHandlers {
    AlbumDTO albumDTO;
    Context context;
    MainActivityViewModel mainActivityViewModel;

    public AddAlbumClickHandlers(AlbumDTO albumDTO, Context context, MainActivityViewModel mainActivityViewModel) {
        this.albumDTO = albumDTO;
        this.context = context;
        this.mainActivityViewModel = mainActivityViewModel;
    }
    public void onAddBtnClick(View view){
        if(albumDTO.getTitle() == null || albumDTO.getArtist() == null || albumDTO.getReleaseYear() == null
        || albumDTO.getGenre() == null || albumDTO.getPriceDto() == null || albumDTO.getStock() == 0){
            Toast.makeText(context,"Fields can't be empty",Toast.LENGTH_SHORT).show();
        }else{
            AlbumDTO newAlbum = new AlbumDTO(albumDTO.getTitle(), albumDTO.getReleaseYear(),albumDTO.getGenre(),
                                albumDTO.getPriceDto(), albumDTO.getStock(), albumDTO.getArtist());
            mainActivityViewModel.postAlbum(newAlbum);
            Intent intent = new Intent(context, MainActivity.class);
            context.startActivity(intent);
        }

    }
    public void onBackBtnClick(View view){

    }
}

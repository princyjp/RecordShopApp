package com.example.recordshopapp.ui.mainactivity;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.recordshopapp.model.Album;
import com.example.recordshopapp.model.AlbumDTO;
import com.example.recordshopapp.repository.AlbumRepository;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {
    private AlbumRepository albumRepository;
    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        this.albumRepository = new AlbumRepository(application);
    }
    public MutableLiveData<List<Album>> getMutableLiveData(){
       return albumRepository.getAllAlbums();
    }
    public void postAlbum(AlbumDTO albumDTO){
        albumRepository.postAlbum(albumDTO);
    }
}

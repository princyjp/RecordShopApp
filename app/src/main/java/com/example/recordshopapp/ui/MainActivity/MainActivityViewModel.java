package com.example.recordshopapp.ui.MainActivity;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.recordshopapp.model.Album;
import com.example.recordshopapp.model.AlbumRepository;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {
    private AlbumRepository albumRepository;
    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        this.albumRepository = new AlbumRepository(application);
    }
    public MutableLiveData<List<Album>> getMutableLiveData(){
       return albumRepository.getMutableLiveData();
    }
}

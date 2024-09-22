package com.example.recordshopapp.model;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.example.recordshopapp.service.AlbumApiService;
import com.example.recordshopapp.service.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumRepository {
    private MutableLiveData<List<Album>> mutableLiveData = new MutableLiveData<>();
    private Application application;

    public AlbumRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<Album>> getAllAlbums() {
        AlbumApiService albumApiService = RetrofitInstance.getService();
        Call<List<Album>> call = albumApiService.getAllAlbums();
        call.enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                List<Album> albumList = response.body();
                mutableLiveData.setValue(albumList);

            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable t) {
                Log.e("Http Error", t.getMessage());
            }
        });
        return mutableLiveData;

    }
    public void postAlbum(AlbumDTO albumDTO){
        AlbumApiService albumApiService = RetrofitInstance.getService();
        Call<AlbumDTO> call = albumApiService.postAlbum(albumDTO);
        call.enqueue(new Callback<AlbumDTO>() {
            @Override
            public void onResponse(Call<AlbumDTO> call, Response<AlbumDTO> response) {
                if(response != null) {
                    Log.e("POST Response", String.valueOf(response.body()));
                }
                Toast.makeText(application,"SUCCESS: Album added to database",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<AlbumDTO> call, Throwable t) {
                Log.e("POST Request",t.getMessage());
                Toast.makeText(application,"FAIL: Unable to add Album!",Toast.LENGTH_SHORT).show();
            }
        });
    }
}

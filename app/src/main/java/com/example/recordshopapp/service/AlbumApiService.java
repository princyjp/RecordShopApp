package com.example.recordshopapp.service;

import com.example.recordshopapp.model.Album;
import com.example.recordshopapp.model.AlbumDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface AlbumApiService {

    @GET("albums")
    Call<List<Album>> getAllAlbums();

    @POST("albums")
    Call<AlbumDTO> postAlbum(@Body AlbumDTO albumDTO);

    @PUT("albums/{id}")
    Call<AlbumDTO> updateAlbum(@Path("id") long id, @Body AlbumDTO albumDTO);

    @DELETE("albums/{id}")
    Call<String> deleteAlbum(@Path("id") long id);
}

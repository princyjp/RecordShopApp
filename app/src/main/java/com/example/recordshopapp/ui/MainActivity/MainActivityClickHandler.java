package com.example.recordshopapp.ui.MainActivity;

import android.content.Context;
import android.content.Intent;

import com.example.recordshopapp.ui.MainActivity.addalbum.AddNewAlbumActivity;

public class MainActivityClickHandler {
    Context context;

    public MainActivityClickHandler(Context context) {
        this.context = context;
    }

    public void onFABclick(){
        Intent intent = new Intent(context,AddNewAlbumActivity.class);
        context.startActivity(intent);
    }
}

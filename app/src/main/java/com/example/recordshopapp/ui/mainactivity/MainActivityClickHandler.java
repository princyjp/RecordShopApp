package com.example.recordshopapp.ui.mainactivity;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.example.recordshopapp.ui.mainactivity.addalbum.AddNewAlbumActivity;

public class MainActivityClickHandler {
    Context context;

    public MainActivityClickHandler(Context context) {
        this.context = context;
    }

    public void onFABclick(View view){
        Intent intent = new Intent(context,AddNewAlbumActivity.class);
        context.startActivity(intent);
    }
}

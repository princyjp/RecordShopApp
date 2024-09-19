package com.example.recordshopapp.ui.MainActivity.addalbum;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.recordshopapp.R;
import com.example.recordshopapp.databinding.ActivityAddNewAlbumBinding;
import com.example.recordshopapp.model.Album;
import com.example.recordshopapp.model.AlbumDTO;
import com.example.recordshopapp.ui.MainActivity.AlbumAdapter;
import com.example.recordshopapp.ui.MainActivity.MainActivityViewModel;

import java.util.List;

public class AddNewAlbumActivity extends AppCompatActivity {
    private AddAlbumClickHandlers addAlbumClickHandlers;
    private MainActivityViewModel mainActivityViewModel;
    private AlbumDTO albumDTO;
    private ActivityAddNewAlbumBinding activityAddNewAlbumBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_new_album);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        activityAddNewAlbumBinding = DataBindingUtil.setContentView(this,R.layout.activity_add_new_album);
        mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        activityAddNewAlbumBinding.setAlbumDTO(albumDTO);
        activityAddNewAlbumBinding.setClickHandler(addAlbumClickHandlers);

    }

}
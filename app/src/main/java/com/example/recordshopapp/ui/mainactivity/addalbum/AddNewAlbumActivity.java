package com.example.recordshopapp.ui.mainactivity.addalbum;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.recordshopapp.R;
import com.example.recordshopapp.databinding.ActivityAddNewAlbumBinding;
import com.example.recordshopapp.model.AlbumDTO;
import com.example.recordshopapp.model.Genre;
import com.example.recordshopapp.ui.mainactivity.MainActivityViewModel;
import com.example.recordshopapp.util.Converter;

import java.util.ArrayList;

public class AddNewAlbumActivity extends AppCompatActivity {
    private AddAlbumClickHandlers addAlbumClickHandlers;
    private MainActivityViewModel mainActivityViewModel;
    private AlbumDTO albumDTO;
    private ActivityAddNewAlbumBinding activityAddNewAlbumBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        activityAddNewAlbumBinding = DataBindingUtil.setContentView(this,R.layout.activity_add_new_album);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        albumDTO = new AlbumDTO();

        mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        addAlbumClickHandlers = new AddAlbumClickHandlers(albumDTO,this,mainActivityViewModel);
        activityAddNewAlbumBinding.setClickHandler(addAlbumClickHandlers);

        populateGenreSpinner();

    }

    private void populateGenreSpinner() {
        ArrayList<String> genreList = new ArrayList<>();
        for(Genre genre:Genre.values()){
            genreList.add(genre.name());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, genreList);
        adapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        activityAddNewAlbumBinding.spinnerGenre.setAdapter(adapter);
        activityAddNewAlbumBinding.spinnerGenre.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                albumDTO.setGenre(Genre.valueOf(adapterView.getItemAtPosition(i).toString()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        activityAddNewAlbumBinding.setAlbumDTO(albumDTO);

    }

}
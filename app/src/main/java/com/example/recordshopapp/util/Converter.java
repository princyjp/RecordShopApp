package com.example.recordshopapp.util;

import android.util.Log;

import androidx.databinding.InverseMethod;

import com.example.recordshopapp.model.Artist;
import com.example.recordshopapp.model.Genre;

import java.math.BigDecimal;
import java.time.Year;

public class Converter {
    @InverseMethod("stringToInt")
    public static String intToString(int value){
        return value == 0? "" : String.valueOf(value);
    }

    public static int stringToInt(String value){
        try{
            //if string value is empty then return null so hat we know its empty or check if its null or zero
            return value.isEmpty()? 0: Integer.parseInt(value);
        }catch(NumberFormatException e){
            Log.e("Converter",e.getMessage());
            return 0;
        }
    }
    @InverseMethod("stringToBigDecimal")
    public static String bigDecimalToString(BigDecimal value){
        return value==null? "" : String.valueOf(value);
    }
    public static BigDecimal stringToBigDecimal(String value){
        try{
            //if string value is empty then return null so hat we know its empty or check if its null or zero
            return value.isEmpty()? BigDecimal.ZERO: new BigDecimal(value);
        }catch(NumberFormatException e){
            Log.e("Converter",e.getMessage());
            return  BigDecimal.ZERO;
        }
    }
    @InverseMethod("stringToYear")
    public static String yearToString(Year value){

        return value == null? "" : value.toString();
    }
    public static Year stringToYear(String value){
        try{
            return value.isEmpty()? null: Year.parse(value);
        }catch(Exception e){
            Log.e("Converter", e.getMessage());
            return null;
        }
    }
    @InverseMethod("stringToArtist")
    public static String artistToString(Artist artist){
        return artist == null? "":artist.getName();
    }
    public static Artist stringToArtist(String artist){
        try{
            return artist.isEmpty()? null : new Artist(artist);
        }catch(Exception e){
            Log.e("Converter",e.getMessage());
            return null;
        }
    }
    @InverseMethod("stringToGenre")
    public static String genreToString(Genre genre){
        return genre.name();
    }
    public static Genre stringToGenre(String genre){
        return Genre.valueOf(genre);
    }
}
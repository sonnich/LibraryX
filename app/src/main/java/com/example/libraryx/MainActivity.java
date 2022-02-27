package com.example.libraryx;



import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private NumberPicker numberPicker;
    private Button btnSeeAll, btnCurrentlyReading,btnFinishedBooks ,btnWishList ,btnFavourites ,btnAbout;
    private Utils utils;
    public static final String URL = "url";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        utils = Utils.getInstance();

        String[] valuesDisplayed= getPickerValues(10);

        initViews();
        setupNumberPicker(numberPicker, valuesDisplayed);

        btnSeeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AllBooksActivity.class);
                startActivity(intent);

            }
        });

        btnFinishedBooks.setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AlreadyReadBookActivity.class);
                startActivity(intent);
            }
        });

        btnFavourites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FavouriteBooks.class);
                startActivity(intent);
            }
        });

        btnWishList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, WantedBooks.class);
                startActivity(intent);
            }
        });

        btnCurrentlyReading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CurrentlyReadingActivity.class);
                startActivity(intent);
            }
        });

        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle(getString(R.string.app_name));
                builder.setMessage("Build by me. Check website:");
                builder.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                builder.setPositiveButton("Visit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(MainActivity.this, WebsiteActivity.class);
                        intent.putExtra(URL, "https://www.dr.dk");
                        startActivity(intent);
                    }
                });
                builder.create().show();
            }
        });





    }


    public String[] getPickerValues(int i){
        String[] values = new String[i];

        for (int j = 0; j < i; j++) {

            int num = j*5;
            values[j] = Integer.toString(num);
        }
        return values;
    }

    public void setupNumberPicker(NumberPicker numberPicker, String[] values){


        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(values.length-1);
        numberPicker.setWrapSelectorWheel(true);

        numberPicker.setDisplayedValues(values);
        numberPicker.setFormatter(new NumberPicker.Formatter() {
            @Override
            public String format(int i) {
                return String.format("%02d", 1);
            }
        });

        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {

            }
        });

    }

    private void initViews(){

        btnSeeAll = findViewById(R.id.btnSeeAll);
        btnCurrentlyReading = findViewById(R.id.btnCurrentlyReading);
        btnFinishedBooks = findViewById(R.id.btnFinishedBooks);
        btnWishList = findViewById(R.id.btnWishlist);
        btnFavourites = findViewById(R.id.btnFavourites);
        btnAbout = findViewById(R.id.btnAbout);
        numberPicker = findViewById(R.id.numberPicker);


    }
}
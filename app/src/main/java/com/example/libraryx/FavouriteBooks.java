package com.example.libraryx;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class FavouriteBooks extends AppCompatActivity {

    private RecyclerView recFavourite;
    private BookRecViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite_books);

        recFavourite = findViewById(R.id.recFavouriteBooks);
        adapter = new BookRecViewAdapter(this);
        recFavourite.setAdapter(adapter);
        recFavourite.setLayoutManager(new LinearLayoutManager(this));
        adapter.setBooks(Utils.getFavouriteList());

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        //stops the backstack tracking this activity.
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
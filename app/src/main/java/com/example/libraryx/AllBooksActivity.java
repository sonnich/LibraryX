package com.example.libraryx;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class AllBooksActivity extends AppCompatActivity {

    private static final String TAG = "AllBooksActivity";



    private RecyclerView allBooksRec;
    private BookRecViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_books);


        adapter = new BookRecViewAdapter(this);
        initView();
        //initData();

        allBooksRec.setAdapter(adapter);
        allBooksRec.setLayoutManager(new LinearLayoutManager(this));
        adapter.setBooks(Utils.getInstance().getAllBooksList());


    }

    private void initView(){
        allBooksRec = findViewById(R.id.allBooksRecView);

    }


}

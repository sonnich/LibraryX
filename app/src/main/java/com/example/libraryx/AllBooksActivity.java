package com.example.libraryx;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import java.util.ArrayList;

public class AllBooksActivity extends AppCompatActivity {

    private static final String TAG = "AllBooksActivity";

    private RecyclerView allBooksRec;
    private BookRecViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_books);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //using custom animation causes a bug with black screen.
        //overridePendingTransition(R.anim.slide_in, R.anim.slide_out);

        adapter = new BookRecViewAdapter(this, TAG);
        initView();
        allBooksRec.setAdapter(adapter);
        allBooksRec.setLayoutManager(new LinearLayoutManager(this));
        adapter.setBooks(Utils.getInstance().getAllBooksList());
    }

    private void initView(){
        allBooksRec = findViewById(R.id.allBooksRecView);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

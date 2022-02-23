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
        initData();
        allBooksRec.setAdapter(adapter);
        allBooksRec.setLayoutManager(new LinearLayoutManager(this));


    }

    private void initView(){
        allBooksRec = findViewById(R.id.allBooksRecView);

    }

    private void initData(){
        Book b1 = new Book(1, "1q84", "Murikami", 500, "book about 1 q and 84", "very long book", "https://imgcdn.saxo.com/_9780099578079"  );
        Book b2 = new Book(2, "The Hobbit", "Tolkien", 400, "Book about a hobbit", "book about a hobbit and some dwarves, a wizard, and a dragon."
        ,"https://cdn3.tales.dk/thumbnail/200x0/00019/42606/cover.1497233143.jpg");
        ArrayList<Book> books= new ArrayList<>();

        books.add(b1);
        books.add(b2);
        adapter.setBooks(books);

    }
}
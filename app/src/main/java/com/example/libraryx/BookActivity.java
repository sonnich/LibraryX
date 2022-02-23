package com.example.libraryx;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class BookActivity extends AppCompatActivity {
    private TextView txtTitle, txtAuthor, txtPages, txtShort, txtLong;
    private Button btnAddCurrent, btnAddWant, btnAddAlreadyRead, btnAddFavourite;
    private ImageView imgCover;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        initViews();


        //TODO fix dummy data
        Book b1 = new Book(1, "1q84", "Murikami", 500, "book about 1 q and 84", "very long book", "https://imgcdn.saxo.com/_9780099578079"  );

        setData(b1);




    }



    public void initViews(){
        txtTitle = findViewById(R.id.txtTitle);
        txtAuthor = findViewById(R.id.txtAuthorBookView);
        txtPages = findViewById(R.id.txtPages);
        txtShort = findViewById(R.id.txtShortDesBookView);
        txtLong = findViewById(R.id.txtLongDesBookView);

        btnAddCurrent = findViewById(R.id.btnMarkCurrent);
        btnAddWant = findViewById(R.id.btnMarkWant);
        btnAddAlreadyRead = findViewById(R.id.btnMarkAlRead);
        btnAddFavourite = findViewById(R.id.btnMarkFavourite);

        imgCover = findViewById(R.id.imgCover);

    }

    private void setData(Book b1){
        txtTitle.setText(b1.getName());
        txtAuthor.setText(b1.getAuthor());
        txtPages.setText(Integer.toString(b1.getPages()));
        txtShort.setText(b1.getShortDes());
        txtLong.setText(b1.getLongDes());

        Glide.with(this)
                .asBitmap().load(b1.getImageURL())
                .into(imgCover);


    }
}
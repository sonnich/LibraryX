package com.example.libraryx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {

    private static final String TAG = "BookActivity";
    private TextView txtTitle, txtAuthor, txtPages, txtShort, txtLong;
    private Button btnAddCurrent, btnAddWant, btnAddAlreadyRead, btnAddFavourite;
    private ImageView imgCover;
    private boolean haveRead =false;
    private boolean haveFavored =false;
    private boolean haveWanted =false;
    private boolean haveCurrented =false;

    private static final String BOOK = "book";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        Intent intent = getIntent();
        if(intent != null) {
            Book b1 = intent.getParcelableExtra(BOOK);

            initViews();
            setData(b1);
            checkAlreadyRead(b1);
            checkHaveFavored(b1);

        }




    }

    /**
     * handles adding book to list of favored books + button func
     * @param book
     */

    public void checkHaveFavored(Book book){


    }

    /**
     * handles adding book to list of already read books + button functionality
     * @param b
     */

    public void checkAlreadyRead(Book b){
        ArrayList<Book> alreadyList = Utils.getInstance().getAlreadyReadList();
        for (Book book:alreadyList) {
            if(book.getId()==b.getId()){
                haveRead=true;
            }
        }
        if(haveRead){
            btnAddAlreadyRead.setEnabled(false);
        } else {
            btnAddAlreadyRead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(Utils.getInstance().addToAlreadyRead(b)){
                        Toast.makeText(BookActivity.this, b.getName()+" Added to Already Read!", Toast.LENGTH_SHORT).show();

                        btnAddAlreadyRead.setEnabled(false);
                        Intent intent = new Intent(BookActivity.this, AlreadyReadBookActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(BookActivity.this, "Something went wrong!", Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }
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
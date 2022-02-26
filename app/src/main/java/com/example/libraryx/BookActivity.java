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
    private Book book;


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
            checkHaveWanted(b1);
            checkCurrentlyReading(b1);


        }




    }

    public void checkCurrentlyReading(Book book){
        for (Book b: Utils.getCurrentlyReadingList()) {
            if (b.getId() == book.getId()) {
                haveCurrented = true;
                break;
            }
        }
        if(haveCurrented){
            btnAddCurrent.setEnabled(false);
        } else {
            btnAddCurrent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(Utils.getInstance().addToCurrentlyReading(book)){
                        Intent intent = new Intent(BookActivity.this, CurrentlyReadingActivity.class);
                        btnAddCurrent.setEnabled(false);
                        startActivity(intent);
                    } else {
                        Toast.makeText(BookActivity.this, "Something went wrong!", Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }
    }

    /**
     * handles adding book to want to read list + button functionality
     * @param book <--book object to check
     */

    public void checkHaveWanted(final Book book){
        for (Book b: Utils.getWantToReadList()) {
            if (b.getId() == book.getId()) {
                haveWanted = true;
                break;
            }
        }
        if(haveWanted){
            btnAddWant.setEnabled(false);
        } else {
            btnAddWant.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(Utils.getInstance().addToWanted(book)){
                        Intent intent = new Intent(BookActivity.this, FavouriteBooks.class);
                        btnAddWant.setEnabled(false);
                        startActivity(intent);
                    } else {
                        Toast.makeText(BookActivity.this, "Something went wrong!", Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }
    }

    /**
     * handles adding book to list of favored books + button func
     * @param book <--book object to check
     */

    public void checkHaveFavored(final Book book){


        for (Book b:Utils.getFavouriteList()) {

            if (b.getId() == book.getId()) {
                haveFavored = true;
                break;
            }
        }
        if(haveFavored){
            btnAddFavourite.setEnabled(false);
        } else {
            btnAddFavourite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(Utils.getInstance().addToFavourites(book)){
                        Toast.makeText(BookActivity.this, book.getName()+ " added to favourites", Toast.LENGTH_SHORT).show();
                        btnAddFavourite.setEnabled(false);
                        Intent intent = new Intent(BookActivity.this, FavouriteBooks.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(BookActivity.this, "Something went wrong!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    /**
     * handles adding book to list of already read books + button functionality
     * @param b <--book object to check
     */

    public void checkAlreadyRead(final Book b){
        Utils.getInstance();
        ArrayList<Book> alreadyList = Utils.getAlreadyReadList();
        for (Book book:alreadyList) {
            if (book.getId() == b.getId()) {
                haveRead = true;
                break;
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
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


         String longTest = "A young woman named Aomame follows a taxi driver’s enigmatic suggestion" +
                " and begins to notice puzzling discrepancies in the world around her." +
                " She has entered, she realizes, a parallel existence, which she calls 1Q84 —“Q is for ‘question mark.’" +
                " A world that bears a question.” Meanwhile, an aspiring writer named Tengo takes on" +
                " a suspect ghostwriting project. He becomes so wrapped up with the work and its unusual author that, " +
                "soon, his previously placid life begins to come unraveled.\n\nAs Aomame’s and Tengo’s narratives converge" +
                 " over the course of this single year, we learn of the profound and tangled connections that bind them ever " +
                 "closer: a beautiful, dyslexic teenage girl with a unique vision; a mysterious religious cult that instigated" +
                 " a shoot-out with the metropolitan police; a reclusive, wealthy dowager who runs a shelter for abused women;" +
                 " a hideously ugly private investigator; a mild-mannered yet ruthlessly efficient bodyguard; and a peculiarly" +
                 " insistent television-fee collector.";


        //TODO fix dummy data
        Book b1 = new Book(1, "1q84", "Murikami", 500, "book about 1 q and 84", longTest, "https://imgcdn.saxo.com/_9780099578079"  );

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
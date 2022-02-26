package com.example.libraryx;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.TransitionManager;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookRecViewAdapter extends RecyclerView.Adapter<BookRecViewAdapter.ViewHolder>{

    private static final String TAG = "BookRecViewAdapter";
    private static final String BOOK = "book";
    private static final String WANT_ID = "WantedBooks";
    private static final String FAV_ID = "FavouriteBooks";
    private static final String CURRENT_ID = "CurrentlyReadingActivity";
    private static final String ALREADY_ID = "AlreadyReadBookActivity";
    private static final String MAIN_ID = "MainActivity";
    private static final String ALLBOOKS_ID = "AllBooksActivity";


    private ArrayList<Book> books = new ArrayList<>();
    private Context mContext;
    private String parentActivity;

    public BookRecViewAdapter(Context mContext, String parent) {
        this.mContext = mContext;
        parentActivity = parent;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Returns inner class with a View made from the item layout
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_book, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //method to control what should be done with each entry in the dataset;
        Log.d(TAG, "onBindViewHolder: called");
        holder.txtTitle.setText(books.get(position).getName());
        //loading image from url as bitmap into ImageView. Needs Glide
        Glide.with(mContext)
                .asBitmap()
                .load(books.get(position).getImageURL())
                .into(holder.imgCover);
        
        
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, BookActivity.class);

                intent.putExtra(BOOK, books.get(holder.getAdapterPosition()));
                mContext.startActivity(intent);

            }
        });

        holder.txtAuthorName.setText(books.get(holder.getAdapterPosition()).getAuthor());
        holder.txtShortDes.setText(books.get(holder.getAdapterPosition()).getShortDes());

        if(books.get(holder.getAdapterPosition()).isExpanded()){
            //adds animations with the parent layout as argument;
            TransitionManager.beginDelayedTransition(holder.parent);
            holder.relExpanded.setVisibility(View.VISIBLE);
            holder.btnDown.setVisibility(View.GONE);
            String parent = parentActivity;
            holder.btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Book book = books.get(holder.getAdapterPosition());
                    removeFromList(book, parent, holder);
                }
            });
        } else {
            //adds animations with the parent layout as argument;
            TransitionManager.beginDelayedTransition(holder.parent);
            holder.relExpanded.setVisibility(View.GONE);
            holder.btnDown.setVisibility(View.VISIBLE);
        }

        


    }

    public void removeFromList(Book book, String parent, ViewHolder holder){

        switch (parent){
            case CURRENT_ID:
                if(Utils.getInstance().removeFromCurrentlyReading(book)){
                    notifyItemRemoved(holder.getAdapterPosition());
                    Toast.makeText(mContext, book.getName()+" removed from currently reading.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(mContext, "Something went wrong =/", Toast.LENGTH_SHORT).show();
                }
                break;
            case ALREADY_ID:
                if(Utils.getInstance().removeFromAlreadyRead(book)){
                    notifyItemRemoved(holder.getAdapterPosition());
                    Toast.makeText(mContext, book.getName()+" removed from already read.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(mContext, "Something went wrong =/", Toast.LENGTH_SHORT).show();
                }
                break;
            case WANT_ID:
                if(Utils.getInstance().removeFromWantList(book)){
                    notifyItemRemoved(holder.getAdapterPosition());
                    Toast.makeText(mContext, book.getName()+" removed from wishlist.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(mContext, "Something went wrong =/", Toast.LENGTH_SHORT).show();
                }
                break;
            case FAV_ID:
                if(Utils.getInstance().removeFromFavourite(book)){
                    notifyItemRemoved(holder.getAdapterPosition());
                    Toast.makeText(mContext, book.getName()+" removed from favourites.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(mContext, "Something went wrong =/", Toast.LENGTH_SHORT).show();
                }
                break;
        }

    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CardView parent;
        private ImageView imgCover, btnUp, btnDown;
        private TextView txtTitle, txtAuthorName, txtShortDes, btnDelete;
        private RelativeLayout relExpanded;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parent = itemView.findViewById(R.id.list_item_parent);
            imgCover = itemView.findViewById(R.id.img_listItem);
            txtTitle = itemView.findViewById(R.id.txt_itemTitle);
            btnUp = itemView.findViewById(R.id.btnUpArrow);
            btnDown = itemView.findViewById(R.id.btnDownArrow);
            txtAuthorName = itemView.findViewById(R.id.txtAuthorName);
            txtShortDes = itemView.findViewById(R.id.txtShortDes);
            relExpanded = itemView.findViewById(R.id.relExpanded);
            btnDelete = itemView.findViewById(R.id.btnDelete);

            btnDown.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //onclick inverts the value of isExpanded;
                    Book book = books.get(getAdapterPosition());
                    book.setExpanded(!book.isExpanded());
                    notifyItemChanged(getAdapterPosition());

                }
            });

            btnUp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //onclick inverts the value of isExpanded;
                    Book book = books.get(getAdapterPosition());
                    book.setExpanded(!book.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });

        }
    }


}

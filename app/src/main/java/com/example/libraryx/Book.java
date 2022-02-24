package com.example.libraryx;

import android.os.Parcel;
import android.os.Parcelable;

public class Book implements Parcelable {

    private int id;
    private String name;
    private String author;
    private int pages;
    private String shortDes;
    private String longDes;
    private String imageURL;
    private boolean isExpanded;

    public Book(int id, String name, String author, int pages, String shortDes, String longDes, String imageURL) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.pages = pages;
        this.shortDes = shortDes;
        this.longDes = longDes;
        this.imageURL = imageURL;
        this.isExpanded = false;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel p, int i) {
        p.writeInt(id);
        p.writeString(name);
        p.writeString(author);
        p.writeInt(pages);
        p.writeString(shortDes);
        p.writeString(longDes);
        p.writeString(imageURL);

    }

    protected Book (Parcel in){
        id = in.readInt();
        name = in.readString();
        author = in.readString();
        pages = in.readInt();
        shortDes = in.readString();
        longDes = in.readString();
        imageURL = in.readString();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel parcel) {
            return new Book(parcel);
        }

        @Override
        public Book[] newArray(int i) {
            return new Book[i];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getShortDes() {
        return shortDes;
    }

    public void setShortDes(String shortDes) {
        this.shortDes = shortDes;
    }

    public String getLongDes() {
        return longDes;
    }

    public void setLongDes(String longDes) {
        this.longDes = longDes;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public boolean isExpanded() {
        return isExpanded;
    }

    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
    }

    public void expand(){
        if(this.isExpanded){
            this.isExpanded = false;
        }else{
            isExpanded = true;
        }
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", pages=" + pages +
                ", shortDes='" + shortDes + '\'' +
                ", longDes='" + longDes + '\'' +
                '}';
    }
}

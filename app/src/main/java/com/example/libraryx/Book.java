package com.example.libraryx;

public class Book {

    private int id;
    private String name;
    private String author;
    private int pages;
    private String shortDes;
    private String longDes;
    private String imageURL;

    public Book(int id, String name, String author, int pages, String shortDes, String longDes, String imageURL) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.pages = pages;
        this.shortDes = shortDes;
        this.longDes = longDes;
        this.imageURL = imageURL;
    }

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

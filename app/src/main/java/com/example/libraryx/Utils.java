package com.example.libraryx;

import java.util.ArrayList;

public class Utils {

    private static Utils instance;
    private static ArrayList<Book> allBooksList;
    private static ArrayList<Book> alreadyReadList;
    private static ArrayList<Book> wantToReadList;
    private static ArrayList<Book> currentlyReadingList;
    private static ArrayList<Book> favouriteList;


    private Utils() {
        if(allBooksList==null){
            allBooksList = new ArrayList<>();
            initData();
        }
        if(alreadyReadList == null){
            alreadyReadList = new ArrayList<>();
        }
        if(wantToReadList==null){
            wantToReadList= new ArrayList<>();
        }
        if(currentlyReadingList==null){
            currentlyReadingList= new ArrayList<>();
        }
        if(favouriteList==null){
            favouriteList=new ArrayList<>();
        }

    }

    public static Utils getInstance() {

        if (instance != null) {
            return instance;
        } else {
            instance = new Utils();
            return instance;
        }

    }


    private void initData(){
        //TODO populate starting data;
        Book b1 = new Book(1, "1q84", "Murikami", 500, "book about 1 q and 84", "very long book", "https://imgcdn.saxo.com/_9780099578079"  );
        Book b2 = new Book(2, "The Hobbit", "Tolkien", 400, "Book about a hobbit", "book about a hobbit and some dwarves, a wizard, and a dragon."
                ,"https://cdn3.tales.dk/thumbnail/200x0/00019/42606/cover.1497233143.jpg");
        allBooksList.add(b1);
        allBooksList.add(b2);
    }

    public static ArrayList<Book> getAllBooksList() {
        return allBooksList;
    }

    public static ArrayList<Book> getAlreadyReadList() {
        return alreadyReadList;
    }

    public static ArrayList<Book> getWantToReadList() {
        return wantToReadList;
    }

    public static ArrayList<Book> getCurrentlyReadingList() {
        return currentlyReadingList;
    }

    public static ArrayList<Book> getFavouriteList() {
        return favouriteList;
    }
}

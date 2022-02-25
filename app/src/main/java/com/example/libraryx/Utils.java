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
        //TODO populate starting data;
        Book b1 = new Book(1, "1q84", "Murikami", 500, "book about 1 q and 84", longTest, "https://imgcdn.saxo.com/_9780099578079"  );
        Book b2 = new Book(2, "The Hobbit", "Tolkien", 400, "Book about a hobbit", "book about a hobbit and some dwarves, a wizard, and a dragon."
                ,"https://cdn3.tales.dk/thumbnail/200x0/00019/42606/cover.1497233143.jpg");
        allBooksList.add(b1);
        allBooksList.add(b2);
    }

    public boolean addToAlreadyRead(Book b){
        return alreadyReadList.add(b);

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

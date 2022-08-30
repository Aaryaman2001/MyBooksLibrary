package com.example.mybooklibrary;

import java.util.ArrayList;

public class Utils {
    private static Utils instance;
    private static ArrayList<Book> allBooks;
    private static ArrayList<Book> currentlyReadingBooks;
    private static ArrayList<Book> favouriteBooks;
    private static ArrayList<Book> wantToReadBooks;

    public static void setAllBooks(ArrayList<Book> allBooks) {
        Utils.allBooks = allBooks;
    }

    public static ArrayList<Book> getCurrentlyReadingBooks() {
        return currentlyReadingBooks;
    }

    public static void setCurrentlyReadingBooks(ArrayList<Book> currentlyReadingBooks) {
        Utils.currentlyReadingBooks = currentlyReadingBooks;
    }

    public static ArrayList<Book> getFavouriteBooks() {
        return favouriteBooks;
    }

    public static void setFavouriteBooks(ArrayList<Book> favouriteBooks) {
        Utils.favouriteBooks = favouriteBooks;
    }

    public static ArrayList<Book> getWantToReadBooks() {
        return wantToReadBooks;
    }

    public static void setWantToReadBooks(ArrayList<Book> wantToReadBooks) {
        Utils.wantToReadBooks = wantToReadBooks;
    }

    public static ArrayList<Book> getAlreadyReadBooks() {
        return alreadyReadBooks;
    }

    public static void setAlreadyReadBooks(ArrayList<Book> alreadyReadBooks) {
        Utils.alreadyReadBooks = alreadyReadBooks;
    }

    private static ArrayList<Book> alreadyReadBooks;
    private Utils(){
        if(null==allBooks){
            allBooks = new ArrayList<>();
            addData();
        }
        if(null==currentlyReadingBooks){
            currentlyReadingBooks = new ArrayList<>();

        }
        if(null==favouriteBooks){
            favouriteBooks = new ArrayList<>();

        }
        if(null==wantToReadBooks){
            wantToReadBooks = new ArrayList<>();

        }
        if(null==alreadyReadBooks){
            alreadyReadBooks = new ArrayList<>();

        }


    }

    private void addData() {
        allBooks.add(new Book(1,492, "Crime and Punishment", "Fyodor Dostoyevsky", "https://kbimages1-a.akamaihd.net/c8f66724-16c7-4e30-ab42-2e205435eb20/1200/1200/False/crime-and-punishment-by-fyodor-dostoyevsky.jpg",
                "A book of wicket morals.", "Supreme masterpiece recounts in feverish, compelling tones the story of Raskolnikov, an impoverished student tormented by his own thoughts after he brutally murders an old woman." ));
        allBooks.add(new Book(2,840, "Brothers Kamarazov", "Fyodor", "https://images-na.ssl-images-amazon.com/images/I/71OZJsgZzQL.jpg",
                "An enticing murder mystery", "The Brothers Karamazov is a murder mystery, a courtroom drama, and an exploration of erotic rivalry in a series of triangular love affairs involving the “wicked and sentimental” Fyodor Pavlovich Karamazov and his three sons―the impulsive and sensual Dmitri; the coldly rational Ivan; and the healthy, red-cheeked young novice Alyosha" ));
        allBooks.add(new Book(3,384, "Mein Kampf", "Adolph Hitler", "https://cdn.britannica.com/16/187816-050-74B41B7B/Cover-edition-Adolf-Hitler-Mein-Kampf-1943.jpg",
                "A book of wicket morals.", "Madman, tyrant, animal—history has given Adolf Hitler many names. In Mein Kampf (My Struggle), often called the Nazi bible, Hitler describes his life, frustrations, ideals, and dreams. Born to an impoverished couple in a small town in Austria, the young Adolf grew up with the fervent desire to become a painter." ));

        allBooks.add(new Book(1,499, "Crime and Nourishment", "Fyodor Dostoyevsky", "https://kbimages1-a.akamaihd.net/c8f66724-16c7-4e30-ab42-2e205435eb20/1200/1200/False/crime-and-punishment-by-fyodor-dostoyevsky.jpg",
                "A book of wicket jokers.", "Supreme masterpiece recounts in feverish, compelling tones the story of Raskolnikov, an impoverished student tormented by his own thoughts after he brutally murders an old woman." ));
        allBooks.add(new Book(2,56, "Sisters Kamarazov", "Fyodor", "https://images-na.ssl-images-amazon.com/images/I/71OZJsgZzQL.jpg",
                "An enticing murder sistery", "The Brothers Karamazov is a murder mystery, a courtroom drama, and an exploration of erotic rivalry in a series of triangular love affairs involving the “wicked and sentimental” Fyodor Pavlovich Karamazov and his three sons―the impulsive and sensual Dmitri; the coldly rational Ivan; and the healthy, red-cheeked young novice Alyosha" ));
        allBooks.add(new Book(3,768, "Mein Kampf", "Adolph Hitler", "https://cdn.britannica.com/16/187816-050-74B41B7B/Cover-edition-Adolf-Hitler-Mein-Kampf-1943.jpg",
                "A book of wicket morals.", "Madman, tyrant, animal—history has given Adolf Hitler many names. In Mein Kampf (My Struggle), often called the Nazi bible, Hitler describes his life, frustrations, ideals, and dreams. Born to an impoverished couple in a small town in Austria, the young Adolf grew up with the fervent desire to become a painter." ));

            allBooks.add(new Book(1,56, "Crime and Whorishment", "Fyodor Dostoyevsky", "https://kbimages1-a.akamaihd.net/c8f66724-16c7-4e30-ab42-2e205435eb20/1200/1200/False/crime-and-punishment-by-fyodor-dostoyevsky.jpg",
                "A book of wicket morals.", "Supreme masterpiece recounts in feverish, compelling tones the story of Raskolnikov, an impoverished student tormented by his own thoughts after he brutally murders an old woman." ));
        allBooks.add(new Book(2,6789, "Fyodor Dostoyevsky", "Fyodor", "https://images-na.ssl-images-amazon.com/images/I/71OZJsgZzQL.jpg",
                "An enticing murder mystery", "The Brothers Karamazov is a murder mystery, a courtroom drama, and an exploration of erotic rivalry in a series of triangular love affairs involving the “wicked and sentimental” Fyodor Pavlovich Karamazov and his three sons―the impulsive and sensual Dmitri; the coldly rational Ivan; and the healthy, red-cheeked young novice Alyosha" ));
        allBooks.add(new Book(3,768, "Mein Kampf", "Adolph Hitler", "https://cdn.britannica.com/16/187816-050-74B41B7B/Cover-edition-Adolf-Hitler-Mein-Kampf-1943.jpg",
                "A book of wicket morals.", "Madman, tyrant, animal—history has given Adolf Hitler many names. In Mein Kampf (My Struggle), often called the Nazi bible, Hitler describes his life, frustrations, ideals, and dreams. Born to an impoverished couple in a small town in Austria, the young Adolf grew up with the fervent desire to become a painter." ));

        allBooks.add(new Book(1,67, "Crime and Punishment", "Fyodor Dostoyevsky", "https://kbimages1-a.akamaihd.net/c8f66724-16c7-4e30-ab42-2e205435eb20/1200/1200/False/crime-and-punishment-by-fyodor-dostoyevsky.jpg",
                "A book of wicket morals.", "Supreme masterpiece recounts in feverish, compelling tones the story of Raskolnikov, an impoverished student tormented by his own thoughts after he brutally murders an old woman." ));
        allBooks.add(new Book(2,678, "Beyond Good and Evil", "Bietchjbfowbeg", "https://images-na.ssl-images-amazon.com/images/I/71OZJsgZzQL.jpg",
                "This book was honestly very hard to read.", "The Brothers Karamazov is a murder mystery, a courtroom drama, and an exploration of erotic rivalry in a series of triangular love affairs involving the “wicked and sentimental” Fyodor Pavlovich Karamazov and his three sons―the impulsive and sensual Dmitri; the coldly rational Ivan; and the healthy, red-cheeked young novice Alyosha" ));
        allBooks.add(new Book(3,235, "Mein Kampf", "Adolph Hitler", "https://cdn.britannica.com/16/187816-050-74B41B7B/Cover-edition-Adolf-Hitler-Mein-Kampf-1943.jpg",
                "A book of wickets.", "Madman, tyrant, animal—history has given Adolf Hitler many names. In Mein Kampf (My Struggle), often called the Nazi bible, Hitler describes his life, frustrations, ideals, and dreams. Born to an impoverished couple in a small town in Austria, the young Adolf grew up with the fervent desire to become a painter." ));
    }
    public static ArrayList<Book> getAllBooks(){
        return allBooks;
    }

    public static Utils getInstance(){
        if (null == instance) {
            instance = new Utils();
        }
        return instance;
    }
    public Book getBookByID(int id){
        for(Book b: allBooks){
            if(b.getId() == id){
                return b;}
            }
             return null;
        }

    public static boolean addToAlreadyRead(Book b){
       return alreadyReadBooks.add(b);
    }
    public static boolean addToCurrent(Book b){
        return currentlyReadingBooks.add(b);
    }
    public static boolean addToWishList(Book b){return wantToReadBooks.add(b);
    }
    public static boolean addToFavourite(Book b){return favouriteBooks.add(b);
    }

    public static boolean removeAlreadyReadBooks(Book b){
        return alreadyReadBooks.remove(b);
    }
    public static boolean removeCurrentlyReadingBooks(Book b){
        return currentlyReadingBooks.remove(b);
    }
    public static boolean removeFavouriteBooks(Book b){
        return favouriteBooks.remove(b);
    }
    public static boolean removeWishlist(Book b){
        return wantToReadBooks.remove(b);
    }

    }



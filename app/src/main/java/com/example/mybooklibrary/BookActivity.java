package com.example.mybooklibrary;

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
    private TextView setAuthor, setPages, setDesc, setName;
    private ImageView setImage;
    private Button addToFav, addToWish, addToCurrent, addToRead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        setAuthor = findViewById(R.id.setAuthor);
        setPages = findViewById(R.id.setPages);
        setDesc = findViewById(R.id.setLongDesc);
        setName = findViewById(R.id.setBookName);
        setImage = findViewById(R.id.setImage);
        addToFav = findViewById(R.id.btnAddToFavourite);
        addToCurrent = findViewById(R.id.btnAddToCurrentlyReading);
        addToRead = findViewById(R.id.btnAddToAlreadyRead);
        addToWish = findViewById(R.id.btnAddToWantToRead);
//        Book book = new Book(1,180, "Crime and Punishment", "Fyodor", "https://kbimages1-a.akamaihd.net/c8f66724-16c7-4e30-ab42-2e205435eb20/1200/1200/False/crime-and-punishment-by-fyodor-dostoyevsky.jpg",
//                "A book of wicket morals.", "Long I removed the player.prepare() line from my answer as I double checked the documentation and \n you were correct. I'm not sure why its crashing the emulator, maybe it doesn't have any sound files to play? Can you provide the logcat output of \n the error/crash? I don't believe there are any other default system sounds other than the 3 provided."+
//                "Long I removed the player.prepare() line from my answer as I double checked the documentation and \n you were correct. I'm not sure why its crashing the emulator, maybe it doesn't have any sound files to play? Can you provide the logcat output of \n the error/crash? I don't believe there are any other default system sounds other than the 3 provided."+
//        "Long I removed the player.prepare() line from my answer as I double checked the documentation and \n you were correct. I'm not sure why its crashing the emulator, maybe it doesn't have any sound files to play? Can you provide the logcat output of \n the error/crash? I don't believe there are any other default system sounds other than the 3 provided.");
//        addData(book);
        Intent intent = getIntent();

        if (null != intent) {
            int bookid = intent.getIntExtra("BookId", -1);
            if (bookid != -1) {
                Book incoming = Utils.getInstance().getBookByID(bookid);
                if (incoming != null) {
                    addData(incoming);
                    handleAlreadyRead(incoming);
                    handleCurrentBooks(incoming);
                    handleFavouriteBooks(incoming);
                    handleWishlist(incoming);
                }
            }

        }
    }

    private void handleWishlist(Book incoming) {
        ArrayList<Book> wishlist = Utils.getInstance().getWantToReadBooks();
        boolean exists = false;
        for (Book b : wishlist) {
            if (b.getId() == incoming.getId()) {
                exists = true;
            }
        }
        if (exists) {
            addToWish.setEnabled(false);
        }else{
            addToWish.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(Utils.addToWishList(incoming)) {
                        Toast.makeText(BookActivity.this, "Book has been added.", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(BookActivity.this, WishListActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(BookActivity.this, "Something went wrong.", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void handleFavouriteBooks(Book incoming) {
        ArrayList<Book> favouriteBooks = Utils.getInstance().getFavouriteBooks();
        boolean exists = false;
        for (Book b : favouriteBooks) {
            if (b.getId() == incoming.getId()) {
                exists = true;
            }
        }
        if (exists) {
            addToFav.setEnabled(false);
        }else{
            addToFav.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(Utils.addToFavourite(incoming)) {
                        Toast.makeText(BookActivity.this, "Book has been added.", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(BookActivity.this, FavouriteActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(BookActivity.this, "Something went wrong.", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }


    private void handleAlreadyRead(Book incoming) {
        ArrayList<Book> alreadyRead = Utils.getInstance().getAlreadyReadBooks();
        boolean exists = false;
        for (Book b : alreadyRead) {
            if (b.getId() == incoming.getId()) {
                exists = true;
            }
        }
        if (exists) {
            addToRead.setEnabled(false);
        }else{
            addToRead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(Utils.addToAlreadyRead(incoming)) {
                        Toast.makeText(BookActivity.this, "Book has been added.", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(BookActivity.this, AlreadyReadBookActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(BookActivity.this, "Something went wrong.", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }


    private void handleCurrentBooks(Book incoming) {
        ArrayList<Book> currentlyReadingBooks = Utils.getInstance().getCurrentlyReadingBooks();
        boolean exists = false;
        for (Book b : currentlyReadingBooks) {
            if (b.getId() == incoming.getId()) {
                exists = true;
            }
        }
        if (exists) {
            addToCurrent.setEnabled(false);
        }else{
            addToCurrent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(Utils.addToCurrent(incoming)) {
                        Toast.makeText(BookActivity.this, "Book has been added.", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(BookActivity.this, CurrentlyReadingActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(BookActivity.this, "Something went wrong.", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }




    public void addData(Book book){
        setAuthor.setText(book.getAuthor());
        setName.setText(book.getName());
        setPages.setText(String.valueOf(book.getPages()));
        setDesc.setText(book.getLongDesc());
        Glide.with(this).asBitmap().load(book.getImageUrl()).into(setImage);
    }
}
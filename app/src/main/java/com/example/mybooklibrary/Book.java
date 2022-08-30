package com.example.mybooklibrary;

import androidx.annotation.NonNull;

public class Book {
    private int id, pages;
    private String name, author, imageUrl, shortDesk, longDesc;
    private boolean isExpanded;


    public Book(int id, int pages, String name, String author, String imageUrl, String shortDesk, String lomgDesc) {
        this.id = id;
        this.pages = pages;
        this.name = name;
        this.author = author;
        this.imageUrl = imageUrl;
        this.shortDesk = shortDesk;
        this.longDesc = lomgDesc;
        isExpanded = false;

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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getShortDesk() {
        return shortDesk;
    }

    public void setShortDesk(String shortDesk) {
        this.shortDesk = shortDesk;
    }

    public String getLongDesc() {
        return longDesc;
    }

    public void setLongDesc(String longDesc) {
        this.longDesc = longDesc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }


    public boolean isExpanded() {
        return isExpanded;
    }

    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
    }
}

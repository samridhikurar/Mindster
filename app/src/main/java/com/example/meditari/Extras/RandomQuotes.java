package com.example.meditari.Extras;

public class RandomQuotes {

    String quote, author;

    public RandomQuotes(String quote, String author){
        this.quote=quote;
        this.author=author;
    }

    public String getQuote() {
        return quote;
    }

    public String getAuthor() {
        return author;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

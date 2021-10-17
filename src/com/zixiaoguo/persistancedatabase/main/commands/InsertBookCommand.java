package com.zixiaoguo.persistancedatabase.main.commands;

import com.zixiaoguo.persistancedatabase.main.Book;

import java.util.ArrayList;
import java.util.Objects;

public class InsertBookCommand implements Command{

    private ArrayList<Book> books;
    private Book book;

    public InsertBookCommand(ArrayList<Book> books, Book book) {
        this.books = books;
        this.book = book;
    }


    //TODO: call helper to save command after execution
    @Override
    public ArrayList<Book> execute() {

        boolean found = false;
        for (Book bookIterator : books) {
            if (Objects.equals(bookIterator.getId(), book.getId())) {
                found = true;
                bookIterator.incrementQuantity();
                break;
            }
        }
        if (!found) {
            books.add(book);
            found = true;
        }

        return this.books;
    }
}

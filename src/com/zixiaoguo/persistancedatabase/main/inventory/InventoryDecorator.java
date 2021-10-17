package com.zixiaoguo.persistancedatabase.main.inventory;

import com.zixiaoguo.persistancedatabase.main.Book;
import com.zixiaoguo.persistancedatabase.main.commands.Command;
import com.zixiaoguo.persistancedatabase.main.commands.InsertBookCommand;

import java.util.ArrayList;

public class InventoryDecorator implements Inventory{

    private Inventory inventory;

    public InventoryDecorator(Inventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public ArrayList<Book> getBooks() {
        return inventory.getBooks();
    }

    @Override
    public void setBooks(ArrayList<Book> books) {
        inventory.setBooks(books);
    }

    @Override
    public boolean add(Book book) {
        //Maybe Command cmd = new InsertBookCommand(inventory.getBooks())
        //then inventory.setBooks(cmd.execute(inventory.getBooks)
        Command cmd = new InsertBookCommand(inventory.getBooks(), book);
        inventory.setBooks(cmd.execute());
        return true;
    }

    @Override
    public boolean sellBook(Book book) {
        return inventory.sellBook(book);
    }

    @Override
    public void changePrice(Book book, int newPrice) {
        inventory.changePrice(book, newPrice);
    }

    @Override
    public int getPrice(int id) {
        return inventory.getPrice(id);
    }

    @Override
    public int getPrice(String name) {
        return inventory.getPrice(name);
    }
}

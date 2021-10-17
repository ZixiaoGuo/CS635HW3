package com.zixiaoguo.persistancedatabase.main.invokers;

import com.zixiaoguo.persistancedatabase.main.Book;
import com.zixiaoguo.persistancedatabase.main.commands.Command;

import java.util.ArrayList;

public class InvokerDecorator implements Invoker {
    ArrayList<Book> books;

    public InvokerDecorator(ArrayList books) {
        this.books = books;
    }

    public ArrayList<Book> invoke(Command command) {
        return command.execute();
    }   //need to execute command inside this method
}

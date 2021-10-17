package com.zixiaoguo.persistancedatabase.main.commands;

import com.zixiaoguo.persistancedatabase.main.Book;

import java.io.Serializable;
import java.util.ArrayList;

public interface Command extends Serializable {

    public ArrayList<Book> execute();

}

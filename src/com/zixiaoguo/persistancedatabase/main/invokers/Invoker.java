package com.zixiaoguo.persistancedatabase.main.invokers;

import com.zixiaoguo.persistancedatabase.main.Book;
import com.zixiaoguo.persistancedatabase.main.commands.Command;

import java.util.ArrayList;

public interface Invoker {
    ArrayList<Book> invoke(Command command);
}

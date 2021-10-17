package com.zixiaoguo.persistancedatabase.main;

import com.zixiaoguo.persistancedatabase.main.commands.Command;

import java.io.*;
import java.util.ArrayList;

public class DataSaveHelper {
    //TODO: add originator caretaker objects
    private static int commandCounter = 0;

    public static void saveCommand(Command command) {
        try {
            FileOutputStream f = new FileOutputStream(new File("myObjects.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);

            // Write objects to file

            o.writeObject(command);

            o.close();
            f.close();


        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
            e.printStackTrace();
        }
    }

    public static void saveMemento(BaseInventory inventory) {
        ArrayList<Book> books = inventory.getBooks();
        try {
            FileOutputStream f = new FileOutputStream(new File("myObjects.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);

            // Write objects to file
            o.writeObject(books);

            o.close();
            f.close();


        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
            e.printStackTrace();
        }
    }


}

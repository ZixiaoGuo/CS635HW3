package com.zixiaoguo.persistancedatabase.main;

import java.io.*;

public class DatabaseApplication {

    public static void main(String[] args) {
        Book book1 = new Book("firstBook", 10, IDGenerator.nextValue(), 1);
        Book book2 = new Book("SecondBook", 20, IDGenerator.nextValue(), 1);
        BaseInventory inventory = new BaseInventory();

        Caretaker caretaker = new Caretaker();
        Originator originator = new Originator();

        inventory.add(book1);
        inventory.add(book1);
        originator.setState(inventory.getBooks());
        caretaker.add(originator.createMemento());
        inventory.add(book2);
        //inventory.setBooks(originator.restoreState(caretaker.get()));
        System.out.println(inventory);


        try {
            FileOutputStream f = new FileOutputStream(new File("myObjects.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);

            // Write objects to file
            o.writeObject(caretaker.getMomento());

            o.close();
            f.close();

            FileInputStream fi = new FileInputStream(new File("myObjects.txt"));
            ObjectInputStream oi = new ObjectInputStream(fi);

            // Read objects
            Memento memento1 = (Memento) oi.readObject();


            System.out.println(memento1.toString());

            oi.close();
            fi.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }




    }
}

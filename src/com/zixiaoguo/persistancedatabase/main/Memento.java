package com.zixiaoguo.persistancedatabase.main;

import java.io.Serializable;
import java.util.ArrayList;

public class Memento implements Serializable {
    private ArrayList<Book> state;

    public Memento(ArrayList<Book> state) {
        this.state = new ArrayList<>(state);
    }

    public ArrayList<Book> getState() {
        return state;
    }

    @Override
    public String toString() {
        return "com.zixiaoguo.persistancedatabase.main.Memento{" +
                "state=" + state +
                '}';
    }
}

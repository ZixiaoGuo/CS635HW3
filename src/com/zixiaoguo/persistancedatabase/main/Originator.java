package com.zixiaoguo.persistancedatabase.main;

import java.util.ArrayList;

public class Originator {
    private ArrayList<Book> state = new ArrayList<>();

    public Memento createMemento(){
        System.out.println("memento saved");
        return new Memento(state);
    }

    public void setState(ArrayList<Book> state) {
        this.state = state;
    }

    public ArrayList<Book> restoreState(Memento oldState){
        state = oldState.getState();
        System.out.println("restoring previous state: " + oldState);
        return state;
    }

}

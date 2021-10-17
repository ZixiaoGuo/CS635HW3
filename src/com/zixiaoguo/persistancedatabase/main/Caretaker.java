package com.zixiaoguo.persistancedatabase.main;

public class Caretaker {
    /*
    private ArrayList<com.zixiaoguo.persistancedatabase.main.Memento>  savedStates = new ArrayList<>();


    public void add(com.zixiaoguo.persistancedatabase.main.Memento state) {
        savedStates.add(state);
    }

    public com.zixiaoguo.persistancedatabase.main.Memento get(int index) {
        return savedStates.get(index);
    }

     */
    private Memento savedStates;


    public void add(Memento state) {
        savedStates = state;
    }

    public Memento getMomento() {
        return savedStates;
    }
}

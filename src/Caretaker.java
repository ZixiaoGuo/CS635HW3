import java.util.ArrayList;

public class Caretaker {
    private Memento savedState = new Memento();


    public void add(Memento state) {
        savedState = state;
    }

    public Memento get() {
        return savedState;
    }
}

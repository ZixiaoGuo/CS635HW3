import java.util.ArrayList;

public class Originator {
    private ArrayList<Book> state;

    public void setState(ArrayList<Book> state) {
        this.state = new ArrayList<>(state);
    }

    public ArrayList<Book> getState(){
        return state;
    }



    public Memento createMemento(){
        Memento memento = new Memento();
        memento.setState(state);
        return memento;
    }

    public void restoreState(ArrayList<Book> oldState){
        state = oldState;
    }

}

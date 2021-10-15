import java.io.Serializable;
import java.util.ArrayList;

public class Memento implements Serializable {
    private ArrayList<Book> state;



    protected void setState(ArrayList<Book> books) {
        //TODO: this might be shallow copy
        this.state = new ArrayList<>(books);    //create a copy of the state of the old inventory
    }

    public ArrayList<Book> getState() {
        return state;
    }

    @Override
    public String toString() {
        return "Memento{" +
                "state=" + state +
                '}';
    }
}

import java.io.*;

public class DatabaseApplication {

    public static void main(String[] args) {
        Book book1 = new Book("firstBook", 10, IDGenerator.nextValue(), 1);
        Book book2 = new Book("SecondBook", 20, IDGenerator.nextValue(), 1);

        Inventory inventory = new Inventory();
        Originator originator = new Originator();
        Caretaker careTaker = new Caretaker();
        inventory.insertBook(book1);
        //originator.setState(inventory.getBooks());
        inventory.save(originator);
        Memento memento = new Memento();
        memento.setState(inventory.getBooks());
        inventory.insertBook(book2);
        //inventory.setBooks(originator.getState());
        inventory.undo(originator);
        System.out.println(inventory);
        //TODO: make careTaker save

        try {
            FileOutputStream f = new FileOutputStream(new File("myObjects.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);

            // Write objects to file
            o.writeObject(memento);

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
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

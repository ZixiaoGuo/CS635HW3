import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Collectors;

public class Inventory {

    private ArrayList<Book> books;

    public Inventory() {
        books = new ArrayList<>();
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    // used for memento to restore state
    protected void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public boolean insertBook(Book book) {
        books.add(book);
        return true;
    }

    public boolean incrementBookCopy(Book book) {
        boolean found = false;
        for (Book bookIterator : books) {
            if (Objects.equals(bookIterator.getId(), book.getId())) {
                found = true;
                bookIterator.incrementQuantity();
                break;
            }
        }
        if (!found) {
            books.add(book);
            found = true;
        }

        return found;
    }

    public boolean sellBook (Book book) {
        boolean found = false;
        for (Book bookIterator : books) {
            if (Objects.equals(bookIterator.getId(), book.getId())) {
                found = true;
                bookIterator.decrementQuantity();
                break;
            }
        }
        return found;
    }

    public void changePrice (Book book, int newPrice) {
        for (Book bookIterator : books) {
            if (Objects.equals(bookIterator.getId(), book.getId())) {
                bookIterator.setPrice(newPrice);
                break;
            }
        }
    }

    public int getPrice(Long id) {
        for (Book bookIterator : books) {
            if (Objects.equals(bookIterator.getId(), id)) {
                return bookIterator.getPrice();
            }
        }
        throw new NoSuchElementException(); //if not found, throw exception
    }

    public int getPrice(String name) {
        for (Book bookIterator : books) {
            if (Objects.equals(bookIterator.getName(), name)) {
                return bookIterator.getPrice();
            }
        }
        throw new NoSuchElementException(); //if not found, throw exception
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "books=" + books +
                '}';
    }

    public void undo(Originator originator) {
        books = originator.getState();
    }

    public void save(Originator originator) {
        originator.setState(books);
    }
}

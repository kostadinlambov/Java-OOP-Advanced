package p04_Book_Comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Book bookOne = new Book("Animal Farm", 2003, "George Orwell");
        Book bookThree = new Book("The Documents in the Case", 2002);
        Book bookTwo = new Book("The Documents in the Case", 1930, "Dorothy" +
                " Sayers", "Robert Eustace");
        Book bookFour = new Book("Test Book", 1930, "Dorothy" +
                " Sayers");

        List<Book> books = new ArrayList<>();
        books.add(bookOne);
        books.add(bookTwo);
        books.add(bookThree);
        books.add(bookFour);

        books.sort(new BookComparator());
        books.sort(new BookComparator().reversed());
        books.sort(Comparator.naturalOrder());
        books.sort(Comparator.reverseOrder());

        for (Book book : books) {
            System.out.println(book.getTitle() + " " +  book.getYear());
        }
    }
}

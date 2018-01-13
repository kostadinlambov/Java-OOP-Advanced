package p03_Comparable_Book;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Book bookOne = new Book("Animal Farm", 2003, "George Orwell");

        Book bookTwo = new Book("The Documents in the Case", 1930, "Dorothy" +
                " Sayers", "Robert Eustace");
        Book bookThree = new Book("The Documents in the Case", 2002);

        if (bookOne.compareTo(bookTwo) > 0) {
            System.out.println(String.format("%s is before %s", bookOne.getTitle(), bookTwo.getTitle()));
        } else if (bookOne.compareTo(bookTwo) < 0) {
            System.out.println(String.format("%s is before %s", bookTwo.getTitle(), bookOne.getTitle()));
        } else {
            System.out.println("Book are equal");
        }
    }
}

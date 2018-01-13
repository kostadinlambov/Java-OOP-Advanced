package p09_Linked_List_Traversal;

public interface MyLinkedList<T> {

    void addLast(T element);

    boolean removeFirstOccurrenceOfItem(T element);

    int getSize();
}

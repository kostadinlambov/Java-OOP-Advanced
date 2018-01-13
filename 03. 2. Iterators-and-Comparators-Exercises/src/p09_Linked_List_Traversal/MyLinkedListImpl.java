package p09_Linked_List_Traversal;

import java.util.Iterator;

public class MyLinkedListImpl<T> implements MyLinkedList<T>, Iterable<T> {

    private ListNode<T> head;
    private ListNode<T> tail;
    private int size;

    public MyLinkedListImpl() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public void addLast(T element) {
        ListNode<T> newNode = new ListNode<T>(null, this.tail, element);
        if (this.size == 0) {
            this.tail = this.head = newNode;
        } else {
            this.tail.setNextNode(newNode);
            this.tail = newNode;

        }

        this.size++;
    }

    @Override
    public boolean removeFirstOccurrenceOfItem(T element) {

        ListNode<T> newNode = this.head;

        while (newNode != null) {

            if (element == newNode.getValue()) {

                if (newNode == this.head) {
                    this.head = newNode.getNextNode();
                }

                if (newNode == this.tail) {
                    this.tail = newNode.getPrevNode();
                    this.tail.setNextNode(null);
                }

                if (newNode.getPrevNode() != null) {
                    newNode.getPrevNode().setNextNode(newNode.getNextNode());
                }

                if (newNode.getNextNode() != null) {
                    newNode.getNextNode().setPrevNode(newNode.getPrevNode());
                }

                this.size--;
                return true;
            }

            newNode = newNode.getNextNode();
        }
        return false;
    }

    @Override
    public int getSize() {
        return this.size;
    }


    @Override
    public Iterator<T> iterator() {
        return new myIterator();
    }

    private final class myIterator implements Iterator<T>{
        private ListNode<T> currentNode;

        public myIterator() {
            this.currentNode = head;
        }

        @Override
        public boolean hasNext() {
            return this.currentNode != null;
        }

        @Override
        public T next() {
            T element = this.currentNode.getValue();
            this.currentNode = this.currentNode.getNextNode();
            return element;
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (T t : this) {
            result.append(t).append(" ");
        }

        return result.toString().trim();
    }
}

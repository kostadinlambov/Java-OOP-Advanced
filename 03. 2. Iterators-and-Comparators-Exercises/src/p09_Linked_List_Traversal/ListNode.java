package p09_Linked_List_Traversal;

public class ListNode<T> {

    private ListNode<T> nextNode;
    private ListNode<T> prevNode;
    private T value;

    public ListNode(T value) {
        this.setValue(value);
    }

    public ListNode(ListNode<T> nextNode, ListNode<T> prevNode, T value) {
        this.setNextNode(nextNode);
        this.setPrevNode(prevNode);
        this.setValue(value);
    }

    public T getValue() {
        return this.value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public ListNode<T> getNextNode() {
        return this.nextNode;
    }

    public void setNextNode(ListNode<T> nextNode) {
        this.nextNode = nextNode;
    }

    public ListNode<T> getPrevNode() {
        return this.prevNode;
    }

    public void setPrevNode(ListNode<T> prevNode) {
        this.prevNode = prevNode;
    }
}

package util;

public class DoublyLinkedListImpl implements DoublyLinkedList {
    private final Node head;
    private final Node tail;

    public DoublyLinkedListImpl() {
        this.head = new Node("", "");
        this.tail = new Node("", "");
        this.head.setNext(this.tail);
        this.tail.setPrev(this.head);
        this.head.setPrev(null);
        this.tail.setNext(null);
    }

    @Override
    public void removeLast() {
        Node lastNode = this.tail.getPrev();
        Node prevNode = lastNode.getPrev();
        prevNode.setNext(tail);
        tail.setPrev(prevNode);
    }

    @Override
    public void addFirst(Node node) {
        Node firstNode = this.head.getNext();

        head.setNext(node);
        node.setPrev(head);
        node.setNext(firstNode);
        firstNode.setPrev(node);
    }

    @Override
    public Node getLast() {
        return this.tail.getPrev();
    }
}

package util;

public class Node {
    private String key;
    private String value;
    private Node next;
    private Node prev;

    public Node(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getNext() {
        return this.next;
    }

    public Node getPrev() {
        return this.prev;
    }

    public String getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void detachFromList() {
        Node prevNode = getPrev();
        Node nextNode = getNext();

        prevNode.setNext(nextNode);
        nextNode.setPrev(prevNode);
    }
}

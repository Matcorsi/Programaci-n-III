package Listas.ejer7;

public class Node<T> {
    private T info;
    private Node<T> next;
    private Node<T> prev;

    public Node(T info, Node<T> next, Node<T> prev) {
        this.info = info;
        this.next = next;
        this.prev = prev;
    }

    public T getInfo() { return info; }
    public Node<T> getNext() { return next; }
    public Node<T> getPrev() { return prev; }

    public void setNext(Node<T> next) { this.next = next; }
    public void setPrev(Node<T> prev) { this.prev = prev; }
}

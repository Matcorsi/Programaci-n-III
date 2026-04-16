package Listas.ejer7;

public class MySimpleLinkedList<T> {

    private Node<T> first;
    private Node<T> last;
	private int size;
	
	public MySimpleLinkedList() {
		this.first = null;
		this.last = null;
		this.size = 0;
	}

    public void insertFront(T info) {
        Node<T> newNode = new Node<>(info, first, null);

        if (first != null) {
            first.setPrev(newNode);
        } else {
            last = newNode; // lista estaba vacía
        }

        first = newNode;
        size++;
    }

    public void insertBack(T info) {
        Node<T> newNode = new Node<>(info, null, last);

        if (last != null) {
            last.setNext(newNode);
        } else {
            first = newNode;
        }

        last = newNode;
        size++;
    }

    public T extractFront() {
        if (first == null) return null;

        T data = first.getInfo();
        first = first.getNext();

        if (first != null) {
            first.setPrev(null);
        } else {
            last = null;
        }

        size--;
        return data;
    }

    public T extractBack() {
        if (last == null) return null;

        T data = last.getInfo();
        last = last.getPrev();

        if (last != null) {
            last.setNext(null);
        } else {
            first = null;
        }

        size--;
        return data;
    }

    public T get(int index) {
        if (index < 0 || index >= size) return null;

        Node<T> current;

        if (index < size / 2) {
            current = first;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
        } else {
            current = last;
            for (int i = size - 1; i > index; i--) {
                current = current.getPrev();
            }
        }

        return current.getInfo();
    }
}

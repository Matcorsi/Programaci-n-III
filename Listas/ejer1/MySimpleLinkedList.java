package Listas.ejer1;

import java.util.Iterator;

public class MySimpleLinkedList<T> implements Iterable<T>{
	
	private Node<T> first;
	private int size;
	
	public MySimpleLinkedList() {
		this.first = null;
		this.size = 0;
	}
	
	public void insertFront(T info) {
		Node<T> tmp = new Node<T>(info,null);
		tmp.setNext(this.first);
		this.first = tmp;
		this.size++;
	}
	
	public T extractFront() {
		if(this.first == null){
			return null;
		}

		T data = this.first.getInfo();
		this.first = this.first.getNext();
		this.size--;
		return data;
	}

	public boolean isEmpty() {
		if(this.size() == 0){
			return true;
		}
		return false;
	}

	public T get(int index){
        if (index < 0 || index >= this.size) {
            return null;
        }
        
        Node<T> current = this.first;
        int i = 0;
        
        while (i < index) {
            current = current.getNext();
            i++;
        }
        
        return current.getInfo();
    }
    
    public int size() {
        return this.size;
    }

    public int indexOf(T data){
        Node<T> current = first;
        int index = 0;

        while(current != null){
            if (current.getInfo().equals(data)) {
                return index;
            }
            current = current.getNext();
            index++;
        }
        return -1;
    }

    public void iterarLista(){
        Node<T> current = first;
        while(current != null){
            System.out.println(current.getInfo());
            current = current.getNext(); 
        }
    }
    
    @Override
    public String toString() {
        String result = "[";
        Node<T> current = this.first;
        
        while (current != null) {
            result += current.getInfo();
            if (current.getNext() != null) {
                result += ", ";
            }
            current = current.getNext();
        }
        
        result += "]";
        return result;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T data = current.getInfo();
                current = current.getNext();
                return data;
            }
        };
    }
	
}
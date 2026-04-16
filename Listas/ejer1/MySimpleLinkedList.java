package Listas.ejer1;

import java.util.Iterator;

public class MySimpleLinkedList<T> implements Iterable<T>{
	
	private Node<T> first;
	private int size;
	
	public MySimpleLinkedList() {
		this.first = null;
		this.size = 0;
	}

    public MySimpleLinkedList<T> nuevaLista(MySimpleLinkedList<T> list1, MySimpleLinkedList<T> list2){
        MySimpleLinkedList<T> resultado = new MySimpleLinkedList<>();
        Node<T> nodo = list1.first;
        while(nodo != null){
            Node<T> nodo2 = list2.first;
            while(nodo2 != null){
                if(nodo.getInfo().equals(nodo2.getInfo())){
                    if(!resultado.contains(nodo2.getInfo())){
                        resultado.insertFront(nodo2.getInfo());
                    }
                    break;
                }
                nodo2 = nodo2.getNext();
            }
            nodo = nodo.getNext();
        }
    
        return resultado;
    }

    public MySimpleLinkedList<T> newLista(MySimpleLinkedList<T> list1, MySimpleLinkedList<T> list2){
        MySimpleLinkedList<T> resultado = new MySimpleLinkedList<>();
        Node<T> nodo = list1.first;
        while(nodo != null){
            Node<T> nodo2 = list2.first;
            boolean esIgual = false;
            while(nodo2 != null && !esIgual){
                if(nodo.getInfo().equals(nodo2.getInfo())){
                    esIgual = true;
                } else {
                    nodo2 = nodo2.getNext();
                }
            }
            if(!esIgual && !resultado.contains(nodo.getInfo())){
                resultado.insertFront(nodo.getInfo());
            }
            nodo = nodo.getNext();
        }
        return resultado;
    }


    public boolean contains(T dato) {
        Node<T> actual = this.first;

        while (actual != null) {
            if (actual.getInfo().equals(dato)) {
                return true;
            }
            actual = actual.getNext();
        }

        return false;
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
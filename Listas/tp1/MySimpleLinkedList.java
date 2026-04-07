package Listas.tp1;

public class MySimpleLinkedList<T> {
	
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
	
	
}
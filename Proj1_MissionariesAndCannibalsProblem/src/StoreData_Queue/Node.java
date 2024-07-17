package StoreData_Queue;

public class Node <T>{
	
	//=== Attributes --------------------------------------------------------
    private T data;
    private Node<T> next;
    
    
    
    //=== Constructor --------------------------------------------------------
    public Node(T data) {
        this.data = data;
    }
    
    
    
    //=== Getter and Setter --------------------------------------------------
    public T getData() {
        return data;
    }
    public Node<T> getNext() {
        return next;
    }
    /////////////////////////////////////
    public void setData(T data) {
        this.data = data;
    }
    public void setNext(Node<T> next) {
        this.next = next;
    }
    ////////////////////////////////////
    
    
}


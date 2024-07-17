package StoreData_Stack;

public class Stack<T> {
	
	//=== Attributes --------------------------------------------------------
	private Node<T> topNode; 
	
	
	
	
	
	
	//=== Methods -----------------------------------------------------------
    
	//// add elements
	public void push(T data) {
		Node<T> newNode = new Node<>(data);
		newNode.setNext(topNode);
		topNode = newNode;
	}

	
	//// delete the last element
	public T pop() {
		Node<T> del_Node = topNode;

		if (topNode != null) {
			topNode = topNode.getNext();
		}

		return del_Node.getData();
	}


	//// return the top node
	public Node<T> peek() {
		return topNode;
	}


	//// the stack is empty or not
	public boolean isEmpty() {
		if (topNode == null) {
			return true;
		} else {
			return false;
		}
	}


	//// remove all entries in the stack
	public void clear() {
		topNode = null;
	}


	//// the length number
	public int length() {

		int length = 0;
		Node<T> curr = topNode;

		while (curr != null) {
			length++;
			curr = curr.getNext();
		}

		return length;
	}

	// isContains
	public boolean isContains(T element) {
        Node<T> current = topNode;

        while (current != null) {
            if (current.getData().equals(element)) {
                return true;
            }
            current = current.getNext();
        }

        return false;
    }
	
	//// show data
	@Override
	public String toString() {
		Node<T> curr = topNode;

		String s = "Top Node";
		if (isEmpty() == true) {
			System.out.println(" |" + "The Stack is Empty" + " |");
			return "";
		}

		else {
			while (curr != null) {
				s += " --> " + curr.getData();
				curr = curr.getNext();
			}

			return " |" + s + " |";
		}

	}
	
	public void printData() {
		Node<T> curr = topNode;

		String s = "Top Node";
		if (isEmpty() == true) {
			System.out.println(" |" + "The Stack is Empty" + " |");
		}

		else {
			while (curr != null) {
				s += " --> " + curr.getData();
				curr = curr.getNext();
			}

			System.out.println(" |" + s + " |"); 
		}
	}
}
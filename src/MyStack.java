public class MyStack implements IStack {

	/**
	 * Node class.
	 */
	public class Node {
		
		/**
		 * The value held inside the node.
		 */
		private Object element;
		
		/**
		 * Node's pointer to next node.
		 */
		private Node next;
		
		/**
		 * Node constructor.
		 * @param num value held by the node.
		 * @param n next node.
		 */
		public Node(Object num, Node n) {
			element = num;
			next = n;
		}
		
		/**
		 * Gets the value held by the node.
		 * @return the element held by the node.
		 */
		public Object getElement() {
			return element;
		}
		
		/**
		 * Points to next node.
		 * @return next node.
		 */
		public Node getNext() {
			return next;
		}
		
		/**
		 * Sets the value of the element held by the node.
		 * @param newElem element to be added to the node.
		 */
		public void setElement(Object newElem) {
			element = newElem;
		}
		
		/**
		 * Sets the new next node to which the current node will be pointing.
		 * @param newElem the new next node to point to.
		 */
		public void setNext(Node newNext) {
			next = newNext;
		}

	}
	
	/**
	 * Head node of the used SLL.
	 */
	private static Node head;
	
	/**
	 * Size of the used SLL.
	 */
	private static int size;
		
	/**
	 * Stack constructor.
	 */
	public MyStack() {
		head = null;
		size = 0;
	}
	
	/**
	 * Prints the content of a given SLL.
	 * @param givenList the list to be printed.
	 * @param s number of elements to be printed.
	 */
	public void printList(MyStack givenList, int s) {
		System.out.print("[");
		if(givenList.isEmpty()) {
			s = 0;
		}
        for(int i = 0; i < s; ++i) {
	       	System.out.print(givenList.get(i));
        	if(i != s - 1) {
        		System.out.print(", ");
	       	}
	    }
        System.out.print("]");
	}
	
	
	/**
	 * Gets the value held by a node having a specific index.
	 * @param index the desired index to get the value from.
	 * @return the desired element.
	 */
	public Object get(int index) {
		
		if(index >= size || index < 0) {
			System.out.println("Error");
			System.exit(0);
		}
		Node tempNode = head;
		for(int i = 0; i < index; ++i) {
			tempNode = tempNode.getNext();
		}
		
		return tempNode.getElement();
	}
	
	/*** Removes the element at the top of stack and returnsthat element.
	  * @return top of stack element, or through exception if empty.
	  */
	public Object pop() {
		
		if(size <= 0) {
			System.out.println("Error");
			System.exit(0);
		}
		Object temp = head.element;
		Node removedNode = head;
		head = removedNode.getNext();
		removedNode.setNext(null);
		size--;

		return temp;
	}
	

	/*** Get the element at the top of stack without removing it from stack.
	  * @return top of stack element, or through exception if empty.
	  */
	public Object peek() {

		if(size <= 0) {
			System.out.println("Error");
			System.exit(0);
		}
		
		return head.element;
	}

	/*** Pushes an item onto the top of this stack.
	  * @param element object to insert.
	  */
	public void push(Object element) {

		Node addedNode = new Node(element, head);
		head = addedNode;
		size++;

	}

	/*** Tests if this stack is empty.
	  * @return true if stack empty.
	  */
	public boolean isEmpty() {
		return size <= 0;
	}

	/**
	 * Returns the current size of the stack.
	 * @return the stack size.
	 */
	public int size() {
		return size;
	}

}

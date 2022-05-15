
public class MyQueue implements IQueue {
	
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
    private static Node head;
    private static int size;
    
    public MyQueue() {
        head = null;
        size = 0;
    }
    public void printList(MyQueue givenList, int s) {
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

    public void enqueue(Object element) {
        Node added_Node = new Node(element, head);
        head = added_Node;
        size++;
        
    }

    public Object get(int index) {
        
        if(index >= size || index < 0 || size == 0) {
            System.out.println("Error");
            System.exit(0);
        }
        Node tempNode = head;
        for(int i = 0; i < index; ++i) {
            tempNode = tempNode.getNext();
        }
        
        return tempNode.getElement();
    }

    public boolean isEmpty() {
        if(size <= 0) {
            return true;
        }
        return false;
    }

    public Object dequeue() {
        if(size <= 0) {
            System.out.print("Error");
            System.exit(0);
        }
        Node tempNode = head;
        Node prevTemp = head;
        while( tempNode.getNext() != null) {
            prevTemp = tempNode;
            tempNode = tempNode.getNext();
        }
        prevTemp.setNext(null);
        size--;
        return tempNode.element;
    }

    public int size() {
        return size;
    }
}

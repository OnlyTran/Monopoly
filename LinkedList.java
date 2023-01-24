public class LinkedList {
    private Node head;
   
    // Constructor
    public LinkedList() {
        head = null;
    }
   
    // Add to the front of the linked list
    public void addToFront(brand n) {
        if (head == null) {
            head = new Node(n);
        } else {
            Node newNode = new Node(n);
            newNode.setNext(head);
            head = newNode;
        }
    }
    // Remove a string from the list
    public String remove() {
        String removed = getTopItem();
        Node newNode = head.getNext();
        head = newNode;
        return removed;
    }
    // Get the top item of the list
    public String getTopItem() {
        if (head == null) {
          return "Your list is empty!";
        } else {
          return head.getData();
        }
      }
    // Print out the list
    public String toString() {
        String result = "";
        Node dummy = head;
        if (head != null) {
            while (dummy.getNext() != null) {
                result += (dummy.getData() + ", ");
                dummy = dummy.getNext();
            }
            result += dummy.getData();
            return result;
        } else {
            return "No brands learned from.";
        }
    }
    // Checks if the list is empty
    public boolean isEmpty() {
        return head == null;
    }
    // Nodes for the linked list
    private class Node {
        private brand data;
        private Node next;
        // Constructor
        public Node(brand n) {
            data = n;
            next = null;
        }
        // Set the next node for a selected node/head
        public void setNext(Node a) {
            next = a;
        }
        // Get the node ahead of the selected node
        public Node getNext() {
            return next;
        }
        // Get data of a node
        public String getData() {
            return data.toString();
        }
 
    }
 
}

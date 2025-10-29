package LinkedList;

public class SinglyLinkedList {

    Node head;
    int size;

    public SinglyLinkedList() {
        head = null;
        size = 0;

    }

    public void addNode(int data) {//Adds node to the front
        
        Node newNode = new Node(data);

        if(head == null) {
            head = newNode;  
            size++;
            return;

        } 

        newNode.next = head;
        head = newNode;

        size++;

    }

    public void addNodeEnd(int data) {

        Node newNode = new Node(data);

        if(head == null) {
            head = newNode;
            size++;
            return;

        }

        Node currentNode = head;

        while(currentNode.next != null) {
            currentNode = currentNode.next;
        }

        currentNode.next = newNode;

    }

    public void addNodePosition(int pos, int val) {
        
        if(pos > size + 1) {
            System.out.println("Linked list size is larger than given position. Position given: " + pos + " Size: " + size);

        } else if (pos == 0) {
            System.out.println("Error, position starts at 1 ");

        }

        Node newNode = new Node(val);

        if(head == null) {
            head = newNode;
        }

        Node currentNode = head;
        for(int i = 1; i < pos - 1; i++) {
            currentNode = currentNode.next;

        }

        newNode.next = currentNode.next;
        currentNode.next = newNode;

    }

    public void deleteNode(int pos) {

        if(head == null) {
            System.out.println("Cannot delete there is nothing to delete. Linked List empty");
            return;
        }

        if(pos < 1 || pos > size + 1) {
            System.out.println("Invalid positions");
            return;
        }

        if(pos == 1) {
            head = head.next;
            size--;
            return;
        }

        Node currentNode = head;
        for(int i = 1; i < pos - 1; i++) {
            currentNode = currentNode.next;
            size--;
        }

        currentNode.next = currentNode.next.next;

    }
    
}

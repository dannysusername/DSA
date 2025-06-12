package Stack;
import Stack.Node;

public class StackLinkedList {

    /*
    LinkedList holds chains of nodes
    First there is a dummy node of null value; we save the top node
    Add function puts a new node with value to top nodes next
    */
    Node head;
    int size;

    public StackLinkedList() {
        head = null;
        size = 0;

    }

    public void push(int value) {
        //Adds node to top, increase size;
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;

    }

    public int pop() {

        if(head == null) {
            throw new IllegalStateException("Error - Pop from empty stack");
        }
        // if empty return 
        int poppedData = head.value;
        head = head.next;
        return poppedData;

    }

    public int peek() {
        if(head == null) {
            throw new IllegalStateException("Error - stack empty");
        }

        return head.value;

    }

    public boolean isEmpty() {
        if(head == null) {
            return true;
        }

        return false;
    }

    public void display() {

        Node temp = head;


        while(temp != null) {
            System.out.println(temp.value + ", ");
            temp = temp.next;

        }

    }

    
}

package Stack;

public class main {

    public static void main(String[] args) {
        StackLinkedList stack1 = new StackLinkedList();

        stack1.push(5);
        stack1.push(2);
        stack1.push(3);
        stack1.push(1);
        stack1.push(10);
        stack1.push(4);

        stack1.pop();

        stack1.display();
        
        

    }
    
}

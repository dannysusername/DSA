package Stack;

public class main {

    public static void main(String[] args) {
        StackDeque stack1 = new StackDeque(5);
        stack1.push(2);
        stack1.push(3);
        stack1.push(4);
        stack1.push(2);
        stack1.push(3);
        stack1.push(4);
        stack1.push(2);
        stack1.push(3);
        stack1.push(4);
        stack1.pop();
        stack1.display();
        

    }
    
}

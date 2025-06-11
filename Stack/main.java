package Stack;

public class main {

    public static void main(String[] args) {
        StackArray stack1 = new StackArray(5);
        stack1.push(10);
        
        StackArrayList stack2 = new StackArrayList(5);
        stack2.push(2);

        System.out.println(stack2.peek());
       
        

    }
    
}

package Stack;

public class StackArray {

    /*Stack has push, pop, peek, isFull, isEmpty methods

    Push method adds items to the top of the stack, first it checks if the stack is full
    Pop removes items from the top of the stack, first it checks if the stack is empty "Stack is empty"
    Peek returns the item on the top of the stack, first it checks if the stack is empty "Stack is empty"
    isFull checks if stack is full
    isEmpty checks if the stack is empty

    */

    int top;
    int capacity = 0;
    int a[];

    public StackArray(int capacity) {
        top = -1;
        this.capacity = capacity;
        this.a = new int[capacity];

    }

    public boolean push(int item) {
        if(isFull()) {
            System.out.println("Stack full cannot push");
        }

        a[++top] = item;
        return true;

    }

    public int pop() {
        if(isEmpty()) {
            System.out.println("Stack empty cannot pop");
            return 0;
        } else {
            return a[top--];

        }

    }

    public int peek() {
        if(isEmpty()) {
            System.out.println("Stack empty cannot pop");
            return 0;
        } else {
            return a[top];
        }

    }

    public boolean isEmpty() {
        if(top == -1) {
            return true;
        }

        return false;

    }

    public boolean isFull() {
        if (top == capacity - 1) {
            return true;
        }

        return false;

    }

    public void display() {

        for(int i = 0; i <= top; i++) {
            System.out.println(a[i] + ", ");

        }

    }
    
}


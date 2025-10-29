package Stack;

import java.util.ArrayList;

public class StackArrayList {
    
    int capacity;
    int top;
    ArrayList<Integer> list;

    public StackArrayList(int capacity) {
        list = new ArrayList<Integer>();
        this.capacity = capacity;
        this.top = -1;

    }

    public void push(int item) {
        if(isFull()) {
            System.out.println("Stack full cannot add");

        } else {
           list.add(item);
           top++;

        }

    }

    public int pop() {
        if(isEmpty()) {
            System.out.println("Stack empty cannot remove");
            return -1;
        }
        list.remove(top);
        top--;
        return top;

    }

    public int peek() {
        if(isEmpty()) {
            System.out.println("Stack empty");
            return -1;
        } else {
            return list.get(top);
        }

    }

    public boolean isFull() {
        if(top == capacity - 1) {
            return true;
        }

        return false;

    }

    public boolean isEmpty() {
        if(top == - 1) {
            return true;
        }

        return false;
    }

    public void display() {
        if(top == -1) {
            System.out.println("Stack empty, cannot display empty arraylist");
        }

        for(int i = 0; i <= top; i++) {
            System.out.println(list.get(i));
        }
    }

}

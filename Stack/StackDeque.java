package Stack;

public class StackDeque {

    /*Deque is also known as double ended queue, it is typically implemented using a circular array or doubly linked list
     * Use an circular array
     * Keep track of ends, bottom top
     * add remove first, add first, remove last, add last, pop, push, peek, resize and display(from one side)
     */

    int capacity;
    int size;
    int first = 0;
    int last;
    int [] circularArr;

    public StackDeque(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.last = 0;
        this.circularArr = new int[capacity];

    }

    public int removeFirst() {
        if(size == 0) {
            throw new IllegalStateException("Empty stack empty");

        }

        int removed = circularArr[first];
        circularArr[first] = 0;
        first = (first + 1) % capacity;
        size--;

        return removed;

    }

    public void addFirst(int value) {

        if(size == capacity) {
            resize();

        }

        first = first - 1 % capacity;
        circularArr[first] = value;
        size++;

    }

    public int removeLast() {

        if(size == 0) {
            throw new IllegalStateException("Empty stack empty");

        }

        last = (last - 1) % capacity;
        circularArr[last] = 0;
        size--;

        return circularArr[last];

    }

    public void addLast(int value) {

        if(size == capacity) {
            resize();
            System.out.println();
        }

        last = (first + size) % capacity;        
        circularArr[last] = value;
        
        size++;

    }

    public void resize() {

        int[] newArr = new int[capacity * 2];
        capacity = capacity * 2;

        for(int i = 0; i < circularArr.length; i++) {
            newArr[i] = circularArr[i];

        }

        circularArr = newArr;

    }

    public void push(int value) {
        addLast(value);

    }

    public int pop() {
        return removeLast();

    }

    public int peek() {
        return circularArr[last];
    }

    public void display() {

        int curr = last;

        for(int i = 0; i < size; i++) {
            System.out.println(circularArr[curr]);
            curr = (curr - 1 + capacity) % capacity;
        }
    }
    
}

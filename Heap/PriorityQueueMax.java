package Heap;

import Arrays.Arrays;

public class PriorityQueueMax {

    /*
     * Priority Queue is a queue that prioritizes a certain type of number, such as smallest or largest
     */

     BinaryMaxHeap heap;
     int size;
     int capacity;

    public PriorityQueueMax(int capacity) {

        this.size = 0;
        this.capacity = capacity;
        heap = new BinaryMaxHeap(capacity);
       
        /*
         * Heap holds the array with the capacity;
         */

    }

    public void add(int val) { // O(log n)
        heap.insert(val);
        size++;

    }

    public int poll() { // O(log n)
        size--;
       
        return heap.extract_max();

    }

    public int peek() { // O(1)
        
        System.out.println(heap.getMax());
        return heap.getMax();

    }

    public void display() {
        heap.display();
    }

    
    
}

class TestPq {
    public static void main(String[] args) {

        PriorityQueueMin pq1 = new PriorityQueueMin(10);

        pq1.add(10);
        pq1.add(5);
        pq1.add(3);

        pq1.poll(); //removes 3: 1, 5, 8, 10, 15

        pq1.add(15);
        pq1.add(8);
        pq1.add(1);

        pq1.peek(); //prints 1 

        pq1.poll(); //remove 1: 5, 8, 10, 15

        pq1.peek(); //prints 5

        pq1.poll(); //removes 5: 8, 10, 15

        pq1.peek(); //prints 8

        pq1.poll(); //removes 8: 10, 15

        pq1.peek(); //prints 10

        pq1.poll(); //removes 10: 15

        pq1.peek(); //prints 15

        pq1.poll(); //removes 15:

    }

}


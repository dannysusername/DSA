package Heap;

public class BinaryMaxHeap {

int capacity;
int[] heapArray;
int currentHeapSize;
/*
 * This is a min heap implementation that was written from scratch after studying the heap data structure
 */

public BinaryMaxHeap(int capacity) {
    this.capacity = capacity;
    this.heapArray = new int[capacity];
    this.currentHeapSize = 0;

}

public void insert(int num) {
    int i = currentHeapSize;
    heapArray[i] = num;

/*
    This implementation is for a minheap. so the smallest number is at the root.
 * While the inserted number is less than the parent swap, then make i the parent, (bubbles up) O(log n)
 */

while(i != 0 && heapArray[i] > heapArray[parent(i)]) {
    swap(i, parent(i));
    i = parent(i);

}  

currentHeapSize++;

}

public void delete() {

    /*
     * Delete the root element by swapping the last element with it and decrementing current heap size, then heapify down to fix min heap violation O(log n)
     */
    int i = currentHeapSize;

    if(i <= 0) {
        return;
    }

    //int root = heapArray[0];
    swap(currentHeapSize - 1, 0);
    currentHeapSize--;
    heapify(0); // bubble down

}

/*
 * Given the index decrease it to value then heapify downwards. DecreaseKey function assumes the value of index gets smaller
 */
public void decreaseKey(int index, int value) {
    heapArray[index] = value;

    //Bubble down
    heapify(index);
   
}
/*
 * IncreaseKey function changes the index's value to the given 'value'. Then bubble up. IncreaseKey function assumes the value at index gets
 * increased
 */
public void increaseKey(int index, int value) {
    heapArray[index] = value;

    int i = index;

    while(i != 0 && heapArray[i] > heapArray[parent(i)]) {
        swap(i, parent(i));
        i = parent(i);

    }
    

}

/*
 * Change priority
 * Remove a particular key
 */

public void heapify(int index) {
    /*
     * Bubble down
     */
    int left = left(index);
    int right = right(index);

    int largest = index;

    if (left < currentHeapSize && heapArray[left] > heapArray[largest]) {
        largest = left;

    }

    if (right < currentHeapSize && heapArray[right] > heapArray[largest]) {
        largest = right;

    }

    if(largest != index) {
        swap(largest, index);
        heapify(largest);
    }

}

public int extract_max() {

    if(currentHeapSize == 0) {
        return Integer.MAX_VALUE;
    }

    int max = getMax();
    delete();
    return max;
}

public int getMax() {
    return heapArray[0];
}

public int parent(int i) {
    return (i - 1) / 2;

}

public int left(int i) {
    return (2 * i) + 1;

}

public int right(int i) {
    return (2 * i) + 2;

}

public void swap(int a, int b) {
    int temp = heapArray[a];
    heapArray[a] = heapArray[b];
    heapArray[b] = temp; 

}

public void display() {
    for(int i = 0; i < currentHeapSize; i++) {
        System.out.print(heapArray[i]);
        if(i != currentHeapSize - 1) {
            System.out.print(", ");
        }
    }
}

/* This data structure can create a min heap or a max heap
 * Insert (number)
 * - First you insert at the end of heap array, then swap if min heap is violated.
 * Delete ()
 * DeleteKey ()
 */
    
}

class BinaryHeapTest {

    public static void main(String[] args) {
        BinaryMaxHeap test = new BinaryMaxHeap(7);
        test.insert(5);
        test.insert(6);
        test.insert(3);
        test.insert(1);
        test.insert(9);
        
        test.increaseKey(1, 10);
        test.decreaseKey(4, 1);

        test.extract_max();
        test.extract_max();
        test.extract_max();
        test.extract_max();
        test.extract_max();
        test.extract_max();
        test.extract_max();
       

    }

}

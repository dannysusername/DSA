package Heap;

import Arrays.Arrays;

public class BinaryMinHeap {

int capacity;
int[] heapArray;
int currentHeapSize;
/*
 * This is a min heap implementation that was written from scratch after studying the heap data structure
 */

public BinaryMinHeap(int capacity) {
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

while(i != 0 && heapArray[i] < heapArray[parent(i)]) {
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
 * Given the index decrease it to value then heapify upwards. DecreaseKey function assumes the value of index gets smaller
 */
public void decreaseKey(int index, int value) {
    heapArray[index] = value;
    int i = index;

    while(i != 0 && heapArray[i] < heapArray[parent(i)]) {
        swap(i, parent(i));
        i = parent(i);

    }

}
/*
 * IncreaseKey function changes the index's value to the given 'value'. Then heapify is used to bubble down. IncreaseKey function assumes the value at index gets
 * increased
 */
public void increaseKey(int index, int value) {
    heapArray[index] = value;
    heapify(index);

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

    int smallest = index;

    if (left < currentHeapSize && heapArray[left] < heapArray[smallest]) {
        smallest = left;

    }

    if (right < currentHeapSize && heapArray[right] < heapArray[smallest]) {
        smallest = right;

    }

    if(smallest != index) {
        swap(smallest, index);
        heapify(smallest);
    }

}

public int extract_min() {

    if(currentHeapSize == 0) {
        return Integer.MAX_VALUE;
    }

    int min = getMin();
    delete();
    return min;
}

public void convertToMaxHeap(int[] arr) {
    int n = arr.length;

    for(int i = (n - 2) / 2; i >= 0; --i) {
        MaxHeapify(arr, i, n);
    }

}

public void MaxHeapify(int arr[], int i, int N) {

    int left = 2 * i + 1;
    int right = 2 * i + 2;
    int largest = i;

    if(left < N && arr[left] > arr[i]) {
        largest = left;
    }

    if(right < N && arr[right] > arr[largest]) {
        largest = right;
    }

    if(largest != i) {
        swap(largest, i);
        MaxHeapify(arr, largest, N);
    }

}

public int getMin() {
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

class BinaryHeap2Test {

    public static void main(String[] args) {
        BinaryMinHeap test = new BinaryMinHeap(7);
        test.insert(5);
        test.insert(6);
        test.insert(3);
        test.insert(1);
        test.insert(9);
        test.insert(8);
        test.insert(7);
        
        test.convertToMaxHeap(test.heapArray);
        
        
       
    }

}

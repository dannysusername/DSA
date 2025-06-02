package Sorting;

public class InsertionSort {
    
    public static void InsertionSort(int[] arr) { 
        /*
        Insertion Sort starts at the second element (i = 1) then sees if it is smaller than its previous elements if it is, its swapped. 
        The optimized version moves elements down and then swaps the element that is not greater than i. This is optimized because its 
        less assignments than the swap function. 

        Insertion sort is the simplest sorting algorithm to implement, its time complexity is O(n^2) 
        for worst case and O(n) best case for sorted arrays and O(n^2) for randomly ordered arrays
        and is stable(preserves relative order of equal elements)

        -Useful for nearly sorted and small arrays
        -
        12, 11, 13, 5, 6 
        */
        
        for (int i = 1; i < arr.length; i++) {
            int j = i;

            while (j > 0 && arr[j] < arr[j - 1]) {
                swap(arr, j - 1, j);
                j--;

            }
        }
    
    }

    public static void optimizedIS(int[] arr) {
        /* This version of insertion sort moves values over (1 assignment) rather than swapping (3 assigments)  */

        for(int i = 1; i < arr.length; i++) {
            int j = i;
            int key = arr[i];

            while(j > 0 && key < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;

            }

            arr[j] = key;

        }

    }

    public static void swap(int[] arr, int num1, int num2) {

        int temp = arr[num2];
        arr[num2] = arr[num1];
        arr[num1] = temp;

    }

    public static void main(String[] args) {

         int arr[] = { 12, 11, 13, 5, 6 };

         InsertionSort(arr);

         System.out.println(arr);


    }

   


}



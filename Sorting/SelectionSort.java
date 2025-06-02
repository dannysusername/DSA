package Sorting;

public class SelectionSort {
    /* 
    Selection Sort finds the smallest element in the array and swaps it with the unsorted part of the array (the front)
    Continuously until it reaches the the second to last element since the inner for loop checks the next element.

    O(n^2)time O(1) space
    -Least number of swaps or memory writes other than cycle sort
    -Easy to understand
    -Ineffecient
    -Not stable(does not keep relative order of equal elements)

    */

    public static void SelectionSort(int[] arr) {

        for(int i = 0; i < arr.length - 1; i++){
           
            int smallest = i;

            for(int j = i + 1; j < arr.length; j++) {

                if(arr[j] < arr[smallest]) {
                    smallest = j;
                }

            }

            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;

        }

    }

    public static void main(String[] args) {

        int[] arr = { 64, 25, 12, 22, 11 };
        SelectionSort(arr);

        for(int x : arr) {
            System.out.println(x);
        }

    }
    
}

package Sorting;

import Arrays.Arrays;

public class QuickSort {

    public static void quickSort(int[] arr, int low, int high) {


        if (low < high) { //return

            int pi = partition(arr, low, high); //splits arr in half, left half has less valued elements that the right of the pi

            quickSort(arr, low, pi - 1); //left side execution
            quickSort(arr, pi + 1, high); //right side

        }


    }

    public static int partition(int arr[], int low, int high) {
        
        int pivot = arr[high];

        int i = low - 1;
       
        for(int j = low; j <= high - 1; j++) {
            if(arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }

        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    public static void swap(int[] arr, int a, int b) {

        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;

    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 2, 1, 2, 3, 3};
        quickSort(arr, 0 , arr.length - 1);

        for(int x : arr) {
            System.out.println(x);
        }

       

    }


    
}

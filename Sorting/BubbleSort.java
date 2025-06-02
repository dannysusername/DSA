package Sorting;

public class BubbleSort {

    public static void bubbleSort(int[] arr) {
        //Largest element moves to end at each iteration. Sorted elements are at the end. or before arr.length - i - 1.
        //Bubble sort is ineffiecient for large data sets. Essentially for each pass the largest element moves to the right. o(n^2)
        //Easy to implement, no memory space and stable algorithm(saves relative order of equal elements)

        for(int i = 0; i < arr.length - 1; i++) {

            for(int j = 0; j < arr.length - i - 1; j++) {

                if(arr[j + 1] < arr[j]) {
                    swap(arr, j, j + 1);

                }

            }

        }

    }

    public static void swap(int[] arr, int num1, int num2) {
        //put num2 into spot 1
        int temp = arr[num1];
        arr[num1] = arr[num2];
        arr[num2] = temp;

    }

    public static void main(String[] args) {

        int arr[] = { 64, 34, 25, 12, 22, 11, 90 };
        bubbleSort(arr);

        for(int x : arr) {
            System.out.print(x + ", ");
        }

    }
    
}

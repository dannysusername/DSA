package Searching;

import java.util.Arrays;
import java.util.HashSet;

public class SearchingProblems {
    

    //Find largest element in the given array, input = [10, 20, 4] output: 20, input = [20, 10, 20, 4, 100] output = 100
    public static int findMax(int[] arr, int i) {
       
        if(i == arr.length - 1) {
            return arr[i];
        }

        int recMax = findMax(arr, i + 1);

        return Math.max(recMax, arr[i]);

    }

    public static int largest(int[] arr) {
        return findMax(arr, 0);

    }

    public static int secondLargest(int[] arr) {
        /*
         * Given an array of positive integers of size n, task is to find second largest distinct element in the array, if not return -1;
         * Input: arr[] = [12, 35, 1, 10, 34, 1]
        Output: 34
        Explanation: The largest element of the array is 35 and the second largest element is 34.

        Input: arr[] = [10, 5, 10]
        Output: 5

        Input: arr[] = [10, 10, 10]
        Output: -1
        */

        int largest = -1;
        int secondLargest = -1;

        for(int i = 0; i < arr.length; i++) {

            if(arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } else if(arr[i] < largest && arr[i] > secondLargest) {
                secondLargest = arr[i];
            }

        }

        return secondLargest;
    }

    public static int[] largestThree(int arr[]) {
        //Given an array find the largest 3 distinct elements in array

        int[] result = new int[3];

        int largest = -1;
        int secondLargest = -1;
        int thirdLargest = -1;

        for(int i = 0; i < arr.length; i++) {

            if(arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];

            } else if(arr[i] < largest && arr[i] > secondLargest) {
                thirdLargest = secondLargest;
                secondLargest = arr[i];

            } else if(arr[i] < largest && arr[i] < secondLargest && arr[i] > thirdLargest) {
                thirdLargest = arr[i];

            }

        }

        result[0] = largest;
        result[1] = secondLargest;
        result[2] = thirdLargest;

        return result;

    }

    public static int findRepeat(int[] arr) {
        /*
         * Task is to find index of first repeating element in array.
         * Input: arr[] = {10, 5, 3, 4, 3, 5, 6}
            Output: 5 

            Input: arr[] = {6, 10, 5, 4, 9, 120, 4, 6, 10}
            Output: 6 

            2. Check if number is in hashset then add that number. If hashset contains number then return i (iteration)
            O(n) time, O(n) space
    
        */

        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < arr.length; i++) {

            if(set.contains(arr[i])){
                return i;
            }

            set.add(arr[i]);  

        }

        return -1;

    }

    public static int[] missingAndRepeating(int[] arr) {

        /*
         * Given an unsorted array of size n the elements are in the range from 1-n. Return the number that is missing and number that is repeating
         * Input: arr[] = {3, 1, 3}
         * Output: 3, 2
         * Input: arr[] = {4, 3, 6, 2, 1, 1}
         * Output: 1, 5
         * 1. HashSet for repeating numbers , sort for missing numbers 
         * O(n) time with O(n) auxiliary space
         */

        int[] result = new int[2]; 
        HashSet<Integer> set = new HashSet<>();
        int arrTotal = 0;
        int realTotal = 0;

        for(int i = 0; i < arr.length; i++) {
            
            if(set.contains(arr[i])){
                result[0] = arr[i];

            } else {
                arrTotal += arr[i];
                set.add(arr[i]);
            }

            realTotal += i + 1;  

        }

        result[1] = realTotal - arrTotal;

        return result;

    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 3};

        System.out.println(Arrays.toString(missingAndRepeating(arr)));
    }

}

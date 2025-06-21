package Searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

import Heap.PriorityQueueMax;
import Heap.PriorityQueueMin;

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

            realTotal += 
            i + 1;    

        }

        result[1] = realTotal - arrTotal;

        return result;

    }

    public static int[] missingAndRepeating2(int[] arr) {

        int[] result = new int[2];

        int repeating = -1;

        for(int i = 0; i < arr.length; i++) {

            int absVal = Math.abs(arr[i]);

            if(arr[absVal - 1] > 0) {
                arr[absVal - 1] = -arr[absVal - 1];
            } else {
                repeating = absVal;
            }

        }

        int missing = -1;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > 0) {
                missing = i + 1;
                break;
            }
        }

        result[0] = missing;
        result[1] = repeating;

        return result;
    }

    public static int countOnes(int[] arr, int left, int right) {

        int n = arr.length;

         while (left <= right) { 
            int mid = (left + right) / 2;

            // If mid element is 0
            if (arr[mid] == 0)
                right = mid - 1;
                
            // If element is last 1
            else if (mid == n - 1 || arr[mid + 1] != 1)
                return mid + 1;
                
            // If element is not last 1    
            else
                left = mid + 1;

        }
        return 0;

    }
    
    public static boolean pairWGivenDiff(int[] arr, int x) {
    /*
     * Given an unsorted array and an integer x, the task is find if there is a pair in array that abs difference is X 
     * 
     * 
     */

    Arrays.sort(arr);
    
    for(int i = 0; i < arr.length - 1; i++) {

        int toFind = Math.abs(x + arr[i]);
        int index = Arrays.binarySearch(arr, i + 1, arr.length, toFind);
        if(index > 0) {
            return true;
        }
        
    }

    return false;

    }
    
    public static boolean pairWGivenDiff2(int[] arr, int x) {

        Arrays.sort(arr);

        int left = 0;
        int right = 1;
        
        while(left < arr.length) {

            int diff = Math.abs(arr[left] - arr[right]);

            if(diff == x) {
                return true;
            }

            if(diff < x) {
                right++;
            } else {
                left++;
            }

        }
       
        return false;
    
    }
    
    public static boolean pairWGivenDiff3(int[] arr, int x) {

        /*
        * Use a hashset / add all the arr numbers into the hashset, then go through arr and find complement and check if the complement is in the array
        */

        HashSet<Integer> st = new HashSet<>();
        
        for (int num : arr) {
            
            // Check if complement exists
            if (st.contains(num + x) || st.contains(num - x)) {
                return true;
            }
            
            st.add(num);
        }

        return false;

    }

    public static int[] findKLargestElements(int[] arr, int k) {
        /*
         * Given an array and k, find the k largest elements in the array, output of elements should be in decreasing order.
         * Input:  [1, 23, 12, 9, 30, 2, 50], k = 3
             Output: [50, 30, 23]

            Input:  [11, 5, 12, 9, 44, 17, 2], k = 2
            Output: [44, 17]

            1. Brute force and use hashset to save output and use set.contains to skip over already saved ele O(n^2) time, O(n) space
            2. 


        */

        HashSet<Integer> largestElements = new HashSet<Integer>();
        int[] result = new int[k];

        for(int i = 0; i < k; i++) {

            int largest = arr[0];

            for(int j = 0; j < arr.length; j++) {

                if(largestElements.contains(arr[j])) {
                    continue;

                } else if(arr[j] > largest) {
                    largest = arr[j];

                }

            }

            largestElements.add(largest);
            result[i] = largest;

        }

        return result;

    }

    public static int[] findKLargestElements2(int[] arr, int k) {

        /*
         * O(n^2) time, O(1) space
         */
      
        int[] result = new int[k];

        for(int i = 0; i < k; i++) {

            int largest = 0;

            for(int j = 0; j < arr.length; j++) {

                if(arr[j] == -1) {
                    continue;

                } else if(arr[j] > arr[largest]) {
                    largest = j;

                }

            }

            result[i] = arr[largest];
            arr[largest] = -1;

        }

        return result;

    }

    public static int[] findKLargestElements3(int[] arr, int k) {

        /*
         * O(nLogn) time, O(1) space
         */
      
        int[] result = new int[k];
        Arrays.sort(arr);
        int n = arr.length;

        for(int i = 0; i < k; i++) {

            result[i] = arr[n - i - 1];

        }

        return result;

    }

    public static ArrayList<Integer> findKLargestElements4(int[] arr, int k) {

        /*
         * Using a priority queue that implements a binary max heap in the background costs n log n to create.
         */
        PriorityQueueMin pqMin = new PriorityQueueMin(arr.length);

        for(int i = 0; i < k; i++) { // O(n log n)
            pqMin.add(arr[i]);

        }

        for(int i = k; i < arr.length; i++) {

            if(arr[i] > pqMin.peek()) {
                pqMin.poll();
                pqMin.add(arr[i]);

            }

        }

        ArrayList<Integer> res = new ArrayList<>();

        for(int i = 0; i < k; i++) {
            res.add(pqMin.poll());

        }

        Collections.reverse(res);

        return res;

    }



    /*
     * Given a 2D matrix (n x n) where each array is sorted find the Kth smallest element in the matrix; the range is [1, n * n]
     * 
     * 1.) Brute force O(n^2)
     * 2.) Using priority queue with min binary heap
     * 3.) Use binary search
     * 
     * Find the mid point and check how many values there are less than mid (through a helper method), if its less than k then make low = mid + 1, else high = mid - 1;
     */

    public static int countSmallerEqual(int[][] mat, int x) {
        int n = mat.length;
        int count = 0;
        int row = 0;
        int col = n - 1;

        while(row < n && col >= 0) {

            if(mat[row][col] <= x) {
                count += (col + 1);
                row++;

            } else {
                col--;

            }

        }

        return count;

    }

    public static int findKSmallestNumber(int[][] mat, int k) {

        int n = mat.length;
        int low = mat[0][0];
        int high = mat[n - 1][n - 1];
        int ans = 0;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            int count = countSmallerEqual(mat, mid);

            if(count < k) {
                low = mid + 1;

            } else {
                ans = mid;
                high = mid - 1;

            }

        }

        return ans;

    }

    public static ArrayList<Integer> findCommonElementsInSortedArrays(int[] arr1, int[] arr2, int[] arr3) {

        /*
         * Given 3 sorted non decreasing arrays, print the common elements in non decreasing order across these arrays, if there are no such elements return an
         * empty array or -1
         * 1.) HashSet O(b + c) time and O(a) space
         * 2.) 3 pointer technique O(a + b + c) and O(1) space
         */

        int p1 = 0;
        int p2 = 0;
        int p3 = 0;

        ArrayList<Integer> res = new ArrayList<>();

        while(p1 < arr1.length && p2 < arr2.length && p3 < arr3.length) {
            if(arr1[p1] == arr2[p2] && arr2[p2] == arr3[p3]) {
                res.add(arr1[p1]);
                p1++;
                p2++;
                p3++;

            } else if (Math.min(Math.min(arr1[p1], arr2[p2]), arr3[p3]) == arr1[p1]) {
                p1++;

            } else if (Math.min(Math.min(arr1[p1], arr2[p2]), arr3[p3]) == arr2[p2]) {
                p2++;

            } else {
                p3++;

            }

        }

        return res;

    }

    public static int ceilingSearch(int[] arr, int target) {
        /*
         * Given a sorted array return the smallest number than is greater than or equal to x 
         * Use binary search to find number.
         * 
         * Since the array is sorted we can use linear search or binary search. Since binary search is the optimized solution 
         * we implemented that. Since we are finding the smallest number that is GREATER than or EQUAL to the target we set 'index'
         * to mid since it is the potential answer.
         */

        int n = arr.length;
        int left = 0;
        int right = n - 1;
        int index = 0;

        while(left <= right) {
            int mid = left + (right - left)/2;

            if(arr[mid] == target) {
                index = mid + 1;
                break;

            } else if (arr[mid] > target) {
                right = mid - 1;
                index = mid;
                
            } else {
                left = mid + 1;
            } 

        }

        if(index >= arr.length) {
            index = -1;
        } 

        return index;

    }

    public static int findFloor(int[] arr, int target) {

        int n = arr.length;
        int left = 0;
        int right = n - 1;
        int index = 0;

        while(left <= right) {

            int mid = left + (right - left) / 2; /*this formula is used to avoid integer overflow. Maximum integer type is 2^31 - 1 for 32bit signed integer
                                                    this formula is safe from that */

            if(arr[mid] == target) {
                index = mid - 1;
                break;

            } else if (arr[mid] > target) {
                right = mid - 1;

            } else {
                left = mid + 1;
                index = mid;
            }

        }

        if(index < 0) {
            index = -1;
        
        }

        return index;

    }

    public static int bitonicPoint(int[] arr) {
        /*
         * Given an array that is initially strictly increasing then strictly decreasing, your task is to find the bitonic point (maximum value). The bitonic point
         * is the point which before it values are strictly increasing and the after it are strictly decreasing in this particular array. Basically find the point in this
         * array where the values on the left and right are less than the middle. We can solve this in O(n) time simply by finding the largest number but we can 
         * optimize it using binary search O(log n). We find mid at each iteration then our goal it to go to the side that is larger so if mid + 1 is larger move the left pointer,
         * if mid - 1 is larger move the right pointer, otherwise middle is the largest element. Edge cases are dealt wealth in the condition. The first 2 conditions only 
           check for mid + 1 or mid - 1 if there in the range.

           O(log n) time and O(1) auxiliary space
         */

        int n = arr.length;
        int largest = Integer.MIN_VALUE;
        int left = 0;
        int right = n - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if(mid + 1 < arr.length && arr[mid + 1] > arr[mid]) {
                left = mid + 1;

            } else if(mid - 1 > 0 && arr[mid - 1] > arr[mid]) {
                right = mid - 1;

            } else {
                largest = arr[mid];
                return largest;

            }
            
        }

        return largest;

    }

    public static ArrayList<Integer> morethanNbyK(int[] arr, int k) {

        Arrays.sort(arr); //n log n

        //9, 10, 7, 9, 2, 9, 1
        
        ArrayList<Integer> res = new ArrayList<>();
        int freq = 0;
        int n = arr.length;

        for(int i = 1; i < arr.length; i++) { //O(n)
            if(arr[i - 1] == arr[i] && freq < 2) {
                freq = 2;

            } else if (arr[i - 1] != arr[i]) {
                freq = 1;

            } else {
                freq++;

            }

            if(freq == n/k + 1) {
                res.add(arr[i]);
                
            }

        }

        return res;  

    }

    public static ArrayList<Integer> morethanNbyK2(int[] arr, int k) {

        Arrays.sort(arr); //n log n

        //9, 10, 7, 9, 2, 9, 1
        
        ArrayList<Integer> res = new ArrayList<>();
        int freq = 0;
        int prev = arr[0];
        int n = arr.length;

        for(int i = 0; i < arr.length; i++) { //O(n)
            if(prev == arr[i]) {
                freq++;

            } else {
                prev = arr[i];
                freq = 1;

            }

            if(freq == n/k + 1) {
                res.add(arr[i]);

            }

        }

        return res;  

    }

    public static void main(String[] args) {
        int arr[] = {9, 10, 7, 9, 2, 9, 10};
        System.out.println(morethanNbyK2(arr, 3));

    }

}

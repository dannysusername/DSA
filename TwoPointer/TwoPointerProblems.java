package TwoPointer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Arrays;



public class TwoPointerProblems{
/* 
Two pointer is a technique used for sorting, searching and optimization problems that helps reduce time complexity from O(n^2) to O(n) and O(nlogn). 
It is used for problems like TwoSum, merging sorted arrays
*/

    public static int RemoveAllOccurences(int[] arr, int ele) {
        /* given int[] and ele remove all occurences of ele in int[] in place and
        return number of elements not equal to ele 
        
        ex. input = [3, 2, 2, 3], ele = 3, output = 2
        for loop
        You just need one pointer to keep track of non elements then replace the non elements with the pointer O(n)
        
        */

        int pointer = 0;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != ele) {
                arr[pointer] = arr[i];


                pointer++;
            }

        }

        for(int x : arr) {
            System.out.print(x + ", ");
        }

        return pointer;

    }

    public static int removeDuplicatsSorted(int[] arr) {

        /*
        Given a sorted array, rearrange array so that all distinct elements are at the beginning in sorted order, return length of distinct sorted 
        subarray int d, keeps track of distinct sorted subarray length;

        1. We can use a hashset to add elements and if hashset does not contain the element then add to array at idx, then incremement idx. O(n) time O(n)
        space. HashSet removes duplicates but does not sort elements.
        2. Since the array is sorted we just need to check if the previous element is the same as arr[i] if its not then add it to array at d distinct
        element tracker

        */  

        int d = 0;
        int prev = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            
            if (prev != arr[i]) {
                arr[d++] = arr[i];
                prev = arr[i];
                
            }

        }

        return d;

    }

    public static void reverseString(String string) {
        /* Reverse string and preserve the position of spaces, ex. "internship at geeks for geeks" output: skeegrofsk ee gtapi hsn retni
         * 1.) This implementation first puts the characters into an array, then gets the spaces and puts them into another array in those positions. We have 
         * the length saved in a variable(j), then we iterate through a loop(i) from 0 -> string length, if the char array is a letter and not a space then
         * next we check does is result a space in this position? If it is decrement or move to the next value else skip. Then add  the value that is at
         * position i to result j. This implementation is O(n) space, and O(n) time
         */
        
        char[] stringChars = string.toCharArray(); //stringchars just holds the array of chars of the 'string'
        char[] result = new char[stringChars.length]; //result array holds spaces and there correct location which was directed by below for loop

        //this for loop iterates through the char[] array with the 'string' characters and finds the spaces and adds them to result array
        for(int i = 0; i < stringChars.length; i++) {//O(n)

            if(stringChars[i] == ' ') {
               result[i] = ' ';

            }

        }

        int j = stringChars.length - 1; // saves last element
       
         for(int i = 0; i < stringChars.length; i++) { 

            if(stringChars[i] != ' ') { // if the char array is not a space (letter), because we only care about the spaces in result which are in the correct position

                if(result[j] == ' ') { // if we are at the space in result then go over it 
                    j--;
                }

                result[j] = stringChars[i]; //place value in position j
                j--; //move to next position in result
            }

        } 

        System.out.println(String.valueOf(result));

    }

    /* Auxiliary space is extra space used by an algorithm beyond the space required to store the input data and output.
     * Space Complexity, represents the total space an algorithm uses, including input space and Auxiliary and output 
     */

    public static void reverseString2(String string) {
        /* Reverse string and preserve the position of spaces, ex. "internship at geeks for geeks" output: skeegrofsk ee gtapi hsn retni
         * This implementation removes space to make it constant
         */
        
        int i = 0;
        int j = string.length() - 1;

        char[] stringArr = string.toCharArray(); //Auxiliary Space because it is assumed that the input is mutable, or treats char[] creation as part of input (Geeks for Geeks)

        while(i <= j) {

            if(stringArr[i] == ' ') {
               stringArr[i] = ' ';
               i++;

            } else if (stringArr[j] == ' ') {
               stringArr[j] = ' ';
               j--;

            } else {
                char temp = stringArr[j];
                stringArr[j] = stringArr[i];
                stringArr[i] = temp;
                i++;
                j--;

            }

        }

        System.out.println(String.valueOf(stringArr));

    }

    public static int[] dutchNatFlag1(int [] arr) {

        /*Given an input of numbers (0's 1's and 2's) sort the numbers such that 0's come first, then 1's then 2's
        Input: arr[] = {0, 1, 2, 0, 1, 2}
        {0, 0, 2, 1, 1, 2}
        Output: {0, 0, 1, 1, 2, 2}
        */

        // 1 Brute force o(n^2) - Selection Sort
        // 2 Effecient sorting - Merge Sort, QuickSort O(n log n)
        // 3 Count amount of 1's 2's and 3's then refill array O(n) but theres 4 for loops
        // 4 Use 3 pointers and conditions on one pass

        for(int i = 0; i < arr.length - 1; i++) {

            int min = i;

            for(int j = i; j < arr.length; j++) {
               
                if(arr[j] < arr[min]) {
                    min = j;

                }

            }

            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;       

        }

        return arr;

    }

    public static int[] dutchNatFlag2(int [] arr) {
        // 

        int zero = 0;
        int one = 0;
        int two = 0;

        for(int i = 0; i < arr.length; i++) {

            if(arr[i] == 0) {
                zero++;

            } else if (arr[i] == 1) { 
                one++;

            } else {
                two++;

              }

        }

        int idx = 0;

        for(int q = 0; q < zero; q++) {
            arr[idx++] = 0;
        }

        for(int w = 0; w < one; w++) {
            arr[idx++] = 1;
        }

        for(int e = 0; e < two; e++) {
            arr[idx++] = 2;

        }  

        return arr;

    }

    public static void dutchNatFlag3(int[] arr) {

        //  0, 1, 2, 0, 1, 2
        //     lo
        //       mid    hi

        //lo
        int n = arr.length;
        int lo = 0;
        int mid = 0;
        int hi = n - 1;

        while(lo <= hi) {

            if(arr[mid] == 0) {
                swap(arr, mid, lo);
                lo++;
                mid++;

            } else if (arr[mid] == 1){
                mid++;

            } else {
                swap(arr, mid, hi);
                hi--;
            }

        }

    }

    public static boolean pairSumSortedAndRotated(int[] arr, int target) {

        /*
        Given an array that is sorted and then rotated around an unknown pivot the task is to see
        if there exists a pair of elements in the array whose sum is equal to target
        1 HashTable saved complements of each element then a for loop iterates through the array and executes .contains
        2 This implementation - find the pivot the largest element and then the smallest then compare from there. if smaller than target then 
        decrement smallest, if larger than target increment largest
        */

        int n = arr.length;
        int min = 0;

        for(int i = 0; i < arr.length; i++) {

            if(arr[i] < arr[min]) {
                min = i;
            }

        }

        int d = min;
        int t = (min - 1 + n) % n;

        while(d != t) {

            if(arr[d] + arr[t] == target) {
                return true;

            } else if(arr[d] + arr[t] > target) {
                t = (t - 1 + n) % n;

            } else {
                d = (d + 1 + n) % n;

            }

        }

        return false;

    }

    public static List<Integer> PairSumClosestToTarget(int[] arr, int target) {
       /* Given an array and a target find a pair of elements that are closest to the target, if there are multiple pairs then
        return the pair with the maximum absolute difference. If no such pair exists return an empty array
        Input: arr[] = [10, 30, 20, 5], target = 25
        Output: [5, 20]

        Input: arr[] = [5, 2, 7, 1, 4], target = 10
        Output: [2, 7]

        sorted = [1, 2, 4, 5, 7]

        O(n log n + n)

     */  
        
        int n = arr.length;
        Arrays.sort(arr);
        List<Integer> res = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;

        int left = 0, right = n - 1;

        while (left < right) {
            int currSum = arr[left] + arr[right];

            // Check if this pair is closer than the closest
            // pair so far
            if (Math.abs(target - currSum) < minDiff) {
                minDiff = Math.abs(target - currSum);
                res = Arrays.asList(arr[left], arr[right]);
            }

            // If this pair has less sum, move to greater values
            if (currSum < target)
                left++;

            // If this pair has more sum, move to smaller values
            else if (currSum > target)
                right--;

            // If this pair has sum = target, return it
            else
                return res;
        }

        return res;
      
    }

    public static int binarySearch(int[] arr, int target, int left, int right) {

        int closest = Integer.MAX_VALUE;

        while(left <= right) {

            int mid = (right + left) / 2;

            if(arr[mid] == target) {
                return arr[mid];

            } else if (target < arr[mid]) {
                right = mid - 1;

            } else {
                left = mid + 1;

            }

            closest = arr[mid];

        }

        return closest;

    }

    public static int[] printClosest(int[] arr1, int[] arr2, int target) {
        /*Given two arrays the task is to find two numbers i and j such that arr1[i] + arr2[j] - x is minimum.
        Input:  arr1[] = {1, 4, 5, 7};
            arr2[] = {10, 20, 30, 40};
            x = 32
        Output:  1 and 30
        Input:  arr1[] = {1, 4, 5, 7};
            arr2[] = {10, 20, 30, 40};
            x = 50      
        Output:  7 and 40

        This function runs on O(n) time with O(n) space, first merge the two sorted arrays by simply using two pointers and auxiliary array and comparing the values. Then
        iterate through the merged array and at each element of the first array get the complement. Using Binary Search search the second half of array to find the closest 
        number to the complement. To do this, compare absolute values of closest and save the closest value to the complement. At each iteration the number that has the lowest
        absolute value difference between closest and arr[i] is saved.  

        */
        int n = arr1.length;
        int m = arr2.length;

        int p1 = 0;
        int p2 = 0;
        int p3 = 0;

        int[] arr3 = new int[m + n];

        while(p1 < n && p2 < m) {

            if(arr1[p1] <= arr2[p2]) {
                arr3[p3] = arr1[p1];               
                p3++;
                p1++;

            } else {
                arr3[p3] = arr2[p2];                
                p3++;
                p2++;

            }

        }

        while(p1 < n) {
            arr3[p3] = arr1[p1];
            p3++;
            p1++;

        }    

        while(p2 < m) {
            arr3[p3] = arr2[p2];
            p3++;
            p2++;
            
        }

        //Just merged array now we 

        //1 4 5 7 10 20 30 40 , find two pairs that abs value are closest to 32 when subtracted by 32
        //iterate through array. find element closest to its complement. the element with the min difference gets returned. make sure numbers are from diff array

        int diff = Integer.MAX_VALUE;

        int[] result = new int[2];

        for(int i = 0; i < n; i++) {

            int complement = target - arr3[i];
            int closest = findClosest(arr3, n, m + n - 1, complement);
            
            if(Math.abs((arr3[i] + closest) - target) < diff) {
                diff = Math.abs((arr3[i] + closest) - target);
                result[0] = arr3[i];
                result[1] = closest;

            }

        }

        return result;

    }

    public static int findClosest(int[] arr, int l, int r, int complement) {
        //Binary Search O(log n)

        int closest = arr[l];

        while(l <= r) {
            int mid = (l + r) / 2;

            if(Math.abs(arr[mid] - complement) < Math.abs(closest - complement)) {
                closest = arr[mid];

            } else if (Math.abs(arr[mid] - complement) == Math.abs(closest - complement)){
                closest = Math.max(closest, arr[mid]);
            }

            if(arr[mid] == complement) {
                return arr[mid];

            } else if (complement > arr[mid]) {
                l = mid + 1;

            } else {
                r = mid - 1;
            }

            }

            return closest;       

    }

    public static void findClosest2(int[] arr1, int[] arr2, int target) {
        /*This function finds a pair of numbers each from a sorted array whos sum is closest to the target. This is solved using a two pointer technique. The way it works is that
        there are two pointers. One is on the farthest left of the first array and the second the farthest right on the second array. The total abs value of the pair is calculated and the difference is 
        saved. The lowest diff is saved. This continues until left or right are traveresed. If a pair is greater than target then right is decreased if pair is less than target left is increased.
        results are printed with a println statement. O(n) time O(1) auxiliary space
        */
    

        int diff = Integer.MAX_VALUE;
        int left = 0; 
        int right = arr2.length - 1;
        int res_l = 0;
        int res_r = 0;

        while(left < arr1.length && right >= 0) {

            if(Math.abs(arr1[left] + arr2[right] - target) < diff) {
                diff = Math.abs(arr1[left] + arr2[right] - target);
                res_l = arr1[left];
                res_r = arr2[right];

            }

            if((Math.abs(arr1[left] + arr2[right]) > target)) {
                right--;

            } else {
                left++;

            }

        }

        System.out.println("This pair is closest to " + target + " : " + res_l + ", " + res_r);

        
    }

    public static int binarySearch2(int ar2[], int left, int right, int x) {
        if (left > right)
            return left-1;
        int mid = (left + right) / 2;
        if (ar2[mid] == x)
            return mid;
        else if (ar2[mid] > x)
            return binarySearch2(ar2, left, mid-1, x);
        else
            return binarySearch2(ar2, mid+1, right, x);
    }

    public static int smallestSubArraySum(int[] arr, int x) {

        /* Given an array of numbers and x, find the smallest length subarray that sum is strictly greater than x
         *  Input: x = 51, arr[] = [1, 4, 45, 6, 0, 19]
            Output: 3
            Explanation: Minimum length subarray is [4, 45, 6]

            Input: x = 100, arr[] = [1, 10, 5, 2, 7]
            Output: 0
            Explanation: No subarray exist
         */
        int p1 = 0;
        int p2 = 0;
        
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        while(p2 < arr.length) {

            //if sum is less than target
            while(p2 < arr.length && sum <= x) {
                sum += arr[p2++];

            }

            if(p2 == arr.length && sum <= x) {
                break;

            }

            //if the first pointer be subtracted
            while(p1 < p2 && sum - arr[p1] > x) {
                sum -= arr[p1++];

            }

            minLength = Math.min(minLength, p2 - p1);    

            sum -= arr[p1];
            p1++;

        }

        if(minLength == Integer.MAX_VALUE || minLength == arr.length) {
            return 0;
        }

        return minLength; 

    }

    static int smallestSubWithSum(int x, int[] arr) {
        int n = arr.length;

        int res = Integer.MAX_VALUE;
        int[] preSum = new int[n + 1];

        // Compute the prefix sums
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + arr[i - 1];
        }

        // Iterate through each starting index
        for (int i = 1; i <= n; i++) {
          
            // Target sum for current subarray
            int toFind = x + preSum[i - 1] + 1;

            // Find the first prefix sum > target
            int bound = Arrays.binarySearch(preSum, toFind);
            if (bound < 0) {
                bound = -(bound + 1);
            }

            if (bound <= n) {
                int len = bound - (i - 1);
                res = Math.min(res, len);
            }
        }

        // If subarray does not exists
        if (res == Integer.MAX_VALUE) return 0;

        return res;
    }

    /*
    Given an even sized arr[] of length n. A dominant pair (i, j) is defined as i: belongs to the first half of the array, j belongs to the
    second half. The value at index i is atleast 5 times the value at index j, arr[i] >= 5 * arr[j], the task is to find the total amount of dominant pairs
    in the array.
    */
    public static int dominantPairs(int[] arr) {
        //Brute Force O(n^2)

        int ans = 0;
        int n = arr.length;

        int i = 0;
        int j = arr.length/2;

        while(i < n/2) {

            while(j < arr.length) {

                if(arr[i] / arr[j] >= 5) {
                    ans++;
                }

                j++;

            }
            j = 0;
            i++;

        }

        return ans;

    }

    public static void main(String[] args) {

        int[] arr = {10, 8, 2, 1, 1, 2};

        System.out.println(dominantPairs(arr));
       
    }

     public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;

    }

}   


public class WST {

    /*
     * There are two types of sliding windows:
     * 1. Fixed sliding window
     *      Find the size of the window and compute the result for the 1st window, then increment the window and compute until you reach the end.
     *      Two for loops O(n^2)
     * 
     * 2. Variable sliding window
     *      For finding the maximum number in a subarray of length k, you add the next number and subtract and first number. Variable sliding window aloo can be used 
     *      if a condition doesnt match and shrinking the size of the window by the left pointer . If condition satisfies the right pointer is increased. 
     *      Basically this uses pointers to allow for O(n) traversal
     *      
     */

    public static int maxSumOfArray(int[] array, int length, int k) {
        /*
         * Given an array and a number K find the max sum of subarray in the given array of size k. A subarray is a contiguous part of an array. (Sequence of elements from 
         * the original array that are adjacent to each other) This implementation has a worst case time complexity of O(nxk)
         */

        int maxSum = Integer.MIN_VALUE;
        int last = k - 1;

        for(int i = 0; i < length - k + 1; i++) { 
            int sum = getSum(array, i, last);
            if(sum > maxSum) {
                maxSum = sum;
            }
            last++;
            
        }

        return maxSum;

    }

    public static int getSum(int[] array, int first, int last) {

        int result = 0;

        for(int i = first; i < last + 1; i++){
            result = array[i] + result;

        }

        return result;

    }

     static int maxSum(int arr[], int n, int k){ 
        //G4G version just makes the maxSum the numbers from index 0 - k, then adds the next number and 
        //subtracts the first number, checks if the sum is greater than max

        // n must be greater
        if (n <= k) {
            System.out.println("Invalid");
            return -1;
        }

        // Compute sum of first window of size k
        int max_sum = 0;
        for (int i = 0; i < k; i++)
            max_sum += arr[i];

        // Compute sums of remaining windows by
        // removing first element of previous
        // window and adding last element of
        // current window.
        int window_sum = max_sum;
        for (int i = k; i < n; i++) {
            window_sum += arr[i] - arr[i - k];
            max_sum = Math.max(max_sum, window_sum);
        }

        return max_sum;
    }

    public static int maxSumEffecient(int[] arr, int k) {
        /*
         * Here the time complexity is O(n) and space O(1) so only one pass will occur. You set first and last
         * variables to 0 and k - 1 respestively. First you get the sum of the first k numbers(0 - (k - 1)) then after that you subtract the 'first' number
         * and add the the number after the last number. This allows you to not have to iterate through first to last at each iteration of the first for loop.  
         */

        int length = arr.length;

        int maxSum = 0;
        int currentSum = 0;
        
        int first = 0;
        int last = k - 1;

        if(length < k) {
            System.out.println("Invalid");
            return -1;
        }

        for(int i = 0; i < arr.length; i++) {
            if(i > last) {
                if(currentSum > maxSum) {
                    maxSum = currentSum;
                }
                currentSum = currentSum - arr[first] + arr[last + 1];
                first++;
                last++;

            } else {
                currentSum += arr[i]; // 6
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {

        int arr[] = {1, 4, 2, 10, 23, 3, 1, 0, 20};
        int arr2[] = {5, 2, -1, 0, 3};
        int k = 3;

        int length = arr2.length;
        System.out.println("The max sum of this array part of a subarray is " + maxSum(arr2, length, k));


    }

    
}
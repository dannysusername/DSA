package Arrays;
import java.util.Arrays;
import java.lang.reflect.Array;
import java.util.*;

public class ArrayProblems{

    public static int getSecondLargest(int[] arr){
        int n = arr.length;

        Arrays.sort(arr);

        for(int i = n - 2; i >= 0; i--){
            if(arr[i] != arr[n - 1]){
                return arr[i];
            }
        }

        return -1;
    }

    public static int getThirdLargest(int[] arr){

        int n = arr.length;

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        int thirdLargest = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            if(arr[i] > largest){
                thirdLargest = secondLargest;
                secondLargest = largest;
                largest = arr[i];

            } else if (arr[i] > secondLargest) {
                thirdLargest = secondLargest;
                secondLargest = arr[i];

            } else if (arr[i] > thirdLargest) {

                thirdLargest = arr[i];

            } 

        }

        if(thirdLargest == Integer.MIN_VALUE){
            return -1;
        } else {
            return thirdLargest;
        }

    }

    public static int maximumProductOfATriplet(int[] arr) {

        int largestNumber = Integer.MIN_VALUE;
        int secondLargestNumber = Integer.MIN_VALUE;
        int thirdLargestNumber = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++){

            if(arr[i] > largestNumber){
                thirdLargestNumber = secondLargestNumber;
                secondLargestNumber = largestNumber;
                largestNumber = arr[i];

            } else if (arr[i] > secondLargestNumber) {
                thirdLargestNumber = secondLargestNumber;
                secondLargestNumber = arr[i];

            } else if (arr[i] > thirdLargestNumber) {
                thirdLargestNumber = arr[i];

            }

        }

        // { -6, -10, -2, -1, -20 }

        return largestNumber * secondLargestNumber * thirdLargestNumber;


    }

    public static ArrayList<Integer> leadersInArray(int[] array){

        // [16, 17, 4, 3, 5, 2]
        int index = 0;
        ArrayList<Integer> leaders = new ArrayList<>();

        for(int i = 0; i < array.length; i++){

            if(array[index] < array[i]){
                index++;
                i = index;
            } else if (i == (array.length - 1)){
                leaders.add(array[index]);
                i = index;
                index++;
            }

        }

        return leaders;

    }

    public static ArrayList<Integer> suffLeadersInArray(int[] array) {

        ArrayList<Integer> suffLeadersInArray = new ArrayList<>();

        int n = array.length;
        int maxRight = array[n - 1];
        suffLeadersInArray.add(maxRight);

        for(int i = n - 2; i >= 0; i--){
            if(array[i] > maxRight){
                suffLeadersInArray.add(array[i]);
                maxRight = array[i];
            }
        }

        Collections.reverse(suffLeadersInArray);

        return suffLeadersInArray;

    }

    public static boolean isArraySorted(int[] array, int n){

        // [10, 20, 40, 50, 60]

        if(n == 0 || n == 1){
            return true;
        }


        return array[n - 1] >= array[n - 2] && 
            isArraySorted(array, n - 1);

    }

    public static int removeDuplicatesFromSortedArray(int[] array){

        // 1, 2, 2, 3, 4, 4, 4, 5, 5
        int n = array.length;

        if(n <= 1){
            return n;
        }

        int idx = 1;

        for(int i = 1; i < n; i++){

            if(array[i] != array[i - 1]){
                array[idx++] = array[i];
            }

        }

        return idx;

    }

    public static void generatingAllSubArrays(ArrayList<Integer> array){

        int n = array.size();

        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                for(int k = i; k <= j; k++){
                    System.out.println(array.get(k));
                }
                System.out.println();
            }
        }

    }

    public static void recursiveSubArrays(int[] array, int start, int end){

        if (end == array.length){
            return;

        } else if(start > end) {
            recursiveSubArrays(array, 0, end + 1);

        } else {
            System.out.print("[");
            for(int i = start; i < end; i++){
                System.out.print(array[i] + ", ");
            }
            System.out.println(array[end] + "]");
            recursiveSubArrays(array, start + 1, end);

        }
        return;

    }

    public static int[] reverseArray(int[] array){
        int[] reversedArray = array;
        int start = 0;
        int end = array.length - 1;

        while(start < end){
            int temp = reversedArray[end];
            reversedArray[end--] = reversedArray[start];
            reversedArray[start++] = temp;

        }

        return reversedArray;

    }

    public static void recursiveReverseArray(int[] array, int start, int end){
        
        if(start >= end){
            return;
        }

        int temp = array[end];
        array[end] = array[start];
        array[start] = temp;
        
        recursiveReverseArray(array, ++start, --end);

    }

    public static void rotateArrayCW(int[] array, int d){

        int n = array.length;
        

        for(int i = 0; i < 2; i++){
            int temp1 = 0;
            int temp2 = array[0];
            for(int j = 0; j < n; j++){
                temp1 = array[(j + 1) % n];            
                array[(j + 1) % n] = temp2;           
                temp2 = temp1;            
            }

        }  
        //[1, 2, 3, 4, 5, 6]
         //[1, 1, 3, 4, 5, 6] temp1 = 2; temp2 = 2; i = 0;
         //[1, 1, 2, 4, 5, 6] temp1 = 3; temp2 = 3; i = 1;
         //[1, 1, 2, 3, 5, 6] temp1 = 4; temp2 = 4; i = 2;
         //[1, 1, 2, 3, 4, 6] temp1 = 5; temp2 = 5; i = 3;
         //[1, 1, 2, 3, 4, 5] temp1 = 6; temp2 = 6; i = 4;
         //[6, 1, 2, 3, 4, 5] temp1 = 1; temp2 = 1; i = 5;

    }

    public static void rotateArrayCCW(int[] array, int d){

        int n = array.length;

        for(int i = 0; i < d; i++){
            int temp1 = 0;
            int temp2 = array[n - 1];

            for(int j = n - 1 ; j > 0; j--){
                temp1 = array[(j - 1) % n];            
                array[(j - 1) % n] = temp2;           
                temp2 = temp1;

            }

        }  
        //[1, 2, 3, 4, 5, 6]
         //[1, 1, 3, 4, 5, 6] temp1 = 2; temp2 = 2; i = 0;
         //[1, 1, 2, 4, 5, 6] temp1 = 3; temp2 = 3; i = 1;
         //[1, 1, 2, 3, 5, 6] temp1 = 4; temp2 = 4; i = 2;
         //[1, 1, 2, 3, 4, 6] temp1 = 5; temp2 = 5; i = 3;
         //[1, 1, 2, 3, 4, 5] temp1 = 6; temp2 = 6; i = 4;
         //[6, 1, 2, 3, 4, 5] temp1 = 1; temp2 = 1; i = 5;

    }

    public static int[] tempArrayRotate(int[] array, int d){

        int n = array.length;
        int[] temp = new int[n];

        d %= n;
 
            for(int i = 0; i < d; i++) {
                temp[i] = array[n - d + i];
            }

            for(int i = 0; i < n - d; i++) {
                temp[i + d] = array[i]; 
            }

            for(int i = 0; i < n; i++){
                array[i] = temp[i];
            }

            return array;
        

    }

    public static void JugglingAlgorithm(int[] array, int d){

       
        int n = array.length;
        int nextEle;
        int currEle = array[0];
        d %= n;

        for(int i = 0; i < n/2; i++){
            nextEle = array[((i * d) + d) % n];
            array[((i * d) + d) % n] = currEle;
            currEle = nextEle;
            
        }

    }

    public static void moveZerosToEnd(int[] array){

        int curIdx = 0;

        for(int i = 0; i < array.length; i++){

            if(array[i] != 0){
                int temp = array[curIdx];
                array[curIdx] = array[i];
                array[i] = temp; // 0
                curIdx++;
            } 

        }

    }

    public static int minIncByKOperations(int array[], int k){

        int largestNum = array[0];

        for(int i = 0; i < array.length; i++){
            if(array[i] > largestNum){
                largestNum = array[i];
            }

            if(array[i] % k != 0){
                return -1;
            }
        }

        int totalOperations = 0;

        for(int i = 0; i < array.length; i++){

            if(array[i] != largestNum){
                int total = (largestNum - array[i]);
                totalOperations += total/k;
            }

        }

        return totalOperations;

    }

    public static int minSumOfCosts(int[] array){
        
        int smallestNumber = array[0];
        int smnIdx = 0;
        int n = array.length;

        for(int i = 0; i < n; i++){
            if(array[i] < smallestNumber){
                smallestNumber = array[i];
                smnIdx = i;
            }
        }

        int cost = (n - 1) * smallestNumber;

        return cost;

    }

    public static void printAltElements(int[] array, int i){
        
        if(i >= array.length){
            return;
        }

        System.out.println(array[i]);
        i += 2;
        printAltElements(array, i);
        
    }

    public static void printDistinctElementsSort(int[] array){

        int n = array.length - 1;
        quickSort(array, 0, n);

        for(int val : array){
            System.out.println("val: " + val);

        }

        int prev = Integer.MIN_VALUE;

        for(int i = 0; i < array.length; i++){

            if(array[i] != prev) {
                System.out.println(array[i]);
                prev = array[i];
            } else {
                prev = array[i];
            }

        }

    }

    public ArrayList<Integer> printDistinctElementsHashSet(int[] array){

        HashSet<Integer> set = new HashSet<>();

        for(int x : array){
            set.add(x);

        }

        return new ArrayList<>(set);   

    }

    public static boolean duplicateKDistanceArray(int[] array, int k){
        for(int i = 0; i < array.length; i++){

            for(int j = i; j <= k && i + j <= k; j++){

                if(array[i] == array[j]){
                    return true;
                }

            }

        }

        return false;

    }

    public static boolean checkDuplicates(int[] array, int k){

        HashSet<Integer> Set = new HashSet<>();

        for(int i = 0; i < array.length; i++){

            if(Set.contains(array[i])){
                return true;
            }

            Set.add(array[i]);

            if(i >= k){
                Set.remove(array[i - k]);
            }

        }

        return false;

    }

    public static int[] evenGreaterThanOdd(int[] array) {

        quickSort(array, 0, array.length - 1);
        
        int[] sortedArray = new int[array.length];

        int ptr = 0;
        int ptr2 = array.length - 1;

        for(int i = 0; i < sortedArray.length; i++){
            if((i + 1) % 2 == 0) {   
                sortedArray[i] = array[ptr2--];
            } else {
                sortedArray[i] = array[ptr++];
            }
        }

        return sortedArray;

    }

    public static int sumOfSubArrays(int[] array){

        
        int sum = 0;

        // [1, 2, 3]

        int n = array.length;

        for(int i = 0; i < n; i++){
            sum = sum + array[i] * (i + 1) * (n-i);

        }

        return sum;

    }

    public static int maximumProfit(int[] prices){

        int localMinima = prices[0];
        int localMaxima = prices[0];
        int sum = 0;

        int n = prices.length;

        int i = 0; 

        while(i < n - 1){

            while(i < n - 1 && prices[i] >= prices[i + 1]) { i++; }
            localMinima = prices[i];

            while(i < n - 1 && prices[i] <= prices[i + 1]) { i++; }
            localMaxima = prices[i];

            sum += (localMaxima - localMinima);

        }

        return sum;

    }

    //Brute force O(n^2)
    //Sort then compare adjacent elements

    public static int findUnique(int [] array){

        int n = array.length;

        quickSort(array, 0, n - 1); //O(n log n)

        for(int i = 0; i < n - 1; i++){ //O(n)

            if(array[i] != array[i + 1]){
                return array[i];
            }

        }

        return -1;

    }



    public static int findUnique1(int[] array){

        HashMap<Integer, Integer> map = new HashMap<>();

        //Puts all values from array to HashMap
        for(int num : array) {
            map.put(num, map.getOrDefault(num, 0) + 1);

        }

        //Checks for which key has one
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() == 1) {
                System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
                return entry.getValue();

            }
        }

        return -1;

    }

    public static int findUnique2(int[] array){

        int res = 0;

        for(int i = 0; i < array.length; i++){
            res ^= array[i];

        }

        return res;
            
    }

    //Brute force O(n^2)
    // 8 + 2 + 4 + 5 + 3 + 7 + 1 = 30;
    // 8 + 2 + 4 + 5 + 6 + 7 + 1 = 33;

    public static int missingNum(int[] array) {

        int n = array.length + 1;
        int sum = 0;

        for(int i = 0; i < array.length; i++){
            sum += array[i];

        }

        long expSum = n * (n + 1) / 2;

        return (int)expSum - sum;

    }


    //Finding duplicate
    //Brute force
    //Quicksort then compare O(n log n)
    //HashMap with key value then remove from array then finding missing O(N)
    public static void findTwoElements(int [] array) {

        //HashMap used to only add distinct numbers and to find the duplicate by using getOrDefault(array[i], 0) + 1, so when a duplicate is found it should be 2
        //since its the only value that gets +1 twice.
        //Then use enhanced for loop to iterate and calculate sum. Use expected sum formula to get expected sum. Subtracting exp sum from sum gives me the missing value.
        HashMap<Integer, Integer> map1 = new HashMap<>();

        for(int i = 0; i < array.length; i++){

            int x = (map1.getOrDefault(array[i], 0) + 1);
            map1.put(array[i], x);

            if (x == 2){
                System.out.println("Duplicate: " + array[i]);
            }

        }

        int n = array.length;

        int expSum = n * (n + 1) / 2;
        int sum = 0;

        for(Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            sum += entry.getKey();

        }

        System.out.println("Missing number: " + (expSum - sum));
    }

        //1 repetitive element, find it
        //Sort then compare elements O(n log n)
        //Add all to hashmap find through iteration using getOrDefault O(N)
        //Create frequency array of size N with all zeros, Traverse the frequency array from index 1 to n:
            //If any index has frequency 0, that index is our missing number
            //If any index has frequency 2, that index is our repeating number
        //Use mathematical approach finding sum, sum of squares and exp sum and exp sum of squares

    public static void findDuplicate(int[] array){
        
        int n = array.length;

        int[] freqArray = new int[n];

        for(int i = 0; i < freqArray.length; i++){
            freqArray[i] = 0;
        }

        for(int i = 0; i < freqArray.length; i++){
            freqArray[array[i]]++;
        }

        for(int i = 0; i < freqArray.length; i++){
            if(freqArray[i] == 2){
                System.out.println("Duplicate: " + array[i]);
            }
        }

    }   

    public static int findDuplicate2(int[] arr) {

        // slow pointer
        int slow = arr[0]; 

        // fast pointer
        int fast = arr[0]; 

        do {

            // moves one step
            slow = arr[slow];  

            // moves two steps
            fast = arr[arr[fast]];     
        } while (slow != fast);

        // reinitialize fast to the start
        fast = arr[0]; 
  
        // Loop until both pointers meet at the duplicate
        while (slow != fast) {
            slow = arr[slow];
            fast = arr[fast];
        }
  
       // Return duplicate number
        return slow;
    }

    public static int FloydCycleDetection(int[] array){

        int slow = array[0];
        int fast = array[0];



        //cycle detection
        //3, 1, 3, 4, 2

        try{
            do {

                slow = array[slow];
                fast = array[array[fast]];

            } while (slow != fast);
        } catch (IndexOutOfBoundsException x){

            System.out.println("Array elements are not 1-n or there is a missing number");
            return -1;
        }
        slow = array[0];

        while(slow != fast){
            slow = array[slow];
            fast = array[fast];

        }

        return slow;


    }

    public static int find3Numbers(int[] array){

        int n = array.length;

        int min = 0;
        //3 for loops 1 for smaller aux array, 1 for big aux array and 1 for printing the numbers

        //create for loop that iterates through and find a number that has a smaller number on its left and saved that numbers index if not put -1
        //make first number -1, 1 -> n, we need to set a min number which is index[1]

        int[] smallerArray = new int[n];
        smallerArray[0] = -1;

        for(int i = 1; i < n; i++) {

            //[12, 11, 10, 5, 6, 2, 30]

            if(array[i] <= array[min]){
                min = i;
                smallerArray[i] = -1;              

            } else {
                smallerArray[i] = min;

            }

        }

        int[] greaterArray = new int[n];
        greaterArray[n-1] = -1;

        int max = n - 1;

        for(int i = max - 1; i >= 0; i--){

            if(array[i] >= array[max]){
                greaterArray[i] = -1;
                max = i;

            } else {
                greaterArray[i] = max;

            }

        }

        for(int i = 0; i < n; i++){
            if(smallerArray[i] != -1 && greaterArray[i] != -1){
                System.out.println(array[smallerArray[i]] + " " + array[i] + " " + array[greaterArray[i]]);
                return i;
            }
        }

        return -1;
 
    }

    public static void find3Numbers2(int[] nums) 
    {
       
      // If number of elements < 3
      // then no triplets are possible
      if (nums.length < 3){
        System.out.print("No such triplet found");
        return;
      }
       
      // track best sequence length 
      // (not current sequence length)
      int seq = 1;        
       
      // min number in array
      int min_num = nums[0];  
       
      // least max number in best sequence 
      // i.e. track arr[j] (e.g. in 
      // array {1, 5, 3} our best sequence 
      // would be {1, 3} with arr[j] = 3)
      int max_seq = Integer.MIN_VALUE;      
       
      // save arr[i]
      int store_min = min_num;   
       
      // Iterate from 1 to nums.size()
      for (int i = 1; i < nums.length; i++) 
      {
        if (nums[i] == min_num)
          continue;
         
        else if (nums[i] < min_num) 
        {
          min_num = nums[i];
          continue;
        } 
         
        // this condition is only hit 
        // when current sequence size is 2
        else if (nums[i] < max_seq) {    
           
          // update best sequence max number 
          // to a smaller value 
          // (i.e. we've found a 
          // smaller value for arr[j])
          max_seq = nums[i];       
           
          // store best sequence start value 
          // i.e. arr[i]
          store_min = min_num;            
        } 
         
        // Increase best sequence length & 
        // save next number in our triplet
        else if (nums[i] > max_seq) 
        {    
          seq++;
           
          // We've found our arr[k]!
          // Print the output
          if (seq == 3) 
          {            
            System.out.println("Triplet: " + store_min +
                               ", " + max_seq + ", " + nums[i]);
            return;
          }
          max_seq = nums[i];
        }
      }
       
      // No triplet found
      System.out.print("No such triplet found");
    }

    public static void segregate0and1(int[] arr){

        int n = arr.length;

        int left = 0;
        int right = arr.length - 1;


        while(left < right){

            if(arr[left] == 1 && arr[right] == 0){
                swap(arr, left, right);
                continue;

            }

            if(arr[left] == 0){
                left++;
            }

            if(arr[right] == 1){
                right--;
            }

        }

    }

    //O(1) space, 
    //Negative numbers before positive integers
    //Order should be maintained 
   

    public static void quickSort(int[]array, int low, int high){
       
        if(low < high) {
           int partition = partition(array, low, high);

           quickSort(array, low, partition - 1);
           quickSort(array, partition + 1, high);

        }

    }

    public static int partition(int[] array, int low, int high){

        int pivot = array[high];
        int i = low - 1;

        for(int j = low; j <= high - 1; j++){
            if(array[j] < pivot){
                i++;
                swap(array, i, j);
            }

        }

        int position = i + 1;
        swap(array, position, high);

        return position;
    
    }

    public static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;

    }

    
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        int[] temp = new int[arr.length];
        mergeSortHelper(arr, 0, arr.length - 1, temp);
    }

    private static void mergeSortHelper(int[] arr, int left, int right, int[] temp) {
        if (left >= right) return;
        
        int mid = left + (right - left) / 2;
        mergeSortHelper(arr, left, mid, temp);
        mergeSortHelper(arr, mid + 1, right, temp);
        merge(arr, left, mid, right, temp);
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        // Copy to temp array
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }

        int i = left;      // Left subarray index
        int j = mid + 1;   // Right subarray index
        int k = left;      // Result array index

        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                arr[k++] = temp[i++];
            } else {
                arr[k++] = temp[j++];
            }
        }

        // Copy remaining elements from left subarray
        while (i <= mid) {
            arr[k++] = temp[i++];
        }
    }
    
        // Example usage

    public static void main(String[] args) {

        int arr[] = {12, 11, -13, -5, 6, -7, 5, -3, -6};
        int n = arr.length;

        mergeSort(arr);

        for (int ele: arr) {
        	System.out.print(ele + " ");
        }
        

    }

    

}


    


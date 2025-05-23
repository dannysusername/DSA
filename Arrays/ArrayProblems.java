package Arrays;
import java.util.Arrays;
import java.lang.reflect.Array;
import java.util.*;

//good sites: https://roadmap.sh/computer-science

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
    
    public static void waveForm(int[] array) {

        quickSort(array, 0, array.length - 1);

        int i = 0; 
        int j = i + 1;

        while(j < array.length) {   
            swap(array, i, j);
            i += 2;
            j += 2;
        }

    } 

    public static void waveForm2(int[] array) {

        for(int i = 2; i < array.length - 1; i+=2) {

            if(i > 0 && array[i] < array[i - 1]){
                swap(array, i, i - 1);

                if (i < array.length-1 && array[i] < array[i + 1]) {
                    swap(array, i, i + 1);
                }

            }   

        }

    }

    public static int maximumSubArraySum(int[] arr){

        //Kadens Algorithm

        int maxSum = arr[0];
        int maxSumEnding = arr[0]; 


       for(int i = 1; i < arr.length; i++){

            //i < 7 (1-6)

            //[2, 3, -8, 7, -1, 2, 3]
            //MaxEnding is the max sum of the subaarray that ends in element i. So to find maxEnding ask your self... does the previous
            //MaxEnding plus arr[i] > arr[i], if yes add arr[i] to maxEnding if not make maxSum and maxEnding = arr[i]
            //For i = 1 maxSumEnding = 2 and arr[i] = 3 so maxSumEnding + arr[i] = 5 which is greater than 3. maxSumEnding = 5, maxSum = 5;
            //For i = 2 maxSumEnding = 5 and arr[i] = -8 so maxSumEnding + arr[i] = -3 which is greater than -8. maxSumEnding = -3, maxSum = 5;
            //For i = 3 maxSumEnding = -3 and arr[i] = 7 so maxSumEnding + arr[i] = 4 which is NOT greater than 7. maxSumEnding = 7, maxSum = 7;
            //For i = 4 maxSumEnding = 7 and arr[i] = -1 so maxSumEnding + arr[i] = 6 which is greater than -1. maxSumEnding = 6, maxSum = 7;
            //For i = 5 maxSumEnding = 6 and arr[i] = 2 so maxSumEnding + arr[i] = 8 which is greater than 2. maxSumEnding = 8, maxSum = 8;
            //For i = 6 maxSumEnding = 8 and arr[i] = 3 so maxSumEnding + arr[i] = 11 which is greater than 3. maxSumEnding = 11, maxSum = 11;

            //Max Sum = 11

            //Max of maxSumEnding + arr[i] and arr[i] - "What is larger previous max sum ending at arr[i] plus arr[i] or the current element arr[i]"
            if(maxSumEnding + arr[i] > arr[i]){
                maxSumEnding += arr[i];

            } else {
                maxSumEnding = arr[i];
                maxSum = arr[i];

            }

            //Find max of maxSumEnding, MaxSum
            if(maxSumEnding > maxSum){
                maxSum = maxSumEnding;

            } 

       }

       return maxSum;

    }

    public static int KadensAlgorithm(int[] arr) {

        int maxSumEnding = arr[0];
        int maxSum = arr[0];

        for(int i = 1; i < arr.length; i++){

            maxSumEnding = Math.max(maxSumEnding + arr[i], arr[i]);

            maxSum = Math.max(maxSum, maxSumEnding);

        }

        return maxSum;

    }

    public static int maximumSubArraySumWithK(int[] arr, int k) {

        int maxSum = arr[0]; //maxSum found in subArray in arr 
        int maxEnding = arr[0]; //MaxSum in the subarray ending in current element; ex. i = 1 [-1, 10, 20] maxEnding = 10.

        for(int i = 1; i < (arr.length * k); i++){

            int f = (i % arr.length);

            //Find maxEnding 
            if(maxEnding + arr[f] > arr[f]){
                maxEnding = maxEnding + arr[f];
            } else {
                maxEnding = arr[f];
            }

            //Find maxSum
            if(maxEnding > maxSum) {
                maxSum = maxEnding;
            }

        }

        return maxSum;

    }

    public static int maximumProductSubArray(int[] arr){

        int currMin = arr[0];
        int currMax = arr[0];
        int maxProd = arr[0];

        //-2, 6, -3, -10, 0, 2

        for(int i = 1; i < arr.length; i++){

           int temp = max(arr[i], currMin * arr[i], currMax * arr[i]);
           currMin = min(arr[i], currMin * arr[i], currMax * arr[i]);

           currMax = temp;

           maxProd = Math.max(maxProd, currMax);

        }

        return maxProd;

    }

    public static int min(int a, int b, int c){
        return Math.min(a, Math.min(b, c));

    }

    public static int max(int a, int b, int c){
        return Math.max(a, Math.max(b, c));

    }

    public static int maxProductSubArray2(int[] arr) {

        int n = arr.length;
        int leftToRight = 1;
        int rightToLeft = 1;
        int maxProd = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++) {

            leftToRight *= arr[i];
            rightToLeft *= arr[n - i - 1];

            if(leftToRight == 0){
                leftToRight = 1;
            }

            if(rightToLeft == 0){
                rightToLeft = 1;
            }

            maxProd = Math.max(maxProd, Math.max(rightToLeft, leftToRight));

        }

        return maxProd;

    }

    public static void prefixSumArray(int[] arr, int[] prefixArray) {
        //O(N) time, O(N) space

       
        int sum = 0;

        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            prefixArray[i] += sum;
            
        }

    }

    public static int rangeSumQueries(int[] arr, int k, int j) {

        //O(N) time, O(1) space

        int sum = 0;


        for(int i = k; i <= j; i++) {
            sum += arr[i];

        }

        return sum;

    }

    public static int effRangeSum(int[] pre, int k, int j){

        //This method allows O(1) for each query time and O(N) overall cause of prefixSum which only executes once. O(N) space

        if(k == 0) {
            return pre[j];
        } else {
            return pre[j] - pre[k - 1];
        }

    }

    public static void suffixSumArray(int[] arr, int[] suff) {

        int sum = 0;

        for(int i = arr.length - 1; i >= 0; i--) {

            sum += arr[i];
            suff[i] += sum; 

        }

    }

    public static int findEquilibriumIneff(int[] arr) {
        //O(n^2)

        // {-7, 1, 5, 2, -4, 3, 0}

        for(int i = 0; i < arr.length; i++) {

            int leftSum = 0;

            for(int j = 0; j < i; j++){
                leftSum += arr[j];
            }

            int rightSum = 0;

            for(int k = i + 1; k < arr.length; k++) {
                rightSum += arr[k];
            }

            if(leftSum == rightSum) {
                return i;
            }

        }

        return -1;

    }

    
    public static int findEquilibrium(int[] arr){
        //O(N) time and O(N) space

        int n = arr.length;

        int[] prefixArr = new int[n];
        int[] suffixArr = new int[n];

        suffixSumArray(arr, suffixArr);
        prefixSumArray(arr, prefixArr);

        for(int i = 0; i < n; i++) {

            if(prefixArr[i] == suffixArr[i]){
                return i;
            }

        }

        return -1;

    }

    public static int findEquilibrium2(int[] arr){

        //Loop that compares PrefixArr(pivot - 1) and SuffixArr(pivot + 1)
        //pivot == i in loop
        int n = arr.length;

        int totalSum = totalSum(arr);

        for(int i = 0; i < n - 1; i++) {

            int pre = prefixSum(i, arr);
            int suf = suffixSum(i, arr, totalSum);

            if(pre == suf){
                return i;
            }


        }
        return -1;

    }

    public static int findEquilibrium3(int[] arr) {

        int totalSum = 0;
        int prefixSum = 0;

        for(int x : arr){
            totalSum += x;

        }

        for(int pivot = 0; pivot < arr.length; pivot++) {

            int suffSum = totalSum - prefixSum - arr[pivot];
            if (prefixSum == suffSum) {
                return pivot;
            }
            prefixSum += arr[pivot];

        }

        return -1;

    }

    public static int prefixSum(int p, int[] array) {

        int sum = 0;

        for(int i = 0; i <= p; i++){
            sum+= array[i];
        }

        return sum;

    }

    public static int totalSum(int[] arr){

        int total = 0;

        for(int i = 0; i < arr.length; i++){
            total += arr[i];
        }

        return total;

    }

    public static int suffixSum(int s, int[] arr, int total) {

        int sum = total;

        for(int i = 0; i < s; i++){
            sum-= arr[i];
        }

        return sum;

    }

    

    public static void main(String[] args) {

       int[] arr = {1, 7, 3, 6, 5, 6};

        System.out.println(findEquilibrium3(arr));

    }

}





    




    


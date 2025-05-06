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
               

    public static void main(String[] args) {

        int[] array = {2, 1, 2, 3, 7};
        
        System.out.println(duplicateKDistanceArray(array, 2) ? "Yes" : "No");

    }

}


    


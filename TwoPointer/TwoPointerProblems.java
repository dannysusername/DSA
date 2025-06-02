package TwoPointer;

import java.util.ArrayList;

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

    public static void main(String[] args) {

        String s = "internship at geeks for geeks";
        reverseString2(s);

    }


}   
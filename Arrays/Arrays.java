package Arrays;
import java.util.ArrayList;

public class Arrays {
    public static void main(String [] args){

        /*

        1. Arrays based on size

        Fixed sized array

        */

        int array[] = {1,2,3,4,5};
        
        int []array2 = new int[3];
         
        //Dynamically sized array memory is allocated and deallocated in these arrays
        
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(5);
        arr.add(2);
        arr.add(3);
        
        // [5, 2, 3]

        /*
        
        2. Arrays based on dimensions 

        One-dimensional Array

        */

        int row[] = {1, 2, 3, 4, 5};

        /*
        
        Multi-dimensional Array
            Used to store complex data in the form of tables. Can have 2-D arrays, 3-D arrays, 4-D arrays and so on.

        -Two Dimensional Array (2DArray or Matrix) considered array of arrays or as a matirx consisting of rows and columns
        */
     
        int[][] twodarray;

        twodarray = new int[2][2]; // 2 Dimensional fixed size array with 2 rows and 2 columns

        int[][] twodarray2 = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };

        /* 
        -Three Dimensional Array (3DArray) A 3-D Multidimensional Array contains three dimensions so it can be considered an array of two-dimensional arrays

        */

        int [][][] threedarray;

        threedarray = new int[3][3][3];

        int [][][] threedarray2 = {
            {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
            },
            {
                {13, 14, 15, 16},
                {17, 18, 19, 20},
                {21, 22, 23, 24}
            }
        };

        /* 

        3. Operations on Array - when arrays are created it occupies a continguous block of memory and elements are stored in an indexed manner

        =Array Traversal - accessing each element from start to end or in reverse by using a loop

        Types of array traversal:

        -Sequential Linear Traversal
        -Reverse Traversal

        =Insertion in Array - inserting a element at a specific position while mainting order of the existing elements, often requires shifting existing elements 
        to make space and updating the size. Depending on the position of the new element depends on the time complexity of the insertion operation.

        =Deleting in Array - deletion in an array involves shifting the elements to cover the element that needs to be deleted and updating the size.

        =Searching in Array - searches through an array to find a element in a list.

        -Linear Search(Sequential Search) - traverses array one element at a time and compares each element with target value, if match found returns index of the element

        -Binary Search(Effecient search for sorted arrays) - repeatedly divdes the search space in half until the target element is found




        */


    }


}


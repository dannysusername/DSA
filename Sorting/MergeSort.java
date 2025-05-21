package Sorting;

public class MergeSort {
    
    // //recursive merge sort O(n log n), made for large datasets and is a stable sorting algorithm meaning equal elements keep relative position

    public static void mergeSort(int[] array){
        if(array == null || array.length <= 1){
            return;
        }

        int[] temp = new int[array.length];
        mergeSortHelper(array, 0, array.length - 1, temp);

    }

    public static void mergeSortHelper(int[] array, int left, int right, int[] temp){

        if(left >= right) { //base case when there is only one element left(sorted)
            return;
        }

        int mid = left + (right - left) / 2;
        mergeSortHelper(array, left, mid, temp);
        mergeSortHelper(array, mid + 1, right, temp);
        merge(array, left, mid, right, temp);

    }

    public static void merge(int[] array, int left, int mid, int right, int[] temp){

        for(int i = left; i <= right; i++){
            temp[i] = array[i];
        }

        int i = left;
        int j = mid + 1;
        int k = left;

        while(i <= mid && j <= right){
            if(temp[i] <= temp[j]){
                array[k++] = temp[i++];
            } else {
                array[k++] = temp[j++];
            }
        }

        while(i <= mid){

            array[k++] = temp[i++];

        }

    }



    //these functions moves negative values to the left and positive ones to the right but keep the values
    //in the same relative position they were in originally. O(n) extra space

    static void rearrange(int[] arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;

            // Sort first and second halves
            rearrange(arr, l, m);
            rearrange(arr, m + 1, r);

            merge2(arr, l, m, r);
        }
    }

    static void mergeR(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        // create temp arrays 
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data to temp arrays L[] and R[] 
        System.arraycopy(arr, l, L, 0, n1);
        System.arraycopy(arr, m + 1, R, 0, n2);

        int i = 0, j = 0, k = l;

        // copy negative elements of left subarray
        while (i < n1 && L[i] < 0)

            arr[k++] = L[i++];

        // copy negative elements of right subarray
        while (j < n2 && R[j] < 0)
            arr[k++] = R[j++];

        // copy positive elements of left subarray
        while (i < n1)
            arr[k++] = L[i++];

        // copy positive elements of right subarray
        while (j < n2)
            arr[k++] = R[j++];
    }

    //these functions have the above purpose but with constant extra space

    static void reverse(int[] arr, int l, int r) {
        if (l < r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            reverse(arr, ++l, --r);
        }
    }

    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    static void merge2(int[] arr, int l, int m, int r) {
        int i = l; //beginning of left side
        int j = m + 1; //beginning of right side

        // find starting index of positive part in the 
        // first half i.e., find starting index of Lp
        while (i <= m && arr[i] < 0)
            i++;   

        // find ending index of negative part in the 
        // first second i.e., find ending index of Rn
        while (j <= r && arr[j] < 0)
            j++;
        j--;

        // reverse positive part of
        // left sub-array (arr[i..m])
        reverse(arr, i, m);

        // reverse negative part of
        // right sub-array (arr[m+1..j])
        reverse(arr, m + 1, j);

        // reverse arr[i..j]
        reverse(arr, i, j);
    }
   

}

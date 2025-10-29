

public class BinarySearch {
    
    public static void main(String [] args) {

        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(binarySearch(arr, 0, arr.length - 1, 2));

    }

    public static boolean binarySearch(int[] arr, int left, int right, int target) {
        //Used for sorted array, O log n

        while(left <= right) {

            int mid = (left + right) / 2;

            if(arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }

        return false;

    }

}

public class SlidingWindowProblems {

    final static int max_char = 26;
    
        public static String smallestSubstring2(String s, String t){
            /*
             * Leetcode problem
             */
    
            int minSubstringSize = Integer.MAX_VALUE;
    
            int indexA = -1;
            int indexB = -1;
            int indexC = -1;
    
            int minIndex = 0;
            int maxIndex = 0;
    
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == 'A') {
                    indexA = i;
                    
                } else if (s.charAt(i) == 'B') {
                    indexB = i;
    
                } else if (s.charAt(i) == 'C') {
                    indexC = i;
    
                }
    
                if(indexA != -1 && indexB != -1 && indexC != -1) {
                    int min = Math.min(indexA, Math.min(indexB, indexC));
                    int max = Math.max(indexA, Math.max(indexB, indexC));
                    int size = max - min + 1;
    
                    if(size < minSubstringSize) {
                        minSubstringSize = size;
                        minIndex = min;
                        maxIndex = max + 1;
                    }
                }
            }
    
            return s.substring(minIndex, maxIndex);
        }
    
        public static int smallestWindow(String S) {
    
             /*
                Variable sized window
             * Given a String S that consists of 0,1,2 (String only consists of 0,1,2)
             * Return the size of the smallest substring that contains 0, 1, 2 in String S
             * This algorithm requires variable window technique
             * 
             * In this problem I used variables to store index's when I encountered 0, 1 or 2. After
             * all the indexes were filled there is a for loop that checks the size of the window by computing
             * (maxIndex - minIndex) + 1.
             * 
             */
    
            int n = S.length();
            int smallestSize = Integer.MAX_VALUE;
    
            int index0 = -1;
            int index1 = -1;
            int index2 = -1;
    
            for(int i = 0; i < S.length(); i++) {
                if(S.charAt(i) == '0'){
                    index0 = 0;
                } else if(S.charAt(i) == '1'){
                    index1 = 1;
                } else if(S.charAt(i) == '2'){
                    index2 = 2;
                }
    
                if(index0 != -1 && index1 != -1 && index2 != -1) {
                    int minIndex = Math.min(index0, Math.min(index1, index2));
                    int maxIndex = Math.max(index0, Math.max(index1, index2));
                    int size = maxIndex - minIndex + 1;
                    if(size < smallestSize) {
                        smallestSize = size;
                    }
                }
            }
    
            if(smallestSize == Integer.MAX_VALUE) {
                return -1;
            }
    
            return smallestSize;
    
        }
    
        public static boolean isPermutationSubstring(String txt, int startIdx, String pat) {
            /*
             * Given two Strings 'txt' and 'pat' having lowercase letters the task is to check if any permuation of pat is a 
             * substring of txt.
             * ex. Input: txt = "programming", pat = "rain" (a perm of rain can be nair, niar, rnai etc.)
             * O: false
             * Explanation: No permutation of rain exists as a substring in programming
             * 
             * BruteForce - O(n x m)
             * 
             */
            int n = txt.length();
            int p = pat.length();
            
            /*
             * Create freq array of size 26 for the alphabet
             * Create for loop that iterates through the txt subtrings. 
             *      Create for loop that increments freq for letters in txt 
             *      Create for loop that decrements freq for letters in pat
             * 
             *      If the freq has all zeroes then it is a permutation.
             *      
             */
                final int max_char = 26;
                int[] freq = new int[max_char];
    
                for(int i = 0; i < pat.length(); i++) { //O(m)
                    freq[txt.charAt(startIdx + i) - 'a'] += 1;
    
                    freq[pat.charAt(i) - 'a'] -= 1;
    
                }
    
                for(int i = 0; i < 26; i++) { //O(freq.length)
                    if(freq[i] != 0) {
                        return false;
                    }
                }
    
                return true;
    
        }
    
        public static boolean search(String txt, String pat) { 
            int n = txt.length();
            int p = pat.length();
    
            for(int i = 0; i < n - p + 1; i++) {
                if(isPermutationSubstring(txt, i, pat)) { // O(n) worst case. This method calls {isPermutationSubstring} which is O(m)
                    return true;
                } 
            }
    
            return false;
        
        }
    
        /*
         * End of O(n x m) time and O(MAX_CHAR) permutation finder
         */
    
         public static boolean search2(String txt, String pat) { 
            /*
             * Array with size 26(alphabet) is created. Then we add the frequencies of the first pat.length() elements in txt AND then decrement the letters in pat
             * and then we call check.
             * 
             * If its not true we continue else return true
             * 
             * Now since we did the first pat.length letters of text and checked it we can now use a sliding window technique by working on index 1 on txt - 
             * index 1 + pat.length. For example, if "Tarantula" is txt and ulta is "pat" the code already did the first 4 indexes so now we work on index 1 - 5
             * by using a for loop.
             * 
             * This for loop will allow the next letter to be added to the window and increment it AND remove the first letter of the window and decrement.
             * For example, if "Tarantula" is txt and ulta is "pat" the code already did the first 4 indexes so now we work on index 1 - 4
             * by using a for loop. Firstly, we add the next letter which is index 4 of "Tarantula" which is 'n'. 'n' ASCII is 110. The code subtracts 110 by
             * 97 which is the ASCII for 'a' which gives you 13. We do this to increment the frequency of index 13 on the array "freq". The sliding window 
             * removes 't' and decrements its frequency by getting its ASCII which is 116 and subtracting 'a' which gives you 19. So the index 19 on the 
             * frequency array gets decremented to.
             * 
             * At every for loop iteration we check the freq array. If the entire array is 0 this means there is a permutation in "txt" that contains the letters in "pat"
             * 
             * This method has a time complexity of O(n * 26) and a time complexity of O(1) because the array is only created once. 
             */
    
            int n = txt.length();
            int m = pat.length();
    
            final int max_char = 26;
    
            int[] freq = new int[max_char]; //<= Only called once
            for(int i = 0; i < max_char; i++){ //O(26)
                freq[i] = 0;
            }
    
            for(int i = 0; i < m; i++) { //O(m)
                freq[txt.charAt(i) - 'a'] += 1;
                freq[pat.charAt(i) - 'a'] -= 1;
            
    
            }
    
            if(check(freq)) {
                return true;
            }

            for(int i = m; i < n; i++) { //O(n)
                   freq[txt.charAt(i) - 'a'] += 1;
                freq[txt.charAt(i - m) - 'a'] -= 1;

                if(check(freq))
                    return true;
            }

            return false;
    
         }
    
         public static boolean check(int[] freq) { //O(26)
            for(int i = 0; i < max_char; i++) {
                if(freq[i] != 0) {
                    return false;
                }

            }

            return true;

     }

    public static int countStrictlyIncreasingSubarray(int[] array) {
    /*
     * Count number of subarrays that are strictly increasing and have a size of atleast two. 
     * Given input: Array of integers
     * 
     * Input: arr[] = [1, 4, 5, 3, 7, 9]
        Output: 6
        Explanation: The strictly increasing subarrays are: [1, 4], [1, 4, 5], [4, 5], [3, 7], [3, 7, 9], [7, 9]

        What do we know? 
        -We need to compare a number to previous number
        -We need to iterate through the array
        -We need to keep track of numbers
        -We need to count all subarrays including ones greater than 2.
        -In order to count all the subarrays greater than two, you must utilize the formula that allows you find all subarrays in a array of 
        integers. This is n * (n + 1)/2, to find the subarrays in a array with a minimum size of 2, you do n * (n - 1)/2.

        -The way this problem is solved is by using a length variable to get the length of a strictly increasing subarray. Then once we hit 
        that is less than its previous element, we use the calculation to get the number of subarrays in it. Then we add that number to the
        count and reset the length.

        -A calculation is added to count at the end to make sure the remaining 'strictly' increasing subarrays are accounted for.

        We will use sliding window technique, probably
        What we dont know - Will it be fixed or variable? Do I need aux space? What is the most optimized solution?

        This is a variable sized sliding window technique, the length variable grows in size when a number greater than its previous is found.

        This algorithm is run with a time complexity of O(n) and space complexity of O(1)
     * 
     * 
     */

     int length = 1;
     int temp = array[0];
     int count = 0;

     for(int i = 1; i < array.length; i++) { // O(n)

        if(array[i] > temp) {
            length++;
        } else {
            count += length * (length - 1) / 2;   
            length = 1;
        }

        temp = array[i];

     }

     count += (length * (length - 1)) / 2;

     return count;

    }

    // Java Code to count strictly increasing 
    // subarrays using Length based Formula
    // Function to count strictly increasing 
    // subarrays (G4G)

    static int countIncreasing(int[] arr) {
        
        int n = arr.length;
        int count = 0;
        int len = 1;

        // Iterate through the array
        for (int i = 1; i < n; i++) {
            
            // If current element is greater than 
            // previous, increase len
            if (arr[i] > arr[i - 1]) {
                len++;
            } 
            
            else {
                
                // Add subarrays count and reset len
                count += (len * (len - 1)) / 2;
                len = 1;
            }
        }

        // Add remaining subarrays count
        count += (len * (len - 1)) / 2;

        return count;
    }

    public static String removeConsecutiveDuplString(String s) {

        /*
         * Given a String remove all consecutive duplicate characters of the String and return the resultant String
         * Ex. Input: S = "aaaaabbbbbb"
         * O: ab
         * Remove the consecutive duplicate characters such as all the a's except the first one and all the b's except the first one
         * 
         * Ex. Input: S = 'geeksforgeeks'
         * O: geksforgeks
         * Since e is a consecutive duplicate remove it
         * 
         * O(n). Basically you add every letter that is different than saved char. If you find a different letter you update saved char to that char and add 
         * the letter to the new string
         * 
         */

        if(s.isEmpty()) {
            return s;
        }

        char savedChar = s.charAt(0);
        String newString = String.valueOf(savedChar);

        for(int i = 1; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if(currentChar != savedChar) {
                savedChar = currentChar;
                newString = newString + currentChar;
            }

        }

        return newString;

    }

    public static void main(String[] args) {
        String s = "aaabbccbaaaaabvccccdd";
        System.out.println(removeConsecutiveDuplString(s));

    }
    
}

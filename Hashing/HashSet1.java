

package Hashing;

import java.util.HashSet;

public class HashSet1 {
    

    public static void main(String [] args){
        HashSet set1 = new HashSet();
        HashSet<Integer> set2 = new HashSet<Integer>(20);

        System.out.println(set2.add(null));
        System.out.println(set2.add(1));
        System.out.println(set2.add(2));
        System.out.println(set2.add(null));
    }

}

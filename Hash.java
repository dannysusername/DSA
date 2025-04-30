import java.util.ArrayList;

//Program for hashing with chaining
//Auxiliary Space O(1)

public class Hash{

    int bucket;
    ArrayList<Integer>[] table;

    public Hash(int bucket){
        this.bucket = bucket;
        this.table = new ArrayList[bucket];

        for(int i = 0; i < bucket; i++){
            table[i] = new ArrayList<>(); 
        }
    }

    public int hashFunction(int key){
        return(key % bucket);
    }

    public void insertItem(int key){
        int index = hashFunction(key);
        table[index].add(key);
        //O(1 + n/m)
    }

    public void deleteItem(int key){

        int index = hashFunction(key); //O(1)

        if(!table[index].contains(key)){
            return; //O(1 + n/m)
        } 

        table[index].remove(Integer.valueOf(key)); //O(1 + n/m)

    }

    public void displayHash(){

        //O(n + n/m)

        for(int i = 0; i < table.length; i++){
            System.out.print (i + ". ");
            for(int x : table[i]){
                System.out.print("--> " + x);
            }
            System.out.println();

        }

    }

    public static void main(String[] args){
        int[] array = { 15, 11, 27, 8, 12 };
        Hash h = new Hash(7);
        for(int i = 0; i < array.length; i++){
            h.insertItem(array[i]);
        }

        h.displayHash();

    }

}
import java.util.ArrayList;

//Program for hashing with chaining

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
    }

    public void deleteItem(int key){

        int index = hashFunction(key);

        if(!table[index].contains(key)){
            return;
        } 

        table[index].remove(Integer.valueOf(key));

    }

    public void displayHash(){

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
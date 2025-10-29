package Hashing;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashChainingWithRehashing {

    int bucket;
    int numOfElements;

    ArrayList<LinkedList<Integer>> table;

    public HashChainingWithRehashing(int b){
        this.bucket = b;
        this.numOfElements = 0;
        table = new ArrayList<>(bucket);

        for(int i = 0; i < bucket; i++){
            table.add(new LinkedList<>());

        }

    }

    public int hashFunction(int key){
        int result = (key % bucket);
        return result;

    }
    
    public float loadFactor(){
        return (float) numOfElements / bucket;

    }

    public void rehashing(){

        int OLDBucket = bucket;
        int NEWBucket = OLDBucket * 2;

        ArrayList<LinkedList<Integer>> OldTable = table;

        table = new ArrayList<>(NEWBucket);
        numOfElements = 0;

        for(int i = 0; i < NEWBucket; i++){
            table.add(new LinkedList<>());
        }

        for(int i = 0; i < OLDBucket; i++){
            for(Integer key : OldTable.get(i)){
                insert(key);
            }
        }

        this.bucket = NEWBucket;

    }


    public void insert(int key){

        while(loadFactor() > 0.5){
            rehashing();
        }

        int index = hashFunction(key);
        table.get(index).add(key);
        numOfElements++;
    }

    public void delete(int key){
        int index = hashFunction(key);
        LinkedList<Integer> chain = table.get(index);

        if(chain.contains(key)){
            chain.remove((Integer) key);
            numOfElements--;
        }
        

    }

    public void displayHash(){


        for(int i = 0; i < bucket; i++){
            System.out.print(i);
            for(int x : table.get(i)){
                System.out.print("-->" + x);
            }
            System.out.println();
        }

    }

    public static void main(String [] args){

        ArrayList<Integer> a = new ArrayList<>();
        a.add(15);
        a.add(11);
        a.add(27);
        a.add(8);
        a.add(12);

        a.add(51);
        a.add(17);
        a.add(21);
        a.add(81);
        a.add(1);

        a.add(51);
        a.add(17);
        a.add(21);
        a.add(81);
        a.add(1);

        HashChainingWithRehashing table1 = new HashChainingWithRehashing(20);
        
        for(int i : a){
            table1.insert(i);
        }

        table1.displayHash();


    }





}
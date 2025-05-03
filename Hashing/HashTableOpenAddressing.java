package Hashing;

public class HashTableOpenAddressing {
    //Linear probing


    int tableSize;
    int numOfElements;
    HashNode[] table;

    public HashTableOpenAddressing(int tableSize){
        this.tableSize = tableSize;
        this.numOfElements = 0;
        table = new HashNode[tableSize];

    }

    public int hashFunction(int key){
        return key % tableSize;
    }

    public float loadFactor(){
        return (float) numOfElements/tableSize;
    }

    public void rehashing(){
        HashNode[] oldTable = table;
        tableSize = tableSize * 2;
        table = new HashNode[tableSize * 2];
        numOfElements = 0;

        for(HashNode oldkeyval : oldTable){
            if(oldkeyval != null && oldkeyval.getKey() != -1){
                insert(oldkeyval.getKey(), oldkeyval.getValue());
            }
        }


    }

    public int delete(int key){
        HashNode dummyNode = new HashNode(-1, -1);
        int index = hashFunction(key);

        while(table[index] != null){
            if(table[index].getKey() == key){
                table[index] = dummyNode;
                numOfElements--;
                return index;
            }

            index += 1 % tableSize;

        }

        return -1;

    }

    public int find(int key){

        int index = hashFunction(key);
        int counter = 0;

        while(table[index] != null){

            if(counter > tableSize){
                break;
            }

            if(table[index].getKey() == key){
                return table[index].getKey();
            }

            index += 1 % tableSize;
            counter++;

        }

        return -1;

    }

    public void insert(int key, int value){

        if(loadFactor() > 0.5){
            System.out.println("Rehashing");
            rehashing();
        }

        HashNode temp = new HashNode(key, value);
        int index = hashFunction(key);

        while(table[index] != null && table[index].getKey() != key && table[index].getKey() != -1){
            index += 1 % tableSize;

        }
        if(table[index] == null || table[index].getKey() == -1){
            numOfElements++;
        } else if (table[index].getKey() == key){
            System.out.println("Key found, key value replaced");
        }

        table[index] = temp;

    }

    public static void main(String [] args){

    }

}
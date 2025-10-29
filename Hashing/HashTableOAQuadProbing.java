package Hashing;
public class HashTableOAQuadProbing {

    int tableSize;
    int numOfElements;
    HashNode[] table;
    static HashNode dummyNode = new HashNode(-1, -1);

    public HashTableOAQuadProbing(int tableSize){
        this.tableSize = tableSize;
        numOfElements = 0;
        table = new HashNode[tableSize];

    }

    public int hashFunction(int key){
        return key % tableSize;

    }

    public int nextPowerOf2(int tableSize){
        int m = tableSize;

        m--;
        m |= m >> 1;
        m |= m >> 2;
        m |= m >> 4;
        m |= m >> 8;
        m |= m >> 16;
        m++;

        return m;

    }

    public void insert(int key, int value){

        HashNode temp = new HashNode(key, value);

            int hashIndex = hashFunction(key);

            if(table[hashIndex] == null){
                table[hashIndex] = temp;
            } else {

                int m = nextPowerOf2(tableSize);
                for(int j = 0; j <= m; j++){
                    int t = (hashIndex + (j + j * j) / 2) % m;
                    if(t < tableSize && table[t] == null){
                        table[t] = temp;
                        break;
                    }
                }

            }

        


    }

    public void display(){

        System.out.println("Number of elements" + numOfElements);
        System.out.println("Table size: " + tableSize);
        int counter = 0;

        for(HashNode keyval : table){

            if(keyval != null) {
                System.out.println(counter + ". Key: " + keyval.getKey() + " Value: " + keyval.getValue());
                
            } else {
                System.out.println(counter + ". null");
            }

            counter++;
        }

       
    }
    
    public static void main(String [] args){

        int[][] array = {{10,3}, {21, 4}, {5, 10}, {15, 2}, {30, 2}, {1, 10}, {2, 2}, {4, 2}, {9, 10}, {23, 2}, {45, 2}};
        int[][] array2 = {{21, 2}, {10, 3}, {32, 4}, {43, 5}, {54, 6}, {65, 7}, {87, 8}, {76, 6}};
        HashTableOAQuadProbing table1 = new HashTableOAQuadProbing(11);

        

        for(int[] x : array2){
           table1.insert(x[0], x[1]);
        }

        table1.display();




    }

}

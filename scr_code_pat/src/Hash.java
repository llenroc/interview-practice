/**
 * Created by yizhaoyang on 6/19/17.
 */
public class Hash {

    //复杂版的还要加上 resize 和 loadfactor

    int capacity ;
    HashEntry[] table;


    private final static int TABLE_SIZE = 128;

    Hash(){
        capacity = 10;
        table = new HashEntry[TABLE_SIZE];
        for(int i = 0; i < 10; i++)
            table[i] = null;
    }

    int get(int key){
        int hash = key % this.TABLE_SIZE;
        while(table[hash] != null && table[hash].getKey() != key)
            hash = (hash + 1) % TABLE_SIZE;
        if(table[hash] == null){
            return -1;
        }
        return table[hash].getValue();
    }

    void put(int key, int value){
        int hash = key % this.TABLE_SIZE;
        while(table[hash] != null && table[hash].getKey() != key)
            hash = (hash + 1) % TABLE_SIZE;
        table[hash] = new HashEntry(key, value);
    }

    public class HashEntry{

        int key;
        int value;

        HashEntry(int key,int value){
            this.key=key;
            this.value = value;
        }

        int getKey(){
            return this.key;
        }

        int getValue(){
            return this.value;
        }
    }


}

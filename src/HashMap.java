import java.util.*;

class HashNode<T> {
    public int key;
    public T value;
    public HashNode<T> next;
    public HashNode(int key, T value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}
public class HashMap <T> {
    private HashNode<T>[] table;
    private int maxSize;

    public int getMaxSize() {
        return maxSize;
    }

    public HashMap(int maxSize) {
        this.maxSize = maxSize;
        table = new HashNode[maxSize];
        for (int i = 0; i < maxSize; i++)
            table[i] = null;
    }
    public int mid_square_hash(int key) {
        int value = key * key;
//        return middleValue(value);
        return key%maxSize;
    }
    public int middleValue(int value) {
        String valStr = String.valueOf(value);
        int midIndex = valStr.length() / 2;
        String middleDigits = valStr.substring(midIndex, midIndex + 1);
        return Integer.parseInt(middleDigits)%maxSize;
    }
    public void Insert(int k,T v){
        if (table[mid_square_hash(k)]==null){
            table[mid_square_hash(k)] = new HashNode(k,v);
        }
        else {
            HashNode hashNode = table[mid_square_hash(k)];
            while (hashNode.next!=null){
                hashNode = hashNode.next;
            }
            hashNode.next = new HashNode(k,v);
        }
    }
    public boolean contains(int k){
        if (table[mid_square_hash(k)]!=null){
            HashNode hashNode = table[mid_square_hash(k)];
            while (hashNode!=null){
                if (hashNode.key==k){
                    return true;
                }
                hashNode=hashNode.next;
            }
        }
        return false;
    }

    public T SearchKey(int k) {
        T temp = null;
        if (table[mid_square_hash(k)]!=null){
            HashNode hashNode = table[mid_square_hash(k)];
            while (hashNode!=null){
                if (hashNode.key==k){
                    temp =  (T) hashNode.value;
                }
                hashNode=hashNode.next;
            }
        }
        return temp;
    }
    public ArrayList<T> SearchKey_Multiple(int k) {
        ArrayList<T> tempList = new ArrayList<T>();
        if (table[mid_square_hash(k)]!=null){
            HashNode hashNode = table[mid_square_hash(k)];
            while (hashNode!=null){
                if (hashNode.key==k){
                    tempList.add((T) hashNode.value);
                }
                hashNode=hashNode.next;
            }
        }
        return tempList;
    }

    public void Remove(int k) {
        if (table[mid_square_hash(k)]!=null){
            HashNode hashNode = table[mid_square_hash(k)];
            while (hashNode!=null){
                if (hashNode.key==k){
                    table[mid_square_hash(k)] = hashNode.next;
                    break;
                }
                hashNode=hashNode.next;
            }
        }
    }
}
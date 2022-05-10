package HW3;
import java.util.LinkedList;

public class MyHashTable<K,V> {
    private class HashNode<K,V>{
    private K key;
    private V value;
    private HashNode<K,V> next;

    public HashNode(K key, V value){
        this.key=key;
        this.value=value;

    }
    @Override
    public String toString() {
        return "{" + key + " " + value + "}";
        }
    }
    private HashNode<K,V>[] chainArray;
    private int M = 11;
    private int size;



    public MyHashTable() {
    this(11);
    }

    public MyHashTable(int M){
        this.M = M;
        this.size = 0;
        this.chainArray = new HashNode[M];
    }


    private int hash(K key) {
        return key.hashCode() % M;
    }

    public void put(K key, V value){
   if(key == null || value == null){
       throw new IllegalArgumentException("Null");
   }
        int index = hash(key);
        HashNode head = chainArray[index];
        while (head != null){
            if(head.key == key){
                head.value = value;
                return;
            }
            head = head.next;
        }
        size++;
        head = chainArray[index];
        HashNode node = new HashNode(key,value);
        node.next = head;
        chainArray[index] = node;
    }


    public V get(K key){
        int x = hash(key);
        return (V)chainArray[x];
    }


    public V remove(K key){
        if(key == null){
            throw new IllegalArgumentException("Null");
        }
        int index = hash(key);
        HashNode head = chainArray[index];
        HashNode previous = null;
        while (head != null){
            if(head.key == key){
                break;
            }
            previous = head;
            head = head.next;
        }
       else if (head == null){
            return null;
        }
        size--;

        if(previous != null){
            previous.next = head.next;
        }
        else{
            chainArray[index] = head.next;
        }
        return head.value;
    }


    public boolean contains(V value){
        for(int i = 0; i < size - 1; i++){
            if(value == chainArray[i]) {
                return true;
            }
        }
        return false;
    }
}

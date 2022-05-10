package HW3;

import javax.swing.tree.TreeNode;

public class BST<K extends Comparable<K>, V> {
    private Node root;
    private class Node
    {
        private K key;
        private V val;
        private Node left,right;
        public Node(K key,V value)
        {
            this.key = key;
            this.val = value;
        }
    }
    public void put(K key, V val) {
        Node node = new Node;
        if (key.compareTo(node.key) < 0) {
            if (node.left != null ) {
                return;
            }
            else {
                node.left = new Node(key, val);
            }
        }
        else if (key.compareTo(node.key) > 0 ) {
            if (node.right != null) {
                node.right = new Node(key, val);
            } else {
                node.right = new Node(key,val);
            }
        }
        else {
            node.val = val;
        }
    }

    public V get(K key){

        }

    public void delete(K key){

    }

    public Iterable<K> iterator(){

    }
}

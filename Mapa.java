// package sem4.zal1;

import java.net.PasswordAuthentication;

public class Mapa<K, V> {
    private Mapa<K, V> head;
    int size = 6;
    Node<K, V>[] nodes = new Node[size];

    public V put(K key, V value) {
        Node<K, V> newNode = new Node<>(key, value);
        int index = getIndex(key);
        Node<K, V> currentNode = nodes[index];
        while (currentNode != null) {
            if (currentNode.key == key) {
                V tmp = currentNode.value;
                currentNode.value = value;
                return tmp;
            }
            currentNode = currentNode.nextNode;
        }
        newNode.nextNode = nodes[index];
        nodes[index] = newNode;
        return null;
    }

    public int getIndex(K key) {
        return Math.abs(key.hashCode()) % size;
    }

    public V get(K key) {
        int index = getIndex(key);
        Node<K, V> node = nodes[index];
        while (node != null) {
            if (node.key.equals(key)) {
                return node.value;
            }
            node = node.nextNode;
        }
        return null;
    }

    public V replace(K key, V value) {
        int index = getIndex(key);
        Node<K, V> currentNode = nodes[index];
        while (currentNode != null) {
            if (currentNode.key.equals(key)) {
                currentNode.value = value;
            }
            return currentNode.value;
        }
        return null;
    }

    public int sizeHash() {
        int count = 0;
        for (int i = 0; i < nodes.length; i++) {
            // Node<K, V> newnNode = nodes[i]; //
            count++;
        }
        return count;
    }

    public boolean containsKey(K key) {
        int index = getIndex(key);
        Node<K, V> currentNode = nodes[index];
        while (currentNode != null) {
            if (currentNode.key == key) {
                return true;
            }
            currentNode = currentNode.nextNode;
        }
        return false;
    }

    public boolean containsValue(V value) {
        for (int i = 0; i < nodes.length; i++) {
            Node<K, V> neweNode = nodes[i];
            System.out.println(neweNode.value);
            if (neweNode != null && neweNode.value == value) {
                return true;
            }
        }
        return false;

    }

    public V remove(K key) {
        int index = getIndex(key);
        Node<K, V> currentNode = nodes[index];
        Node<K, V> previousNode = null;
        while (currentNode != null) {
            if (currentNode.key.equals(key)) {
                V tmp = currentNode.value;
                if (previousNode == null)
                    nodes[index] = currentNode.nextNode;
                else if (currentNode.nextNode == null)
                    previousNode.nextNode = null;
                else
                    previousNode.nextNode = currentNode.nextNode;
                return tmp;
            }
            previousNode = currentNode;
            currentNode = currentNode.nextNode;
        }
        return null;
    }

    public V remove2(K key) {
        Integer index = key.hashCode() % 16;
        Node<K, V> currentNode = nodes[index];
        if (currentNode != null) {
            while (currentNode.nextNode != null) {
                if (currentNode.nextNode.key == key) {
                    V result = currentNode.nextNode.value;
                    currentNode.nextNode = currentNode.nextNode.nextNode;
                    return result;
                }
                currentNode = currentNode.nextNode;
            }
        }
        return null;
    }

}

// public static void main(String[] args) {
// Node<Integer, String> node = new Node<>();
// node.key = 12;
// node.value = "12";
//
// node.key.hashCode();
// // System.out.println(node.value.hashCode() % 16);
// }
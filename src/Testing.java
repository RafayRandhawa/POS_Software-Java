import java.util.ArrayList;

public class Testing {
    public static void main(String[] args) {
        CustomHashMap<Integer, String> customHashMap = new CustomHashMap<>();
        CustomBinarySearchTree<Integer> customBST = new CustomBinarySearchTree<>();

        // Measure execution time for CustomHashMap put operation
        long hashMapPutStartTime = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            customHashMap.put(i, "Value" + i);
        }
        long hashMapPutEndTime = System.nanoTime();
        long hashMapPutTime = hashMapPutEndTime - hashMapPutStartTime;
        System.out.println("CustomHashMap put operation time (100,000 entries): " + hashMapPutTime + " nanoseconds");

        // Measure execution time for CustomHashMap get operation
        long hashMapGetStartTime = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            customHashMap.get(i);
        }
        long hashMapGetEndTime = System.nanoTime();
        long hashMapGetTime = hashMapGetEndTime - hashMapGetStartTime;
        System.out.println("CustomHashMap get operation time (100,000 entries): " + hashMapGetTime + " nanoseconds");

        // Measure execution time for CustomBinarySearchTree insert operation
        long bstInsertStartTime = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            customBST.insert(i);
        }
        long bstInsertEndTime = System.nanoTime();
        long bstInsertTime = bstInsertEndTime - bstInsertStartTime;
        System.out.println("CustomBinarySearchTree insert operation time (100,000 entries): " + bstInsertTime + " nanoseconds");

        // Measure execution time for CustomBinarySearchTree search operation
        long bstSearchStartTime = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            customBST.search(i);
        }
        long bstSearchEndTime = System.nanoTime();
        long bstSearchTime = bstSearchEndTime - bstSearchStartTime;
        System.out.println("CustomBinarySearchTree search operation time (100,000 entries): " + bstSearchTime + " nanoseconds");
    }

    static class CustomHashMap<K, V> {
        private ArrayList<ArrayList<Entry<K, V>>> buckets;
        private int capacity;
        private static final int DEFAULT_CAPACITY = 16;

        public CustomHashMap() {
            this(DEFAULT_CAPACITY);
        }

        public CustomHashMap(int capacity) {
            this.capacity = capacity;
            this.buckets = new ArrayList<>(capacity);
            for (int i = 0; i < capacity; i++) {
                buckets.add(new ArrayList<>());
            }
        }

        public void put(K key, V value) {
            int hash = hash(key);
            int index = getIndex(hash);
            ArrayList<Entry<K, V>> bucket = buckets.get(index);
            for (Entry<K, V> entry : bucket) {
                if (entry.key.equals(key)) {
                    entry.value = value;
                    return;
                }
            }
            bucket.add(new Entry<>(key, value));
        }

        public V get(K key) {
            int hash = hash(key);
            int index = getIndex(hash);
            ArrayList<Entry<K, V>> bucket = buckets.get(index);
            for (Entry<K, V> entry : bucket) {
                if (entry.key.equals(key)) {
                    return entry.value;
                }
            }
            return null;
        }

        private int hash(K key) {
            return key == null ? 0 : key.hashCode();
        }

        private int getIndex(int hash) {
            return Math.abs(hash) % capacity;
        }

        static class Entry<K, V> {
            private final K key;
            private V value;

            Entry(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }
    }

    static class CustomBinarySearchTree<T extends Comparable<T>> {
        private Node<T> root;

        static class Node<T> {
            private T data;
            private Node<T> left, right;

            Node(T data) {
                this.data = data;
                left = right = null;
            }
        }

        public void insert(T data) {
            root = insertRec(root, data);
        }

        private Node<T> insertRec(Node<T> root, T data) {
            if (root == null) {
                return new Node<>(data);
            }
            if (data.compareTo(root.data) < 0) {
                root.left = insertRec(root.left, data);
            } else if (data.compareTo(root.data) > 0) {
                root.right = insertRec(root.right, data);
            }
            return root;
        }

        public boolean search(T value) {
            return searchRec(root, value);
        }

        private boolean searchRec(Node<T> root, T value) {
            if (root == null) {
                return false;
            }

            if (value.compareTo(root.data) == 0) {
                return true;
            } else if (value.compareTo(root.data) < 0) {
                return searchRec(root.left, value);
            } else {
                return searchRec(root.right, value);
            }
        }
    }
}

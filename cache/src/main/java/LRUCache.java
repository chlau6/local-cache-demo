import util.DoublyLinkedList;
import util.DoublyLinkedListImpl;
import util.Node;

import java.util.HashMap;
import java.util.Map;

public class LRUCache implements Cache {
    private final Map<String, Node> cache;
    private final DoublyLinkedList doublyLinkedList;
    private final CacheAlgorithm algorithm;
    private int maxCapacity;

    LRUCache(int maxCapacity) {
        this.cache = new HashMap<>();
        this.doublyLinkedList = new DoublyLinkedListImpl();
        this.algorithm = CacheAlgorithm.LRU;
        this.maxCapacity = maxCapacity;
    }

    @Override
    public void put(String key, String value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.setValue(value);
            node.selfDelete();
            doublyLinkedList.addFirst(node);
        } else {
            Node node = new Node(key, value);
            cache.put(key, node);
            doublyLinkedList.addFirst(node);
        }

        removeLRUKey();
    }

    @Override
    public String get(String key) {
        if (!cache.containsKey(key)) return "null"; // or implement your data loader

        Node node = cache.get(key);
        node.selfDelete();
        doublyLinkedList.addFirst(node);

        return node.getValue();
    }

    @Override
    public boolean evict(String key) {
        if (!cache.containsKey(key)) return false;

        Node node = cache.get(key);
        cache.remove(node.getKey());
        node.selfDelete();

        return true;
    }

    @Override
    public void clear(String key) {
        cache.clear();
    }

    @Override
    public int getSize() {
        return this.cache.size();
    }

    @Override
    public int getMaxCapacity() {
        return this.maxCapacity;
    }

    @Override
    public void setMaxCapacity(int capacity) {
        this.maxCapacity = capacity;

        removeLRUKey();
    }

    @Override
    public String getCacheAlgorithm() {
        return this.algorithm.toString();
    }

    private void removeLRUKey() {
        int currentSize = getSize();
        int maxCapacity = getMaxCapacity();

        if (currentSize <= maxCapacity) return;

        int numOfLRUKey = currentSize - maxCapacity;

        for (int i = 0; i < numOfLRUKey; i++) {
            Node oldNode = doublyLinkedList.getLast();
            cache.remove(oldNode.getKey());
            doublyLinkedList.removeLast();
        }
    }
}

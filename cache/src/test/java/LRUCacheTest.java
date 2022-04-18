import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LRUCacheTest {
    @Test
    void lruCacheTest() {
        LRUCache lruCache = new LRUCache(2);

        lruCache.put("Alice", "apple");
        lruCache.put("Bob", "banana");
        assertEquals("apple", lruCache.get("Alice"));

        lruCache.put("Charlie", "cherry");
        assertEquals("null", lruCache.get("Bob"));

        lruCache.put("David", "durian");
        assertEquals("null", lruCache.get("Alice"));

        assertEquals("cherry", lruCache.get("Charlie"));
        assertEquals("durian", lruCache.get("David"));

        lruCache.setMaxCapacity(1);
        assertEquals("null", lruCache.get("Charlie"));
        assertEquals("durian", lruCache.get("David"));
    }
}

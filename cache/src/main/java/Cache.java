public interface Cache {
    void put(String key, String value);

    String get(String key);

    boolean evict(String key);

    void clear(String key);

    int getSize();

    int getMaxCapacity();

    void setMaxCapacity(int maxCapacity);

    String getCacheAlgorithm();
}

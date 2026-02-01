package cache;

import java.lang.ref.SoftReference;
import java.util.LinkedHashMap;
import java.util.Map;

public class SoftLruCache<K, V> {
    private final int capacity;
    private final Map<K, SoftReference<V>> map;

    public SoftLruCache(int capacity) {
        this.capacity = capacity;
        this.map = new LinkedHashMap<>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, SoftReference<V>> eldest) {
                return size() > SoftLruCache.this.capacity;
            }
        };
    }

    public synchronized void put(K key, V value) {
        map.put(key, new SoftReference<>(value));
    }

    public synchronized V get(K key) {
        SoftReference<V> softRef = map.get(key);
        if (softRef == null) return null;

        V value = softRef.get();
        if (value == null) {
            map.remove(key);
            return null;
        }
        return value;
    }
}

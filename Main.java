public class Main {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2); // capacity = 2

        cache.put(1, 10); // cache = {1=10}
        cache.put(2, 20); // cache = {2=20, 1=10}
        System.out.println(cache.get(1)); // returns 10, cache = {1=10, 2=20}

        cache.put(3, 30); // evicts key 2, cache = {3=30, 1=10}
        System.out.println(cache.get(2)); // returns -1 (not found)

        cache.put(4, 40); // evicts key 1, cache = {4=40, 3=30}
        System.out.println(cache.get(1)); // returns -1 (not found)
        System.out.println(cache.get(3)); // returns 30
        System.out.println(cache.get(4)); // returns 40
    }
    
}

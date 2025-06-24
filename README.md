# 🧠 LRU Cache in Java

This project implements a **Least Recently Used (LRU) Cache** in Java using **HashMap** and a **Doubly Linked List** to achieve constant time (`O(1)`) operations for both `get()` and `put()`.

## 🚀 Features

- `get(key)`: Retrieves a value by key. If the key exists, the node is moved to the front (most recently used).
- `put(key, value)`: Adds a key-value pair. If the cache is full, it evicts the least recently used item.
- Maintains `O(1)` time complexity for all operations.

## 📦 Data Structures Used

- **HashMap** for fast key-based access.
- **Doubly Linked List** to track order of usage.

⚙️ How to Run
🖥️ Prerequisites
Java 8 or higher installed

A Java IDE (like IntelliJ / VS Code) or terminal/command line

🧪 Running from Terminal
1. Clone the repository:
```bash
git clone https://github.com/<your-username>/lru-cache-java.git
cd lru-cache-java
```
2. Compile the files:
```bash
javac LRUCache.java Main.java
```
3. Run the program:
```bash
java Main
```

## 🧪 Example Usage

```java
LRUCache cache = new LRUCache(2); // capacity = 2

cache.put(1, 10);  // cache = {1=10}
cache.put(2, 20);  // cache = {2=20, 1=10}
cache.get(1);      // returns 10, cache = {1=10, 2=20}
cache.put(3, 30);  // evicts key 2, cache = {3=30, 1=10}



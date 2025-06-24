##  **General Java Collections Questions**

1. What is the Java Collections Framework?
2. What are the main benefits of using collections?
3. What is the difference between `Collection` and `Collections`?
4. Why are generics used with collections?
5. What is the root interface of the collections hierarchy?

---

##  **List Interface**

1. What is the difference between `ArrayList` and `LinkedList`?
2. When would you use `Vector` instead of `ArrayList`?
3. How does `ListIterator` differ from `Iterator`?
4. Can you add or remove elements while iterating a `List`?
5. What is the initial capacity of an `ArrayList`, and how does it grow?

---

##  **Set Interface**

1. What is the difference between `HashSet`, `TreeSet`, and `LinkedHashSet`?
2. How does a `HashSet` prevent duplicates?
3. How does `TreeSet` maintain ordering?
4. Why does `HashSet` require `hashCode()` and `equals()` to be overridden?
5. Can a `Set` contain null values?

---

##  **Queue & Deque**

1. What is the difference between `Queue` and `Deque`?
2. How does a `PriorityQueue` determine the order of elements?
3. Can you implement a stack using `Deque`?
4. What’s the difference between `offer()`, `add()`, `poll()`, `remove()`, and `peek()` in queues?
5. What are the thread-safe alternatives for queues?

---

##  **Map Interface**

1. What is the difference between `HashMap`, `TreeMap`, `LinkedHashMap`, and `Hashtable`?
2. How does `HashMap` work internally? (Very common)
3. What are the time complexities for get/put in `HashMap`?
4. What happens when two keys in a `HashMap` have the same hash code?
5. How does `ConcurrentHashMap` achieve thread safety?
6. Can a `Map` have null keys or values?

---

##  **Iteration**

1. What are the different ways to iterate over a collection?
2. What’s the difference between `Iterator` and `Enumeration`?
3. What is the fail-fast behavior in iterators?
4. How does a `ConcurrentModificationException` occur?

---

##  **Sorting and Searching**

1. What’s the difference between `Comparable` and `Comparator`?
2. How do you sort a list of custom objects?
3. How does `Collections.sort()` work internally?
4. What is binary search, and how can you implement it with collections?

---

##  **Synchronization & Thread-Safety**

1. Are Java collections thread-safe by default?
2. How do you make a collection thread-safe?
3. Difference between `Collections.synchronizedList()` and `CopyOnWriteArrayList`?
4. When would you use `ConcurrentHashMap` over `HashMap`?

---

##  **Advanced & Trick Questions**

1. How would you remove duplicates from a list?
2. How do you detect and break a circular reference in a graph using `Set`?
3. Which collection would you use for implementing an LRU cache?
4. What are weak references, and how does `WeakHashMap` use them?
5. Difference between fail-fast and fail-safe iterators?

---

##  **Legacy Collections**

1. What are legacy classes in Java Collections?
2. What is the difference between `Vector` and `ArrayList`?
3. Why is `Hashtable` considered obsolete?



Absolutely! Here's a **complete answer set** for all the questions you listed, organized by category for easy copy-paste and review:

---

## 🌐 **General Java Collections**

1. **What is the Java Collections Framework?**
   A set of classes and interfaces that implement commonly reusable data structures like `List`, `Set`, `Queue`, `Map`, and algorithms to manipulate them, found in `java.util`.

2. **What are the main benefits of using collections?**

   * Code reusability
   * Type safety with generics
   * Efficient data manipulation
   * Interoperability and flexibility
   * Rich APIs for sorting, searching, and iteration

3. **What is the difference between `Collection` and `Collections`?**

   * `Collection`: Root interface for `List`, `Set`, `Queue`.
   * `Collections`: Utility class with static methods like `sort()`, `reverse()`, `shuffle()`.

4. **Why are generics used with collections?**
   They provide **type safety** at compile-time, eliminate explicit casting, and improve code readability.

5. **What is the root interface of the collections hierarchy?**

   * `Collection` (for List, Set, Queue)
   * `Map` is a separate hierarchy

---

## 📋 **List Interface**

1. **Difference between `ArrayList` and `LinkedList`**

| Feature       | ArrayList          | LinkedList         |
| ------------- | ------------------ | ------------------ |
| Storage       | Dynamic Array      | Doubly Linked List |
| Access        | O(1) Random Access | O(n)               |
| Insert/Delete | Slower in middle   | Faster in middle   |
| Memory        | Less overhead      | More overhead      |

2. **When would you use `Vector` instead of `ArrayList`?**
   When thread-safety is essential and synchronization is required. (Rare today)

3. **How does `ListIterator` differ from `Iterator`?**
   `ListIterator` can:

   * Traverse in both directions
   * Add/remove elements
   * Get index during traversal

4. **Can you add or remove elements while iterating a List?**
   Yes, using `ListIterator.add()` and `ListIterator.remove()`.
   Regular `Iterator` allows only `remove()`; otherwise, a `ConcurrentModificationException` occurs.

5. **Initial capacity of `ArrayList` and how it grows**

   * Default: 10
   * Grows by 1.5x (e.g., 10 → 15 → 22...)

---

## 🔗 **Set Interface**

1. **Difference between `HashSet`, `LinkedHashSet`, and `TreeSet`**

| Set Type        | Order Maintained | Performance | Sorted |
| --------------- | ---------------- | ----------- | ------ |
| `HashSet`       | No               | Fast        | No     |
| `LinkedHashSet` | Insertion Order  | Moderate    | No     |
| `TreeSet`       | Sorted Order     | Slower      | Yes    |

2. **How does `HashSet` prevent duplicates?**
   Uses `hashCode()` and `equals()` to determine uniqueness of elements.

3. **How does `TreeSet` maintain ordering?**
   Uses **Red-Black Tree** internally. Elements are sorted using natural ordering or a provided `Comparator`.

4. **Why does `HashSet` require `hashCode()` and `equals()` to be overridden?**
   To ensure proper bucket placement and comparison when checking for duplicates.

5. **Can a Set contain null values?**

   * `HashSet`: Yes (only one)
   * `LinkedHashSet`: Yes
   * `TreeSet`: No (throws `NullPointerException`)

---

## 📥 **Queue & Deque**

1. **Difference between `Queue` and `Deque`**

| Feature     | `Queue`        | `Deque` (Double-ended Queue) |
| ----------- | -------------- | ---------------------------- |
| Access Ends | One end (FIFO) | Both ends                    |
| Use Cases   | Print queue    | Stack or Queue               |

2. **How does `PriorityQueue` determine order?**
   Uses **natural ordering** (via `Comparable`) or a **custom `Comparator`**.

3. **Can you implement a Stack using Deque?**

```java
Deque<Integer> stack = new ArrayDeque<>();
stack.push(1); // add
stack.pop();   // remove (LIFO)
```

4. **Difference between `offer()`, `add()`, `poll()`, `remove()`, `peek()`**

| Method   | Behavior                                   |
| -------- | ------------------------------------------ |
| `offer`  | Inserts element, returns false on failure  |
| `add`    | Same as offer, throws exception on failure |
| `poll`   | Retrieves and removes head or returns null |
| `remove` | Removes and throws exception if empty      |
| `peek`   | Views head element without removal         |

5. **Thread-safe alternatives for queues**

   * `ConcurrentLinkedQueue`
   * `LinkedBlockingQueue`
   * `ArrayBlockingQueue`
   * `PriorityBlockingQueue`
   * `DelayQueue`

---

## 🗺️ **Map Interface**

1. **Difference between `HashMap`, `TreeMap`, `LinkedHashMap`, `Hashtable`**

| Map Type        | Order Maintained | Sorted | Thread-Safe |
| --------------- | ---------------- | ------ | ----------- |
| `HashMap`       | No               | No     | No          |
| `LinkedHashMap` | Insertion Order  | No     | No          |
| `TreeMap`       | Sorted by Key    | Yes    | No          |
| `Hashtable`     | No               | No     | Yes         |

2. **How does `HashMap` work internally?**

   * Uses **buckets** based on `hashCode()`
   * Collision resolution via linked list or tree (Java 8+)
   * Keys compared using `equals()`

3. **Time complexities for get/put in `HashMap`**

   * Average: **O(1)**
   * Worst-case: **O(n)** (or O(log n) if tree used)

4. **What happens if two keys have the same hash code?**

   * Stored in the same bucket
   * `equals()` is used to differentiate

5. **How does `ConcurrentHashMap` achieve thread safety?**

   * Bucket-level concurrency
   * Lock-free reads (Java 8)
   * Fine-grained synchronization for updates

6. **Can a Map have null keys or values?**

   * `HashMap`: One null key, multiple null values
   * `TreeMap`: No null key if comparator is used
   * `Hashtable`: No null keys or values

---

## 🔁 **Iteration**

1. **Different ways to iterate over a collection**

```java
// For-each
for (String s : list) {}

// Iterator
Iterator<String> it = list.iterator();
while (it.hasNext()) {
    it.next();
}

// Stream API
list.stream().forEach(System.out::println);
```

2. **Difference between `Iterator` and `Enumeration`**

| Feature         | Iterator     | Enumeration       |
| --------------- | ------------ | ----------------- |
| Supports remove | Yes          | No                |
| Direction       | Forward only | Forward only      |
| Use             | Modern       | Legacy (`Vector`) |

3. **Fail-fast behavior**
   Throws `ConcurrentModificationException` if structure modified during iteration.

4. **How does `ConcurrentModificationException` occur?**

   * Modifying collection directly while iterating using for-each or `Iterator`
   * Use `Iterator.remove()` or `CopyOnWriteArrayList` to avoid

---

## 🔍 **Sorting and Searching**

1. **Comparable vs Comparator**

| Feature    | `Comparable`     | `Comparator`    |
| ---------- | ---------------- | --------------- |
| Defined in | Class itself     | Separate class  |
| Method     | `compareTo()`    | `compare()`     |
| Use case   | Natural ordering | Custom ordering |

2. **Sort a list of custom objects**

```java
Collections.sort(list); // if implements Comparable
Collections.sort(list, new CustomComparator()); // Comparator
```

3. **How does `Collections.sort()` work?**
   Uses **TimSort**, a hybrid of merge sort and insertion sort.

4. **What is binary search and how to use it?**

```java
int index = Collections.binarySearch(sortedList, target);
```

Efficient O(log n) search; list must be sorted.

---

## 🔐 **Synchronization & Thread-Safety**

1. **Are Java collections thread-safe by default?**
   No. Most (`ArrayList`, `HashMap`) are **not** thread-safe.

2. **How to make a collection thread-safe?**

   * `Collections.synchronizedList()`
   * `CopyOnWriteArrayList`
   * `ConcurrentHashMap`

3. **Difference between `synchronizedList()` and `CopyOnWriteArrayList`**

| Feature       | `synchronizedList`          | `CopyOnWriteArrayList`    |
| ------------- | --------------------------- | ------------------------- |
| Thread-safety | External synchronized block | Internally synchronized   |
| Performance   | Moderate                    | Better for frequent reads |
| Use case      | Read/write equal            | Read-heavy                |

4. **When to use `ConcurrentHashMap` over `HashMap`?**
   In multi-threaded environments where concurrent access is needed. Avoids issues like data corruption and infinite loops.

---

## 🧠 **Advanced & Trick Questions**

1. **Remove duplicates from a List**

```java
List<String> uniqueList = new ArrayList<>(new HashSet<>(originalList));
```

Or (Java 10+):

```java
List<String> unique = new ArrayList<>(Set.copyOf(originalList));
```

2. **Detect and break circular reference using Set**

```java
Set<Node> visited = new HashSet<>();
boolean hasCycle(Node node) {
    if (!visited.add(node)) return true;
    for (Node neighbor : node.neighbors) {
        if (hasCycle(neighbor)) return true;
    }
    return false;
}
```

3. **Which collection to use for an LRU cache?**
   `LinkedHashMap` with access order and `removeEldestEntry()` overridden.

```java
LinkedHashMap<K, V> cache = new LinkedHashMap<>(16, 0.75f, true) {
   protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
       return size() > MAX_SIZE;
   }
};
```

4. **What are weak references and how does `WeakHashMap` use them?**

   * Keys are stored as `WeakReference`
   * GC removes entry when key is no longer in ordinary use

5. **Difference between fail-fast and fail-safe iterators**

| Iterator Type | Behavior                                 | Examples                                    |
| ------------- | ---------------------------------------- | ------------------------------------------- |
| Fail-fast     | Throws `ConcurrentModificationException` | `ArrayList`, `HashMap`                      |
| Fail-safe     | Works on clone or snapshot               | `CopyOnWriteArrayList`, `ConcurrentHashMap` |

---

## 🏛️ **Legacy Collections**

1. **What are legacy classes?**
   Classes from pre-Java 1.2 (before Collections API):

   * `Vector`, `Hashtable`, `Stack`, `Enumeration`

2. **Difference between `Vector` and `ArrayList`**

| Feature         | `ArrayList` | `Vector`                |
| --------------- | ----------- | ----------------------- |
| Thread-safe     | No          | Yes                     |
| Performance     | Faster      | Slower                  |
| Synchronization | Manual      | Built-in (synchronized) |

3. **Why is `Hashtable` considered obsolete?**

   * Fully synchronized = poor performance
   * No null keys or values
   * Replaced by `ConcurrentHashMap` and `HashMap`

---

Let me know if you'd like this as a PDF, markdown file, or printable cheat sheet!

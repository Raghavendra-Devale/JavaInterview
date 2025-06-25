## 🌐 **General Java Collections**

1. **What is the Java Collections Framework?**
   A unified architecture for representing and manipulating groups of objects, including interfaces (List, Set, Map, Queue), implementations, and utility classes.

2. **What are the benefits of using collections?**
   Reusability, flexibility, type safety (with generics), rich APIs, performance, and ease of manipulation.

3. **Difference between `Collection` and `Collections`?**

   * `Collection`: Interface for data structures like List, Set, Queue.
   * `Collections`: Utility class with static methods (e.g., `sort()`, `reverse()`).

4. **What is the root interface in collections?**

   * `Collection` for List, Set, Queue
   * `Map` is a separate root interface

5. **Why use generics with collections?**
   Provides compile-time type safety, removes the need for casting, improves readability.

---

## 📋 **List Interface**

1. **Difference between `ArrayList` and `LinkedList`**

| Feature       | ArrayList      | LinkedList         |
| ------------- | -------------- | ------------------ |
| Storage       | Dynamic array  | Doubly linked list |
| Access        | O(1)           | O(n)               |
| Insert/Delete | Slow in middle | Fast in middle     |

2. **When to use `Vector` over `ArrayList`?**
   When thread safety is needed. But `Vector` is legacy and generally avoided in modern code.

3. **How does `ListIterator` differ from `Iterator`?**
   `ListIterator` supports bidirectional traversal and can add/set elements during iteration.

4. **Can you modify a List during iteration?**
   Yes, safely using `ListIterator`. Using a regular `Iterator` allows only `remove()`.

5. **How does `ArrayList` grow?**
   Starts at capacity 10, then grows by 1.5x when full.

---

## 🔗 **Set Interface**

1. **Difference between `HashSet`, `LinkedHashSet`, `TreeSet`**

| Set Type      | Order Maintained | Sorted | Null Allowed |
| ------------- | ---------------- | ------ | ------------ |
| HashSet       | ❌                | ❌      | ✅ (1 null)   |
| LinkedHashSet | ✅ (insertion)    | ❌      | ✅            |
| TreeSet       | ❌ (sorted only)  | ✅      | ❌            |

2. **How does `HashSet` prevent duplicates?**
   Uses `hashCode()` and `equals()` to ensure uniqueness (internally uses a `HashMap`).

3. **How does `TreeSet` maintain ordering?**
   Via natural ordering or custom `Comparator`, implemented with a Red-Black Tree.

4. **Why override `equals()` and `hashCode()` for sets?**
   To ensure logical equality and proper hash-based storage.

---

## 📥 **Queue & Deque**

1. **Difference between `Queue` and `Deque`**

| Feature  | Queue (FIFO) | Deque (Double-ended)   |
| -------- | ------------ | ---------------------- |
| Access   | One end      | Both ends              |
| Use Case | Task queues  | Stack + Queue (hybrid) |

2. **How does `PriorityQueue` work?**
   Uses a min-heap structure to order elements by natural order or custom `Comparator`.

3. **How to implement a stack using Deque?**

```java
Deque<Integer> stack = new ArrayDeque<>();
stack.push(10);
stack.pop();
```

4. **Queue methods comparison**

| Method     | Behavior                           |
| ---------- | ---------------------------------- |
| `offer()`  | Insert, return false if full       |
| `add()`    | Insert, throw exception if full    |
| `poll()`   | Retrieve & remove, null if empty   |
| `remove()` | Remove, throws exception if empty  |
| `peek()`   | Retrieve, no remove, null if empty |

5. **Thread-safe queue alternatives**

   * `ConcurrentLinkedQueue`
   * `LinkedBlockingQueue`
   * `PriorityBlockingQueue`
   * `ArrayBlockingQueue`

---

## 🗺️ **Map Interface**

1. **Difference between `HashMap`, `TreeMap`, `LinkedHashMap`, `Hashtable`**

| Map Type      | Order           | Sorted | Thread-Safe | Null Support           |
| ------------- | --------------- | ------ | ----------- | ---------------------- |
| HashMap       | ❌               | ❌      | ❌           | ✅ (1 key, many values) |
| LinkedHashMap | Insertion order | ❌      | ❌           | ✅                      |
| TreeMap       | Sorted by key   | ✅      | ❌           | ❌ (if comparator used) |
| Hashtable     | ❌               | ❌      | ✅           | ❌                      |

2. **How does `HashMap` work internally?**
   Uses an array of buckets based on `hashCode()`. Collisions are handled via linked lists or trees (Java 8+).

3. **What if two keys have same hash code?**
   Placed in same bucket; `equals()` resolves identity.

4. **Time complexity of `HashMap` operations**

   * Best/Average case: O(1)
   * Worst case (collisions): O(log n) in tree buckets

5. **How does `ConcurrentHashMap` ensure thread safety?**

   * Java 7: segmented locking
   * Java 8+: bucket-level CAS + synchronized blocks for writes

6. **Nulls in Maps**

   * `HashMap`: 1 null key, many null values
   * `TreeMap`: no null key if comparator is used
   * `Hashtable`: no null keys/values

---

## 🔁 **Iteration Techniques**

1. **Ways to iterate a collection**

```java
for (String s : list) {}
list.forEach(System.out::println);

Iterator<String> it = list.iterator();
while (it.hasNext()) { it.next(); }

ListIterator<String> lit = list.listIterator();
```

2. **Iterator vs Enumeration**

| Feature        | Iterator | Enumeration |
| -------------- | -------- | ----------- |
| Remove support | ✅        | ❌           |
| Modern use     | ✅        | ❌ (legacy)  |

3. **Fail-fast vs Fail-safe iterators**

| Type      | Behavior                                 | Examples                                    |
| --------- | ---------------------------------------- | ------------------------------------------- |
| Fail-fast | Throws `ConcurrentModificationException` | `ArrayList`, `HashMap`                      |
| Fail-safe | Works on a snapshot or clone             | `ConcurrentHashMap`, `CopyOnWriteArrayList` |

4. **What causes `ConcurrentModificationException`?**
   Modifying the collection directly during iteration without using `Iterator.remove()`.

---

## 🔍 **Sorting & Searching**

1. **Comparable vs Comparator**

| Feature   | Comparable           | Comparator             |
| --------- | -------------------- | ---------------------- |
| Interface | Implemented in class | External or lambda     |
| Method    | `compareTo()`        | `compare()`            |
| Use case  | Natural order        | Custom multiple orders |

2. **Sort a list of objects**

```java
Collections.sort(list); // if implements Comparable

Collections.sort(list, Comparator.comparing(Employee::getAge)); // custom
```

3. **How does `Collections.sort()` work?**
   Uses **TimSort**, optimized hybrid of merge sort and insertion sort.

4. **Binary search on collections**

```java
int index = Collections.binarySearch(sortedList, key);
```

Requires the list to be sorted before searching.

---

## 🔐 **Thread-Safety in Collections**

1. **Are Java collections thread-safe by default?**
   No. Most (e.g., `ArrayList`, `HashMap`) are not thread-safe.

2. **How to make collections thread-safe?**

   * `Collections.synchronizedList()`
   * `CopyOnWriteArrayList`
   * Use concurrent collections (`ConcurrentHashMap`)

3. **`synchronizedList` vs `CopyOnWriteArrayList`**

| Feature         | synchronizedList    | CopyOnWriteArrayList |
| --------------- | ------------------- | -------------------- |
| Synchronization | External            | Internal             |
| Best for        | Balanced read/write | Read-heavy workloads |

---

## 🧠 **Advanced & Edge Cases**

1. **Remove duplicates from a List**

```java
List<String> unique = new ArrayList<>(new HashSet<>(list));
```

2. **Detect circular references in a graph**

```java
Set<Node> visited = new HashSet<>();
boolean hasCycle(Node node) {
    if (!visited.add(node)) return true;
    for (Node child : node.neighbors) {
        if (hasCycle(child)) return true;
    }
    return false;
}
```

3. **Implement LRU cache using `LinkedHashMap`**

```java
new LinkedHashMap<>(capacity, 0.75f, true) {
   protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
       return size() > capacity;
   }
};
```

4. **How does `WeakHashMap` work?**
   Uses weak references for keys; if the key has no strong reference elsewhere, it's garbage-collected automatically.

---

## 🏛️ **Legacy Collections**

1. **What are legacy collection classes?**
   Pre-Java 1.2 classes like `Vector`, `Hashtable`, `Stack`, and `Enumeration`.

2. **Why is `Hashtable` considered obsolete?**

   * Fully synchronized → poor performance
   * No null keys/values
   * Replaced by `ConcurrentHashMap`

3. **Difference between `Vector` and `ArrayList`**

| Feature     | Vector (legacy)   | ArrayList     |
| ----------- | ----------------- | ------------- |
| Thread-safe | Yes               | No (can sync) |
| Performance | Slower            | Faster        |
| Usage       | Avoid in new code | Preferred     |

---

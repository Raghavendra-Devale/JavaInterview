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



##  **General Java Collections**

### 1. **What is the Java Collections Framework?**

It's a **set of classes and interfaces** that provide data structures like lists, sets, queues, and maps, along with algorithms to manipulate them. It's part of `java.util`.

---

### 2. **Difference between `Collection` and `Collections`?**

* `Collection`: Root interface for data structures like `List`, `Set`, and `Queue`.
* `Collections`: Utility class with static methods like `sort()`, `reverse()`, `shuffle()`, etc.

---

### 3. **Why use generics with collections?**

Generics provide **type safety** at compile-time and eliminate the need for casting.

```java
List<String> list = new ArrayList<>(); // safer than using raw types
```

---

##  **List Interface**

### 1. **`ArrayList` vs `LinkedList`**

| Feature      | ArrayList          | LinkedList         |
| ------------ | ------------------ | ------------------ |
| Data Storage | Dynamic array      | Doubly linked list |
| Access Time  | O(1) (index-based) | O(n)               |
| Insertion    | Slower in middle   | Faster             |
| Memory       | Less overhead      | More overhead      |

---

### 2. **What is `ListIterator`?**

It's a bidirectional iterator that allows modification of elements and traversal in both directions, unlike `Iterator` which is forward-only.

---

### 3. **Can you add elements while iterating?**

Yes, using `ListIterator.add()`, but not with a regular `Iterator` unless you want a `ConcurrentModificationException`.

---

##  **Set Interface**

### 1. **Difference between `HashSet`, `LinkedHashSet`, and `TreeSet`**

| Set Type        | Order Maintained | Performance | Sorting |
| --------------- | ---------------- | ----------- | ------- |
| `HashSet`       | No               | Fast        | No      |
| `LinkedHashSet` | Insertion order  | Moderate    | No      |
| `TreeSet`       | Sorted           | Slower      | Yes     |

---

### 2. **How does `HashSet` prevent duplicates?**

It uses the **`hashCode()`** and **`equals()`** methods of objects to ensure uniqueness.

---

### 3. **Can a Set contain null?**

* `HashSet`: Yes (only one null)
* `TreeSet`: No (throws `NullPointerException` if comparator doesn't allow it)

---

##  **Queue & Deque**

### 1. **How does `PriorityQueue` order elements?**

By **natural ordering** (Comparable) or **custom Comparator** provided during construction.

---

### 2. **Stack via `Deque` example:**

```java
Deque<Integer> stack = new ArrayDeque<>();
stack.push(1); stack.push(2); // LIFO
stack.pop(); // returns 2
```

---

### 3. **Methods like `offer()`, `poll()`, `peek()`**

| Method    | Behavior                      |
| --------- | ----------------------------- |
| `offer()` | Add element (returns boolean) |
| `poll()`  | Remove and return head        |
| `peek()`  | Return head without removal   |

---

##  **Map Interface**

### 1. **`HashMap` vs `TreeMap` vs `LinkedHashMap`**

| Map Type        | Order           | Sorted | Performance |
| --------------- | --------------- | ------ | ----------- |
| `HashMap`       | Unordered       | No     | Fast        |
| `LinkedHashMap` | Insertion order | No     | Moderate    |
| `TreeMap`       | Sorted by keys  | Yes    | Slower      |

---

### 2. **How does `HashMap` work?**

It uses a **hashing mechanism** to store key-value pairs in **buckets**. If keys have the same hash, it uses a **linked list** or **red-black tree** (from Java 8 onwards) to resolve collisions.

---

### 3. **Can a Map have null keys or values?**

* `HashMap`: One null key, multiple null values
* `TreeMap`: No null key if comparator is used
* `Hashtable`: No null key or value

---

##  **Iteration**

### 1. **Fail-fast vs Fail-safe**

* **Fail-fast**: Throws `ConcurrentModificationException` if modified during iteration (`ArrayList`, `HashMap`)
* **Fail-safe**: Allows modification without error (`ConcurrentHashMap`, `CopyOnWriteArrayList`)

---

### 2. **Different ways to iterate**

```java
// For-each loop
for (String s : list) {}

// Iterator
Iterator<String> it = list.iterator();
while(it.hasNext()) {
  it.next();
}

// Stream API
list.stream().forEach(System.out::println);
```

---

##  **Sorting and Searching**

### 1. **Comparable vs Comparator**

* `Comparable`: Natural order, implemented in the class (`compareTo()`)
* `Comparator`: Custom order, defined externally (`compare()`)

```java
class Student implements Comparable<Student> {
    public int compareTo(Student s) {
        return this.age - s.age;
    }
}
```

---

### 2. **How does `Collections.sort()` work?**

Internally uses a variant of **TimSort**, a hybrid of merge sort and insertion sort (efficient for real-world data).

---

##  **Synchronization & Thread-Safety**

### 1. **Thread-safe alternatives**

* `Collections.synchronizedList(new ArrayList<>())`
* `CopyOnWriteArrayList`
* `ConcurrentHashMap`

---

### 2. **Why prefer `ConcurrentHashMap` over `Hashtable`?**

Better concurrency by dividing the map into **segments**, allowing concurrent updates without locking the entire map.

---

### 3. **Difference between `Hashtable` and `HashMap`**

| Feature     | `HashMap` | `Hashtable` |
| ----------- | --------- | ----------- |
| Thread-safe | No        | Yes         |
| Null keys   | Allowed   | Not allowed |
| Performance | Faster    | Slower      |

---

##  **Advanced Topics**

### 1. **Remove duplicates from a list**

```java
List<String> list = new ArrayList<>(Set.copyOf(originalList));
```

### 2. **Which collection to use for LRU Cache?**

* `LinkedHashMap` with access-order set to `true`, and overriding `removeEldestEntry()`.

---


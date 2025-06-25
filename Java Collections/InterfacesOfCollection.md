

##  ** Key Interfaces in Java Collections Framework (In Depth)**

---

###  1. **`Collection<E>`** – The Root Interface

**Purpose**: Defines the basic operations common to most collections, such as adding/removing elements, checking size, etc.

```java
Collection<String> names = new ArrayList<>();
names.add("Alice");
names.add("Bob");
System.out.println(names.size()); // 2
```

**Important Methods**:

* `add(E e)`
* `remove(Object o)`
* `contains(Object o)`
* `isEmpty()`
* `size()`
* `iterator()`

**Notes**:

* Extended by `List`, `Set`, and `Queue`
* Not implemented directly, but forms the base of all collection types (except `Map`)

---

###  2. **`List<E>`** – Ordered Collection

**Purpose**: A sequence of elements where order matters and duplicates are allowed. Index-based access is available.

```java
List<String> list = new ArrayList<>();
list.add("apple");
list.add("banana");
list.add("apple"); // Duplicates allowed
System.out.println(list.get(1)); // banana
```

**Common Implementations**:

* `ArrayList` – backed by dynamic array
* `LinkedList` – doubly-linked list
* `Vector` – legacy, synchronized

**Key Methods**:

* `get(int index)`
* `add(int index, E element)`
* `remove(int index)`
* `indexOf(Object o)`, `lastIndexOf(Object o)`
* `subList(int fromIndex, int toIndex)`

**Use Case**:

* Maintain insertion order and access by position
* Example: Shopping cart items

---

###  3. **`Set<E>`** – Unique Elements Only

**Purpose**: Collection that does **not allow duplicate elements**.

```java
Set<String> set = new HashSet<>();
set.add("apple");
set.add("banana");
set.add("apple"); // Ignored
System.out.println(set.size()); // 2
```

**Common Implementations**:

* `HashSet` – unordered, backed by `HashMap`
* `LinkedHashSet` – preserves insertion order
* `TreeSet` – sorted, uses `TreeMap` internally

**Key Methods** (inherited from `Collection`):

* `add(E e)`
* `contains(Object o)`
* `remove(Object o)`
* `iterator()`

**Use Case**:

* Storing unique IDs, tags, or categories

---

###  4. **`SortedSet<E>` & `NavigableSet<E>`** – Ordered Sets

**SortedSet**: Keeps elements in **natural order** or using a custom comparator
**NavigableSet**: Extends `SortedSet` with navigation features

```java
SortedSet<Integer> set = new TreeSet<>();
set.add(10);
set.add(5);
set.add(20);
System.out.println(set); // [5, 10, 20]

NavigableSet<Integer> navSet = (NavigableSet<Integer>) set;
System.out.println(navSet.lower(10)); // 5
```

**Key Methods (NavigableSet)**:

* `lower(E e)`, `higher(E e)`
* `floor(E e)`, `ceiling(E e)`
* `pollFirst()`, `pollLast()`

**Use Case**:

* Leaderboards, range queries, sorted data views

---

###  5. **`Queue<E>` & `Deque<E>`** – FIFO / LIFO Structures

#### `Queue<E>`:

* First-In-First-Out (FIFO)
* Often used in task scheduling, messaging

```java
Queue<String> queue = new LinkedList<>();
queue.add("task1");
queue.add("task2");
System.out.println(queue.poll()); // task1
```

#### `Deque<E>`:

* Double-ended queue (can be used as Stack or Queue)

```java
Deque<String> deque = new ArrayDeque<>();
deque.addFirst("front");
deque.addLast("back");
System.out.println(deque.removeLast()); // back
```

**Use Case**:

* Task queues, undo stacks, real-time scheduling

---

###  6. **`Map<K, V>`** – Key-Value Pairs

**Purpose**: Stores key-value pairs with **unique keys**

```java
Map<String, Integer> map = new HashMap<>();
map.put("Alice", 85);
map.put("Bob", 92);
System.out.println(map.get("Bob")); // 92
```

**Common Implementations**:

* `HashMap` – fast, unordered
* `LinkedHashMap` – insertion order maintained
* `TreeMap` – sorted by key
* `Hashtable` – legacy, synchronized

**Key Methods**:

* `put(K key, V value)`
* `get(Object key)`
* `remove(Object key)`
* `containsKey(Object key)`
* `keySet()`, `entrySet()`, `values()`

**Use Case**:

* Dictionaries, configurations, caches

---

###  7. **`SortedMap<K, V>` & `NavigableMap<K, V>`**

* Just like `SortedSet`, but for `Map`
* Keeps keys in a **sorted** order (natural or custom)
* `TreeMap` is the main implementation

```java
SortedMap<String, Integer> scores = new TreeMap<>();
scores.put("Math", 90);
scores.put("English", 85);
System.out.println(scores.firstKey()); // English
```

**Key Methods (NavigableMap)**:

* `lowerKey(K key)`, `ceilingKey(K key)`
* `subMap()`, `headMap()`, `tailMap()`

**Use Case**:

* Range queries, leaderboards, ordered maps

---
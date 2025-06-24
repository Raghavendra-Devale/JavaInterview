### What Is Java Collections Framework?

The **Java Collections Framework** (JCF) is a unified architecture for representing and manipulating collections. It includes:

- **Interfaces**: Abstract data types (e.g., `List`, `Set`, `Queue`, `Map`)
- **Implementations**: Concrete classes like `ArrayList`, `HashSet`, `LinkedList`, etc.
- **Algorithms**: Utility methods like sorting, searching, shuffling (via the `Collections` class)
- **Legacy classes**: Like `Vector` and `Hashtable`, made compatible with the new collection interfaces

---

### Core Interfaces

| Interface    | Description                                                   |
| ------------ | ------------------------------------------------------------- |
| `Collection` | Root interface for most collections (except `Map`)            |
| `List`       | Ordered collection (allows duplicates), indexed access        |
| `Set`        | Unordered collection that does not allow duplicates           |
| `Queue`      | Collection used to hold multiple elements prior to processing |
| `Deque`      | Double-ended queue; can insert/remove from both ends          |
| `Map`        | Key-value pairs, no duplicate keys                            |

---

### Main Implementations

#### 1. **List Implementations**

| Class        | Description                                             |
| ------------ | ------------------------------------------------------- |
| `ArrayList`  | Resizable array, fast random access, slow insert/remove |
| `LinkedList` | Doubly-linked list, fast insert/remove, slower access   |
| `Vector`     | Legacy synchronized list                                |
| `Stack`      | LIFO (extends `Vector`)                                 |

#### 2. **Set Implementations**

| Class           | Description                                               |
| --------------- | --------------------------------------------------------- |
| `HashSet`       | No duplicates, unordered, uses hashing                    |
| `LinkedHashSet` | Maintains insertion order                                 |
| `TreeSet`       | Sorted set (natural or custom order), uses Red-Black Tree |

#### 3. **Queue/Deque Implementations**

| Class           | Description                                     |
| --------------- | ----------------------------------------------- |
| `PriorityQueue` | Elements ordered by natural order or comparator |
| `ArrayDeque`    | Resizable array for double-ended queue          |
| `LinkedList`    | Can be used as a queue, stack, or deque         |

#### 4. **Map Implementations**

| Class               | Description                      |
| ------------------- | -------------------------------- |
| `HashMap`           | Unordered key-value pairs        |
| `LinkedHashMap`     | Maintains insertion order        |
| `TreeMap`           | Sorted map by key                |
| `Hashtable`         | Legacy synchronized map          |
| `ConcurrentHashMap` | Thread-safe version of `HashMap` |

---

### Utility Classes

- `Collections`: Static methods like `sort()`, `shuffle()`, `reverse()`, `binarySearch()`, `synchronizedList()`, etc.
- `Arrays`: Utility methods for arrays, like `asList()`, `sort()`, etc.

---

### Key Features

- **Generic support**: Type-safe collections (e.g., `List<String>`)
- **Thread safety**: Collections are not thread-safe by default, but wrappers are available
- **Sorting & Searching**: Built-in algorithms in `Collections` class
- **Comparable vs Comparator**: Custom sorting mechanisms

---

### Example: Using `ArrayList`

```java
import java.util.*;

public class Example {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Apple"); // Duplicates allowed

        Collections.sort(list);
        System.out.println(list); // [Apple, Apple, Banana]
    }
}
```

---

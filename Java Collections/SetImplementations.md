##  **4. Set Implementations in Java (In Depth)**

A `Set` is a **collection that does not allow duplicates**. Java provides multiple implementations for different needs:

---

### ✅ 1. **HashSet**

### 🔧 Internal Working:

* Backed by a **HashMap**
* Uses the **hashCode()** and **equals()** methods to determine uniqueness
* **Does not maintain order**

```java
Set<String> set = new HashSet<>();
set.add("Java");
set.add("Python");
set.add("Java"); // Ignored (duplicate)
```

### ✅ Advantages:

* Very **fast operations** (add, remove, contains) — average O(1)
* Best choice for general-purpose sets

### ❌ Disadvantages:

* **No guaranteed order**
* **Poor performance** if hash functions are poorly implemented

### 📌 Use Cases:

* Storing **unique items**, e.g., unique usernames, email addresses

---

### ✅ 2. **LinkedHashSet**

### 🔧 Internal Working:

* Inherits from `HashSet`
* Maintains a **doubly-linked list** of elements for insertion order

```java
Set<String> set = new LinkedHashSet<>();
set.add("C");
set.add("A");
set.add("B");
System.out.println(set); // [C, A, B]
```

### ✅ Advantages:

* Predictable **insertion order**
* Nearly same performance as `HashSet`

### ❌ Disadvantages:

* Slightly **more memory** than `HashSet`
* Still not sorted

### 📌 Use Cases:

* Need both **uniqueness and predictable order**
* Example: Caching recent items

---

### ✅ 3. **TreeSet**

### 🔧 Internal Working:

* Backed by a **Red-Black Tree** (self-balancing BST)
* Stores elements in **sorted order**
* Implements `NavigableSet` and `SortedSet`

```java
Set<Integer> set = new TreeSet<>();
set.add(30);
set.add(10);
set.add(20);
System.out.println(set); // [10, 20, 30]
```

### ✅ Advantages:

* Maintains **natural or custom order**
* Supports **range operations** (`headSet()`, `tailSet()`)

### ❌ Disadvantages:

* Slower than `HashSet` (O(log n) for most operations)
* Requires elements to be **Comparable** or have a **Comparator**

### 📌 Use Cases:

* **Sorted unique elements**: e.g., leaderboard, rankings, calendars

---

### ✅ 4. **EnumSet**

### 🔧 Internal Working:

* Optimized set implementation for use with **enum types only**
* Backed by a **bit vector**

```java
enum Day { MON, TUE, WED }
EnumSet<Day> days = EnumSet.of(Day.MON, Day.WED);
```

### ✅ Advantages:

* Extremely **fast** and **memory efficient**
* Safer than using `HashSet<Enum>`

### ❌ Disadvantages:

* Only works with enums

### 📌 Use Cases:

* Flag sets, configuration enums

---

### 🧠 Summary Comparison Table

| Implementation    | Order Maintained? | Sorted? | Performance       | Thread-Safe | Use Case                            |
| ----------------- | ----------------- | ------- | ----------------- | ----------- | ----------------------------------- |
| **HashSet**       | ❌ No              | ❌ No    | O(1) average      | ❌           | Unique values with best performance |
| **LinkedHashSet** | ✅ Insertion       | ❌ No    | O(1) average      | ❌           | Ordered unique values               |
| **TreeSet**       | ✅ Sorted          | ✅ Yes   | O(log n)          | ❌           | Sorted collections                  |
| **EnumSet**       | ✅ Enum Order      | ✅ Yes   | O(1) bit-wise ops | ❌           | Efficient enum flags                |

---

### ⚠️ Notes on Thread Safety

* None of the standard `Set` implementations are thread-safe
* Use:

  ```java
  Set<String> syncSet = Collections.synchronizedSet(new HashSet<>());
  ```

  Or for concurrency: `ConcurrentSkipListSet` (sorted + concurrent)

---
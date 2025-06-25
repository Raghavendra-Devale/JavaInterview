## 🔷 **7. Iteration Techniques in Java (In Depth)**

### ✅ 1. **Using `for-each` Loop (Enhanced for loop)**

Works with anything that implements `Iterable` (e.g., List, Set, Queue).

```java
List<String> names = List.of("Alice", "Bob", "Carol");
for (String name : names) {
    System.out.println(name);
}
```

* **Readable and clean**
* Cannot remove elements during iteration

---

### ✅ 2. **Using `Iterator`**

Gives more control and allows safe removal during iteration.

```java
List<String> names = new ArrayList<>(List.of("A", "B", "C"));
Iterator<String> it = names.iterator();
while (it.hasNext()) {
    String val = it.next();
    if (val.equals("B")) {
        it.remove(); // Safe removal
    }
}
```

* Use `iterator.remove()` instead of `list.remove()` to avoid `ConcurrentModificationException`

---

### ✅ 3. **Using `ListIterator`** (for Lists only)

Bi-directional iterator that allows **forward and backward traversal**, **in-place updates**, and **insertion**.

```java
List<String> items = new ArrayList<>(List.of("X", "Y", "Z"));
ListIterator<String> lit = items.listIterator();
while (lit.hasNext()) {
    if (lit.next().equals("Y")) {
        lit.set("YY");
        lit.add("NEW"); // Adds after "YY"
    }
}
```

* Only available for Lists
* Supports `add()`, `set()`, `remove()` during iteration

---

### ✅ 4. **Using `for` Loop with Index (Lists only)**

```java
List<Integer> nums = List.of(10, 20, 30);
for (int i = 0; i < nums.size(); i++) {
    System.out.println(nums.get(i));
}
```

* Ideal when index access is needed
* Works well with `ArrayList`

---

### ✅ 5. **Using `Map` Iteration**

#### a) Iterate over `entrySet()`

```java
Map<String, Integer> map = Map.of("A", 1, "B", 2);
for (Map.Entry<String, Integer> entry : map.entrySet()) {
    System.out.println(entry.getKey() + " = " + entry.getValue());
}
```

#### b) Iterate over `keySet()` and `values()`

```java
for (String key : map.keySet()) {
    System.out.println("Key: " + key);
}
for (Integer val : map.values()) {
    System.out.println("Value: " + val);
}
```

* `entrySet()` is preferred for accessing both key and value together

---

### ✅ 6. **Using `forEach()` with Lambda (Java 8+)**

```java
List<String> list = List.of("apple", "banana");
list.forEach(item -> System.out.println(item));

Map<String, Integer> map = Map.of("x", 1, "y", 2);
map.forEach((k, v) -> System.out.println(k + ":" + v));
```

* Functional, concise
* Can't break out of the loop (`break/return` not allowed like in a normal loop)

---

### ✅ 7. **Using Streams (Java 8+)**

```java
List<Integer> nums = List.of(1, 2, 3, 4);
nums.stream().filter(n -> n % 2 == 0).forEach(System.out::println);
```

* Declarative and powerful
* Supports map/filter/reduce operations

---

### 🧠 Summary Table

| Technique          | Collection Types | Modifiable? | Direction      | Best For                      |
| ------------------ | ---------------- | ----------- | -------------- | ----------------------------- |
| `for-each` loop    | All (`Iterable`) | ❌           | Forward        | Simple iteration              |
| `Iterator`         | All (`Iterable`) | ✅ (remove)  | Forward        | Safe removal                  |
| `ListIterator`     | Lists only       | ✅           | Bi-directional | In-place changes              |
| `for` with index   | Lists only       | ✅           | Forward        | Index-based logic             |
| `entrySet`, etc.   | Maps             | ❌           | Forward        | Key-value access              |
| `forEach()` lambda | All              | ❌           | Forward        | Concise functional processing |
| `Streams`          | All              | ❌           | Forward        | Filtering, mapping, reducing  |

---

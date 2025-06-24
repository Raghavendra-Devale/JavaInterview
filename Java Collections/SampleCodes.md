##  **1. ArrayList Basics**

**Task:** Create an `ArrayList` of integers. Add elements 1 to 10, remove even numbers, and print the result.

```java
import java.util.*;

public class ArrayListPractice {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }

        list.removeIf(n -> n % 2 == 0); // Remove even numbers
        System.out.println("After removing evens: " + list);
    }
}
```

---

##  **2. Set Uniqueness Check**

**Task:** Remove duplicates from a list using a `HashSet`.

```java
List<String> names = Arrays.asList("Tom", "Alice", "Tom", "Bob");
Set<String> uniqueNames = new HashSet<>(names);
System.out.println(uniqueNames);
```

---

##  **3. Map Lookup Practice**

**Task:** Use a `HashMap` to count word frequencies.

```java
String text = "apple banana apple orange banana apple";
String[] words = text.split(" ");
Map<String, Integer> freq = new HashMap<>();

for (String word : words) {
    freq.put(word, freq.getOrDefault(word, 0) + 1);
}

System.out.println(freq); // Output: {apple=3, banana=2, orange=1}
```

---

##  **4. Sort Custom Objects**

**Task:** Sort a list of `Student` objects by age using `Comparable`.

```java
class Student implements Comparable<Student> {
    String name;
    int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int compareTo(Student other) {
        return Integer.compare(this.age, other.age);
    }

    public String toString() {
        return name + " (" + age + ")";
    }
}

public class SortStudents {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Alice", 22),
            new Student("Bob", 20),
            new Student("Charlie", 25)
        );

        Collections.sort(students);
        System.out.println(students);
    }
}
```

---

##  **5. LRU Cache with LinkedHashMap**

**Task:** Implement a simple LRU cache using `LinkedHashMap`.

```java
class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private int capacity;

    LRUCache(int capacity) {
        super(capacity, 0.75f, true); // accessOrder = true
        this.capacity = capacity;
    }

    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }
}

public class TestLRU {
    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>(3);
        cache.put(1, "One");
        cache.put(2, "Two");
        cache.put(3, "Three");
        cache.get(1); // Access 1
        cache.put(4, "Four"); // Evicts 2

        System.out.println(cache); // {3=Three, 1=One, 4=Four}
    }
}
```

---

##  **6. Fail-Fast Iterator Demonstration**

```java
List<String> list = new ArrayList<>(List.of("A", "B", "C"));

for (String s : list) {
    if (s.equals("B")) {
        list.remove(s); // Throws ConcurrentModificationException
    }
}
```

**Fix:**

```java
Iterator<String> it = list.iterator();
while (it.hasNext()) {
    if (it.next().equals("B")) {
        it.remove();
    }
}
```
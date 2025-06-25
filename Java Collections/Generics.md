## 🔷 **8. Generics in Java Collections (In Depth)**

### 🧩 What Are Generics?

Generics allow you to define **classes, interfaces, and methods** that work with **typed parameters** — so you can write **type-safe and reusable code**.

### 🚫 Without Generics (Pre-Java 5):

```java
List list = new ArrayList();   // Raw type
list.add("hello");
String s = (String) list.get(0); // Manual casting
```

* ✅ Flexible
* ❌ Prone to `ClassCastException`
* ❌ Type safety lost

---

### ✅ With Generics:

```java
List<String> list = new ArrayList<>();
list.add("hello");
String s = list.get(0);  // No casting needed
```

* ✅ Type safety at compile time
* ✅ No explicit casting
* ✅ Improved readability and tooling

---

### 🔧 Syntax of Generics:

```java
ClassName<Type> object = new ClassName<>();
```

Example:

```java
Map<String, Integer> scores = new HashMap<>();
```

---

### ✅ Why Use Generics in Collections?

1. **Compile-time type checking**
2. **Avoids ClassCastException**
3. **Removes the need for casting**
4. **Cleaner and more maintainable code**

---

### 🎯 Generics with Common Collections

#### ✔️ List

```java
List<Integer> numbers = new ArrayList<>();
```

#### ✔️ Set

```java
Set<String> words = new HashSet<>();
```

#### ✔️ Map

```java
Map<String, Double> prices = new HashMap<>();
```

---

### 🔄 Wildcards in Generics

#### ✅ `?` – Unbounded Wildcard

```java
List<?> list = new ArrayList<String>();
```

* Means: List of **unknown type**
* Good for **read-only** operations

#### ✅ `? extends T` – Upper Bounded Wildcard

```java
List<? extends Number> nums = new ArrayList<Integer>();
```

* Accepts `Integer`, `Double`, etc.
* Can **read** elements, but can't safely **add**

#### ✅ `? super T` – Lower Bounded Wildcard

```java
List<? super Integer> ints = new ArrayList<Number>();
ints.add(10); // Allowed
```

* Good for **writing** (contravariance)

---

### ⚠️ Limitations of Generics

* No primitive types: use wrapper classes (`int` ➝ `Integer`)
* Type erasure: generic type information is **not retained** at runtime
* Cannot create generic arrays: `new T[]` is not allowed
* Cannot use instanceof with parameterized types: `if (obj instanceof List<String>)`

---

### 🧠 Generic Method Example

```java
public <T> void printList(List<T> list) {
    for (T item : list) {
        System.out.println(item);
    }
}
```

* Works with `List<String>`, `List<Integer>`, etc.

---

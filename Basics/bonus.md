## 🎯 Bonus: Other Common Java Interview Questions (With Answers)

### 1. What is the difference between `==` and `.equals()` in Java?

- `==` compares **object references** (memory addresses).
- `.equals()` compares **object contents or values** (can be overridden in custom classes).

```java
String a = new String("hello");
String b = new String("hello");

System.out.println(a == b);        // false (different objects)
System.out.println(a.equals(b));   // true  (same content)
```

---

### 2. What is a constructor? Can it be overloaded?

**Constructor:** A special method that is called when an object is instantiated using `new`. It initializes the object.

- Has the same name as the class
- No return type (not even `void`)
- Can be overloaded

```java
class Person {
    Person() { }                  // default constructor
    Person(String name) { }       // overloaded constructor
}
```

---

### 3. What are static methods and static blocks?

- **Static Method:** Belongs to the class, not instances. Can be called without creating an object.

```java
class Demo {
    static void greet() {
        System.out.println("Hi");
    }
}
Demo.greet();  // No object needed
```

- **Static Block:** Executes once when the class is loaded. Used to initialize static variables.

```java
static {
    System.out.println("Class loaded");
}
```

---

### 4. What is the difference between `final`, `finally`, and `finalize()`?

| Keyword     | Purpose                                         |
|-------------|-------------------------------------------------|
| `final`     | Used to declare constants, prevent inheritance or method overriding |
| `finally`   | Block that always executes after `try-catch`    |
| `finalize()`| Method called by GC before object destruction (deprecated) |

---

### 5. What is the use of the `this` keyword in Java?

- Refers to the **current object** inside an instance method or constructor.
- Used to avoid variable shadowing and call other constructors.

```java
class Car {
    String model;
    Car(String model) {
        this.model = model;  // disambiguates local and instance variable
    }
}
```

---

### 6. How is memory managed in Java?

- **Heap:** Stores objects
- **Stack:** Stores method frames and local variables
- **Garbage Collector (GC):** Automatically deallocates unused objects

```java
String s = new String("Java"); // 's' in stack, object in heap
```

---

### 7. What is autoboxing and unboxing?

- **Autoboxing:** Automatic conversion of primitive → wrapper object
- **Unboxing:** Conversion of wrapper → primitive

```java
int a = 10;
Integer obj = a;        // autoboxing
int b = obj;            // unboxing
```

---

### 8. What are the access modifiers in Java?

| Modifier   | Access Scope                  |
|------------|-------------------------------|
| `private`  | Within the same class         |
| `default`  | Within the same package       |
| `protected`| Package + subclasses          |
| `public`   | Everywhere                    |

---

### 9. What is the difference between `ArrayList` and `LinkedList`?

| Feature        | `ArrayList`               | `LinkedList`                |
|----------------|---------------------------|-----------------------------|
| Backed By      | Dynamic Array             | Doubly Linked List          |
| Access Time    | Fast (O(1) random access) | Slow (O(n) traversal)       |
| Insertion/Del  | Slow (shifting elements)  | Fast (add/remove at ends)   |

---

### 10. How is exception handling done in Java? Explain `try-catch-finally`.

- **try block:** Code that may throw exception
- **catch block:** Handles specific exceptions
- **finally block:** Always executes (cleanup, closing resources)

```java
try {
    int a = 5 / 0;
} catch (ArithmeticException e) {
    System.out.println("Cannot divide by zero");
} finally {
    System.out.println("Cleanup code");
}
```

---

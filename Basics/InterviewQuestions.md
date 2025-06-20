
# Java Basics & I/O – Most Asked Interview Questions (In-Depth)

## 1. What is the difference between JDK, JRE, and JVM?

| Component | Definition | Purpose | Contains |
|----------|------------|---------|----------|
| **JDK** (Java Development Kit) | Complete development toolset | To **develop, compile,     run,    debug** Java apps | JRE + Compiler (`javac`), tools (`jar`, `javadoc`, etc.) |
______________________________________________________________________________________
| **JRE** (Java Runtime Environment) | Java execution environment | To **run** Java applications | JVM + core libraries |
______________________________________________________________________________________
| **JVM** (Java Virtual Machine) | Abstract machine | To **execute bytecode (.class)** | Class loader, memory manager, JIT |
______________________________________________________________________________________________

## 2. Why is Java platform independent?

## Definition: Java is platform-independent because compiled bytecode can run on any system that has a compatible JVM, regardless of OS or hardware.

### Internals:
- `javac` compiles `.java` → `.class` (bytecode)
- JVM runs `.class` on **any OS**
- Bytecode is the same for all platforms

**Flow:**

```bash
javac Hello.java → Hello.class → Run on any JVM (Windows, Linux, Mac)
```

**Keyword:** WORA – *Write Once, Run Anywhere*

---

## 3. What are primitive vs non-primitive data types?

| Type | Definition | Examples | Memory Location |
|------|------------|----------|-----------------|
| **Primitive** | Built-in simple data types | `int`, `float`, `char`, `boolean` | Stored on stack |
| **Non-Primitive** | Objects and class-based types | `String`, `Scanner`, `Array` | Objects on heap, references on stack |

### Notes:
- Primitive types store actual values
- Non-primitive types store references
- Only non-primitives can be `null`

```java
int age = 25;          // Primitive
String name = "John";  // Non-primitive
```

---

## 4. What is the default value of int, float, char, boolean?

> Only **instance variables** (class-level) have default values.  
> **Local variables** must be explicitly initialized.

| Type      | Default Value    |
|-----------|------------------|
| `int`     | `0`              |
| `float`   | `0.0f`           |
| `char`    | `\u0000` (null char) |
| `boolean` | `false`          |

### Example:

```java
class Demo {
    int x;         // default 0
    boolean flag;  // default false

    void test() {
        int y;     // ❌ Compile error if used without init
    }
}
```

---

## 5. Explain how Scanner is used to take input.

**Definition:**  
`Scanner` is a utility class from `java.util` that reads user input from various sources (keyboard, files, strings).

### Example:

```java
import java.util.Scanner;

Scanner sc = new Scanner(System.in);
int age = sc.nextInt();
String name = sc.nextLine();
```

### How it works:
- Internally uses `BufferedReader`
- Splits input using whitespace (default delimiter)
- Uses wrapper parsers (`Integer.parseInt`, etc.)

### Common Pitfall:

```java
int x = sc.nextInt();
String name = sc.nextLine(); // ❌ reads leftover \n
```

**Fix:**

```java
int x = sc.nextInt();
sc.nextLine();               // ✅ consume leftover newline
String name = sc.nextLine();
```

### Common Methods:

| Method         | Description            |
|----------------|------------------------|
| `nextInt()`    | Reads integer          |
| `nextLine()`   | Reads entire line      |
| `next()`       | Reads next word/token  |
| `hasNext()`    | Checks if more input   |

---

## 🎯 Bonus: Other Common Java Interview Questions (Basic)

1. What is the difference between `==` and `.equals()` in Java?
2. What is a constructor? Can it be overloaded?
3. What are static methods and static blocks?
4. What is the difference between `final`, `finally`, and `finalize()`?
5. What is the use of the `this` keyword in Java?
6. How is memory managed in Java?
7. What is autoboxing and unboxing?
8. What are the access modifiers in Java?
9. What is the difference between `ArrayList` and `LinkedList`?
10. How is exception handling done in Java? Explain `try-catch-finally`.

---

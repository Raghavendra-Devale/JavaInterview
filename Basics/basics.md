## Java Basics & I/O — In-Depth with Definitions & Internals

## 1. ⚙️ JVM, JRE, JDK — Beyond the Definitions


### 🔹 JDK (Java Development Kit)

## Definition: A full software development kit for Java that includes the compiler, debugger, and tools necessary to write and build Java applications.
Contains:
 `javac` – Java compiler
 `jdb` – Debugger
 `javap`, `javadoc`, `jar` – Disassembler, doc generator, archive tool
 **JRE** – To run the programs after building


**JRE (Java Runtime Environment)**

## Definition: A lightweight runtime that allows execution of Java applications. It doesn’t include tools to compile Java, only to run.

Includes:
Core libraries (`java.lang`, `java.io`, etc.)
Java Class Loader
Bytecode Verifier
JVM


**JVM (Java Virtual Machine)**

## Definition: A virtual runtime environment that loads, verifies, and executes Java bytecode, making Java platform-independent.

Interprets `.class` bytecode files
Optimizes frequently used code with **JIT (Just-In-Time)** compilation
Available as HotSpot (Oracle), OpenJ9, GraalVM, etc.


**JVM Internal Structure Diagram:**

         ┌───────────────────────────────┐
         │        Class Loader           │ ← Loads .class files
         └────────────┬──────────────────┘
                      ↓
         ┌───────────────────────────────┐
         │      Bytecode Verifier        │ ← Ensures safety & integrity
         └────────────┬──────────────────┘
                      ↓
         ┌───────────────────────────────┐
         │     Runtime Data Areas        │ ← Memory partitions
         │   ┌───────────────────────┐   │
         │   │ Method Area           │   │ ← Class structures & constants
         │   │ Heap                  │   │ ← Objects live here
         │   │ Stack (per thread)    │   │ ← Method call frames
         │   │ PC Register (per thr) │   │ ← Bytecode address pointer
         │   │ Native Method Stack   │   │ ← For JNI calls
         └───┴───────────────────────┘───┘
                      ↓
         ┌───────────────────────────────┐
         │     Execution Engine          │ ← Runs bytecode
         │  ┌─────────────────────────┐  │
         │  │ Interpreter             │  │ ← Interprets bytecode
         │  │ JIT Compiler            │  │ ← Converts hot code to native
         └──┴─────────────────────────┘──┘




## 2. Memory Layout and Variable Scope in Java

### Runtime Memory Areas — Definitions

| Area                    | Definition                                                                |
| ----------------------- | ------------------------------------------------------------------------- |
| **Heap**                | Shared memory area where objects are                allocated                            |

| **Method Area**         | Stores class structure, method metadata, static variables                 |

| **Stack (per thread)**  | Memory for local variables and function calls                             |

| **PC Register**         | Program Counter – stores address of current instruction                   |

| **Native Method Stack** | Used for methods written in native code (via JNI – Java Native Interface) |


**Local Variable Storage**

Each method call gets its own **stack frame** which holds:

 **Local Variable Array**
 **Operand Stack**
 **Return Address**

```java
public void example() {
    int a = 10;
    int b = 20;
    int sum = a + b;
}
```

Resulting stack frame:

```
[0] a = 10
[1] b = 20
[2] sum = 30
```



## 3. Data Types – Internal Representation & Precision

### Primitive Data Types

## Definition: The eight built-in data types in Java that store simple, low-level values.

## Internal Notes:

| Type      | Size | Stored As               | Notes                                 |
| --------- | ---- | ----------------------- | ------------------------------------- |
| `byte`    | 1 B  | 2's complement          | Useful for memory-constrained systems |
| `int`     | 4 B  | 2's complement          | Default integer type                  |
| `float`   | 4 B  | IEEE 754 format         | \~6-7 decimal digits precision        |
| `double`  | 8 B  | IEEE 754 format         | \~15-16 digits precision              |
| `char`    | 2 B  | UTF-16 Unicode          | Supports multilingual chars           |
| `boolean` | 1 B  | Stored as byte (0 or 1) | Logic gates, control flow             |

> ⚠️ Overflow is **not** an error — values wrap around silently.



## 4. 🛠️ **Operators – Bytecode Insight**

### 🔹 **Operators 

## Definition: Symbols that represent operations like addition, comparison, and logical decisions.

```java
int result = 10 + 5 * 2;
```

### 🔸 Order of Evaluation:

* `5 * 2 = 10`
* `10 + 10 = 20`


 **Stack-based Execution**: JVM operates like a stack calculator. No registers.



## 5. 🧾 **Scanner – Deep Dive**

### Scanner 
## Definition : A utility class from `java.util` that reads and tokenizes input from standard input or files.

### 🔸 How it works:

```java
Scanner sc = new Scanner(System.in);
int a = sc.nextInt();
```

Internally:

* Wraps `System.in` in `BufferedReader`
* Uses `Pattern` to split input into tokens
* Parses tokens to types (via `Integer.parseInt()` etc.)

### ⚠️ Common Trap:

```java
int a = sc.nextInt();
String name = sc.nextLine();  // will read leftover newline
```

🔧 **Fix:**

```java
int a = sc.nextInt();
sc.nextLine(); // consume leftover \n
String name = sc.nextLine();
```

---

## 6. 📤 `System.out.println` – Internals

###
## Definition: Method of the `PrintStream` class used to display output on the console.

```java
System.out.println("Hello");
```

Internally:

1. `System` contains static `PrintStream out`
2. `out.println()` calls `write()`
3. Which writes to **stdout stream**

```java
PrintStream out = System.out;
out.println("Hello");  // Calls OutputStreamWriter.write()
```

---

## 7. 🧵 **Compilation, Bytecode, Class Loading**

## Compilation Process

```
javac Hello.java     # Produces Hello.class (bytecode)
java Hello           # Starts JVM, loads class
```

### 🔸 Bytecode View (via `javap -c Hello`):

```java
public class Hello {
  public static void main(String[] args) {
    System.out.println("Hello");
  }
}


## 8. 🧪 Common Misconceptions & Realities

| Misconception                          | Reality                                            |
| -------------------------------------- | -------------------------------------------------- |
| Java is always interpreted             | JVM uses JIT to compile to native code dynamically |
| `==` compares string contents          | `==` compares references, use `.equals()`          |
| Local variables are always initialized | ❌ Must be explicitly initialized before use        |
| Java passes objects by reference       | ❌ Passes **reference values by value**             |

---

## 🧠 Deep Interview-Level Trap

**Q: What happens if you use `Scanner` with `nextInt()` and `nextLine()` inside a loop?**
→ The `nextInt()` doesn't consume the trailing newline, so `nextLine()` reads a blank line.

🔧 **Solution:**

```java
int n = sc.nextInt();
sc.nextLine(); // eat the newline
String line = sc.nextLine();
```
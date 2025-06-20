#  Arrays in Java

##  What is an Array?

* An **array** is a collection of *homogeneous* data elements (all of the same data type).
* Array elements are accessed using **index values**, starting from **0**.
* In **Java**, arrays are **objects** stored in the **heap**.
* Once created, an array's **size is fixed**.

---

##  Advantages of Arrays

* Efficiently stores **multiple data items**.
* Supports storage of **object references**.
* Can be used to implement data structures like **stacks**, **queues**, **lists**, etc.
* Allows **fast access** via indexing (O(1) time complexity).

---

##  Disadvantages of Arrays

* Size is **fixed** at declaration time.
* May lead to **memory wastage** if not fully used.
* Cannot store **different data types** in the same array.

---

##  Types of Arrays in Java

---

### 1. **One-Dimensional Array**

* Linear structure (single row).
* **Declaration**:

  ```java
  int[] arr = new int[5];
  arr[0] = 10;
  ```
* **Representation**:

  ```
  Index:   0   1   2   3   4
  Values: 10  20  30  40  50
  ```

####  Code Example

```java
public class OneDArrayExample {
    public static void main(String[] args) {
        int[] oneD = {10, 20, 30, 40, 50};
        System.out.println("1D Array:");
        for (int i = 0; i < oneD.length; i++) {
            System.out.println("Index " + i + ": " + oneD[i]);
        }
    }
}
```

---

### 2. **Two-Dimensional Array (Matrix)**

* Array of arrays (rows × columns).
* **Declaration**:

  ```java
  int[][] matrix = new int[2][3];
  matrix[0][0] = 1;
  ```
* **Representation**:

  ```
        Column →
        0    1    2
  ```

Row 0 \[11] \[12] \[13]
Row 1 \[21] \[22] \[23]


####  Code Example
```java
public class TwoDArrayExample {
  public static void main(String[] args) {
      int[][] twoD = {
          {11, 12, 13},
          {21, 22, 23}
      };
      System.out.println("\n2D Array:");
      for (int i = 0; i < twoD.length; i++) {
          for (int j = 0; j < twoD[i].length; j++) {
              System.out.println("Element at [" + i + "][" + j + "]: " + twoD[i][j]);
          }
      }
  }
}
```

---

### 3. **Multidimensional Array (3D and Beyond)**

* Array with more than 2 dimensions (like a cube).
* **Declaration**:

  ```java
  int[][][] cube = new int[2][2][2];
  cube[0][0][0] = 7;
  ```

---

### 4. **Jagged Array (Array of Arrays)**

* A 2D array where each row can have a **different number of columns**.
* **Declaration**:

  ```java
  int[][] jagged = new int[3][];
  jagged[0] = new int[2];
  jagged[1] = new int[4];
  jagged[2] = new int[1];
  ```
* **Simplified Representation**:

  ```
  Row 0 → [a, b]
  Row 1 → [c, d, e, f]
  Row 2 → [g]
  ```

####  Code Example

```java
public class JaggedArrayExample {
    public static void main(String[] args) {
        int[][] jagged = {
            {10, 20},
            {30, 40, 50},
            {60}
        };
        System.out.println("\nJagged Array:");
        for (int i = 0; i < jagged.length; i++) {
            for (int j = 0; j < jagged[i].length; j++) {
                System.out.println("Element at [" + i + "][" + j + "]: " + jagged[i][j]);
            }
        }
    }
}
```

---

## 🛠 Ways to Create & Initialize Arrays

---

###  1D Array

```java
int[] arr1 = new int[5];                  // With size, default values
int[] arr2 = {10, 20, 30, 40, 50};        // Inline initialization
int[] arr3 = new int[]{10, 20, 30};       // Using new keyword
```

---

###  2D Array

```java
int[][] matrix1 = new int[2][3];          // Fixed-size matrix
int[][] matrix2 = {
    {1, 2, 3},
    {4, 5, 6}
};                                        // Inline initialization
```

---

###  Jagged Array

```java
int[][] jagged = new int[3][];
jagged[0] = new int[2];
jagged[1] = new int[4];
jagged[2] = new int[1];
```

```java
int[][] jagged2 = {
    {10, 20},
    {30, 40, 50},
    {60}
};
```

---

###  Multidimensional Array

```java
int[][][] cube = new int[2][2][2];        // 3D array
```

---

##  Common Exceptions While Creating or Assigning Arrays

| Exception                        | Cause / Trigger Example                |
| -------------------------------- | -------------------------------------- |
| **`NegativeArraySizeException`** | Creating an array with a negative size |

```java
int[] arr = new int[-3]; // 
```

\| **`NullPointerException`**       | Accessing an array that is `null`

```java
int[] arr = null;
arr[0] = 10; // 
```

\| **`ArrayIndexOutOfBoundsException`** | Accessing index outside bounds

```java
int[] arr = {1, 2, 3};
System.out.println(arr[5]); // 
```

\| **`ArrayStoreException`**        | Storing wrong type in an object array

```java
Object[] objArr = new String[3];
objArr[0] = 100; // 
```

\| **`IllegalArgumentException`**   | Invalid argument used (e.g., in utility methods)

```java
int[] arr = new int[5];
Arrays.copyOf(arr, -2); // 
```

---



# CC189
Interview question implementation for Cracking the Coding Interview 6th ed.

## [Chapter 1 Arrays and Strings](./src/chapter1/)

### Hash Tables
#### 1. Maps keys to values for highly efficient lookup
#### 2. Implementations
- User an array of linked lists and a hash code function
- Compute the key's hash code to **int** or **long**
  - Two different keys could have the same hash code, as there may be an infinite number of keys and a finite number of ints
- Map the hash code to an index in the array, e.g. hash(key) % array_length
- To store, append the key-value pair in the linked list at this index
- To retrieve, search throught the linked list fort the value with this key
#### 3. Runtime
- Worst: O(N) if the number of collisions is very high
- Assume: O(1)

### ArrayList & Resizable Arrays
#### 1. An array  that resizes itself as needed while still providing O(1) access
#### 2. Insertion runtime:
- Inserting the total number of copies to insert N elements is roughly N
- Each insertion is O(1) on average, even though some take O(N) in the worst case

### StringBuilder
#### Simply creates a resizable array of all the strings, copying them back to a string only when necessary
- String is immutable, and on each concatenation, a new copy of the string is crated. Total time is O(xn<sup>2</sup>)



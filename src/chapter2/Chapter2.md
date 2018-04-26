# Chapter 2 Linked Lists

## Actions
### 1. Create
- Node with pointer to next/previous
- Data structure with head node
- Singly or doubly linked
### 2. Delete a node
- Update the pointer of the previous/next node
- check for null pointer and update head/tail pointer as necessary
### 3. Time complexity
- Access kth element: O(k)
- Find a node: O(n)
- Append and remove: O(1)

## Special approaches
### 1. Runner / Second pointer
- Fast pointer is x nodes ahead of slow pointer
- Find the mid point / measure the length
- Find a circle
### 2. Recursive
- O(n) space complexity: n is the depth of the recursive call
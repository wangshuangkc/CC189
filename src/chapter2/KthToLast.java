package chapter2;

/**
 * Find the kth to last element of a singly linked list
 * k should be 0 or positive, head should not be null
 */
public class KthToLast {

  // Time: O(n) Space: O(1)
  public static int kthToLast(Node head, int k) {
    if (head == null || k < 0) {
      throw new IllegalArgumentException("The linked list does not exist or k is not an invalid index");
    }

    if (head.next == null) {
      return head.data;
    }

    Node first = head;
    int i = 0;
    while (first.next != null && ++i < k) {
      first = first.next;
    }

    Node second = head;
    while (first.next != null) {
      first = first.next;
      second = second.next;
    }

    return second.data;
  }

  // Time: O(n-k)
  public static int kthToLast_knowSize(Node head, int size, int k) {
    if (head == null || k < 0) {
      throw new IllegalArgumentException("The linked list does not exist or k is not an invalid index");
    }

    if (head.next == null || k >= size) {
      return head.data;
    }

    Node n = head;
    for (int i = 0; i < size - k; i++) {
      n = n.next;
    }
    return n.data;
  }

  // Time: O(n) Space: O(n)
  public static int kthToLast_recursive(Node head, int k) {
    if (head == null) {
      return 0;
    }

    int index = kthToLast_recursive(head.next, k) + 1;
    if (index == k) {
      System.out.println(head.data);
    }

    return index;
  }

  // Time: O(n) Space: O(n)
  public static Node kthToLast_recurIndex(Node head, int k) {
    Index idx = new Index();
    return kthToLast(head, k, idx);
  }

  private static Node kthToLast(Node head, int k, Index idx) {
    if (head == null) {
      return null;
    }

    Node n = kthToLast(head.next, k, idx);
    idx.value++;
    if (idx.value == k) {
      return head;
    }

    return n;
  }

  static class Index{
    int value = 0;
  }

  public static void main(String[] args) {
    int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    Node head = Node.createList(data);
    System.out.println(head.getNodes());

    int kth = kthToLast(head, 5);
    System.out.println(kth);

    kth = kthToLast_knowSize(head, data.length, 5);
    System.out.println(kth);

    kthToLast_recursive(head, 5);

    Node k = kthToLast_recurIndex(head, 5);
    System.out.println(k.data);
  }
}

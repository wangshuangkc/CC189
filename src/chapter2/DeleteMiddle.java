package chapter2;

/**
 * Given the middle node, delete it from the singly linked list
 */
public class DeleteMiddle {
  // Time: O(1) Space: O(1)
  public static boolean deleteMiddle(Node middle) {
    if (middle == null || middle.next == null) {
      return false;
    }

    Node next = middle.next;
    middle.data = next.data;
    middle.next = next.next;
    return true;
  }

  public static void main(String[] args) {
    int[] values = {1, 2, 3, 4, 5, 6, 7};
    Node head = Node.createList(values);
    Node middle = getMiddleNode(head);
    deleteMiddle(middle);
    System.out.println(head.getNodes());
  }

  private static Node getMiddleNode(Node head) {
    if (head == null) {
      return head;
    }

    Node first = head;
    Node second = head;
    while (first.next != null && first.next.next != null) {
      first = first.next.next;
      second = second.next;
    }
    return second;
  }
}

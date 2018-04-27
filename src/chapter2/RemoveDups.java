package chapter2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Remove duplicates from an unsorted linked list.
 * No temporary buffer
 */
public class RemoveDups {

  // Time: O(n) Space: O(n)
  public static Node removeDups_buffer(Node head) {
    final Set<Integer> values = new HashSet<>();
    if (head == null || head.next == null) {
      return head;
    }

    values.add(head.data);
    Node temp = head;
    while (temp != null && temp.next != null) {
      if (values.contains(temp.next.data)) {
        temp.next = temp.next.next;
      } else {
        values.add(temp.next.data);
        temp = temp.next;
      }
    }
    return head;
  }

  // Time: O(n^2) Space: O(1)
  public static Node removeDups_noBuffer(Node head) {
    if (head == null || head.next == null) {
      return head;
    }

    Node slow = head;
    while (slow != null && slow.next != null) {
      Node fast = slow;
      do {
        if (fast.next.data == slow.data) {
          fast.next = fast.next.next;
        }
        fast = fast.next;
      } while (fast != null && fast.next != null);
      slow = slow.next;
    }

    return head;
  }

  public static void main(String[] args) {
    int[] values = {1, 2, 2, 3, 4, 4, 5, 5, 6, 7, 7};
    Node head = Node.createList(values);
    System.out.println(head.getNodes());

    Node dedupe1 = removeDups_buffer(head);
    System.out.println(dedupe1.getNodes());

    head = Node.createList(values);
    Node dedupe2 = removeDups_noBuffer(head);
    System.out.println(dedupe2.getNodes());
  }
}


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
    while (temp.next != null) {
      if (values.contains(temp.next.data)) {
        temp.next = temp.next.next;
      } else {
        values.add(temp.next.data);
      }
      temp = temp.next;
    }
    return head;
  }

  // Time: O(n^2) Space: O(1)
  public static Node removeDups_noBuffer(Node head) {
    if (head == null || head.next == null) {
      return head;
    }

    Node slow = head;
    while (slow.next != null) {
      Node fast = slow;
      do {
        if (fast.next.data == slow.data) {
          fast.next = fast.next.next;
        }
        fast = fast.next;
      } while (fast.next != null);
      slow = slow.next;
    }

    return head;
  }

  public static void main(String[] args) {
    Node head = createLinkedList();
    System.out.println(head.getNodes());

    Node dedupe1 = removeDups_buffer(head);
    System.out.println(dedupe1.getNodes());

    head = createLinkedList();
    Node dedupe2 = removeDups_noBuffer(head);
    System.out.println(dedupe2.getNodes());
  }

  private static Node createLinkedList() {
    int[] data = {1, 2, 2, 3, 4, 4, 5, 6, 6, 7};
    Node head = new Node(data[0]);
    for (int i = 1; i < data.length; i++) {
      head.append(data[i]);
    }
    return head;
  }
}

class Node {
  Node next = null;
  final int data;

  Node(int data) {
    this.data = data;
  }

  void append(int data) {
    Node end = new Node(data);
    Node n = this;
    while (n.next != null) {
      n = n.next;
    }
    n.next = end;
  }

  String getNodes() {
    StringBuffer buffer = new StringBuffer("[");

    buffer.append(this.data);
    Node n = this;
    while(n.next != null) {
      buffer.append("," + n.next.data);
      n = n.next;
    }

    buffer.append("]");
    return buffer.toString();
  }
}
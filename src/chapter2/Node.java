package chapter2;

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

  static Node createList(int[] data) {
    Node head = new Node(data[0]);
    for (int i = 1; i < data.length; i++) {
      head.append(data[i]);
    }
    return head;
  }
}

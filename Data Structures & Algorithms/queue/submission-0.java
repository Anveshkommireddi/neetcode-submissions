class Deque {

    Node dummy_head;
    Node dummy_tail;

    public Deque() {
        this.dummy_head = new Node(-1);
        this.dummy_tail = new Node(-1);
        this.dummy_head.next = this.dummy_tail;
        this.dummy_tail.prev = this.dummy_head;
    }

    public boolean isEmpty() {
        return dummy_head.next == dummy_tail;
    }

    public void append(int value) {
       Node new_node = new Node(value);
       Node last_node = dummy_tail.prev;
       last_node.next = new_node;
       new_node.next = dummy_tail;
       new_node.prev = last_node;
       dummy_tail.prev = new_node;
    }

    public void appendleft(int value) {
        Node new_node = new Node(value);
        Node first_node = dummy_head.next;
        new_node.next = first_node;
        new_node.prev = dummy_head;
        first_node.prev = new_node;
        dummy_head.next = new_node;
    }

    public int pop() {
        if(isEmpty()) {
            return -1;
        }
       Node last_node = dummy_tail.prev;
       Node before_last_node = last_node.prev;
       before_last_node.next = dummy_tail;
       dummy_tail.prev = before_last_node;
       return last_node.val;
    }

    public int popleft() {
        if(isEmpty()) {
            return -1;
        }
        Node first_node = dummy_head.next;
        Node second_node = first_node.next;
        dummy_head.next = second_node;
        second_node.prev = dummy_head;
        return first_node.val;
    }
}

class Node {

    Node prev;
    Node next;
    int val;

    Node(int val) {
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}
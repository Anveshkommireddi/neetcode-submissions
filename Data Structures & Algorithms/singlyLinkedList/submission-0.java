class LinkedList {
    Node head;
    Node tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public int get(int index) {
        int curr_idx = 0;
        Node curr = this.head;
        while (null != curr && curr_idx < index) {
            curr = curr.next;
            curr_idx++;
        }
        if (index == curr_idx && null != curr) {
            return curr.val;
        }
        return -1;
    }

    public void insertHead(int val) {
        Node new_node = new Node(val);
        if (this.head == null) {
            this.head = new_node;
            this.tail = new_node;
            return;
        }
        new_node.next = this.head;
        this.head = new_node;
    }

    public void insertTail(int val) {
        Node new_node = new Node(val);
        if (this.head == null) {
            this.head = new_node;
            this.tail = new_node;
            return;
        }
        Node curr_tail = this.tail;
        curr_tail.next = new_node;
        this.tail = new_node;
    }

    public boolean remove(int index) {
        if (this.head == null) {
            return false;
        }
        if (index == 0) {
            this.head = this.head.next;
            if (this.head == null) {
                this.tail = null;
            }
            return true;
        }
        int curr_idx = 0;
        Node curr = this.head;
        while (null != curr.next && curr_idx < index - 1) {
            curr = curr.next;
            curr_idx++;
        }
        if (curr.next != null && curr_idx == index - 1) {
            if (curr.next == this.tail) {
                this.tail = curr;
            }
            curr.next = curr.next.next;
            return true;
        }
        return false;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> values = new ArrayList<>();
        Node curr = this.head;
        while (null != curr) {
            values.add(curr.val);
            curr = curr.next;
        }
        return values;
    }
}

class Node {
    int val;

    Node next;

    Node(int val) {
        this.val = val;
        this.next = null;
    }
}

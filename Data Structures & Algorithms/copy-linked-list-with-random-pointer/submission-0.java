/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> nodeInfo = new HashMap<>();
        Node curr = head;
        while(null != curr) {
            Node newNode = new Node(curr.val);
            nodeInfo.put(curr, newNode);
            curr = curr.next;
        }
        curr = head;
        while(null != curr) {
            Node oldRp = curr.random;
            Node oldNext = curr.next;
            Node newNode = nodeInfo.get(curr);
            Node newRp = nodeInfo.get(oldRp);
            newNode.next = nodeInfo.get(oldNext);
            newNode.random = newRp;
            curr = curr.next;
        }
        return nodeInfo.get(head);
    }
}

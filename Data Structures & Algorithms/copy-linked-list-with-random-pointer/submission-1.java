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

        Map<Node, Node> oldToNew = new HashMap<>();
        Node curr = head;
        while(null != curr) {
            Node newNode = new Node(curr.val);
            oldToNew.put(curr, newNode);
            curr = curr.next;
        }

        for(Map.Entry<Node, Node> entry : oldToNew.entrySet()) {
            Node oldNode = entry.getKey();
            Node newNode = entry.getValue();

            Node oldNextNode = oldNode.next;
            Node newNextNode = oldToNew.get(oldNextNode);
            newNode.next = newNextNode;

            Node oldRandomNode = oldNode.random;
            Node newRandomNode = oldToNew.get(oldRandomNode);
            newNode.random = newRandomNode;
        }

        return oldToNew.get(head);
        
    }
}

/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {

    public Node cloneGraph(Node node) {

        if(null == node) return node;

         Map<Node, Node> oldNewMap = new HashMap<>();
         Queue<Node> queue = new LinkedList<>();
         Node cNode = new Node(node.val);
         oldNewMap.put(node, cNode);
         queue.add(node);

         while(!queue.isEmpty()) {
            Node currNode = queue.poll();
            Node clonedNode = oldNewMap.get(currNode);
            List<Node> childs = currNode.neighbors;
            for(Node child : childs) {
                Node childNode = oldNewMap.get(child);
                if(null == childNode) {
                    childNode = new Node(child.val);
                    oldNewMap.put(child, childNode);
                    queue.add(child);
                } 
                clonedNode.neighbors.add(childNode);
            }
         }
         return oldNewMap.get(node);
    }
}
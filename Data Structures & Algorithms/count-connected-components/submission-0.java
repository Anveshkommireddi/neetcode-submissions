class Solution {
    public int countComponents(int n, int[][] edges) {
        DSUF dsuf = new DSUF(n);
        for(int[] edge : edges) {
            dsuf.union(edge[0], edge[1]);
        }
        int result = dsuf.connectedComponents();
        return result;
    }
}

class DSUF {

    private List<Integer> size;
    private List<Integer> parent;

    public DSUF(int n) {
        size = new ArrayList<>();
        parent = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            size.add(1);
            parent.add(i);
        }
    }

    public boolean union(int v1, int v2) {
        int upv1 = fup(v1);
        int upv2 = fup(v2);
        if(upv1 == upv2) {
            return true;
        }
        int sv1 = size.get(upv1);
        int sv2 = size.get(upv2);
        if(sv1 >= sv2) {
            parent.set(upv2, upv1);
            size.set(upv1, sv1 + sv2);
        } else {
            parent.set(upv1, upv2);
            size.set(upv2, sv1 + sv2);
        }
        return false;
    }

    public int fup(int node) {
        if(node == parent.get(node)) {
            return node;
        }
        int up = fup(parent.get(node));
        parent.set(node, up);
        return parent.get(node);
    }

    public int connectedComponents() {
        int count = 0;
        for(int idx = 0; idx < parent.size(); idx++) {
            if(parent.get(idx) == idx) {
                count++;
            }
        }
        return count;
    }
}
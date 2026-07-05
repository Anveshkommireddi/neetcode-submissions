class Solution {
    public boolean validTree(int n, int[][] edges) {

		List<List<Integer>> adjList = createAdjacencyList(n, edges);
		boolean[] vis = new boolean[n];
		int connectedComponents = 0;
		for (int vertex = 0; vertex < n; vertex++) {
			if (vis[vertex] == false) {
				boolean hasCycle = dfs(adjList, vis, vertex, -1);
				connectedComponents++;
				if (hasCycle || connectedComponents > 1) {
					return false;
				}
			}
		}
		return true;
	

    }
    private boolean dfs(List<List<Integer>> adjList, boolean[] vis, int srcVertex, int parent) {
		vis[srcVertex] = true;
		List<Integer> neighbors = adjList.get(srcVertex);
		for (Integer neighbor : neighbors) {
			if (vis[neighbor] == false) {
				boolean tempCycle = dfs(adjList, vis, neighbor, srcVertex);
				if (tempCycle) {
					return true;
				}
			} else if (parent != neighbor) {
				return true;
			}
		}
		return false;
	}

    private List<List<Integer>> createAdjacencyList(int n, int[][] edges) {
		List<List<Integer>> adjList = new ArrayList<>();
		for (int vertex = 0; vertex < n; vertex++) {
			adjList.add(new ArrayList<>());
		}
		for (int[] edge : edges) {
			int from = edge[0];
			int to = edge[1];
			adjList.get(from).add(to);
			adjList.get(to).add(from);
		}
		return adjList;
	}
}

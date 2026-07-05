class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
		List<List<int[]>> adjList = new ArrayList<>();
		for (int idx = 0; idx < n; idx++) {
			adjList.add(new ArrayList<>());
		}
		for (int[] edge : flights) {
			int from = edge[0];
			int to = edge[1];
			int cost = edge[2];
			adjList.get(from).add(new int[] { to, cost });
		}
		int[] dist = new int[n];
		Arrays.fill(dist, Integer.MAX_VALUE);
		int result = Integer.MAX_VALUE;

		PriorityQueue<Node> pq = new PriorityQueue<>((node1, node2) -> node1.k - node2.k);
		pq.offer(new Node(0, 0, src));
		while (!pq.isEmpty()) {
			Node currNode = pq.poll();
			int currStops = currNode.k;
			int currCost = currNode.cost;
			int currVertex = currNode.to;
			if (currStops <= k + 1 && currVertex == dst) {
				result = Math.min(currCost, result);
			}
			List<int[]> neighbors = adjList.get(currVertex);
			for (int[] neighbor : neighbors) {
				int toNode = neighbor[0];
				int cost = neighbor[1];
				if (((currStops + 1) <= (k + 1)) && ((currCost + cost) < dist[toNode])) {
					dist[toNode] = currCost + cost;
					pq.offer(new Node(currStops + 1, dist[toNode], toNode));
				}
			}
		}
		return result == Integer.MAX_VALUE ? -1 : result;
    }
}

class Node {

    int k;
    int cost;
    int to;

    public Node(int k, int cost, int to) {
        this.k = k;
        this.cost = cost;
        this.to = to;
    }
}
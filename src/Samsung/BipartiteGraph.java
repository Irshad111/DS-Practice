package Samsung;

public class BipartiteGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int G[][] = { { 0, 1, 1, 0, 0, 0 }, { 1, 0, 0, 1, 0, 0 }, { 1, 0, 0, 0, 1, 0 }, { 0, 1, 0, 0, 0, 1 },
				{ 0, 0, 1, 0, 0, 1 }, { 0, 0, 0, 1, 1, 0 } };

		Bipartite(G, 6);

	}

	// 14. is bipartite M-1 using bfs
	public static void Bipartite(int G[][], int V) {
		// add code here.
		int color[] = new int[V];
		for (int i = 0; i < V; i++) {
			color[i] = -1;
		}

		for (int i = 0; i < V; i++) {

			if (color[i] == -1) {
				if (!bfs(G, V, color, i)) {
					System.out.println("0");
				return;
				}
			}
		}
		for (int i = 0; i < V; i++) {
			if (color[i] == 1) {
				System.out.print(i + " ");
			}
		}

	}

	public static boolean bfs(int G[][], int V, int color[], int src) {
		Queue q = new Queue();
		q.add(src);
		color[src] = 1;
		while (!q.isEmpty()) {
			int rm = q.remove();
			// for self loop
			if (G[rm][rm] == 1) {
				return false;
			}
			for (int v = 0; v < V; v++) {
				if (G[v][rm] == 1) {
					if (color[v] == -1) {
						color[v] = 1 - color[rm];
						q.add(v);
					} else if (color[v] == color[rm]) {
						return false;
					}
				}
			}
		}
		return true;

	}

	static class Queue {
		int[] data = new int[1000000];
		int rear;
		int front;

		Queue() {
			rear = 0;
			front = 0;
		}

		public void add(int item) {
			data[rear++] = item;
		}

		public int remove() {
			return data[front++];
		}

		public boolean isEmpty() {
			return front == rear;
		}

	}

	// M-2 using dfs

	boolean isBipartite(int G[][], int V) {
		// add code here.
		int color[] = new int[V];
		for (int i = 0; i < V; i++) {
			color[i] = -1;
		}
		boolean visited[] = new boolean[V];
		// Queue<Integer> q=new LinkedList<>();
		for (int i = 0; i < V; i++) {
			// for disconnected graph
			if (G[i][i] == 1) {// for self loop
				return false;
			}
			if (!visited[i]) {
				boolean result = dfs(G, V, visited, color, i, 1);
				if (!result) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean dfs(int G[][], int V, boolean vis[], int color[], int pos, int c) {
		vis[pos] = true;
		color[pos] = c;
		boolean ans = true;
		for (int v = 0; v < V; v++) {
			if (G[pos][v] == 1) {
				if (color[v] == -1) {
					ans = dfs(G, V, vis, color, v, 1 - c);
				} else if (color[v] == color[pos]) {
					return false;
				}
			}
			if (!ans) {
				return false;
			}

		}
		return true;

	}

}

package Samsung;

import java.util.ArrayList;

public class Dijkstra {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	static void dijkstra(ArrayList<ArrayList<Integer>> list, int src, int V) {
		// add your code
		int[] dist = new int[V];
		boolean[] visited = new boolean[V];
		for (int i = 0; i < V; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		dist[src] = 0;
		for (int v = 0; v < V; v++) {

			// for mindistance vertex
			int curr_vtx = -1;
			int curr_min = Integer.MAX_VALUE;
			for (int j = 0; j < V; j++) {
				if (!visited[j] && dist[j] <= curr_min) {
					curr_vtx = j;
					curr_min = dist[j];
				}
			}
			visited[curr_vtx] = true;
			ArrayList<Integer> nbr = list.get(curr_vtx);
			for (int i = 0; i < nbr.size(); i++) {
				if (!visited[i] && nbr.get(i) != 0) {
					dist[i] = Math.min(dist[i], curr_min + nbr.get(i));
				}
			}
		}
		for (int element : dist) {
			System.out.print(element + " ");
		}

	}

}

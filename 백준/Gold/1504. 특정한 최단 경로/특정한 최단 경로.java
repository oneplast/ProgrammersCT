import java.io.*;
import java.util.*;

public class Main {
	static final int INF = Integer.MAX_VALUE;
	static List<Edge>[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());

		int n = parseToken(token);
		int e = parseToken(token);

		graph = new ArrayList[n + 1];

		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < e; i++) {
			token = new StringTokenizer(br.readLine());

			int a = parseToken(token);
			int b = parseToken(token);
			int c = parseToken(token);

			graph[a].add(new Edge(b, c));
			graph[b].add(new Edge(a, c));
		}

		token = new StringTokenizer(br.readLine());
		int v1 = parseToken(token);
		int v2 = parseToken(token);

		long[] start = dijkstra(1, n);
		long[] startV1 = dijkstra(v1, n);
		long[] startV2 = dijkstra(v2, n);

		long case1 = start[v1] + startV1[v2] + startV2[n];
		long case2 = start[v2] + startV2[v1] + startV1[n];

		if (start[v1] >= INF || startV1[v2] >= INF || startV2[n] >= INF) {
			case1 = INF;
		}

		if (start[v2] >= INF || startV2[v1] >= INF || startV1[n] >= INF) {
			case2 = INF;
		}

		long result = Math.min(case1, case2);

		System.out.println(result >= INF ? -1 : result);
	}

	public static long[] dijkstra(int start, int n) {
		long[] dist = new long[n + 1];
		Arrays.fill(dist, INF);
		dist[start] = 0;

		PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
		pq.offer(new long[] {0, start});

		while (!pq.isEmpty()) {
			long[] cur = pq.poll();
			long curDist = cur[0];
			int curV = (int) cur[1];

			if (curDist > dist[curV]) {
				continue;
			}

			for (Edge edge : graph[curV]) {
				int nextV = edge.to;
				long nextDist = curDist + edge.weight;

				if (nextDist < dist[nextV]) {
					dist[nextV] = nextDist;
					pq.offer(new long[] {nextDist, nextV});
				}
			}
		}

		return dist;
	}

	public static int parseToken(StringTokenizer tokenizer) {
		return Integer.parseInt(tokenizer.nextToken());
	}
}

class Edge {
	int to;
	int weight;

	public Edge(int to, int weight) {
		this.to = to;
		this.weight = weight;
	}
}
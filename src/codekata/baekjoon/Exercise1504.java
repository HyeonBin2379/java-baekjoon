package codekata.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Exercise1504 {

	private static class Edge implements Comparable<Edge> {

		private final int nodeNum;
		private final long weight;

		Edge(int nodeNum, long weight) {
			this.nodeNum = nodeNum;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge that) {
			return Long.compare(this.weight, that.weight);
		}
	}

	private static final Map<Integer, List<Edge>> graph = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int nodeCount = Integer.parseInt(st.nextToken());
		int edgeCount = Integer.parseInt(st.nextToken());

		// 주어진 간선으로 1~n번까지의 node를 연결한 그래프 생성
		for (int i = 1; i <= nodeCount; i++) {
			graph.putIfAbsent(i, new ArrayList<>());
		}
		for (int i = 1; i <= edgeCount; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			long weight = Long.parseLong(st.nextToken());

			graph.get(from).add(new Edge(to, weight));
			graph.get(to).add(new Edge(from, weight));
		}

		// 거쳐야 하는 중간 경유지 1, 2
		st = new StringTokenizer(br.readLine());
		int node1 = Integer.parseInt(st.nextToken());
		int node2 = Integer.parseInt(st.nextToken());

		if (edgeCount == 0) {
			System.out.println(-1);
			return;
		}

		// 다익스트라 알고리즘 수행
		long result1 = calculateDistance(1, new LinkedList<>(List.of(node1, node2)), nodeCount, false);
		long result2 = calculateDistance(1, new LinkedList<>(List.of(node1, node2)), nodeCount, true);
		long answer = result1 >= Integer.MAX_VALUE && result2 >= Integer.MAX_VALUE ? -1 : Math.min(result1, result2);
		System.out.println(answer);
	}

	private static long calculateDistance(int start, LinkedList<Integer> nodeNums, int end, boolean isReversed) {
		long totalDistance = 0;
		int lastNode = start;

		if (isReversed) {
			Collections.reverse(nodeNums);
		}

		for (int nextNode : nodeNums) {
			totalDistance += dijkstra(lastNode, nextNode, graph.size());
			lastNode = nextNode;
		}
		totalDistance += dijkstra(lastNode, end, graph.size());
		return totalDistance;
	}

	private static long dijkstra(int start, int end, int nodeCount) {
		// node의 번호는 1번부터 시작
		boolean[] visited = new boolean[nodeCount + 1];
		long[] distance = new long[nodeCount + 1];
		// 최종적으로는 거리의 최솟값을 구해야 하므로 Integer.MAX_VALUE로 초기화
		Arrays.fill(distance, Integer.MAX_VALUE);

		// 우선순위큐 -> 연결된 노드와의 거리가 최소인 Edge가 첫번째에 배치됨
		PriorityQueue<Edge> queue = new PriorityQueue<>();
		distance[start] = 0;
		queue.offer(new Edge(start, distance[start]));

		while (!queue.isEmpty()) {
			Edge now = queue.poll();

			// 이미 방문한 노드라면 통과
			if (visited[now.nodeNum]) {
				continue;
			}
			visited[now.nodeNum] = true;

			for (Edge next : graph.get(now.nodeNum)) {
				long dist = distance[now.nodeNum]+next.weight;

				if (!visited[next.nodeNum] && dist < distance[next.nodeNum]) {
					distance[next.nodeNum] = Math.min(dist, distance[next.nodeNum]);
					queue.add(new Edge(next.nodeNum, distance[next.nodeNum]));
				}
			}
		}
		return distance[end];
	}
}

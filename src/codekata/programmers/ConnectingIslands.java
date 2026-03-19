package codekata.programmers;

import java.util.*;
import java.util.stream.IntStream;

public class ConnectingIslands {

	private static class Island implements Comparable<Island> {

		int nodeNum;
		int cost;

		private Island(int nodeNum, int cost) {
			this.nodeNum = nodeNum;
			this.cost = cost;
		}

		@Override
		public int compareTo(Island o) {
			return Integer.compare(this.cost, o.cost);
		}
	}

	private final Map<Integer, List<Island>> graph = new HashMap<>();

	private int[] dist;
	private boolean[] visited;

	public int solution(int n, int[][] costs) {
		// 그래프 구성
		IntStream.range(0, n).forEach(idx -> graph.putIfAbsent(idx, new ArrayList<>()));
		for (int[] cost : costs) {
			graph.get(cost[0]).add(new Island(cost[1], cost[2]));
			graph.get(cost[1]).add(new Island(cost[0], cost[2]));
		}
		dist = new int[n];
		visited = new boolean[n];
		Arrays.fill(dist, Integer.MAX_VALUE);

		return mst(n);
	}

	private int mst(int n) {
		PriorityQueue<Island> pq = new PriorityQueue<>();
		// 임의의 시작점 설정 -> 0번 섬부터 시작
		dist[0] = 0;
		pq.offer(new Island(0, dist[0]));

		int totalCost = 0;
		int nodeCnt = 0;
		while (!pq.isEmpty()) {
			// 연결 비용이 최소인 섬부터 poll
			// (다음에 연결할 섬이 이전 섬과 인접하지 않을 수도 있음)
			Island now = pq.poll();
			if (visited[now.nodeNum]) {
				continue;
			}

			// 방문했다고 체크하는 시점에 연결 -> 모든 섬 방문 시 조기종료
			visited[now.nodeNum] = true;
			totalCost += now.cost;
			nodeCnt++;
			if (nodeCnt == n) {
				break;
			}

			// 방문하지 않은 인접한 섬들 중 연결 비용이 저렴한 섬들을 우선순위큐에 추가
			// 다음 섬에 관한 최소 연결 비용 갱신
			for (Island next : graph.get(now.nodeNum)) {
				if (!visited[next.nodeNum] && next.cost < dist[next.nodeNum]) {
					dist[next.nodeNum] = next.cost;
					pq.offer(new Island(next.nodeNum, next.cost));
				}
			}
		}
		return totalCost;
	}

	public static void main(String[] args) {
		int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
		int result = new ConnectingIslands().solution(4, costs);
		System.out.println(result);
	}
}

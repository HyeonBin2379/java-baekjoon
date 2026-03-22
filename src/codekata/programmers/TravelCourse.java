package codekata.programmers;

import java.util.*;

public class TravelCourse {

	private final Map<String, PriorityQueue<String>> graph = new HashMap<>();
	private final List<String> path = new LinkedList<>();

	public String[] solution(String[][] tickets) {
		setGraph(tickets);

		dfs("ICN");

		Collections.reverse(path);
		return path.toArray(new String[0]);
	}

	private void setGraph(String[][] tickets) {
		for (String[] ticket : tickets) {
			graph.putIfAbsent(ticket[0], new PriorityQueue<>());
			graph.get(ticket[0]).add(ticket[1]);
		}
	}

	private void dfs(String now) {
		PriorityQueue<String> adj = graph.get(now);

		while (adj != null && !adj.isEmpty()) {
			String next = adj.poll();
			dfs(next);
		}

		path.add(now);
	}

	public static void main(String[] args) {
		String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
//		String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
		String[] result = new TravelCourse().solution(tickets);
		System.out.println(Arrays.toString(result));
	}
}

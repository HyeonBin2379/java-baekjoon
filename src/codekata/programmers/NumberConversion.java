package codekata.programmers;

import java.util.*;

public class NumberConversion {

	private final Map<Integer, Integer> dist = new HashMap<>();

	private int[] moves;

	public int solution(int x, int y, int n) {
		if (x == y) {
			return 0;
		}
		if (x+n > y || x > y) {
			return -1;
		}
		moves = new int[]{n, 2, 3};
		return bfs(x, y);
	}

	private int bfs(int start, int end) {
		Queue<Integer> queue = new LinkedList<>();
		dist.putIfAbsent(start, 0);
		queue.offer(start);

		while (!queue.isEmpty()) {
			int now = queue.poll();

			if (now == end) {
				break;
			}

			for (int i = 0; i < moves.length; i++) {
				int next = (i == 0) ? now+moves[i] : now*moves[i];

				if (dist.containsKey(next) || next > end) {
					continue;
				}
				int min = dist.getOrDefault(now, 0)+1;
				queue.offer(next);
				dist.put(next, min);
			}
		}
		return dist.getOrDefault(end, -1);
	}

	public static void main(String[] args) {
		int result = new NumberConversion().solution(2, 5, 4);
		System.out.println(result);
	}
}

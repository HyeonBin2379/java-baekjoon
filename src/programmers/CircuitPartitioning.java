package programmers;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class CircuitPartitioning {

    private static class Solution {

        private static final boolean[][] circuit = new boolean[101][101];
        public int solution(int n, int[][] wires) {
            int answer = n;
            for (int[] wire : wires) {
                circuit[wire[0]][wire[1]] = true;
                circuit[wire[1]][wire[0]] = true;
            }

            for (int[] wire : wires) {
                circuit[wire[0]][wire[1]] = false;
                circuit[wire[1]][wire[0]] = false;

                answer = Math.min(answer, bfs(n, wire[0]));

                circuit[wire[0]][wire[1]] = true;
                circuit[wire[1]][wire[0]] = true;
            }
            return answer;
        }
        private int bfs(int n, int start) {
            Queue<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[n+1];
            queue.offer(start);

            int count = 1;
            while (!queue.isEmpty()) {
                int now = queue.poll();
                visited[now] = true;

                for (int i = 1; i <= n; i++) {
                    if (!visited[i] && circuit[now][i]) {
                        queue.offer(i);
                        count++;
                    }
                }
            }
            return Math.abs((n-count)-count);
        }
    }

    public static void main(String[] args) throws IOException {
        int n = 4;
        int[][] wires = {{1, 2}, {2, 3}, {3, 4}};
        System.out.println(new Solution().solution(n, wires));
    }
}

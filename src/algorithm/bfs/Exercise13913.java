package algorithm.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Exercise13913 {

    static class Node implements Comparable<Node> {

        int position;
        int time;

        public Node(int position, int time) {
            this.position = position;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.time, o.time);
        }
    }

    private static final int INF = (int)1e9;
    private static final int[] moves = {1, 0, -1};

    private static int[] dist, prev;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        dist = new int[100001];
        prev = new int[100001];
        Arrays.fill(dist, INF);
        Arrays.fill(prev, INF);
        bfs(n, k);
        System.out.println(makePath(n, k));
    }

    private static void bfs(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.offer(new Node(start, dist[start]));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (dist[curr.position] < curr.time) {
                continue;
            }

            for (int move : moves) {
                int next = (move == 0) ? 2*curr.position : curr.position+move;

                if (next < 0 || next > 100000) {
                    continue;
                }

                if (dist[next] > dist[curr.position]+1) {
                    dist[next] = dist[curr.position]+1;
                    pq.offer(new Node(next, dist[next]));
                    prev[next] = curr.position;
                }
            }
        }
        System.out.println(dist[end]);
    }

    private static String makePath(int start, int end) {
        List<String> path = new ArrayList<>();
        int cur = end;
        while (cur != start) {
            path.add(Integer.toString(cur));
            cur = prev[cur];
        }
        path.add(Integer.toString(cur));
        Collections.reverse(path);
        return String.join(" ", path);
    }
}

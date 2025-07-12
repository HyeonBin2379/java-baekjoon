package algorithm.bfs;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Exercise12851 {

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
    private static final int[] moves = {-1, 0, 1};

    private static int[] dist;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        dist = new int[100001];
        Arrays.fill(dist, INF);
        bfs(n, k);
    }

    private static void bfs(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int count = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (dist[curr.position] < curr.time) {
                continue;
            }

            dist[curr.position] = curr.time;
            if (curr.position == end) {
                count++;
            }
            for (int move : moves) {
                int next = (move == 0) ? 2*curr.position : curr.position+move;

                if (next < 0 || next > 100000) {
                    continue;
                }

                if (dist[next] > curr.time+1) {
                    pq.offer(new Node(next, curr.time+1));
                }
            }
        }
        System.out.println(dist[end]);
        System.out.println(count);
    }
}

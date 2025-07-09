package algorithm.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Exercise1261 {

    private static final int INF = (int)1e9;
    private static final int[][] moves = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    static class Node implements Comparable<Node> {
        int row, col;
        int cost;

        public Node(int row, int col, int cost) {
            this.row = row;
            this.col = col;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
    private static int[][] map, dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        dist = new int[n][m];   // 거리: 벽을 부숴야 하는 횟수
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            Arrays.fill(dist[i], INF);
        }
        dijkstra(n, m);
        System.out.println(dist[n-1][m-1]);
    }

    private static void dijkstra(int rowSize, int colSize) {
        // 항상 벽을 부수는 횟수가 최소인 정점에서 시작
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[0][0] = 0;
        pq.offer(new Node(0, 0, dist[0][0]));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            for (int i = 0; i < 4; i++) {
                int nr = cur.row + moves[i][0];
                int nc = cur.col + moves[i][1];

                if (nr < 0 || nr >= rowSize || nc < 0 || nc >= colSize) {
                    continue;
                }
                if (dist[nr][nc] > dist[cur.row][cur.col]+map[nr][nc]) {
                    // map[nr][nc]가 벽이면 이동을 위해 벽을 부수는 횟수 증가
                    // map[nr][nc]가 빈 방이면 현재까지의 횟수를 유지
                    dist[nr][nc] = dist[cur.row][cur.col]+map[nr][nc];
                    pq.offer(new Node(nr, nc, dist[nr][nc]));
                }
            }
        }
    }
}

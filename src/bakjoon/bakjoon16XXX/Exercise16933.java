package bakjoon.bakjoon16XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exercise16933 {

    private static int n, m, k, answer;
    private static char[][] map;
    private static boolean[][][][] visited;
    private static final int[][] move = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static class Node {
        int r, c, boom, day, dist;

        public Node(int r, int c, int boom, int day, int dist) {
            this.r = r;
            this.c = c;
            this.boom = boom;
            this.day = day;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        visited = new boolean[n][m][k+1][2];
        answer = -1;
        bfs();
        System.out.println(answer);
    }

    private static void bfs() {
        Queue<Node> queue = new ArrayDeque<>();
        visited[0][0][k][0] = true;
        queue.offer(new Node(0, 0, k, 0, 1));

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            if (now.r == n-1 && now.c == m-1) {
                answer = now.dist;
                return;
            }

            for (int[] ints : move) {
                int nr = now.r + ints[0];
                int nc = now.c + ints[1];
                int after = (now.day+1) % 2;

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                    continue;
                }
                switch (map[nr][nc]) {
                    case '0' -> { // 정해진 길로 이동하는 경우
                        if (!visited[nr][nc][now.boom][after]) {
                            visited[nr][nc][now.boom][after] = true;
                            queue.offer(new Node(nr, nc, now.boom, after, now.dist+1));
                        }
                    }
                    case '1' -> { // 벽인 경우
                        // 벽 뚫고 지나가는 경우
                        if (now.boom > 0 && now.day % 2 == 0 && !visited[nr][nc][now.boom-1][after]) {
                            visited[nr][nc][now.boom-1][after] = true;
                            queue.offer(new Node(nr, nc, now.boom-1, after, now.dist+1));
                        }
                        // 그 자리에서 기다리는 경우
                        else if (now.boom > 0 && now.day % 2 == 1 && !visited[now.r][now.c][now.boom][after]) {
                            visited[now.r][now.c][now.boom][after] = true;
                            queue.offer(new Node(now.r, now.c, now.boom, after, now.dist+1));
                        }
                    }
                }
            }
        }
    }
}
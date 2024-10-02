package baekjoon.baekjoon18XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Exercise18405 {

    private static int n, k;
    private static int[][] map;
    private static final int[][] MOVE = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static Queue<Node> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        List<Node> temp = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ", n)).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < n; j++) {
                if (map[i][j] != 0) {
                    temp.add(new Node(i, j, map[i][j], 0));
                }
            }
        }
        queue = temp.stream().sorted(Comparator.comparingInt(o -> o.virus)).collect(Collectors.toCollection(LinkedList::new));

        st = new StringTokenizer(br.readLine());
        int sec = Integer.parseInt(st.nextToken());
        int destR = Integer.parseInt(st.nextToken())-1;
        int destC = Integer.parseInt(st.nextToken())-1;
        bfs(sec);
        System.out.println(map[destR][destC]);
    }

    private static class Node {
        int r, c, virus, time;

        public Node(int r, int c, int virus, int time) {
            this.r = r;
            this.c = c;
            this.virus = virus;
            this.time = time;
        }
    }
    private static void bfs(int sec) {
        while (!queue.isEmpty()) {
            Node now = queue.poll();

            if (now.time == sec) {
                return;
            }

            for (int[] ints : MOVE) {
                int nr = now.r + ints[0];
                int nc = now.c + ints[1];

                if (nr < 0 || nr >= n || nc < 0 || nc >= n) {
                    continue;
                }
                if (map[nr][nc] == 0) {
                    map[nr][nc] = now.virus;
                    queue.offer(new Node(nr, nc, now.virus, now.time + 1));
                }
            }
        }
    }
}

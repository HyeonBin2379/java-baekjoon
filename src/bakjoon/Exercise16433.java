package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise16433 {

    private static char[][] field;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken())-1;
        int c = Integer.parseInt(st.nextToken())-1;
        field = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(field[i], '.');
        }

        visited = new boolean[n][n];
        plantCarrot(r, c, n);
        IntStream.rangeClosed(0, n-1).forEach(index -> System.out.println(new String(field[index])));
    }

    private static void plantCarrot(int r, int c, int size) {
        Queue<int[]> queue = new LinkedList<>();
        int[] nr = {-1, -1, 1, 1};
        int[] nc = {-1, 1, -1, 1};

        visited[r][c] = true;
        field[r][c] = 'v';
        queue.add(new int[] {r, c});
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextR = now[0] + nr[i];
                int nextC = now[1] + nc[i];

                if (nextR < 0 || nextR >= size || nextC < 0 || nextC >= size || visited[nextR][nextC]) {
                    continue;
                }
                visited[nextR][nextC] = true;
                field[nextR][nextC] = 'v';
                queue.add(new int[] {nextR, nextC});
            }
        }
    }
}

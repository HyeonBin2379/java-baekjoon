import java.util.Scanner;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static int[][] moves = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static Queue<Integer[]> queue = new LinkedList<>();
    private static int[][] steps, a;
    private static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        // Please write your code here.
        visited = new boolean[n][m];
        steps = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(steps[i], -1);
        }
        bfs(0, 0);
        System.out.println(steps[n-1][m-1]);
    }

    private static void bfs(int startR, int startC) {
        push(startR, startC, 0);

        while(!queue.isEmpty()) {
            Integer[] now = queue.poll();

            for (int[] move : moves) {
                int nr = now[0]+move[0];
                int nc = now[1]+move[1];

                if (!isInRange(nr, nc) || visited[nr][nc] || a[nr][nc] == 0) {
                    continue;
                }
                if (steps[nr][nc] == -1) {
                    push(nr, nc, steps[now[0]][now[1]]+1);
                }
            }
        }
    }

    private static boolean isInRange(int r, int c) {
        return 0 <= r && r < steps.length
            && 0 <= c && c < steps[0].length;
    }

    private static void push(int r, int c, int s) {
        steps[r][c] = s;
        visited[r][c] = true;
        queue.offer(new Integer[]{r, c});
    }
}
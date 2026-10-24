import java.util.Scanner;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

public class Main {

    private static int[][] moves = {{-2, -1}, {-2, 1}, 
                                    {-1, -2}, {-1, 2}, 
                                    {1, -2}, {1, 2}, 
                                    {2, -1}, {2, 1}};
    private static boolean[][] visited;
    private static int[][] steps;
    private static Queue<Integer[]> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r1 = sc.nextInt();
        int c1 = sc.nextInt();
        int r2 = sc.nextInt();
        int c2 = sc.nextInt();
        // Please write your code here.

        visited = new boolean[n][n];
        steps = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(steps[i], -1);
        }

        int answer = bfs(r1-1, c1-1, r2-1, c2-1);
        System.out.println(answer);
    }

    private static int bfs(int startR, int startC, int destR, int destC) {
        push(startR, startC, 0);

        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();

            for (int[] move : moves) {
                int nr = now[0]+move[0];
                int nc = now[1]+move[1];

                if (!isInRange(nr, nc)) {
                    continue;
                }
                if (!visited[nr][nc] && steps[nr][nc] == -1) {
                    push(nr, nc, steps[now[0]][now[1]]+1);
                }
            }
        }

        return steps[destR][destC];
    }

    private static boolean isInRange(int r, int c) {
        return 0 <= r && r < steps.length
            && 0 <= c && c < steps[0].length;
    }

    private static void push(int r, int c, int value) {
        steps[r][c] = value;
        visited[r][c] = true;
        queue.offer(new Integer[]{r, c});
    }
}
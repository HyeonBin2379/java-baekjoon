package bakjoon.bakjoon06XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exercise6601 {
    private static int[][] visited;
    private static final int[][] knightMove = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input;
        while ((input = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(input);
            String start = st.nextToken();
            String end = st.nextToken();

            visited = new int[8][8];
            int count = bfs(getPosition(start), getPosition(end));
            sb.append(String.format("To get from %s to %s takes %d knight moves.\n", start, end, count));
        }
        System.out.print(sb);
    }

    private static Integer[] getPosition(String point) {
        int col = point.charAt(0)-'a';
        int row = (point.charAt(1)-'0')-1;
        return new Integer[] {row, col};
    }

    private static int bfs(Integer[] start, Integer[] dest) {
        Queue<Integer[]> queue = new LinkedList<>();
        visited[start[0]][start[1]] = 0;
        queue.offer(start.clone());

        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();

            if (now[0].equals(dest[0]) && now[1].equals(dest[1])) {
                return visited[dest[0]][dest[1]];
            }

            for (int[] ints : knightMove) {
                int nr = now[0] + ints[0];
                int nc = now[1] + ints[1];

                if (nr < 0 || nr >= 8 || nc < 0 || nc >= 8 || visited[nr][nc] != 0) {
                    continue;
                }
                visited[nr][nc] = visited[now[0]][now[1]]+1;
                queue.offer(new Integer[]{nr, nc});
            }
        }
        return 0;
    }
}

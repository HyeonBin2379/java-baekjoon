import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exercise16928 {
    private static final int[] board = new int[101];
    private static final boolean[] visited = new boolean[101];
    private static final int[] count = new int[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ladders = Integer.parseInt(st.nextToken());
        int snakes = Integer.parseInt(st.nextToken());

        for (int i = 0; i < ladders+snakes; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            board[from] = to;
        }
        br.close();

        System.out.println(bfs(1, 100));
    }

    public static int bfs(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now == end) {
                break;
            }

            for (int i = 1; i < 7; i++) {
                int next = now+i;

                if (next > end || visited[next]) {
                    continue;
                }

                visited[next] = true;
                if (board[next] != 0) {
                    if (!visited[board[next]]) {
                        visited[board[next]] = true;
                        queue.offer(board[next]);
                        count[board[next]] = count[now] + 1;
                    }
                } else {
                    queue.offer(next);
                    count[next] = count[now]+1;
                }
            }
        }
        return count[end];
    }
}

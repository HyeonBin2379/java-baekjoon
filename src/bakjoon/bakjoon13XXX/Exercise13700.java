package bakjoon.bakjoon13XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Exercise13700 {

    private static int n, s, d, f, b, k;
    private static int[] visited;
    private static Set<Integer> police = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        f = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        String input = br.readLine();
        if (k > 0) {
            police = Arrays.stream(input.trim().split(" ", k))
                    .map(Integer::parseInt)
                    .sorted()
                    .collect(Collectors.toCollection(TreeSet::new));
        }
        visited = IntStream.rangeClosed(0, n).map(i -> -1).toArray();
        bfs();
    }

    private static void bfs() {
        Queue<Integer> queue = new ArrayDeque<>();
        visited[s] = 0;
        queue.offer(s);

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now == d) {
                System.out.println(visited[d]);
                return;
            }

            if (now + f >= 1 && now+f <= n && visited[now+f] == -1 && !police.contains(now+f)) {
                visited[now+f] = visited[now]+1;
                queue.offer(now+f);
            }
            if (now - b >= 1 && now - b <= n && visited[now-b] == -1 && !police.contains(now-b)) {
                visited[now-b] = visited[now]+1;
                queue.offer(now-b);
            }
        }
        System.out.println("BUG FOUND");
    }
}

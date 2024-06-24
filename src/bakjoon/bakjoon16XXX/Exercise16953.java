package bakjoon.bakjoon16XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exercise16953 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        System.out.println(bfs(a, b));
    }

    private static int bfs(long start, long end) {
        Queue<Map.Entry<Long, Integer>> queue = new LinkedList<>();
        queue.add(Map.entry(start, 1));
        while (!queue.isEmpty()) {
            Entry<Long, Integer> now = queue.poll();
            if (now.getKey() == end) {
                return now.getValue();
            }
            long[] next = {now.getKey()*2, now.getKey()*10+1};
            for (int i = 0; i < 2; i++) {
                if (next[i] <= end) {
                    queue.add(Map.entry(next[i], now.getValue()+1));
                }
            }
        }
        return -1;
    }
}

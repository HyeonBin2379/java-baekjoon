package bakjoon.bakjoon26XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exercise26042 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new ArrayDeque<>();
        int maxLen = 0;
        int stdNum = Integer.MAX_VALUE;
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int query = Integer.parseInt(st.nextToken());
            switch (query) {
                case 1 -> {
                    int num = Integer.parseInt(st.nextToken());
                    queue.offer(num);
                    if (maxLen < queue.size()) {
                        maxLen = queue.size();
                        stdNum = num;
                    } else if (maxLen == queue.size()) {
                        stdNum = Math.min(num, stdNum);
                    }
                }
                case 2 -> queue.poll();
            }
        }
        System.out.println(maxLen + " " + stdNum);
    }
}

package algorithm.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exercise1966 {

    static class Node {
        int idx;
        int priority;

        public Node(int idx, int priority) {
            this.idx = idx;
            this.priority = priority;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        while (testcase-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Queue<Node> queue = new ArrayDeque<>();
            st = new StringTokenizer(br.readLine());
            Integer[] priorities = new Integer[n];
            for (int i = 0; i < n; i++) {
                priorities[i] = Integer.parseInt(st.nextToken());
                queue.offer(new Node(i, priorities[i]));
            }
            Arrays.sort(priorities, Comparator.reverseOrder());

            int count = 0;
            while (!queue.isEmpty()) {
                Node now = queue.poll();
                if (now.idx == m && now.priority == priorities[count]) {
                    System.out.println(count+1);
                    break;
                }
                if (now.priority == priorities[count]) {
                    count++;
                    continue;
                }
                queue.offer(now);
            }
        }
    }
}

package bakjoon.bakjoon14XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Exercise14427 {

    private static class Node implements Comparable<Node> {
        int value, index;

        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Node o) {
            if (this.value != o.value) {
                return this.value-o.value;
            } else {
                return this.index-o.index;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Node> queue = new PriorityQueue<>();
        int[] num = new int[n+1];
        for (int i = 1; i <= n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            queue.add(new Node(num[i], i));
        }

        int m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int queryType = Integer.parseInt(st.nextToken());
            switch (queryType) {
                case 1 -> {
                    int i = Integer.parseInt(st.nextToken());
                    int v = Integer.parseInt(st.nextToken());
                    queue.add(new Node(v, i));
                }
                case 2 -> {
                    while (!queue.isEmpty() && num[queue.peek().index] != queue.peek().value) {
                        queue.poll();
                    }
                    if (!queue.isEmpty()) {
                        System.out.println(queue.peek().index);
                    }
                }
            }
        }
    }
}

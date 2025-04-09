package baekjoon.baekjoon18XXX;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Exercise18258 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Deque<Integer> queue = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            switch (cmd) {
                case "push" -> {
                    int value = Integer.parseInt(st.nextToken());
                    queue.offer(value);
                }
                case "pop" -> sb.append(queue.isEmpty() ? -1 : queue.poll()).append("\n");
                case "size" -> sb.append(queue.size()).append("\n");
                case "empty" -> sb.append(queue.isEmpty() ? 1 : 0).append("\n");
                case "front" -> sb.append(queue.isEmpty() ? -1 : queue.peek()).append("\n");
                case "back" -> sb.append(queue.isEmpty() ? -1 : queue.peekLast()).append("\n");
            }
        }
        br.close();
        bw.write(sb.toString());
        bw.close();
    }
}

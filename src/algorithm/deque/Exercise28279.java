package algorithm.deque;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Exercise28279 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int menu = Integer.parseInt(st.nextToken());
            int x;

            switch (menu) {
                case 1 -> {
                    x = Integer.parseInt(st.nextToken());
                    deque.offerFirst(x);
                }
                case 2 -> {
                    x = Integer.parseInt(st.nextToken());
                    deque.offerLast(x);
                }
                case 3 -> sb.append(deque.isEmpty() ? -1 : deque.pollFirst()).append("\n");
                case 4 -> sb.append(deque.isEmpty() ? -1 : deque.pollLast()).append("\n");
                case 5 -> sb.append(deque.size()).append("\n");
                case 6 -> sb.append(deque.isEmpty() ? 1 : 0).append("\n");
                case 7 -> sb.append(deque.isEmpty() ? -1 : deque.peekFirst()).append("\n");
                case 8 -> sb.append(deque.isEmpty() ? -1 : deque.peekLast()).append("\n");
            }
        }
        br.close();
        bw.write(sb.toString());
        bw.close();
    }
}

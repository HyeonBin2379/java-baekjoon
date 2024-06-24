package bakjoon.bakjoon28XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Exercise28279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        Deque<Integer> deque = new ArrayDeque<>();
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine());
            int menu = Integer.parseInt(st.nextToken());
            int number;
            int size = deque.size();
            switch (menu) {
                case 1 -> {
                    number = Integer.parseInt(st.nextToken());
                    deque.addFirst(number);
                }
                case 2 -> {
                    number = Integer.parseInt(st.nextToken());
                    deque.addLast(number);
                }
                case 3 -> {
                    if (size != 0) {
                        number = deque.pollFirst();
                        sb.append(number).append("\n");
                    } else {
                        sb.append("-1").append("\n");
                    }
                }
                case 4 -> {
                    if (size != 0) {
                        number = deque.pollLast();
                        sb.append(number).append("\n");
                    } else {
                        sb.append("-1").append("\n");
                    }
                }
                case 5 -> sb.append(size).append("\n");
                case 6 -> {
                    if (deque.isEmpty()) {
                        sb.append("1").append("\n");
                    } else {
                        sb.append("0").append("\n");
                    }
                }
                case 7 -> {
                    if (size != 0) {
                        sb.append(deque.peekFirst()).append("\n");
                    } else {
                        sb.append("-1").append("\n");
                    }
                }
                case 8 -> {
                    if (size != 0) {
                        sb.append(deque.peekLast()).append("\n");
                    } else {
                        sb.append("-1").append("\n");
                    }
                }
            }
        }
        System.out.println(sb);
        br.close();
    }
}

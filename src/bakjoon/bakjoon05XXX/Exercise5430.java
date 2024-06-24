package bakjoon.bakjoon05XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Exercise5430 {
    private static final StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ArrayDeque<String> deque;

        for (int i = 0; i < testCase; i++) {
            String command = br.readLine();
            int size = Integer.parseInt(br.readLine());

            deque = new ArrayDeque<>();
            st = new StringTokenizer(br.readLine(), "[],");
            for (int j = 0; j < size; j++) {
                deque.add(st.nextToken());
            }

            AC(command, deque);
        }
        br.close();

        System.out.println(sb);
    }

    public static void AC(String command, ArrayDeque<String> deque) {
        boolean isRight = true;

        for (char cmd : command.toCharArray()) {
            if (cmd == 'R') {
                isRight = !isRight;
                continue;
            }

            if (isRight) {
                if (deque.pollFirst() == null) {
                    sb.append("error\n");
                    return;
                }
            }
            else {
                if (deque.pollLast() == null) {
                    sb.append("error\n");
                    return;
                }
            }
        }

        makeString(deque, isRight);
    }

    public static void makeString(ArrayDeque<String> deque, boolean isRight) {
        sb.append("[");
        if (deque.size() > 0) {
            if (isRight) {
                sb.append(deque.pollFirst());
                while (!deque.isEmpty()) {
                    sb.append(",").append(deque.pollFirst());
                }
            }
            else {
                sb.append(deque.pollLast());
                while (!deque.isEmpty()) {
                    sb.append(",").append(deque.pollLast());
                }
            }
        }
        sb.append("]").append("\n");
    }
}

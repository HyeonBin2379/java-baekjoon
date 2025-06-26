package algorithm.deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Exercise10866 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> deque = new ArrayDeque<>();

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            String[] tokens = Arrays.stream(cmd.split("_")).filter(s -> !s.isEmpty()).toArray(String[]::new);
            switch (tokens[0]) {
                case "push" -> {
                    int num = Integer.parseInt(st.nextToken());
                    if (tokens[1].equals("front")) {
                        deque.offerFirst(num);
                    } else {
                        deque.offerLast(num);
                    }
                }
                case "pop" -> {
                    if (deque.isEmpty()) {
                        System.out.println(-1);
                    } else if (tokens[1].equals("front")) {
                        System.out.println(deque.pollFirst());
                    } else {
                        System.out.println(deque.pollLast());
                    }
                }
                case "size" -> System.out.println(deque.size());
                case "empty" -> System.out.println(deque.isEmpty() ? 1 : 0);
                case "front" -> System.out.println(deque.isEmpty() ? -1 : deque.peekFirst());
                case "back" -> System.out.println(deque.isEmpty() ? -1 : deque.peekLast());
            }
        }
    }
}

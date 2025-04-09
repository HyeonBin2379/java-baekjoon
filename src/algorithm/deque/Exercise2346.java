package algorithm.deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Exercise2346 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] values = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Deque<Integer> deque = IntStream.rangeClosed(2, n)
                .boxed()
                .collect(Collectors.toCollection(ArrayDeque::new));
        StringBuilder sb = new StringBuilder();
        int nextMove = values[0];

        sb.append(1).append(" ");
        while (!deque.isEmpty()) {
            if (nextMove > 0) {
                for (int i = 1; i < nextMove; i++) {
                    deque.offerLast(deque.pollFirst());
                }
                if (!deque.isEmpty()) {
                    nextMove = values[deque.peekFirst()-1];
                    sb.append(deque.pollFirst()).append(" ");
                }
            } else {
                for (int i = 1; i < Math.abs(nextMove); i++) {
                    deque.offerFirst(deque.pollLast());
                }
                if (!deque.isEmpty()) {
                    nextMove = values[deque.peekLast()-1];
                    sb.append(deque.pollLast()).append(" ");
                }
            }
        }
        System.out.println(sb);
    }
}

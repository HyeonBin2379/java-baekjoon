package bakjoon.bakjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Exercise2346 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        br.close();

        StringBuilder sb = new StringBuilder();
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i < count; i++) {
            deque.add(i);
        }

        sb.append("1 ");
        int nextMove = numbers[0];
        while (!deque.isEmpty()) {
            if (nextMove > 0) {
                for (int i = 1; i < nextMove; i++) {
                    deque.addLast(deque.pollFirst());
                }
                if (!deque.isEmpty()) {
                    nextMove = numbers[deque.peekFirst()];
                    sb.append(deque.pollFirst() + 1).append(" ");
                }
            } else {
                for (int i = 1; i < Math.abs(nextMove); i++) {
                    deque.addFirst(deque.pollLast());
                }
                if (!deque.isEmpty()) {
                    nextMove = numbers[deque.peekLast()];
                    sb.append(deque.pollLast() + 1).append(" ");
                }
            }
        }
        System.out.println(sb);
    }
}

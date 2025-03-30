package algorithm.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class Exercise12789 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = Arrays.stream(br.readLine().split(" ", n))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedList::new));
        Deque<Integer> stack = new ArrayDeque<>();

        int next = 1;
        while (!queue.isEmpty()) {
            int now = queue.peek();
            if (next == now) {
                queue.poll();
                next++;
            } else if (!stack.isEmpty() && stack.peek() == next) {
                stack.pop();
                next++;
            } else {
                stack.push(queue.poll());
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek() != next) {
                System.out.println("Sad");
                return;
            }
            stack.pop();
            next++;
        }
        System.out.println("Nice");
    }
}

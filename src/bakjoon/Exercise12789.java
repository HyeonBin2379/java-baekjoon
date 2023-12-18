package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Exercise12789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            queue.offer(Integer.parseInt(st.nextToken()));
        }
        br.close();

        Stack<Integer> stack = new Stack<>();
        int nextNumber = 1;
        while (!queue.isEmpty()) {
            if (queue.peek() == nextNumber) {
                queue.poll();
                nextNumber++;
            }
            else if (!stack.isEmpty() && stack.peek() == nextNumber) {
                stack.pop();
                nextNumber++;
            }
            else {
                stack.push(queue.poll());
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek() == nextNumber) {
                stack.pop();
                nextNumber++;
            }
            else {
                System.out.println("Sad");
                return;
            }
        }
        System.out.println("Nice");
    }
}

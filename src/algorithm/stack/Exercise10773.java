package algorithm.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Exercise10773 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> stack = new ArrayDeque<>();
        while (n-- > 0) {
            int num = Integer.parseInt(br.readLine());
            if (!stack.isEmpty() && num == 0) {
                stack.pop();
                continue;
            }
            stack.push(num);
        }

        int total = 0;
        while (!stack.isEmpty()) {
            total += stack.pop();
        }
        System.out.println(total);
    }
}

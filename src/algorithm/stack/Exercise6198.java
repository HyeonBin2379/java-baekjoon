package algorithm.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Exercise6198 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = Integer.parseInt(br.readLine());
        }

        Deque<Integer> stack = new ArrayDeque<>();
        long answer = 0;
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() <= heights[i]) {
                stack.pop();
            }
            stack.push(heights[i]);
            answer += stack.size()-1;   // 자기 자신은 제외
        }
        System.out.println(answer);
    }
}

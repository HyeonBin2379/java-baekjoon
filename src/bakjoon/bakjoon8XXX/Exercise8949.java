package bakjoon.bakjoon8XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Exercise8949 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> stack1 = getStack(st.nextToken());
        Stack<Integer> stack2 = getStack(st.nextToken());

        Stack<Integer> merger = new Stack<>();
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            int digit1 = stack1.pop();
            int digit2 = stack2.pop();
            merger.push(digit1+digit2);
        }
        while (!stack1.isEmpty()) {
            merger.push(stack1.pop());
        }
        while (!stack2.isEmpty()) {
            merger.push(stack2.pop());
        }

        StringBuilder result = new StringBuilder();
        while (!merger.isEmpty()) {
            result.append(merger.pop());
        }
        System.out.println(result);
    }

    private static Stack<Integer> getStack(String input) {
        Stack<Integer> stack = new Stack<>();
        int[] num1 = Arrays.stream(input.split("")).mapToInt(Integer::parseInt).toArray();
        for (int j : num1) {
            stack.push(j);
        }
        return stack;
    }
}

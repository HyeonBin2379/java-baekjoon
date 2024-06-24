package bakjoon.bakjoon03XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Exercise3986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < testCase; i++) {
            char[] word = br.readLine().toCharArray();
            if (isGoodWord(word)) {
                count++;
            }
        }
        br.close();
        System.out.println(count);
    }

    public static boolean isGoodWord(char[] word) {
        Stack<Character> stack = new Stack<>();
        for (char c : word) {
            if (stack.isEmpty() || stack.peek() != c) {
                stack.push(c);
                continue;
            }
            stack.pop();
        }
        return stack.isEmpty();
    }
}

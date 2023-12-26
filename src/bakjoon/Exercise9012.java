package bakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Exercise9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            char[] PS = br.readLine().toCharArray();
            bw.write((isValidPS(PS)) ? "YES\n" : "NO\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }

    public static boolean isValidPS(char[] PS) {
        Stack<Character> stack = new Stack<>();
        for (Character parenthesis : PS) {
            switch (parenthesis) {
                case '(' -> stack.push(parenthesis);
                case ')' -> {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}

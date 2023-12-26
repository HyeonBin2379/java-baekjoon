package bakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Exercise5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            char[] command = br.readLine().toCharArray();
            bw.write(getPassword(command) + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }

    public static String getPassword(char[] command) {
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        for (Character cursor : command) {
            switch (cursor) {
                case '<' -> {
                    if (!left.isEmpty()) {
                        right.push(left.pop());
                    }
                }
                case '>' -> {
                    if (!right.isEmpty()) {
                        left.push(right.pop());
                    }
                }
                case '-' -> {
                    if (!left.isEmpty()) {
                        left.pop();
                    }
                }
                default -> left.push(cursor);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!left.isEmpty()) {
            right.push(left.pop());
        }
        while (!right.isEmpty()) {
            sb.append(right.pop());
        }
        return sb.toString();
    }
}

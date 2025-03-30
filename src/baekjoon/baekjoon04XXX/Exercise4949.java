package baekjoon.baekjoon04XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Exercise4949 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String ps = br.readLine();
            if (ps.equals(".")) {
                break;
            }
            if (ps.isEmpty() || isVPS(ps)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }

    private static boolean isVPS(String input) {
        Deque<String> stack = new ArrayDeque<>();

        for (String s : input.replaceAll("[A-Za-z .]", "").split("")) {
            switch (s) {
                case "(", "[", "{" -> stack.push(s);
                case "}" -> {
                    if (stack.isEmpty() || !stack.peek().equals("{")) {
                        return false;
                    }
                    stack.pop();
                }
                case "]" -> {
                    if (stack.isEmpty() || !stack.peek().equals("[")) {
                        return false;
                    }
                    stack.pop();
                }
                case ")" -> {
                    if (stack.isEmpty() || !stack.peek().equals("(")) {
                        return false;
                    }
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();
    }
}

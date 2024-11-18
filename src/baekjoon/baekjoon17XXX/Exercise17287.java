package baekjoon.baekjoon17XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Exercise17287 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("");

        Deque<String> stack = new ArrayDeque<>();
        int sum = 0, max = 0;
        for (String letter : input) {
            switch (letter) {
                case "(" -> {
                    sum += 1;
                    stack.push(letter);
                }
                case "{" -> {
                    sum += 2;
                    stack.push(letter);
                }
                case "[" -> {
                    sum += 3;
                    stack.push(letter);
                }
                case ")" -> {
                    stack.pop();
                    sum -= 1;
                }
                case "}" -> {
                    stack.pop();
                    sum -= 2;
                }
                case "]" -> {
                    stack.pop();
                    sum -= 3;
                }
                default -> max = Math.max(sum, max);
            }
        }
        System.out.println(max);
    }
}

package algorithm.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Exercise10799 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("");

        Deque<String> stack = new ArrayDeque<>();
        int answer = 0;

        for (int i = 0; i < input.length; i++) {
            switch (input[i]) {
                case "(" -> stack.push(input[i]);
                case ")" -> {
                    stack.pop();
                    if (input[i - 1].equals("(")) {
                        answer += stack.size();
                    } else {
                        answer += 1;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}

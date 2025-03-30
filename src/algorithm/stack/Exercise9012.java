package algorithm.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Exercise9012 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            String[] input = br.readLine().split("");
            if (isVPS(input)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean isVPS(String[] input) {
        Deque<String> stack = new ArrayDeque<>();

        for (String s : input) {
            switch (s) {
                case "(" -> stack.push(s);
                case ")" -> {
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

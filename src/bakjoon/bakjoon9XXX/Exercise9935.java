package bakjoon.bakjoon9XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.stream.Collectors;

public class Exercise9935 {
    private static final Stack<Character> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String boom = br.readLine();
        br.close();

        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
            if (stack.size() >= boom.length() && isMatchedTo(boom)) {
                boomString(boom);
            }
        }
        String result = stack.stream().map(String::valueOf).collect(Collectors.joining());
        System.out.println(result.isEmpty() ? "FRULA" : result);
    }

    public static boolean isMatchedTo(String boom) {
        for (int i = 0; i < boom.length(); i++) {
            if (stack.get(stack.size()- 1 - i) != boom.charAt(boom.length()-1-i)) {
                return false;
            }
        }
        return true;
    }

    public static void boomString(String boom) {
        for (int i = 0; i < boom.length(); i++) {
            stack.pop();
        }
    }
}

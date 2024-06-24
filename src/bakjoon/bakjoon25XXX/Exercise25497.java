package bakjoon.bakjoon25XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Exercise25497 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] cmd = br.readLine().toCharArray();

        Stack<Character> stackL = new Stack<>();
        Stack<Character> stackS = new Stack<>();
        int count = 0;
        int index = 0;
        boolean error = false;
        while (!error && index < n) {
            if (Character.isDigit(cmd[index])) {
                count++;
                index++;
                continue;
            }
            switch (cmd[index]) {
                case 'L' -> stackL.push(cmd[index]);
                case 'R' -> {
                    if (stackL.isEmpty()) {
                        stackL.pop();
                        count++;
                    } else {
                        error = true;
                    }
                }
                case 'S' -> stackS.push(cmd[index]);
                case 'K' -> {
                    if (!stackS.isEmpty()) {
                        stackS.pop();
                        count++;
                    } else {
                        error = true;
                    }
                }
            }
            index++;
        }
        System.out.println(count);
    }
}

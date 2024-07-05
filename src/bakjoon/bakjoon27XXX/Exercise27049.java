package bakjoon.bakjoon27XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise27049 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int missingIdx = input.indexOf('?');

        String answer = "-1";
        for (int i = 0; i <= 10; i++) {
            int sum = 0;
            for (int j = 0; j < input.length(); j++) {
                char ch = input.charAt(j);
                switch (ch) {
                    case '?' -> sum += i * (10 - j);
                    case 'X' -> sum += 10 * (10 - j);
                    default -> sum += (ch - '0') * (10 - j);
                }
            }
            if (sum % 11 == 0 && (missingIdx == 9 || i < 10)) {
                answer = i < 10 ? Integer.toString(i) : "X";
            }
        }
        System.out.println(answer);
    }
}

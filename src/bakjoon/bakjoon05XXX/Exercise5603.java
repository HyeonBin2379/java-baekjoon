package bakjoon.bakjoon05XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise5603 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();

        for (int i = 0; i < n; i++) {
            input = transform(input);
        }

        System.out.println(input);
    }

    private static String transform(String s) {
        StringBuilder result = new StringBuilder();
        int length = s.length();
        int count = 1;

        for (int i = 1; i < length; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                result.append(count).append(s.charAt(i - 1));
                count = 1;
            }
        }
        result.append(count).append(s.charAt(length - 1));

        return result.toString();
    }
}

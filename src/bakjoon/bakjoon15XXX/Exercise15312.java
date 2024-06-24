package bakjoon.bakjoon15XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise15312 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] stroke = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};
        String him = br.readLine();
        String her = br.readLine();

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < him.length(); i++) {
            answer.append(stroke[him.charAt(i) - 'A']);
            answer.append(stroke[her.charAt(i) - 'A']);
        }

        while (answer.length() > 2) {
            StringBuilder next = new StringBuilder();
            int[] num = Arrays.stream(answer.toString().split("")).mapToInt(Integer::parseInt).toArray();
            for (int i = 0; i < answer.length()-1; i++) {
                next.append((num[i] + num[i + 1]) % 10);
            }
            answer = new StringBuilder(next.toString());
        }
        System.out.println(answer);
    }
}

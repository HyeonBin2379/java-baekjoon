package bakjoon.bakjoon17XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise17838 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            String input = br.readLine();
            int kinds = (int) Arrays.stream(input.split("")).distinct().count();

            if (kinds != 2 || input.length() != 7) {
                System.out.println(0);
                continue;
            }
            char[] letter = input.toCharArray();
            if (letter[0] != letter[2]
                    && (letter[0] == letter[1] && letter[1] == letter[4])
                    && (letter[2] == letter[3] && letter[3] == letter[5] && letter[5] == letter[6])) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}

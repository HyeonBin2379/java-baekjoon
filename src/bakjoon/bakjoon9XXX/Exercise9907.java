package bakjoon.bakjoon9XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise9907 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] digit = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        char[] letter = {'J', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'Z'};
        int result = 0;
        for (int i = 0; i < digit.length; i++) {
            result += (i == 0) ? digit[i]*2 : digit[i]*(8-i);
        }
        System.out.println(letter[result % 11]);
    }
}

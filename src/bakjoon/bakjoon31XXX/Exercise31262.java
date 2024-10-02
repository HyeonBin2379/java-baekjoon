package bakjoon.bakjoon31XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise31262 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        char[] letter = input.substring(0, 3).toCharArray();
        Arrays.sort(letter);
        int[] numbers = Arrays.stream(input.substring(3).split(""))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            result.append(letter[i]).append(numbers[2-i]);
        }
        System.out.println(result);
    }
}

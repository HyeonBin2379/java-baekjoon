package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise21567 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long num1 = Long.parseLong(br.readLine());
        long num2 = Long.parseLong(br.readLine());
        long num3 = Long.parseLong(br.readLine());

        int[] digits = new int[10];
        int[] num = Arrays.stream(Long.toString(num1*num2*num3).split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
        for (int j : num) {
            digits[j]++;
        }
        Arrays.stream(digits).forEach(System.out::println);
    }
}

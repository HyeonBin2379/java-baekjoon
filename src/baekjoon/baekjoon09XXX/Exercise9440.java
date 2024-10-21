package baekjoon.baekjoon09XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise9440 {

    private static int[] digits;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) {
                break;
            }
            digits = new int[n];
            IntStream.range(0, n).forEach(idx -> digits[idx] = Integer.parseInt(st.nextToken()));
            Arrays.sort(digits);
            int index = IntStream.range(0, n).filter(idx -> digits[idx] > 0).findFirst().getAsInt();

            if (index != -1) {
                swap(0, index);
                swap(1, index+1);
            }
            List<String> number1 = new ArrayList<>();
            List<String> number2 = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    number1.add(Integer.toString(digits[i]));
                } else {
                    number2.add(Integer.toString(digits[i]));
                }
            }
            System.out.println(Integer.parseInt(String.join("", number1))
                    + Integer.parseInt(String.join("", number2)));
        }
    }

    private static void swap(int index1, int index2) {
        int temp = digits[index1];
        digits[index1] = digits[index2];
        digits[index2] = temp;
    }
}

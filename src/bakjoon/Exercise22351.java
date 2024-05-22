package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class Exercise22351 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int[] a = IntStream.rangeClosed(1, Math.min(input.length(), 3))
                .map(n -> Integer.parseInt(input.substring(0, n)))
                .toArray();
        for (int j : a) {
            int b = j;
            StringBuilder newNum = new StringBuilder();
            while (newNum.length() < input.length()) {
                newNum.append(b);
                if (newNum.toString().equals(input)) {
                    System.out.println(j + " " + b);
                    return;
                }
                b++;
            }
        }
        System.out.println(input + " " + input);
    }
}

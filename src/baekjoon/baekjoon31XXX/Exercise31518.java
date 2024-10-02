package baekjoon.baekjoon31XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise31518 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < 3; i++) {
            boolean seven = Arrays.stream(br.readLine().split(" ", n))
                    .mapToInt(Integer::parseInt)
                    .anyMatch(value -> value == 7);
            if (!seven) {
                System.out.println(0);
                return;
            }
        }
        System.out.println(777);
    }
}

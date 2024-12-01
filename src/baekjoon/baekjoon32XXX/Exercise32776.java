package baekjoon.baekjoon32XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise32776 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int s = Integer.parseInt(br.readLine());
        int f = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sum();

        if (s <= f || s <= 240) {
            System.out.println("high speed rail");
        } else {
            System.out.println("flight");
        }
    }
}

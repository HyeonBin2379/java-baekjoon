package baekjoon.baekjoon32XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise32661 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int price = Integer.parseInt(br.readLine());
            max = Math.max(price, max);
            min = Math.min(price, min);
        }

        int limit = max / 2;
        int amount = Math.min(min, limit);
        System.out.println(min - amount);
    }
}

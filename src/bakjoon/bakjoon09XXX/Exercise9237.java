package bakjoon.bakjoon09XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Exercise9237 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] growingTime = Arrays.stream(br.readLine()
                .split(" "))
                .map(Integer::parseInt)
                .sorted(Collections.reverseOrder())
                .toArray(Integer[]::new);
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int daysNeeded = growingTime[i-1] + i;
            answer = Math.max(daysNeeded, answer);
        }
        System.out.println(++answer);
    }
}

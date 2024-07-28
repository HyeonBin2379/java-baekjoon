package bakjoon.bakjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Exercise1758 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Long[] line = new Long[n];
        for (int i = 0; i < n; i++) {
            line[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(line, Comparator.reverseOrder());

        long answer = 0;
        for (int i = 0; i < n; i++) {
            answer += Math.max(line[i] - i, 0);
        }
        System.out.println(answer);
    }
}

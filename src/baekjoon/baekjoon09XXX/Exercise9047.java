package baekjoon.baekjoon09XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Exercise9047 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        while (testcase-- > 0) {
            String[] digits = br.readLine().split("");
            int count = 0;
            while (Integer.parseInt(String.join("", digits)) != 6174) {
                int max = Integer.parseInt(Arrays.stream(digits).sorted(Comparator.reverseOrder()).collect(Collectors.joining()));
                int min = Integer.parseInt(Arrays.stream(digits).sorted().collect(Collectors.joining()));
                digits = String.format("%04d", max-min).split("");
                count++;
            }
            System.out.println(count);
        }
    }
}

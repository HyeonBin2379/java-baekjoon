package baekjoon.baekjoon13XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise13985 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] num = Arrays.stream(br.readLine().split(" "))
                .filter(s -> Character.isDigit(s.charAt(0)))
                .mapToInt(Integer::parseInt)
                .toArray();
        br.close();
        System.out.println((num[0] + num[1] == num[2]) ? "YES" : "NO");
    }
}

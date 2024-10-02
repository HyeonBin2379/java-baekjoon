package baekjoon.baekjoon15XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Exercise15029 {

    private static final List<String> colors = Arrays.asList("", "red", "yellow", "green", "brown", "blue", "pink", "black");

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int redCount = 0;
        int max = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            String color = br.readLine();
            if (color.equals("red")) {
                redCount++;
            } else {
                max = Math.max(colors.indexOf(color), max);
                sum += colors.indexOf(color);
            }
        }
        System.out.println((n-redCount) > 0 ? redCount*(1+max) + sum : 1);
    }
}

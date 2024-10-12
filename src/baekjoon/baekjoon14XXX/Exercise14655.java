package baekjoon.baekjoon14XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise14655 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int sum = Arrays.stream(br.readLine().split(" ", n)).mapToInt(s -> Math.abs(Integer.parseInt(s))).sum();
        sum += Arrays.stream(br.readLine().split(" ", n)).mapToInt(s -> Math.abs(Integer.parseInt(s))).sum();
        System.out.println(sum);
    }
}

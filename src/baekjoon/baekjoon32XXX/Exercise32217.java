package baekjoon.baekjoon32XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise32217 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int sum = Arrays.stream(br.readLine().split(" ", n)).mapToInt(Integer::parseInt).sum();
        System.out.println(180*(n-1)-2*sum);
    }
}

package baekjoon.baekjoon29XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise29986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());
        int[] input = Arrays.stream(br.readLine().split(" ", n)).mapToInt(Integer::parseInt).toArray();
        System.out.println((int) Arrays.stream(input).filter(value -> value <= num).count());
    }
}

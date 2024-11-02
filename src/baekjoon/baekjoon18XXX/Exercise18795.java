package baekjoon.baekjoon18XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise18795 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long rowSum = Arrays.stream(br.readLine().split(" ", n)).mapToLong(Long::parseLong).sum();
        long colSum = Arrays.stream(br.readLine().split(" ", m)).mapToLong(Long::parseLong).sum();

        System.out.println(rowSum + colSum);
    }
}

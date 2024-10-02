package baekjoon.baekjoon31XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise31408 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] num = new int[100001];
        int soldier;
        for (int i = 0; i < n; i++) {
            soldier = Integer.parseInt(st.nextToken());
            num[soldier]++;
        }
        int maxCnt = Arrays.stream(num).max().getAsInt();
        System.out.println(maxCnt <= (int)Math.ceil((double) n / 2) ? "YES" : "NO");
    }
}

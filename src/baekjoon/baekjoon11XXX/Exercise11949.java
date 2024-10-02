package baekjoon.baekjoon11XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise11949 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j < n; j++) {
                if (num[j-1] % i > num[j] % i) {
                    int temp = num[j-1];
                    num[j-1] = num[j];
                    num[j] = temp;
                }
            }
        }
        Arrays.stream(num).forEach(System.out::println);
    }
}

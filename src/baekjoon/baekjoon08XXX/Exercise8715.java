package baekjoon.baekjoon08XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise8715 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(num);

        for (int i = 1; i <= n/2; i++) {
            if (num[i-1] != i || num[n-i] != n+1-i) {
                System.out.println("NIE");
                return;
            }
        }
        System.out.println("TAK");
    }
}

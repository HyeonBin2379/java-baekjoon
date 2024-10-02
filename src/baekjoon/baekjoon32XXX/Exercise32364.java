package baekjoon.baekjoon32XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise32364 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] hatNum = new int[n];
        for (int i = 0; i < n; i++) {
            hatNum[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        for (int i = 0; i < n/2; i++) {
            if (hatNum[i] == hatNum[i+n/2]) {
                count++;
            }
        }
        System.out.println(count*2);
    }
}

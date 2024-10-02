package baekjoon.baekjoon18XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise18856 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        int[] num = new int[len];

        System.out.println(len);
        for (int i = 0; i < len; i++) {
            if (i < 2) {
                num[i] = i+1;
            } else if (i == len-1) {
                num[i] = 997;
            } else {
                num[i] = num[i-1]+1;
            }
            System.out.print(num[i] + " ");
        }
    }
}
package baekjoon.baekjoon23XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise23739 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            int time = Integer.parseInt(br.readLine());
            if ((int)Math.ceil((double)time/2) <= 30-sum) {
                count++;
            }
            sum += time;
            if (sum >= 30) {
                sum = 0;
            }
        }
        System.out.println(count);
    }
}
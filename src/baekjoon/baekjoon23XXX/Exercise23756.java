package baekjoon.baekjoon23XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise23756 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int now = Integer.parseInt(br.readLine());
        int answer = 0;
        for (int i = 0; i < n; i++) {
            int angle = Integer.parseInt(br.readLine());
            int diff = Math.abs(now-angle);
            answer += Math.min(diff, Math.min(360-diff, 360+diff));
            now = angle;
        }
        System.out.println(answer);
    }
}

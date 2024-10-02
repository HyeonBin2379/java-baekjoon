package baekjoon.baekjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise1453 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] seat = new boolean[101];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;
        for (int i = 0; i < n; i++) {
            int seatNum = Integer.parseInt(st.nextToken());
            if (seat[seatNum]) {
                answer++;
            }
            seat[seatNum] = true;
        }
        System.out.println(answer);
    }
}

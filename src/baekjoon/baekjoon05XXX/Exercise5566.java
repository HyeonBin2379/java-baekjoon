package baekjoon.baekjoon05XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise5566 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] board = initArray(n);
        int[] dice = initArray(m);
        int now = 0, answer = 0;
        for (int i = 0; i < m; i++) {
            now += dice[i];
            if (now >= n-1) {
                answer = i+1;
                break;
            }
            now += board[now];
            if (now >= n-1) {
                answer = i+1;
                break;
            }
        }
        System.out.println(answer);
    }

    public static int[] initArray(int len) throws IOException {
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        return arr;
    }
}

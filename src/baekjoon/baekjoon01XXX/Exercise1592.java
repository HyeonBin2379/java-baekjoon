package baekjoon.baekjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise1592 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[] caught = new int[n];
        int count = 0;
        int now = 0;
        while (true) {
            int next = (caught[now] % 2 == 1) ? (now+l) % n : ((now+n-l) % n) % n;
            caught[now]++;
            if (caught[now] == m) {
                break;
            }
            now = next;
            count++;
        }
        System.out.println(count);
    }
}

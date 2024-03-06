package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise24333 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int l1 = Integer.parseInt(st.nextToken());
        int r1 = Integer.parseInt(st.nextToken());
        int l2 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int start = Math.max(l1, l2);
        int end = Math.min(r1, r2);
        int count = 0;
        if (start <= end) {
            count = (end-start+1) - (end/k) + (start-1)/k;
        }
        System.out.println(count);
    }
}

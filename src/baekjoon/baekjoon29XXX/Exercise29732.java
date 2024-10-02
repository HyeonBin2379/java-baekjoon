package baekjoon.baekjoon29XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise29732 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        char[] input = br.readLine().toCharArray();
        int minLeft = n, maxRight = 0;
        for (int i = 0; i < n; i++) {
            char person = input[i];
            if (person == 'R') {
                int left = Math.max(0, i-k);
                int right = Math.min(n-1, i+k);
                minLeft = Math.min(left, minLeft);
                maxRight = Math.max(right, maxRight);
            }
        }
        System.out.println((maxRight-minLeft+1) > m ? "No" : "Yes");
    }
}

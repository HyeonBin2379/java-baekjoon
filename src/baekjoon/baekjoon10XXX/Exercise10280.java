package baekjoon.baekjoon10XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise10280 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
        }

        int left = 0;
        int right = n-1;
        while (left < right) {
            right--;
            if (left >= right) {
                break;
            }
            left++;
        }

        System.out.println(left == right && left == p ? "YES" : "NO");
    }
}

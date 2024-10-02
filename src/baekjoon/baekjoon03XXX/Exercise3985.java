package baekjoon.baekjoon03XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise3985 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int l = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[1001];
        int[] count = new int[1001];

        int expected = -1, expectedNum = Integer.MAX_VALUE;
        int result = -1, realNum = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            count[i] = k-p+1;
            if (expected < count[i]) {
                expected = count[i];
                expectedNum = i;
            } else if (expected == count[i]) {
                expectedNum = Math.min(i, expectedNum);
            }
            for (int j = p; j <= k; j++) {
                if (num[j] == 0) {
                    num[j] = i;
                } else {
                    count[i]--;
                }
            }
            if (result < count[i]) {
                result = count[i];
                realNum = i;
            } else if (result == count[i]) {
                realNum = Math.min(i, realNum);
            }
        }
        System.out.println(expectedNum);
        System.out.println(realNum);
    }
}

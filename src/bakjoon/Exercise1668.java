package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise1668 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        int[] trophy = new int[len];

        int max = Integer.MIN_VALUE;
        int leftCnt = 0;
        for (int i = 0; i < len; i++) {
            trophy[i] = Integer.parseInt(br.readLine());
            if (max < trophy[i]) {
                max = trophy[i];
                leftCnt++;
            }
        }

        max = Integer.MIN_VALUE;
        int rightCnt = 0;
        for (int i = len-1; i >= 0; i--) {
            if (max < trophy[i]) {
                max = trophy[i];
                rightCnt++;
            }
        }
        System.out.println(leftCnt);
        System.out.println(rightCnt);
    }
}

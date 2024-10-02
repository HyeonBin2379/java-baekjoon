package baekjoon.baekjoon28XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise28454 {

    private static final int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] today = Arrays.stream(br.readLine().split("-")).mapToInt(Integer::parseInt).toArray();
        int now = getDayCnt(today);

        int n = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < n; i++) {
            int[] expiredDay = Arrays.stream(br.readLine().split("-")).mapToInt(Integer::parseInt).toArray();
            int expired = getDayCnt(expiredDay);
            if (now <= expired) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static int getDayCnt(int[] date) {
        int sum = 0;
        sum += 365*(date[0]-1) + date[2];
        for (int i = 1; i < date[1]; i++) {
            sum += days[i];
        }
        return sum;
    }
}

package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise3226 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int total = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] start = Arrays.stream(st.nextToken().split(":")).mapToInt(Integer::parseInt).toArray();
            int callTime = Integer.parseInt(st.nextToken());

            int[] end = new int[2];
            end[1] = start[1] + callTime;
            if (start[1]+callTime >= 60) {
                end[1] -= 60;
                end[0] = (start[0]+1 > 23) ? 0 : start[0]+1;
            }

            if ((end[0] == 7 || end[0] == 19)
                    && (start[1] >= end[1] && end[1] > 0)) {
                if (end[0] == 7) {
                    total += (callTime - end[1]) * 5 + end[1] * 10;
                } else {
                    total += (callTime - end[1]) * 10 + end[1] * 5;
                }
            } else {
                if (start[0] >= 7 && start[0] <= 18) {
                    total += callTime * 10;
                } else {
                    total += callTime * 5;
                }
            }
        }
        System.out.println(total);
    }
}

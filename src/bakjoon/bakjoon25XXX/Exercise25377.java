package bakjoon.bakjoon25XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise25377 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int[][] time = new int[count][];

        int result = 1001;
        for (int i = 0; i < count; i++) {
            time[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (time[i][0] <= time[i][1]) {
                result = Math.min(result, time[i][1]);
            }
        }
        br.close();
        System.out.println((result == 1001) ? -1 : result);
    }
}

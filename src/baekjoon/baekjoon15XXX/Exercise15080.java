package baekjoon.baekjoon15XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise15080 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] before = Arrays.stream(br.readLine().split(" : ")).mapToInt(Integer::parseInt).toArray();
        int[] after = Arrays.stream(br.readLine().split(" : ")).mapToInt(Integer::parseInt).toArray();
        br.close();
        if (before[0] > after[0]
                || (before[0] == after[0] && before[1] > after[1])
                || (before[0] == after[0] && before[1] == after[1] && before[2] > after[2])) {
            after[0] += 24;
        }
        int time1 = before[0]*3600 + before[1]*60 + before[2];
        int time2 = after[0]*3600 + after[1]*60 + after[2];
        System.out.println(time2 - time1);
    }
}

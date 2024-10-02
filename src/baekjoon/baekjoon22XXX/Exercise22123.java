package baekjoon.baekjoon22XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise22123 {

    private static int[] start, end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            start = Arrays.stream(st.nextToken().split(":")).mapToInt(Integer::parseInt).toArray();
            end = Arrays.stream(st.nextToken().split(":")).mapToInt(Integer::parseInt).toArray();
            int k = Integer.parseInt(st.nextToken());

            int sTime = getTime(start);
            int eTime = getTime(end);
            if (isNextDay()) {
                eTime += 86400;
            }

            int totalTime = eTime-sTime;
            if (totalTime >= k * 60) {
                System.out.println("Perfect");
            } else if (totalTime + 3600 >= k * 60) {
                System.out.println("Test");
            } else {
                System.out.println("Fail");
            }
        }
    }

    private static int getTime(int[] date) {
        int time = 0;
        for (int i = 0; i < date.length; i++) {
            time += date[i]*Math.pow(60, 2 - i);
        }
        return time;
    }

    private static boolean isNextDay() {
        return (start[0] > end[0])
                || (start[0] == end[0] && start[1] > end[1])
                || (start[0] == end[0] && start[1] == end[1] && start[2] >= end[2]);
    }
}

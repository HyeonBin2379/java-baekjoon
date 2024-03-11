package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise13223 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] start = Arrays.stream(br.readLine().split(":")).mapToInt(Integer::parseInt).toArray();
        int[] end = Arrays.stream(br.readLine().split(":")).mapToInt(Integer::parseInt).toArray();
        if (isNextDay(start, end)) {
            end[0] += 24;
        }
        int sec = 0;
        for (int i = 0; i < 3; i++) {
            sec += (int)Math.pow(60, 2-i)*(end[i]-start[i]);
        }
        System.out.printf("%02d:%02d:%02d\n", sec/3600, (sec%3600)/60, sec%60);
    }

    public static boolean isNextDay(int[] start, int[] end) {
        return (start[0] > end[0])
                || (start[0] == end[0] && start[1] > end[1])
                || (start[0] == end[0] && start[1] == end[1] && start[2] >= end[2]);
    }
}

package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise1408 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] start = Arrays.stream(br.readLine().split(":")).mapToInt(Integer::parseInt).toArray();
        int[] end = Arrays.stream(br.readLine().split(":")).mapToInt(Integer::parseInt).toArray();

        int startTime = start[0]*3600 + start[1]*60 + start[2];
        int endTime = end[0]*3600 + end[1]*60 + end[2];
        if (startTime >= endTime) {
            endTime += 86400;
        }
        int timeDiff = endTime - startTime;
        System.out.printf("%02d:%02d:%02d\n", timeDiff/3600, (timeDiff % 3600)/60, timeDiff % 60);
    }
}

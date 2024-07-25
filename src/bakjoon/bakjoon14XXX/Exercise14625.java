package bakjoon.bakjoon14XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise14625 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] start = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] end = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = Integer.parseInt(br.readLine());

        int startTime = start[0]*60+start[1];
        int endTime = end[0]*60+end[1];
        int count = 0;
        for (int i = startTime; i <= endTime; i++) {
            if (String.format("%02d %02d", i / 60, i % 60)
                    .contains(Integer.toString(n))) {
                count++;
            }
        }
        System.out.println(count);
    }
}

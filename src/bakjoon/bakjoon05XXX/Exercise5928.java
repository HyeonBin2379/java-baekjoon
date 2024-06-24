package bakjoon.bakjoon05XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise5928 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dhm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int startTime = 11*1440 + 11*60 + 11;
        int endTime = dhm[0]*1440 + dhm[1]*60 + dhm[2];
        System.out.println((endTime < startTime) ? -1 : endTime-startTime);
    }
}

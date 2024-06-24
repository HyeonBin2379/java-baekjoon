package bakjoon.bakjoon25XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise25933 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] time = Arrays.stream(br.readLine().split(":")).mapToInt(Integer::parseInt).toArray();
        int cook = time[0]*3600 + time[1]*60;
        int expected = time[0]*60 + time[1];
        int needTime = cook-expected;
        System.out.printf("%02d:%02d:%02d\n", needTime/3600, (needTime%3600)/60, needTime%60);
    }
}

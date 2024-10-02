package baekjoon.baekjoon28XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise28840 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] start = Arrays.stream(br.readLine().split(":")).mapToInt(Integer::parseInt).toArray();
        int[] end = Arrays.stream(br.readLine().split(":")).mapToInt(Integer::parseInt).toArray();
        int timeDiff = (end[0]+24-start[0])*60 + (end[1]-start[1]);
        System.out.printf("%02d:%02d\n", timeDiff/60, timeDiff%60);
    }
}

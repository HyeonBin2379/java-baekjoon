package baekjoon.baekjoon14XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise14724 {

    private static final String[] clubName = {"PROBRAIN", "GROW", "ARGOS", "ADMIN", "ANT", "MOTION", "SPG", "COMON", "ALMIGHTY"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int totalMax = 0;
        int idx = 0;
        for (int i = 0; i < clubName.length; i++) {
            int max = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).max().getAsInt();
            if (totalMax < max) {
                totalMax = max;
                idx = i;
            }
        }
        System.out.println(clubName[idx]);
    }
}
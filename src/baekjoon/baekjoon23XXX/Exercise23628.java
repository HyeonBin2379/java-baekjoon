package baekjoon.baekjoon23XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise23628 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] date1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] date2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int total = (date2[0]-date1[0])*360 + (date2[1]-date1[1])*30 + (date2[2]-date1[2]);
        int year = total/360;
        int annual = 0;
        for (int i = 1; i <= year; i++) {
            int temp = i % 2 == 0 ? i-1 : i;
            annual += (temp - (temp/2+1) + 15);
        }

        int monthly = Math.min(total/30, 36);
        System.out.println(annual + " " + monthly);
        System.out.println(total + "days");
    }
}

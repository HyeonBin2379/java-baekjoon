package baekjoon.baekjoon29XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise29657 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] org = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] changed = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] time = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int total = time[0]*org[1]*org[2] + time[1]*org[2] + time[2];
        total %= org[0]*org[1]*org[2];
        System.out.printf("%d %d %d\n",
                total/(changed[1]*changed[2]), (total % (changed[1]*changed[2]))/changed[2], total % changed[2]);
    }
}

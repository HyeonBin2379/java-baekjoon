package baekjoon.baekjoon31XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise31712 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] yoon = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] dalgu = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] ponix = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int pinkBean = Integer.parseInt(br.readLine());

        int raidTime = 0;
        while (true) {
            if (raidTime % yoon[0] == 0) {
                pinkBean -= yoon[1];
                if (pinkBean <= 0) {
                    break;
                }
            }
            if (raidTime % dalgu[0] == 0) {
                pinkBean -= dalgu[1];
                if (pinkBean <= 0) {
                    break;
                }
            }
            if (raidTime % ponix[0] == 0) {
                pinkBean -= ponix[1];
                if (pinkBean <= 0) {
                    break;
                }
            }
            raidTime++;
        }
        System.out.println(raidTime);
    }
}

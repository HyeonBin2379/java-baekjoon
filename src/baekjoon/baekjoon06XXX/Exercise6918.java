package baekjoon.baekjoon06XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise6918 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int pink = Integer.parseInt(br.readLine());
        int green = Integer.parseInt(br.readLine());
        int red = Integer.parseInt(br.readLine());
        int orange = Integer.parseInt(br.readLine());
        int total = Integer.parseInt(br.readLine());

        int minCnt = Integer.MAX_VALUE;
        int count = 0;
        for (int a = 0; a <= total; a += pink) {
            for (int b = 0; b <= total-a; b += green) {
                for (int c = 0; c <= total-b; c += red) {
                    for (int d = 0; d <= total-c; d += orange) {
                        if (a + b + c + d == total) {
                            int ticket = a/pink + b/green + c/red + d/orange;
                            minCnt = Math.min(ticket, minCnt);
                            count++;
                            System.out.printf("# of PINK is %d # of GREEN is %d # of RED is %d # of ORANGE is %d\n", a/pink, b/green, c/red, d/orange);
                            break;
                        }
                    }
                }
            }
        }
        System.out.printf("Total combinations is %d.\n", count);
        System.out.printf("Minimum number of tickets to print is %d.\n", minCnt);
    }
}

package baekjoon.baekjoon06XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise6904 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int area = Integer.parseInt(br.readLine());
            if (area == 0) {
                break;
            }

            int max = 0;
            for (int i = 1; i*i <= area; i++) {
                if (area % i == 0) {
                    max = Math.max(i, max);
                }
            }
            int len = (max + area/max) * 2;
            System.out.printf("Minimum perimeter is %d with dimensions %d x %d\n", len, max, area/max);
        }
    }
}

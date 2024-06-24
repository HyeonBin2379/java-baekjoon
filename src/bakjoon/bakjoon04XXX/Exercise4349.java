package bakjoon.bakjoon04XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise4349 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int num = Integer.parseInt(br.readLine());
            int min = Integer.MAX_VALUE;
            for (int a = 1; a <= num; a++) {
                for (int b = 1; a*b <= num; b++) {
                    for (int c = 1; a*b*c <= num; c++) {
                        if (a*b*c == num) {
                            int area = 2*a*b + 2*(a+b)*c;
                            min = Math.min(area, min);
                            break;
                        }
                    }
                }
            }
            System.out.println(min);
        }
    }
}

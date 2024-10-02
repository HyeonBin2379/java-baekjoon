package baekjoon.baekjoon25XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise25286 {

    private static final int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int year = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());

            if (month == 1) {
                System.out.printf("%d %d %d\n", year-1, 12, days[12]);
            } else if (month == 3) {
                if (isLeapYear(year)) {
                    System.out.printf("%d %d %d\n", year, month-1, days[month-1]+1);
                } else {
                    System.out.printf("%d %d %d\n", year, month-1, days[month-1]);
                }
            } else {
                System.out.printf("%d %d %d\n", year, month-1, days[month-1]);
            }
        }
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }
}

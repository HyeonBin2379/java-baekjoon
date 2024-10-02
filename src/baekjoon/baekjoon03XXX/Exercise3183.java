package baekjoon.baekjoon03XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise3183 {

    private static final int[] daysOfMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());

            if (day == 0 && month == 0 && year == 0) {
                break;
            }
            if (isValidDate(day, month, year)) {
                System.out.println("Valid");
            } else {
                System.out.println("Invalid");
            }
        }
    }

    private static boolean isLeapYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }

    private static boolean isValidMonth(int month) {
        return month >= 1 && month <= 12;
    }

    private static boolean isValidDate(int day, int month, int year) {
        if (month == 2) {
            return (isLeapYear(year) && day >= 1 && day <= daysOfMonth[month]+1)
                    || (!isLeapYear(year) && day >= 1 && day <= daysOfMonth[month]);
        } else if (isValidMonth(month)) {
            return day >= 1 && day <= daysOfMonth[month];
        } else {
            return false;
        }
    }
}

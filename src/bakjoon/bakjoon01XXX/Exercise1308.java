package bakjoon.bakjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise1308 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] startDate = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] endDate = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        br.close();

        if (overThousandYears(startDate, endDate)) {
            System.out.println("gg");
        } else {
            int days1 = getDays(startDate);
            int days2 = getDays(endDate);
            System.out.println("D-" + (days2-days1));
        }
    }

    public static boolean overThousandYears(int[] startDate, int[] endDate) {
        return endDate[0]-startDate[0] > 1000
                || endDate[0]-startDate[0] == 1000 && (startDate[1] < endDate[1] || startDate[1] == endDate[1] && startDate[2] <= endDate[2]);
    }

    public static int getDays(int[] date) {
        int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int totalDays = 0;

        for (int i = 1; i < date[0]; i++) { // 년
            totalDays += (365 + checkLeapYear(i));
        }
        for (int i = 0; i < date[1]; i++) { // 월
            if (i == 2) {
                totalDays += checkLeapYear(date[0]);
            }
            totalDays += days[i];
        }
        return totalDays + date[2]; // 일
    }
    public static int checkLeapYear(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
            return 1;
        else
            return 0;
    }
}

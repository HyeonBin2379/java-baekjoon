package bakjoon.bakjoon2XXX;

import java.util.Scanner;

public class Exercise2948 {

    private static final int[] daysOfMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final String[] daysOfWeek = {"Wednesday", "Thursday", "Friday", "Saturday", "Sunday", "Monday", "Tuesday"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int days = sc.nextInt();
        int month = sc.nextInt();

        for (int i = 1; i < month; i++) {
            days += daysOfMonth[i];
        }
        System.out.println(daysOfWeek[days % 7]);
    }
}

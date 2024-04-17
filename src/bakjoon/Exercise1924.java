package bakjoon;

import java.util.Scanner;

public class Exercise1924 {

    private static final String[] answer = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
    private static final int[] daysOfMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int month = sc.nextInt();
        int totalDays = sc.nextInt();
        for (int i = 1; i < month; i++) {
            totalDays += daysOfMonth[i];
        }
        System.out.println(answer[totalDays % 7]);
    }
}

package bakjoon.bakjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercise1340 {

    private static final List<String> month = new ArrayList<>(List.of(
            "", "January", "February", "March",
            "April", "May", "June", "July", "August",
            "September", "October", "November", "December"));
    private static final int[] daysOfMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] time = br.readLine().split(" ");
        int year = Integer.parseInt(time[2]);
        if (isLeap(year)) {
            daysOfMonth[2]++;
        }

        int totalDays = Arrays.stream(daysOfMonth).sum();
        int today = Integer.parseInt(time[1].split(",")[0]);
        for (int i = 1; i < month.indexOf(time[0]); i++) {
            today += daysOfMonth[i];
        }

        int timeCnt = Integer.parseInt(time[3].split(":")[0])*60 + Integer.parseInt(time[3].split(":")[1]);
        int totalTime = totalDays * 60*24;
        int todayTime = (today-1) * 60*24 + timeCnt;
        double answer = (double) todayTime * 100 / totalTime;
        System.out.printf("%.9f\n", answer);
    }

    public static boolean isLeap(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }
}

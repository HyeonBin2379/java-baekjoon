package baekjoon.baekjoon06XXX;

import java.util.Scanner;

public class Exercise6812 {
    private static final String[] city = {"Victoria", "Edmonton", "Winnipeg", "Toronto", "Halifax", "St. John's"};
    private static final int[] diff = {-180, -120, -60, 0, 60, 90};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int hour = input/100;
        int minute = input % 100;
        int time = 60*hour + minute;

        System.out.printf("%d in %s\n", input, "Ottawa");
        for (int i = 0; i < city.length; i++) {
            int temp = time + diff[i];
            if (temp < 0) {
                temp += 1440;
            }
            String result = String.format("%02d", (temp / 60) % 24) + String.format("%02d", temp % 60);
            System.out.printf("%d in %s\n", Integer.parseInt(result), city[i]);
        }
    }
}

package baekjoon.baekjoon26XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise26576 {

    private static final int[] date = new int[3];
    private static final String[] months = {
            "", "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            String[] tokens = br.readLine().split(", ");
            String[] monthAndDate = tokens[0].split(" ");
            date[0] = convertStringToNum(monthAndDate[0]);
            date[1] = Integer.parseInt(monthAndDate[1]);
            date[2] = Integer.parseInt(tokens[1]) % 100;

            if (date[0] < 1 || date[1] < 1 || date[1] > 31) {
                System.out.println("Invalid");
            } else {
                System.out.printf("%02d/%02d/%02d\n", date[0], date[1], date[2]);
            }
        }
    }

    public static int convertStringToNum(String month) {
        for (int i = 1; i <= 12; i++) {
            if (months[i].equals(month)) {
                return i;
            }
        }
        return 0;
    }
}

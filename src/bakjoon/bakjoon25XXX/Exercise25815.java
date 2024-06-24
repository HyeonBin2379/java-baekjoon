package bakjoon.bakjoon25XXX;

import java.util.Scanner;

public class Exercise25815 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        int month = sc.nextInt();

        int ansYear, ansMonth;
        if (year < 1) {
            ansYear = 15 * month / 12;
            ansMonth = 15 * month % 12;
        } else if (year < 2) {
            ansYear = 15 + (9*month/12);
            ansMonth = 9*month % 12;
        } else {
            ansYear = 24 + (year-2)*4 + (4 * month / 12);
            ansMonth = (4 * month % 12);
        }
        System.out.println(ansYear + " " + ansMonth);
    }
}

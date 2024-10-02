package baekjoon.baekjoon20XXX;

import java.util.Scanner;

public class Exercise20232 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] winner = new String[]{"ITMO", "SPbSU", "SPbSU", "ITMO", "ITMO",
                "SPbSU", "ITMO", "ITMO", "ITMO", "ITMO",
                "ITMO", "PetrSU, ITMO", "SPbSU", "SPbSU",
                "ITMO", "ITMO", "ITMO", "ITMO", "SPbSU",
                "ITMO", "ITMO", "ITMO", "ITMO", "SPbSU", "ITMO"};
        int year = sc.nextInt();
        System.out.println(winner[year-1995]);
    }
}

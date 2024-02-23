package bakjoon;

import java.util.Scanner;

public class Exercise6888 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        for (int i = x; i <= y; i += 60) {
            System.out.printf("All positions change in year %d\n", i);
        }
    }
}

package bakjoon.bakjoon23XXX;

import java.util.Scanner;

public class Exercise23795 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        while (true) {
            int cost = sc.nextInt();
            if (cost < 0) {
                break;
            }
            sum += cost;
        }
        sc.close();
        System.out.println(sum);
    }
}

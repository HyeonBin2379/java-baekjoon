package bakjoon;

import java.util.Scanner;

public class Exercise15025 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int r = sc.nextInt();
        if (l == 0 && r == 0) {
            System.out.println("Not a moose");
            return;
        }

        if (l == r) {
            System.out.printf("Even %d\n", l+r);
        } else {
            System.out.printf("Odd %d\n", Math.max(l, r)*2);
        }
    }
}

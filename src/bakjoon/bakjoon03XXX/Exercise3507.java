package bakjoon.bakjoon03XXX;

import java.util.Scanner;

public class Exercise3507 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int count = 0;
        if (num > 198) {
            System.out.println(count);
            return;
        }

        for (int i = 0; i < 100; i++) {
            if (num - i >= 0 && num - i < 100) {
                count++;
            }
        }
        System.out.println(count);
    }
}

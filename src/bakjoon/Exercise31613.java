package bakjoon;

import java.util.Scanner;

public class Exercise31613 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = Integer.parseInt(sc.nextLine());
        int n = Integer.parseInt(sc.nextLine());

        int count = 0;
        while (x < n) {
            switch (x % 3) {
                case 0 -> x += 1;
                case 1 -> x *= 2;
                case 2 -> x *= 3;
            }
            count++;
        }
        System.out.println(count);
    }
}

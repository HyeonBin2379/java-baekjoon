package bakjoon;

import java.util.Scanner;

public class Exercise24087 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();

        int total = 250;
        for (int i = a; i < s; i += b) {
            total += 100;
        }
        System.out.println(total);
    }
}

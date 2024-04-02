package bakjoon;

import java.util.Scanner;

public class Exercise18005 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if (num % 4 == 0) {
            System.out.println(2);
        } else if (num % 4 == 2) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}

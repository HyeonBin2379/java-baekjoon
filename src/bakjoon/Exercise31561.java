package bakjoon;

import java.util.Scanner;

public class Exercise31561 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int min = sc.nextInt();
        if (min <= 30) {
            System.out.println(min/2.0);
        } else {
            System.out.println(((min-30)*3/2.0) + 15);
        }
    }
}

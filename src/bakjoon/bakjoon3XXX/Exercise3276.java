package bakjoon.bakjoon3XXX;

import java.util.Scanner;

public class Exercise3276 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(Math.round(Math.sqrt(num)) + " " + (int) Math.ceil(Math.sqrt(num)));
    }
}

package bakjoon.bakjoon24XXX;

import java.util.Scanner;

public class Exercise24789 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        System.out.println(y % 2 == 0 ? "possible" : "impossible");
    }
}

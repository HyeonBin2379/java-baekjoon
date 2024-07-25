package bakjoon.bakjoon24XXX;

import java.util.Scanner;

public class Exercise24937 {

    private static final String str = "SciComLove";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt() % str.length();
        if (n == 0) {
            System.out.println(str);
        } else if (n == str.length()-1) {
            System.out.println(str.charAt(n) + str.substring(0, n));
        } else {
            System.out.println(str.substring(n) + str.substring(0, n));
        }
    }
}

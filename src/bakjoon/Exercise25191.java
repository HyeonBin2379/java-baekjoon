package bakjoon;

import java.util.Scanner;

public class Exercise25191 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int chicken = sc.nextInt();
        int coke = sc.nextInt();
        int beer = sc.nextInt();
        System.out.println(Math.min(chicken, (coke/2)+beer));
    }
}

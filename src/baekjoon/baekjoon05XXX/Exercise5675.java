package baekjoon.baekjoon05XXX;

import java.util.Scanner;

public class Exercise5675 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            System.out.println(num % 6 == 0 ? "Y" : "N");
        }
    }
}

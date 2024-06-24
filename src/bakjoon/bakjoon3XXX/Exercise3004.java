package bakjoon.bakjoon3XXX;

import java.util.Scanner;

public class Exercise3004 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int len = count/2;
        System.out.println((count % 2 == 0) ? (int) Math.pow(len+1, 2) : (len+1)*(len+2));
    }
}

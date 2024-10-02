package baekjoon.baekjoon06XXX;

import java.util.Scanner;

public class Exercise6794 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int count = (int) Math.ceil((double)(num+1)/2);
        for (int i = num; i > num/2; i--) {
            if (i > 5) {
                count--;
            }
        }
        System.out.println(count);
    }
}

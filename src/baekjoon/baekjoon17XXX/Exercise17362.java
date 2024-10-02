package baekjoon.baekjoon17XXX;

import java.util.Scanner;

public class Exercise17362 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] cycle = {1, 2, 3, 4, 5, 4, 3, 2};
        System.out.println(cycle[(num-1) % cycle.length]);
    }
}

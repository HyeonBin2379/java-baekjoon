package baekjoon.baekjoon27XXX;

import java.util.Scanner;

public class Exercise27512 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        System.out.println(row % 2 == 1 && col % 2 == 1 ? row*col-1 : row*col);
    }
}

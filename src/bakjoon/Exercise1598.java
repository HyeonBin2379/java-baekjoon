package bakjoon;

import java.util.Scanner;

public class Exercise1598 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int[] posA = getPosition(a);
        int[] posB = getPosition(b);
        System.out.println(Math.abs(posB[0]-posA[0]) + Math.abs(posB[1]-posA[1]));
    }

    public static int[] getPosition(int num) {
        int[] pos = new int[2];
        pos[0] = (num % 4 == 0) ? 4 : num % 4;
        pos[1] = (int) Math.ceil((double) num / 4);
        return pos;
    }
}

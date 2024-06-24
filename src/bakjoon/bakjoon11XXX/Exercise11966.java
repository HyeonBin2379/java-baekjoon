package bakjoon.bakjoon11XXX;

import java.util.Scanner;

public class Exercise11966 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if (num == 1 || isBinary(num)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    public static boolean isBinary(int num) {
        String binary = Integer.toBinaryString(num);
        return binary.startsWith("1")
                && binary.substring(1).chars().allMatch(value -> value == '0');
    }
}

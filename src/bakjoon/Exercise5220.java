package bakjoon;

import java.util.Scanner;

public class Exercise5220 {
    private static boolean solveErrorDetection(int value, int checkbit) {
        int bit = Integer.bitCount(value) % 2 == 0 ? 0 : 1;
        return bit == checkbit;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numCases = sc.nextInt();

        for(int i = 0; i < numCases; i++) {
            int value = sc.nextInt();
            int checkbit = sc.nextInt();
            if (solveErrorDetection(value, checkbit)) {
                System.out.println("Valid");
            }
            else {
                System.out.println("Corrupt");
            }
        }
    }
}

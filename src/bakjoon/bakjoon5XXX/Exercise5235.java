package bakjoon.bakjoon5XXX;

import java.util.Scanner;

public class Exercise5235 {
    private static int checkEvenSumMoreThanOddSum(int[] sequence) {
        int evenSum = 0, oddSum = 0;
        for (int j : sequence) {
            if (j % 2 == 0) {
                evenSum += j;
            } else {
                oddSum += j;
            }
        }
        return Integer.compare(evenSum, oddSum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numCases = sc.nextInt();

        for(int i = 0; i < numCases; i++) {
            int lengthOfSequence = sc.nextInt();
            int [] sequence = new int[lengthOfSequence];

            for(int j = 0; j < lengthOfSequence; j++) {
                sequence[j] = sc.nextInt();
            }

            int res = checkEvenSumMoreThanOddSum(sequence);
            if(res > 0) {
                System.out.println("EVEN");
            } else {
                if(res < 0) {
                    System.out.println("ODD");
                } else {
                    System.out.println("TIE");
                }
            }
        }
    }
}

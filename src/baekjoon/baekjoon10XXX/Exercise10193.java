package baekjoon.baekjoon10XXX;

import java.util.Scanner;

public class Exercise10193 {

    private static int costToSwap(String word1, String word2) {
        int result = 0;
        int n = word1.length();
        for (int i = 0; i < n; i++) {
            result += word1.charAt(i)-word2.charAt(i);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numOfTestCases = sc.nextInt();

        for (int testCase=0; testCase < numOfTestCases; testCase++) {
            String word1 = sc.next();
            String word2 = sc.next();

            int cost = costToSwap(word1, word2);
            System.out.print(
                    "Swapping letters to make " +
                            word1 +
                            " look like " +
                            word2
            );
            if (cost > 0) {
                System.out.println(
                        " earned " + cost + " coins."
                );
            }
            else if (cost < 0) {
                System.out.println(
                        " cost " + ((-1)*(cost)) + " coins."
                );
            }
            else {
                System.out.println(
                        " was FREE."
                );
            }
        }
        sc.close();
    }
}

package baekjoon.baekjoon10XXX;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise10202 {

    private static int solveLongestSubsequence(ArrayList<String> sequence) {
        int answer = -1;
        int count = sequence.get(0).equals("X") ? 1 : 0;
        for (int i = 1; i < sequence.size(); i++) {
            if (sequence.get(i).equals("X") && sequence.get(i).equals(sequence.get(i-1))) {
                count++;
            } else {
                answer = Math.max(count, answer);
                count = 0;
            }
        }
        return Math.max(count, answer);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numCases = sc.nextInt();

        for(int n = 0; n < numCases; n++) {
            int numLength = sc.nextInt();
            ArrayList<String> sequence = new ArrayList<>();
            for(int i = 0; i < numLength; i++) {
                sequence.add(sc.next());
            }
            System.out.println("The longest contiguous subsequence of X's is of length " + solveLongestSubsequence(sequence));
        }

        sc.close();
    }
}

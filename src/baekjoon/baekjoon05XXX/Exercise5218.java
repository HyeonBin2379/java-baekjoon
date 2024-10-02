package baekjoon.baekjoon05XXX;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise5218 {

    private static ArrayList<Integer> solveAlphabetDistance(String s1, String s2) {
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < s1.length(); i++) {
            char x = s1.charAt(i);
            char y = s2.charAt(i);
            answer.add(y >= x ? y-x : y+26-x);
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numCases = sc.nextInt();

        for(int i = 0; i < numCases; i++)
        {
            String s1 = sc.next();
            String s2 = sc.next();

            ArrayList<Integer> answer = solveAlphabetDistance(s1, s2);
            System.out.print("Distances: ");

            for(Integer d : answer) {
                System.out.print(d+" ");
            }
            System.out.println();

        }
    }
}

package baekjoon.baekjoon01XXX;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Exercise1972 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String input = sc.nextLine();
            if (input.equals("*")) {
                break;
            }

            if (input.length() == 1) {
                System.out.println(input + " is surprising.");
                continue;
            }

            char[] temp = input.toCharArray();
            boolean flag = true;
            for (int i = 0; i < input.length()-1; i++) {
                int addCount = 0;
                Set<String> subStrings = new HashSet<>();
                for (int j = 0; j < input.length()-i-1; j++) {
                    String subString = String.valueOf(temp[j]) + temp[j+i+1];
                    subStrings.add(subString);
                    addCount++;
                    if (addCount != subStrings.size()) {
                        flag = false;
                        break;
                    }
                }
                if (!flag) {
                    System.out.println(input + " is NOT surprising.");
                    break;
                }
            }
            if (flag) {
                System.out.println(input + " is surprising.");
            }
        }
        sc.close();
    }
}

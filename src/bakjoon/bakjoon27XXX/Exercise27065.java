package bakjoon.bakjoon27XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Exercise27065 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int year = Integer.parseInt(br.readLine());
            List<Integer> numList = getNumList(year);
            if (isAbundant(year) && numList.stream().noneMatch(value -> isAbundant(value))) {
                System.out.println("Good Bye");
            } else {
                System.out.println("BOJ 2022");
            }
        }
    }

    private static boolean isAbundant(int num) {
        int sum = 0;
        for (int i = 1; i*i <= num; i++) {
            if (num % i == 0) {
                sum += i;
                if (num/i != i) {
                    sum += (num/i != num) ? (num/i) : 0;
                }
            }
        }
        return sum > num;
    }

    private static List<Integer> getNumList(int year) {
        List<Integer> numList = new ArrayList<>();
        for (int j = 1; j*j <= year; j++) {
            if (year % j == 0) {
                numList.add(j);
                if (year/j != j && year/j != year) {
                    numList.add(year/j);
                }
            }
        }
        return numList;
    }
}

package bakjoon.bakjoon04XXX;

import java.io.IOException;
import java.util.Scanner;

public class Exercise4344 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();

        for (int i = 0; i < testCase; i++) {
            int studentCount = sc.nextInt();
            double sum = 0;
            int[] scores = new int[studentCount];
            for (int j = 0; j < studentCount; j++) {
                scores[j] = sc.nextInt();
                sum += scores[j];
            }

            double average = sum / studentCount;
            double count = 0;
            for (Integer score : scores) {
                if (score > average) {
                    count++;
                }
            }
            System.out.printf("%.3f%%\n", count*100/studentCount);
        }
        sc.close();
    }
}

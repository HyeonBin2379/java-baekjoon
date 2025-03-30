package baekjoon.baekjoon25XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise25206 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double totalScore = 0.0;
        int totalUnit = 0;
        for (int i = 0; i < 20; i++) {
            String[] subjectInfo = br.readLine().split(" ");

            if (subjectInfo[2].equals("P")) {
                continue;
            }

            double unit = Double.parseDouble(subjectInfo[1]);
            double gpa = calculateGPA(subjectInfo[2]);

            totalScore += unit * gpa;
            totalUnit += unit;
        }

        System.out.printf("%.4f\n", totalScore / totalUnit);
    }

    private static double calculateGPA(String grade) {
        char[] g = grade.toCharArray();

        double gpa = 0.0;

        if (g[0] == 'F') {
            return gpa;
        }

        switch (g[0]) {
            case 'A' -> gpa += 4;
            case 'B' -> gpa += 3;
            case 'C' -> gpa += 2;
            case 'D' -> gpa += 1;
        }

        switch (g[1]) {
            case '-' -> gpa -= 0.5;
            case '+' -> gpa += 0.5;
        }

        return gpa;
    }
}

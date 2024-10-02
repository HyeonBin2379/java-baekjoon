package baekjoon.baekjoon04XXX;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Exercise4696 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String num = br.readLine();
            if (num.equals("0")) {
                break;
            }
            bw.write(String.format("%.2f\n", getTotalSum(Double.parseDouble(num))));
        }
        br.close();
        bw.flush();
        bw.close();
    }

    public static double getTotalSum(double num) {
        double sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += Math.pow(num, i);
        }
        return sum;
    }
}

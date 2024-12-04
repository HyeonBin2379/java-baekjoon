package baekjoon.baekjoon32XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise32767 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] token = br.readLine().split(" ");
        double result = Double.parseDouble(token[0]);
        for (int i = 1; i < token.length; i += 2) {
            double value = Double.parseDouble(token[i+1]);
            switch (token[i]) {
                case "+" -> result += value;
                case "-" -> result -= value;
                case "*" -> result *= value;
                case "/" -> result /= value;
            }
        }
        print(String.format("%.3f", result));
    }

    private static void print(String result) {
        System.out.println("=================");
        System.out.println("|SASA CALCULATOR|");
        System.out.printf("|%15s|\n", result);
        System.out.println("""
                -----------------
                |               |
                | AC         /  |
                | 7  8  9    *  |
                | 4  5  6    -  |
                | 1  2  3    +  |
                |    0  .    =  |
                =================""");
    }
}

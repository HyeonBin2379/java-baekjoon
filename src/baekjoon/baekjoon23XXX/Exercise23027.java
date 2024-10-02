package baekjoon.baekjoon23XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise23027 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String letter = br.readLine();
        if (letter.contains("A")) {
            System.out.println(letter.replaceAll("[BCDF]", "A"));
        } else if (letter.contains("B")) {
            System.out.println(letter.replaceAll("[CDF]", "B"));
        } else if (letter.contains("C")) {
            System.out.println(letter.replaceAll("[DF]", "C"));
        } else {
            System.out.println(letter.replaceAll("[A-Z]", "A"));
        }
    }
}

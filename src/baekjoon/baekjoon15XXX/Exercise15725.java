package baekjoon.baekjoon15XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise15725 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int xPos = input.indexOf("x");

        if (xPos < 0) {
            System.out.println(0);
            return;
        }

        switch (input.substring(0, xPos)) {
            case "" -> System.out.println(1);
            case "-" -> System.out.println(-1);
            default -> System.out.println(Integer.parseInt(input.substring(0, xPos)));
        }
    }
}

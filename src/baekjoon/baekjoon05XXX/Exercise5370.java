package baekjoon.baekjoon05XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise5370 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ((input = br.readLine()) != null) {
            int num = Integer.parseInt(input);
            String binary = Integer.toBinaryString(num);
            int count = Integer.bitCount(num);
            if (binary.length()-count < count) {
                System.out.println("right");
            } else if (binary.length()-count > count || num == 0) {
                System.out.println("left");
            } else {
                System.out.println("straight");
            }
        }
    }
}

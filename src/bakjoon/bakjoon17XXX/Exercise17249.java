package bakjoon.bakjoon17XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise17249 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("\\(\\^0\\^\\)");

        long partA = input[0].chars().filter(value -> (char) value == '@').count();
        if (input.length == 1) {
            if (input[0].startsWith("@")) {
                System.out.println(partA + " " + 0);
            } else {
                System.out.println(0 + " " + partA);
            }
            return;
        }
        long partB = input[1].chars().filter(value -> (char) value == '@').count();
        System.out.println(partA + " " + partB);
    }
}

package bakjoon.bakjoon21XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise21614 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String previous = "";
        while (true) {
            int input = Integer.parseInt(br.readLine());
            if (input == 99999) {
                break;
            }
            int sum = input/10000 + (input % 10000)/1000;
            if (sum == 0) {
                System.out.println(previous + " " + (input % 1000));
            } else if (sum % 2 == 1) {
                previous = "left";
                System.out.println("left " + (input % 1000));
            } else {
                previous = "right";
                System.out.println("right " + (input % 1000));
            }
        }
    }
}

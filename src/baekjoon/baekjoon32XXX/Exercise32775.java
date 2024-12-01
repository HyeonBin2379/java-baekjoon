package baekjoon.baekjoon32XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise32775 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int s = Integer.parseInt(br.readLine());
        int f = Integer.parseInt(br.readLine());

        if (s > f) {
            System.out.println("flight");
        } else {
            System.out.println("high speed rail");
        }
    }
}

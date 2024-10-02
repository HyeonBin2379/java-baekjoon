package baekjoon.baekjoon10XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise10643 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] mushroom = new int[8];
        for (int i = 0; i < 8; i++) {
            mushroom[i] = Integer.parseInt(br.readLine());
        }

        int answer = 0;
        for (int i = 0; i < 8; i++) {
            int sum = 0;
            for (int j = i; j < i+4; j++) {
                sum += mushroom[j % 8];
            }
            answer = Math.max(sum, answer);
        }
        System.out.println(answer);
    }
}

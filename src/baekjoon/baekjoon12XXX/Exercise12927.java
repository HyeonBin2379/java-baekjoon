package baekjoon.baekjoon12XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise12927 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "N" + br.readLine();
        int answer = 0;
        if (!input.contains("Y")) {
            System.out.println(answer);
            return;
        }

        char[] temp = input.toCharArray();
        for (int i = 1; i < temp.length; i++) {
            if (temp[i] == 'N') {
                continue;
            }
            for (int j = i; j < temp.length; j += i) {
                temp[j] = (temp[j] == 'Y') ? 'N' : 'Y';
            }
            answer++;
        }
        System.out.println(answer);
    }
}

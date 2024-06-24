package bakjoon.bakjoon24XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise24196 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        br.close();

        StringBuilder answer = new StringBuilder();
        int index = 0;
        while (index <= input.length-1) {
            answer.append(input[index]);
            index += input[index] - 'A' + 1;
        }
        System.out.println(answer);
    }
}

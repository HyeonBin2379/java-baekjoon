package bakjoon.bakjoon1XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise1343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        br.close();
        System.out.println(poliomino(input));
    }

    public static String poliomino(String input) {
        String answer;

        input = input.replaceAll("XXXX", "AAAA");
        answer = input.replaceAll("XX", "BB");
        return answer.contains("X") ? "-1" : answer;
    }
}

package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise3447 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input;
        while ((input = br.readLine()) != null) {
            while (input.contains("BUG")) {
                input = input.replace("BUG", "");
            }
            sb.append(input).append("\n");
        }
        System.out.print(sb);
    }
}

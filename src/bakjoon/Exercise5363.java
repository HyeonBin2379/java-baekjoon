package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise5363 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            String[] words = br.readLine().split(" ");
            for (int j = 2; j < words.length; j++) {
                sb.append(words[j]).append(" ");
            }
            sb.append(words[0]).append(" ").append(words[1]).append("\n");
        }
        System.out.print(sb);
    }
}

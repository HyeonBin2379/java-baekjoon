package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise12605 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 1; i <= testCase; i++) {
            String[] words = br.readLine().split(" ");
            sb.append(String.format("Case #%d:", i));
            for (int j = words.length-1; j >= 0; j--) {
                sb.append(" ").append(words[j]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}

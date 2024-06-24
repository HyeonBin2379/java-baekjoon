package bakjoon.bakjoon04XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise4458 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int count = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++) {
            String input = br.readLine();
            String firstLetter = String.valueOf(input.charAt(0));
            input = input.replaceFirst(firstLetter, firstLetter.toUpperCase());
            sb.append(input).append("\n");
        }
        System.out.print(sb);
    }
}

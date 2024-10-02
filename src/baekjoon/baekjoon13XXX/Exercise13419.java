package baekjoon.baekjoon13XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

public class Exercise13419 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            String input = br.readLine();
            Set<String> first = new LinkedHashSet<>();
            Set<String> second = new LinkedHashSet<>();
            for (int j = 0; j < input.length(); j++) {
                first.add(String.valueOf(input.charAt(2*j % input.length())));
                second.add(String.valueOf(input.charAt(((2*j+1) % input.length()))));
            }
            sb.append(String.join("", first)).append("\n")
                    .append(String.join("", second)).append("\n");
        }
        System.out.print(sb);
    }
}

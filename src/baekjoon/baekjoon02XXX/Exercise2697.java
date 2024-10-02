package baekjoon.baekjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Exercise2697 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            String input = br.readLine();
            int index = 0;
            for (int j = input.length()-1; j > 0; j--) {
                if (input.charAt(j) > input.charAt(j-1)) {
                    index = j-1;
                    break;
                }
            }

            StringBuilder a = new StringBuilder(input.substring(0, index));
            String b = input.substring(index);
            if (a.length() == 0 || b.isEmpty()) {
                System.out.println("BIGGEST");
                continue;
            }
            b = Arrays.stream(b.split("")).sorted().collect(Collectors.joining());
            for (int j = 0; j < b.length(); j++) {
                if (b.charAt(j) > input.charAt(index)) {
                    a.append(b.charAt(j));
                    a.append(b, 0, j).append(b.substring(j+1));
                    break;
                }
            }
            System.out.println(a);
        }
    }
}

package bakjoon.bakjoon31XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise31616 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        String input = br.readLine();
        System.out.println(isAllMatched(input) ? "Yes" : "No");
    }

    public static boolean isAllMatched(String str) {
        return str.chars().allMatch(value -> (char)value == str.charAt(0));
    }
}

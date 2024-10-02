package baekjoon.baekjoon16XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise16944 {

    private static final String NUMBER = "0123456789";
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private static final String MARK = "!@#$%^&*()-+";
    private static final String[] types = {NUMBER, ALPHABET, ALPHABET.toUpperCase(), MARK};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();

        int count = 0;
        for (String type : types) {
            if (hasLetter(type, input)) {
                count++;
            }
        }
        if (input.length() + count < 6) {
            count += 6-(input.length()+count);
        }
        System.out.println(count);
    }

    private static boolean hasLetter(String type, String input) {
        return type.chars().noneMatch(ch -> input.contains(String.valueOf((char)ch)));
    }
}

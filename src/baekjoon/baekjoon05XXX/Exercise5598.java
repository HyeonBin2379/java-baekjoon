package baekjoon.baekjoon05XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise5598 {

    private static final String code = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String encrypted = br.readLine();

        StringBuilder decrypted = new StringBuilder();
        for (int i = 0; i < encrypted.length(); i++) {
            int index = code.indexOf(encrypted.charAt(i));
            decrypted.append(code.charAt((index + 23) % 26));
        }
        System.out.println(decrypted);
    }
}

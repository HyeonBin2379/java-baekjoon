package baekjoon.baekjoon14XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class Exercise14626 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String isbn = br.readLine();
        for (int i = 0; i < 10; i++) {
            if (isISBN(isbn.replace("*", Integer.toString(i)))) {
                System.out.println(i);
                return;
            }
        }
    }

    private static boolean isISBN(String isbn) {
        int checkNum = isbn.charAt(12)-'0';
        int sum = IntStream.rangeClosed(0, 11)
                .map(idx -> (idx % 2 == 0) ? (isbn.charAt(idx)-'0') : (isbn.charAt(idx)-'0')*3)
                .sum();
        return (sum+checkNum) % 10 == 0;
    }
}

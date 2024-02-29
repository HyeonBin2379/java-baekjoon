package bakjoon;

import java.io.*;
import java.util.*;

public class Exercise30889 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int reserved = Integer.parseInt(br.readLine());
        char[][] seat = new char['J'-'A'+1][20];
        for (char[] chars : seat) {
            Arrays.fill(chars, '.');
        }
        for (int i = 0; i < reserved; i++) {
            String position = br.readLine();
            int row = position.charAt(0) - 'A';
            int col = Integer.parseInt(position.substring(1)) - 1;
            seat[row][col] = 'o';
        }
        for (char[] chars : seat) {
            System.out.println(new String(chars));
        }
    }
}

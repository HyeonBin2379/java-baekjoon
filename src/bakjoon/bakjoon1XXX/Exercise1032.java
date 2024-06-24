package bakjoon.bakjoon1XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise1032 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] str = new char[n][];

        str[0] = br.readLine().toCharArray();
        for (int i = 1; i < str.length; i++) {
            str[i] = br.readLine().toCharArray();
            for (int j = 0; j < str[0].length; j++) {
                str[0][j] = (str[0][j] != str[i][j]) ? '?' : str[0][j];
            }
        }
        System.out.println(str[0]);
    }
}

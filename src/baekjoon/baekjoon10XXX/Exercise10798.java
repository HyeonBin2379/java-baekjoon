package baekjoon.baekjoon10XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise10798 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] arr = new char[5][];
        int maxLen = 0;
        for (int i = 0; i < 5; i++) {
            arr[i] = br.readLine().toCharArray();
            maxLen = Math.max(arr[i].length, maxLen);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < maxLen; i++) {
            for (int j = 0; j < 5; j++) {
                try {
                    sb.append(arr[j][i]);
                } catch (IndexOutOfBoundsException e) {
                    sb.append(" ");
                }
            }
        }
        System.out.println(sb.toString().replaceAll(" ", ""));
    }
}

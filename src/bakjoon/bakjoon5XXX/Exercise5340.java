package bakjoon.bakjoon5XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise5340 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] len = new int[6];
        for (int i = 0; i < 6; i++) {
            String input = br.readLine();
            len[i] = input.length();
            for (int j = input.length()-1; j >= 0; j--) {
                if (input.charAt(j) != ' ') {
                    break;
                }
                len[i]--;
            }
        }
        System.out.printf("Latitude %d:%d:%d\n", len[0], len[1], len[2]);
        System.out.printf("Longitude %d:%d:%d\n", len[3], len[4], len[5]);
    }
}

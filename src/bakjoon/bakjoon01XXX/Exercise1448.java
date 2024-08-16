package bakjoon.bakjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Exercise1448 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] len = new Integer[n];
        for (int i = 0; i < n; i++) {
            len[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(len, Comparator.reverseOrder());

        int answer = 0;
        for (int i = 0; i < n-2; i++) {
            if (len[i] < len[i+1]+len[i+2]) {
                answer = len[i] + len[i+1] + len[i+2];
                break;
            }
        }
        System.out.println(answer > 0 ? answer : -1);
    }
}

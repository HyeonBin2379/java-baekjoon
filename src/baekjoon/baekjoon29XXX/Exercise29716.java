package baekjoon.baekjoon29XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise29716 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int j = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int count = 0;
        for (int i = 0; i < n; i++) {
            char[] input = br.readLine().toCharArray();
            int size = 0;
            for (char c : input) {
                if (Character.isDigit(c) || (c >= 'a' && c <= 'z')) {
                    size += 2;
                } else if (c >= 'A' && c <= 'Z') {
                    size += 4;
                } else {
                    size += 1;
                }
            }
            if (size <= j) {
                count++;
            }
        }
        System.out.println(count);
    }
}

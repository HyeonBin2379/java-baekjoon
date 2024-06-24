package bakjoon.bakjoon3XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise3054 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        int len = input.length;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            for (int j = 1; j < len+1; j++) {
                if (i == 0 || i == 4) {
                    sb.append(j % 3 != 0 ? "..#." : "..*.");
                } else if (i == 1 || i == 3) {
                    sb.append(j % 3 != 0 ? ".#.#" : ".*.*");
                } else {
                    if (j % 3 == 0 || (j != 1 && j % 3 == 1)) {
                        sb.append("*.").append(input[j-1]).append(".");
                    } else {
                        sb.append("#.").append(input[j-1]).append(".");
                    }
                }
            }
            if (i != 2) {
                sb.append(".\n");
            } else {
                sb.append(len % 3 == 0 ? "*\n" : "#\n");
            }
        }
        System.out.print(sb);
    }
}

package baekjoon.baekjoon06XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise6322 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (true) {
            int[] abc = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (abc[0] == 0 && abc[1] == 0 && abc[2] == 0) {
                break;
            }
            sb.append(String.format("Triangle #%d\n", ++count));
            if (abc[2] != -1 && (abc[0] > abc[2] || abc[1] > abc[2])) {
                sb.append("Impossible.\n\n");
                continue;
            }

            if (abc[0] == -1) {
                double len = Math.pow(abc[2], 2) - Math.pow(abc[1], 2);
                sb.append(len == 0 ? "Impossible.\n\n" : String.format("a = %.3f\n\n", Math.sqrt(len)));
            } else if (abc[1] == -1) {
                double len = Math.pow(abc[2], 2) - Math.pow(abc[0], 2);
                sb.append(len == 0 ? "Impossible.\n\n" : String.format("b = %.3f\n\n", Math.sqrt(len)));
            } else {
                double len = Math.pow(abc[0], 2) + Math.pow(abc[1], 2);
                sb.append(String.format("c = %.3f\n\n", Math.sqrt(len)));
            }
        }
        System.out.print(sb);
    }
}

package bakjoon.bakjoon30XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise30658 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        while (true) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                break;
            }
            int[] rank = new int[num];
            for (int i = num-1; i >= 0; i--) {
                rank[i] = Integer.parseInt(br.readLine());
            }
            for (int i = 0; i < num; i++) {
                result.append(rank[i]).append("\n");
            }
            result.append("0\n");
        }
        System.out.print(result);
    }
}

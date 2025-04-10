package algorithm.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Exercise10989 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] count = new int[10001];
        int n = Integer.parseInt(br.readLine());

        int max = 0;
        while (n-- > 0) {
            int num = Integer.parseInt(br.readLine());
            count[num]++;
            max = Math.max(num, max);
        }
        br.close();

        for (int i = 1; i <= max; i++) {
            if (count[i] == 0) {
                continue;
            }
            while (count[i]-- > 0) {
                bw.write(i + "\n");
            }
        }
        bw.close();
    }
}

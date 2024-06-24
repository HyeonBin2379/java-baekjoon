package bakjoon.bakjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise1817 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        if (n == 0) {
            System.out.println(0);
            return;
        }
        int[] bookWeight = Arrays.stream(br.readLine().split(" ", n)).mapToInt(Integer::parseInt).toArray();
        br.close();

        int box = 1, sum = 0;
        for (int weight : bookWeight) {
            sum += weight;
            if (sum > m) {
                box++;
                sum = weight;
            }
        }
        System.out.println(box);
    }
}

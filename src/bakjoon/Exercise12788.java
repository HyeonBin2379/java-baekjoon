package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise12788 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] pen = Arrays.stream(br.readLine().split(" ", n)).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(pen);

        int count = 0;
        int total = m*k;
        for (int i = pen.length-1; i >= 0; i--) {
            if (total <= 0) {
                break;
            }
            count++;
            total -= pen[i];
        }
        System.out.println(total > 0 ? "STRESS" : count);
    }
}

package baekjoon.baekjoon17XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise17273 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] front = new int[n];
        int[] back = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            front[i] = Integer.parseInt(st.nextToken());
            back[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] isFront = new boolean[n];
        Arrays.fill(isFront, true);
        for (int i = 0; i < m; i++) {
            int k = Integer.parseInt(br.readLine());
            for (int j = 0; j < n; j++) {
                int now = (isFront[j]) ? front[j] : back[j];
                if (now <= k) {
                    isFront[j] = !isFront[j];
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += isFront[i] ? front[i] : back[i];
        }
        System.out.println(sum);
    }
}

package bakjoon.bakjoon21XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise21679 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] c = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int k = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int keyNum = Integer.parseInt(st.nextToken())-1;
            c[keyNum]--;
        }

        for (int i = 0; i < n; i++) {
            System.out.println(c[i] >= 0 ? "no" : "yes");
        }
    }
}

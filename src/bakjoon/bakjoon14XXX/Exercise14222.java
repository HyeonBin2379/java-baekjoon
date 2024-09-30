package bakjoon.bakjoon14XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise14222 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();


        boolean[] checked = new boolean[n+1];
        for (int i = 0; i < n; i++) {
            int temp = arr[i];
            while (temp <= n && checked[temp]) {
                temp += k;
            }
            if (temp > n || checked[temp]) {
                System.out.println(0);
                return;
            }
            checked[temp] = true;
        }
        System.out.println(1);
    }
}

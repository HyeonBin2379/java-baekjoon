package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise20017 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());

        int[] cats = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int fine = 0;
        for (int i = 0; i < n*m-m; i++) {
            if (cats[i]*2 < cats[i+m]) {
                fine += a;
            }
        }
        System.out.println(fine);
    }
}

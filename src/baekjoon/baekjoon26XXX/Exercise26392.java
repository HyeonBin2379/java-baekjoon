package baekjoon.baekjoon26XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise26392 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            int[] nfp = new int[s];
            char[][] graph = new char[r][s];

            for (int j = 0; j < r; j++) {
                graph[j] = br.readLine().toCharArray();
                for (int k = 0; k < s; k++) {
                    if (graph[j][k] == '#') {
                        nfp[k] = r-j;
                    }
                }
            }
            Arrays.sort(nfp);
            System.out.println(nfp[s-1]-nfp[0]);
        }
    }
}

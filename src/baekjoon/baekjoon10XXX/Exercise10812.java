package baekjoon.baekjoon10XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise10812 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] num = new int[n];
        int[] rotated = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = i+1;
        }

        int m = Integer.parseInt(st.nextToken());
        for (int c = 0; c < m; c++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken())-1;
            int j = Integer.parseInt(st.nextToken())-1;
            int k = Integer.parseInt(st.nextToken())-1;

            int idx = i;
            for (int l = 0; l <= j-i; l++) {
                rotated[l+i] = (k+l <= j) ? num[k+l] : num[idx++];
            }
            for (int l = i; l <= j; l++) {
                if (rotated[l] != 0) {
                    num[l] = rotated[l];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(num[i] + " ");
        }
    }
}

package bakjoon.bakjoon20XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise20361 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] cup = new int[n];
        cup[x-1] = 1;
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken())-1;
            int to = Integer.parseInt(st.nextToken())-1;
            int temp = cup[from];
            cup[from] = cup[to];
            cup[to] = temp;
        }
        for (int i = 0; i < n; i++) {
            if (cup[i] == 1) {
                System.out.println(i+1);
                break;
            }
        }
    }
}

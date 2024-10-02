package baekjoon.baekjoon06XXX;

import java.io.*;

public class Exercise6889 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        String[] adjective = new String[n];
        for (int i = 0; i < n; i++) {
            adjective[i] = br.readLine();
        }
        String[] noun = new String[m];
        for (int i = 0; i < m; i++) {
            noun[i] = br.readLine();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(String.format("%s as %s\n", adjective[i], noun[j]));
            }
        }
        System.out.print(sb);
    }
}

package bakjoon.bakjoon14XXX;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Exercise14175 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {
            char[] input = br.readLine().toCharArray();
            StringBuilder temp = new StringBuilder();
            for (int j = 0; j < n; j++) {
                temp.append(String.valueOf(input[j]).repeat(k));
            }
            bw.write((temp + "\n").repeat(k));
        }
        br.close();
        bw.close();
    }
}

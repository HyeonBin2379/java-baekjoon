package baekjoon.baekjoon16XXX;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Exercise16139 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] input = br.readLine().toCharArray();
        int[][] counts = new int[input.length][26];
        counts[0][input[0]-'a'] = 1;
        for (int i = 1; i < input.length; i++) {
            counts[i][input[i]-'a'] = 1;
            for (int j = 0; j < 26; j++) {
                counts[i][j] += counts[i-1][j];
            }
        }

        int q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char letter = st.nextToken().charAt(0);
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if (start == 0) {
                bw.write(counts[end][letter-'a'] + "\n");
            } else {
                bw.write(counts[end][letter-'a']-counts[start-1][letter-'a'] + "\n");
            }
        }
        br.close();
        bw.close();
    }
}

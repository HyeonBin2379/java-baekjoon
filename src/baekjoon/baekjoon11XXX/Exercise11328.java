package baekjoon.baekjoon11XXX;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise11328 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char[] original = st.nextToken().toCharArray();
            char[] strFry = st.nextToken().toCharArray();
            if (hasChar(original, strFry)) {
                bw.write("Possible\n");
            } else {
                bw.write("Impossible\n");
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }

    public static boolean hasChar(char[] original, char[] strFry) {
        Arrays.sort(original);
        Arrays.sort(strFry);
        return Arrays.equals(original, strFry);
    }
}

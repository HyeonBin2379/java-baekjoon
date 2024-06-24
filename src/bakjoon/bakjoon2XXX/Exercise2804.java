package bakjoon.bakjoon2XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise2804 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        char[] a = st.nextToken().toCharArray();
        char[] b = st.nextToken().toCharArray();

        boolean flag = false;
        int crossA = 0, crossB = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (a[i] == b[j]) {
                    crossA = i;
                    crossB = j;
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < b.length; i++) {
            if (i == crossB) {
                sb.append(new String(a)).append("\n");
                continue;
            }
            for (int j = 0; j < a.length; j++) {
                sb.append(j == crossA ? b[i] : '.');
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}

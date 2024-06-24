package bakjoon.bakjoon8XXX;

import java.io.*;
import java.util.StringTokenizer;

public class Exercise8678 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for(int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append((b % a == 0) ? "TAK\n" : "NIE\n");
        }
        System.out.print(sb);
    }
}

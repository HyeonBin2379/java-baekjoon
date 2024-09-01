package bakjoon.bakjoon15XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise15786 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String original = br.readLine();

        for (int i = 0; i < m; i++) {
            String input = br.readLine();
            boolean answer = true;
            int lastIndex = 0;
            for (int j = 0; j < n; j++) {
                int nextIdx = input.indexOf(original.charAt(j), lastIndex);
                if (nextIdx < lastIndex) {
                    answer = false;
                    break;
                }
                lastIndex = nextIdx+1;
            }
            System.out.println(answer);
        }
    }
}

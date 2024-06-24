package bakjoon.bakjoon30XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise30792 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int gahui = Integer.parseInt(br.readLine());
        int rank = 1;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n-1; i++) {
            int votes = Integer.parseInt(st.nextToken());
            if (votes > gahui) {
                rank++;
            }
        }
        System.out.println(rank);
    }
}

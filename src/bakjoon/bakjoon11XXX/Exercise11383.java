package bakjoon.bakjoon11XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise11383 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] original = new String[n];
        for (int i = 0; i < n; i++) {
            original[i] = br.readLine();
        }

        for (int i = 0; i < n; i++) {
            String eyfa = br.readLine();
            for (int j = 0; j < m; j++) {
                if (original[i].charAt(j) != eyfa.charAt(2*j+1)) {
                    System.out.println("Not Eyfa");
                    return;
                }
            }
        }
        System.out.println("Eyfa");
    }
}

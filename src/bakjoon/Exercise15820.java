package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise15820 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n+m; i++) {
            st = new StringTokenizer(br.readLine());
            int answer = Integer.parseInt(st.nextToken());
            int result = Integer.parseInt(st.nextToken());
            if (answer != result) {
                System.out.println(i < n ? "Wrong Answer" : "Why Wrong!!!");
                return;
            }
        }
        System.out.println("Accepted");
    }
}

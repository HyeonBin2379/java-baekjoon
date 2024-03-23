package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise15780 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int count = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int num = Integer.parseInt(st.nextToken());
            count += (num+1)/2;
            if (count >= n) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }
}

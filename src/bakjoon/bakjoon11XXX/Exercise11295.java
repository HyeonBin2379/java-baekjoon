package bakjoon.bakjoon11XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise11295 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int count = 0;

        while (true) {
            int stride = Integer.parseInt(br.readLine().trim());
            if (stride == 0) {
                break;
            }
            sb.append("User ").append(++count).append("\n");
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                int walk = Integer.parseInt(br.readLine());
                sb.append(String.format("%.5f\n", (double)walk*stride*0.00001));
            }
        }
        System.out.print(sb);
    }
}

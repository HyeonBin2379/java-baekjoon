package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise15917 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            int num = Integer.parseInt(br.readLine());
            sb.append((num & (num-1)) == 0 ? 1 : 0).append("\n");
        }
        System.out.print(sb);
    }
}

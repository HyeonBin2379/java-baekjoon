package bakjoon.bakjoon06XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise6721 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            StringBuilder num = new StringBuilder(st.nextToken()).reverse();
            long sum = Long.parseLong(num.toString());
            num.setLength(0);

            num.append(st.nextToken()).reverse();
            sum += Long.parseLong(num.toString());
            num.setLength(0);

            num.append(sum).reverse();
            System.out.println(Long.parseLong(num.toString()));
        }
    }
}

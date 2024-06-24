package bakjoon.bakjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise2828 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int j = Integer.parseInt(br.readLine());
        int left = 1, right = m;
        int answer = 0;
        for (int i = 0; i < j; i++) {
            int basket = Integer.parseInt(br.readLine());

            if (left <= basket && basket <= right) {
                continue;
            }

            if (basket < left) {
                answer += (left-basket);
                right -= (left-basket);
                left = basket;
            } else {
                answer += (basket-right);
                left += (basket-right);
                right = basket;
            }
        }
        System.out.println(answer);
    }
}

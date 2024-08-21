package bakjoon.bakjoon14XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise14429 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int minLen = Integer.MAX_VALUE;
        int gameNum = -1;

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int j = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            // (첫번째 시작 + 유진이 게임에서 이기기 위해 가져가는 턴 수)
            //  + (규용이 가져가는 턴 수 + 규용이 마지막 숫자를 말하는 턴)
            // 유진이 승리하기 위해 가져가는 턴 수 = 규용이 가져가게 되는 턴 수
            int len = ((j-1) / (m+1) + 1) * 2;
            if (len < minLen) {
                minLen = len;
                gameNum = i;
            }
        }
        System.out.println(gameNum + " " + minLen);
    }
}

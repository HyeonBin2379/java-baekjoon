package bakjoon.bakjoon14XXX;

import java.io.*;
import java.util.*;

public class Exercise14471 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<int[]> notWinning = new ArrayList<>();
        int winning = m-1;
        for (int i = 0; i < m; i++) {
            int[] card = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (card[0] >= n) {
                winning--;
                continue;
            }
            notWinning.add(card);
        }
        notWinning.sort((o1, o2) -> o2[0]-o1[0]);

        int answer = 0;
        for (int i = 0; i < winning; i++) {
            int[] card = notWinning.get(i);
            answer += Math.abs(n-card[0]);
        }
        System.out.println(answer);
    }
}

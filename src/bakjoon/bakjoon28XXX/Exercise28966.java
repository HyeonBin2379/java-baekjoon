package bakjoon.bakjoon28XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Exercise28966 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());

        List<Integer> needSwap = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] swapCount = new int[2];
        for (int i = 1; i <= len; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (i % 2 != num % 2) {
                needSwap.add(i);
                swapCount[i % 2]++;
            }
        }

        int ans1 = -1, ans2 = -1;
        if (len > 2 && swapCount[0] == 0 && swapCount[1] == 0) {
            ans1 = 1;
            ans2 = 3;
        } else if (swapCount[0] == 1 && swapCount[1] == 1) {
            ans1 = needSwap.get(0);
            ans2 = needSwap.get(1);
        }
        System.out.println(ans1 + " " + ans2);
    }
}

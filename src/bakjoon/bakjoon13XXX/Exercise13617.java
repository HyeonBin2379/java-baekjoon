package bakjoon.bakjoon13XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise13617 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int count = 0;
        for (int i = 0; i < n; i++) {
            int[] goal = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (!hasNoGoal(goal, m)) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static boolean hasNoGoal(int[] goal, int size) {
        for (int i = 0; i < size; i++) {
            if (goal[i] == 0) {
                return true;
            }
        }
        return false;
    }
}

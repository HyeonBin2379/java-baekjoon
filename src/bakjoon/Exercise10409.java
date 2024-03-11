package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise10409 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int[] workTime = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (sum + workTime[i] > t) {
                System.out.println(i);
                return;
            }
            sum += workTime[i];
        }
        System.out.println(n);
    }
}

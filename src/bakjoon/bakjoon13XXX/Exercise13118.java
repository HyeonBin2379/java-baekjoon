package bakjoon.bakjoon13XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise13118 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] position = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        br.close();

        int result = 0;
        for (int i = 0; i < position.length; i++) {
            if (position[i] == x) {
                result = i+1;
                break;
            }
        }
        System.out.println(result);
    }
}

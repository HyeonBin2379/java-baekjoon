package bakjoon.bakjoon09XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise9723 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 1; i <= testCase; i++) {
            int[] tri = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(tri);
            sb.append(String.format("Case #%d: ", i));
            if (tri[0]*tri[0] + tri[1]*tri[1] == tri[2]*tri[2]) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }
        System.out.print(sb);
    }
}

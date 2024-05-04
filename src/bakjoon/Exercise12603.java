package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise12603 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCase; t++) {
            int c = Integer.parseInt(br.readLine());
            int i = Integer.parseInt(br.readLine());
            int[] price = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            sb.append(String.format("Case #%d: ", t));
            boolean found = false;
            int index = 1;
            while (!found && index < i) {
                for (int k = index+1; k < i+1; k++) {
                    if (price[index-1] + price[k-1] == c) {
                        sb.append(String.format("%d %d\n", index, k));
                        found = true;
                        break;
                    }
                }
                index++;
            }
        }
        System.out.print(sb);
    }
}

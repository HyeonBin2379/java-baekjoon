package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise26531 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] num = Arrays.stream(br.readLine().split("[^0-9]")).filter(s -> !s.isEmpty()).mapToInt(Integer::parseInt).toArray();
        br.close();
        System.out.println((num[0]+num[1] == num[2]) ? "YES" : "NO");
    }
}

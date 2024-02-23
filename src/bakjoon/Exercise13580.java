package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise13580 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] credit = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        br.close();
        Arrays.sort(credit);
        if (credit[0] == credit[1] || credit[1] == credit[2] || credit[0]+credit[1] == credit[2]) {
            System.out.println("S");
        } else {
            System.out.println("N");
        }
    }
}

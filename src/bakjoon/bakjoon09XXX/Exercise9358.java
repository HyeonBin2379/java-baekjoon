package bakjoon.bakjoon09XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise9358 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 1; i <= testCase; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            while (num.length > 2) {
                int newLen = (n % 2 == 0) ? n/2 : (n+1)/2;
                int[] newArr = new int[newLen];
                for (int j = 0; j < newLen; j++) {
                    newArr[j] = num[j] + num[n-1-j];
                }
                n = newLen;
                num = newArr.clone();
            }
            sb.append(String.format("Case #%d: ", i));
            sb.append(num[0] > num[1] ? "Alice\n" : "Bob\n");
        }
        System.out.print(sb);
    }
}

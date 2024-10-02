package baekjoon.baekjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise1551 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int startLen = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] num = Arrays.stream(br.readLine().split(",", startLen)).mapToInt(Integer::parseInt).toArray();
        while (k-- > 0) {
            int[] newNum = new int[num.length-1];
            for (int i = 0; i < newNum.length; i++) {
                newNum[i] = num[i+1]-num[i];
            }
            num = Arrays.copyOf(newNum, --startLen);
        }
        String[] answer = Arrays.stream(num).mapToObj(Integer::toString).toArray(String[]::new);
        System.out.println(String.join(",", answer));
    }
}

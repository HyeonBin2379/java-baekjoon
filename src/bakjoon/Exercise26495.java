package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise26495 {
    public static String[] num = {
            "0000\n0  0\n0  0\n0  0\n0000\n",
            "   1\n   1\n   1\n   1\n   1\n",
            "2222\n   2\n2222\n2\n2222\n",
            "3333\n   3\n3333\n   3\n3333\n",
            "4  4\n4  4\n4444\n   4\n   4\n",
            "5555\n5\n5555\n   5\n5555\n",
            "6666\n6\n6666\n6  6\n6666\n",
            "7777\n   7\n   7\n   7\n   7\n",
            "8888\n8  8\n8888\n8  8\n8888\n",
            "9999\n9  9\n9999\n   9\n   9\n"
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] digit = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();

        for (int j : digit) {
            sb.append(num[j]).append("\n");
        }
        System.out.print(sb);
    }
}
